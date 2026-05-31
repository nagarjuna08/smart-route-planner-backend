package com.SmartMaps.Smart.Route.Planner.client;

import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;

import com.SmartMaps.Smart.Route.Planner.dto.osrm.OsrmResponse;

@Component
public class OsrmClient {

    private final WebClient webClient;

    public OsrmClient(WebClient webClient) {
        this.webClient = webClient;
    }

    public OsrmResponse getRoute(
            double startLat,
            double startLon,
            double endLat,
            double endLon) {

        return webClient.get()
                .uri(
                        "https://router.project-osrm.org/route/v1/driving/"
                                + startLon + "," + startLat
                                + ";"
                                + endLon + "," + endLat
                                + "?overview=full&geometries=geojson")
                .retrieve()
                .bodyToMono(OsrmResponse.class)
                .block();
    }
}
