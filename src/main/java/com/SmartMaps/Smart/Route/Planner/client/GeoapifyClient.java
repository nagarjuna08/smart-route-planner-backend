package com.SmartMaps.Smart.Route.Planner.client;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;

import com.SmartMaps.Smart.Route.Planner.client.response.GeoapifyResponse;
import com.SmartMaps.Smart.Route.Planner.exception.InvalidLocationException;
import com.SmartMaps.Smart.Route.Planner.model.Coordinate;

@Component
public class GeoapifyClient {

    private final WebClient webClient;

    public GeoapifyClient(WebClient webClient) {
        this.webClient = webClient;
    }

    @Value("d9076a070bb64273a72d5a0c67160553")
    private String apiKey;

    public Coordinate fetchCoordinates(String location) {

    	System.out.println("USING GEOAPIFY -> " + location);
        GeoapifyResponse response =
                webClient.get()
                        .uri(uriBuilder ->
                                uriBuilder
                                        .scheme("https")
                                        .host("api.geoapify.com")
                                        .path("/v1/geocode/search")
                                        .queryParam("text", location)
                                        .queryParam("apiKey", apiKey)
                                        .build())
                        .retrieve()
                        .bodyToMono(GeoapifyResponse.class)
                        .block();

        if (response == null
                || response.getFeatures() == null
                || response.getFeatures().isEmpty()) {

            throw new InvalidLocationException(
                    "Location not found : " + location);
        }

        var properties =
                response.getFeatures()
                        .get(0)
                        .getProperties();

        return new Coordinate(
                properties.getLat(),
                properties.getLon());
    }
}
