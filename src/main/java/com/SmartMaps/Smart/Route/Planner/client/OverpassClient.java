package com.SmartMaps.Smart.Route.Planner.client;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;

import com.SmartMaps.Smart.Route.Planner.dto.CoordinateDto;
import com.SmartMaps.Smart.Route.Planner.dto.PlaceResponse;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.SmartMaps.Smart.Route.Planner.dto.overpass.OverpassApiResponse;
import com.SmartMaps.Smart.Route.Planner.dto.overpass.OverpassElement;

@Component
public class OverpassClient {

        private final WebClient webClient;

        public OverpassClient(WebClient webClient) {
                this.webClient = webClient;
        }

        public List<PlaceResponse> fetchPlaces(
                        List<CoordinateDto> routeCoordinates,
                        String category) {

                int radius = getRadius(category);

                StringBuilder query = new StringBuilder();

                query.append("[out:json];(");

                int maxPoints = 50;

                int step = Math.max(
                                1,
                                routeCoordinates.size()
                                                / maxPoints);

                for (int i = 0; i < routeCoordinates.size(); i += step) {

                        CoordinateDto point = routeCoordinates.get(i);

                        query.append(
                                        buildCategoryQuery(
                                                        category,
                                                        radius,
                                                        point.getLatitude(),
                                                        point.getLongitude()));
                }

                query.append(");out body;");

                System.out.println("OVERPASS QUERY:");
                System.out.println(query);
                String response = null;
                try {
                        response = webClient.post()
                                        .uri("https://overpass-api.de/api/interpreter")
                                        .bodyValue(query.toString())
                                        .retrieve()
                                        .bodyToMono(String.class)
                                        .block();

                        System.out.println("OVERPASS RESPONSE:");
                        System.out.println(response);
                } catch (Exception ex) {

                        ex.printStackTrace();

                        return new ArrayList<>();
                }

                try {

                        ObjectMapper mapper = new ObjectMapper();

                        OverpassApiResponse apiResponse = mapper.readValue(
                                        response,
                                        OverpassApiResponse.class);

                        List<PlaceResponse> places = new ArrayList<>();
                        Map<Long, PlaceResponse> uniquePlaces = new HashMap<>();

                        for (OverpassElement element : apiResponse.getElements()) {

                                if (element.getTags() == null
                                                || element.getTags().getName() == null) {

                                        continue;
                                }

                                PlaceResponse place = new PlaceResponse();

                                place.setPlaceId(
                                                element.getId());

                                place.setName(
                                                element.getTags().getName());

                                place.setLatitude(
                                                element.getLat());

                                place.setLongitude(
                                                element.getLon());
                                place.setCategory(category);

                                double maxDistance = getFilterDistance(category);

                                if (isNearRoute(
                                                place,
                                                routeCoordinates,
                                                maxDistance)) {

                                        uniquePlaces.put(
                                                        place.getPlaceId(),
                                                        place);
                                }
                        }

                        return new ArrayList<>(
                                        uniquePlaces.values());

                } catch (Exception ex) {

                        ex.printStackTrace();

                        return new ArrayList<>();
                }
        }

        private int getRadius(String category) {

                switch (category.toUpperCase()) {

                        case "RESTAURANT":
                                return 2000;

                        case "HOTEL":
                                return 2000;

                        case "FUEL_STATION":
                                return 1000;

                        case "TOURIST":
                                return 4000;

                        default:
                                return 1000;
                }
        }

        private double getFilterDistance(
                        String category) {

                switch (category.toUpperCase()) {

                        case "RESTAURANT":
                                return 3.0;

                        case "HOTEL":
                                return 3.0;

                        case "FUEL_STATION":
                                return 1.0;

                        case "TOURIST":
                                return 5.0;

                        default:
                                return 5.0;
                }
        }

        private String buildCategoryQuery(
                        String category,
                        int radius,
                        double lat,
                        double lon) {

                switch (category.toUpperCase()) {

                        case "RESTAURANT":
                                return "node[\"amenity\"=\"restaurant\"]"
                                                + "(around:"
                                                + radius
                                                + ","
                                                + lat
                                                + ","
                                                + lon
                                                + ");";

                        case "HOTEL":
                                return "node[\"tourism\"=\"hotel\"]"
                                                + "(around:"
                                                + radius
                                                + ","
                                                + lat
                                                + ","
                                                + lon
                                                + ");";

                        case "FUEL_STATION":
                                return "node[\"amenity\"=\"fuel\"]"
                                                + "(around:"
                                                + radius
                                                + ","
                                                + lat
                                                + ","
                                                + lon
                                                + ");";

                        case "TOURIST":
                                return "node[\"tourism\"=\"attraction\"]"
                                                + "(around:"
                                                + radius
                                                + ","
                                                + lat
                                                + ","
                                                + lon
                                                + ");";

                        default:
                                return "";
                }
        }

        public PlaceResponse fetchPlaceDetails(Long placeId) {

                PlaceResponse place = new PlaceResponse();

                place.setPlaceId(placeId);

                return place;
        }

        private boolean isNearRoute(
                        PlaceResponse place,
                        List<CoordinateDto> routeCoordinates,
                        double maxDistanceKm) {

                for (CoordinateDto point : routeCoordinates) {

                        double distance = calculateDistance(
                                        place.getLatitude(),
                                        place.getLongitude(),
                                        point.getLatitude(),
                                        point.getLongitude());

                        if (distance <= maxDistanceKm) {
                                return true;
                        }
                }

                return false;
        }

        private double calculateDistance(
                        double lat1,
                        double lon1,
                        double lat2,
                        double lon2) {

                final double R = 6371;

                double dLat = Math.toRadians(
                                lat2 - lat1);

                double dLon = Math.toRadians(
                                lon2 - lon1);

                double a = Math.sin(dLat / 2)
                                * Math.sin(dLat / 2)
                                + Math.cos(
                                                Math.toRadians(lat1))
                                                * Math.cos(
                                                                Math.toRadians(lat2))
                                                * Math.sin(dLon / 2)
                                                * Math.sin(dLon / 2);

                double c = 2 * Math.atan2(
                                Math.sqrt(a),
                                Math.sqrt(1 - a));

                return R * c;
        }
}
