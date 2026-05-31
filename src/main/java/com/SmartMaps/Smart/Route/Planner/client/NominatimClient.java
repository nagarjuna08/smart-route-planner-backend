package com.SmartMaps.Smart.Route.Planner.client;

import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;

import com.SmartMaps.Smart.Route.Planner.client.response.NominatimResponse;
import com.SmartMaps.Smart.Route.Planner.exception.InvalidLocationException;
import com.SmartMaps.Smart.Route.Planner.model.Coordinate;

@Component
public class NominatimClient {

    private final WebClient webClient;
    
    public NominatimClient(WebClient webClient) {
		this.webClient = webClient;
	}

	@Value("${osm.nominatim.url}")
    private String nominatimUrl;

	public Coordinate fetchCoordinates(
	        String location) {

	    try {

	        System.out.println(
	                "Searching Location : "
	                + location);
	        System.out.println("Before API Call");
	        List<NominatimResponse> responses =
	                webClient.get()
	                        .uri(uriBuilder ->
	                                uriBuilder
	                                        .scheme("https")
	                                        .host(
	                                            "nominatim.openstreetmap.org")
	                                        .path("/search")
	                                        .queryParam(
	                                                "q",
	                                                location)
	                                        .queryParam(
	                                                "format",
	                                                "json")
	                                        .queryParam(
	                                                "limit",
	                                                1)
	                                        .build())
	                        .header(
	                                "User-Agent",
	                                "SmartRoutePlanner/1.0")
	                        .header(
	                                "Accept",
	                                "application/json")
	                        .retrieve()
	                        .bodyToFlux(
	                                NominatimResponse.class)
	                        .collectList()
	                        .block();
	        System.out.println("After API Call");

	        System.out.println(
	                "Response : "
	                + responses);

	        if (responses == null
	                || responses.isEmpty()) {

	            throw new InvalidLocationException(
	                    "Location not found : "
	                            + location);
	        }

	        NominatimResponse response =
	                responses.get(0);

	        return new Coordinate(
	                Double.parseDouble(
	                        response.getLat()),
	                Double.parseDouble(
	                        response.getLon())
	        );

	    }
	    catch (Exception ex) {

	        ex.printStackTrace();

	        throw ex;
	    }
	}
}
