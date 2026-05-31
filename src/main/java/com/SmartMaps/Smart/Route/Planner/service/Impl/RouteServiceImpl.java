package com.SmartMaps.Smart.Route.Planner.service.Impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.SmartMaps.Smart.Route.Planner.algorithm.AlgorithmComparator;
import com.SmartMaps.Smart.Route.Planner.algorithm.astar.AStarService;
import com.SmartMaps.Smart.Route.Planner.algorithm.dijkstra.DijkstraService;
import com.SmartMaps.Smart.Route.Planner.dto.CoordinateDto;
import com.SmartMaps.Smart.Route.Planner.dto.RecalculateRouteRequest;
import com.SmartMaps.Smart.Route.Planner.dto.RouteRequest;
import com.SmartMaps.Smart.Route.Planner.dto.RouteResponse;
import com.SmartMaps.Smart.Route.Planner.dto.osrm.OsrmResponse;
import com.SmartMaps.Smart.Route.Planner.dto.osrm.RouteDto;
import com.SmartMaps.Smart.Route.Planner.exception.InvalidRouteException;
import com.SmartMaps.Smart.Route.Planner.model.Coordinate;
import com.SmartMaps.Smart.Route.Planner.model.graph.Graph;
import com.SmartMaps.Smart.Route.Planner.model.graph.Node;
import com.SmartMaps.Smart.Route.Planner.model.graph.RoutePath;
import com.SmartMaps.Smart.Route.Planner.service.GeocodingService;
import com.SmartMaps.Smart.Route.Planner.service.GraphBuilderService;
import com.SmartMaps.Smart.Route.Planner.service.RouteService;
import com.SmartMaps.Smart.Route.Planner.client.OsrmClient;

@Service
public class RouteServiceImpl implements RouteService {
	
    private final GeocodingService geocodingService;
    private final GraphBuilderService graphBuilderService;
    private final AStarService aStarService;
    private final DijkstraService dijkstraService;
    private final AlgorithmComparator algorithmComparator;
    private final OsrmClient osrmClient;
	

	public RouteServiceImpl(GeocodingService geocodingService, GraphBuilderService graphBuilderService,
			AStarService aStarService, DijkstraService dijkstraService, AlgorithmComparator algorithmComparator,OsrmClient osrmClient) {
		super();
		this.geocodingService = geocodingService;
		this.graphBuilderService = graphBuilderService;
		this.aStarService = aStarService;
		this.dijkstraService = dijkstraService;
		this.algorithmComparator = algorithmComparator;
		this.osrmClient=osrmClient;
	}

	@Override
	public RouteResponse findBestRoute(RouteRequest request) 
	{
		if (request.getStartLocation()
		        .trim()
		        .equalsIgnoreCase(
		                request.getDestinationLocation()
		                        .trim())) {

		    throw new InvalidRouteException(
		            "Start and Destination cannot be the same");
		}
		System.out.println("findBestRoute called");
		Coordinate source = geocodingService.getCoordinates(request.getStartLocation());

        Coordinate destination = geocodingService.getCoordinates(request.getDestinationLocation()); 

        Graph graph = graphBuilderService.buildGraph(source,destination);

        Node sourceNode =
                graph.getNearestNode(
                        source.getLatitude(),
                        source.getLongitude());

        Node destinationNode =
                graph.getNearestNode(
                        destination.getLatitude(),
                        destination.getLongitude());

        System.out.println("Source = " + source);
        System.out.println("Destination = " + destination);

        System.out.println("Source Node = " + sourceNode);
        System.out.println("Destination Node = " + destinationNode);
        RoutePath dijkstraPath =
                dijkstraService.findPath(
                        graph,
                        sourceNode,
                        destinationNode);

        RoutePath aStarPath =
                aStarService.findPath(
                        graph,
                        sourceNode,
                        destinationNode);

        RoutePath bestPath =
                algorithmComparator.compare(
                        dijkstraPath,
                        aStarPath);

        RouteResponse response = new RouteResponse();

        OsrmResponse osrmResponse =
                osrmClient.getRoute(
                        source.getLatitude(),
                        source.getLongitude(),
                        destination.getLatitude(),
                        destination.getLongitude());
        RouteDto route =
                osrmResponse.getRoutes().get(0);

        response.setTotalDistance(
                route.getDistance() / 1000);

        response.setTotalDuration(
                route.getDuration() / 60);

        List<CoordinateDto> coordinates =
                new ArrayList<>();

        osrmResponse.getRoutes()
                .get(0)
                .getGeometry()
                .getCoordinates()
                .forEach(coord -> {

                    CoordinateDto dto =
                            new CoordinateDto();

                    dto.setLongitude(coord.get(0));
                    dto.setLatitude(coord.get(1));

                    coordinates.add(dto);
                });

        response.setCoordinates(coordinates);

        response.setExecutionTime(bestPath.getExecutionTime());

        response.setNodesVisited(bestPath.getNodesVisited());

        response.setSelectedAlgorithm(bestPath.getAlgorithmName());
        
        List<String> itinerary =
                new ArrayList<>();

        itinerary.add(
                request.getStartLocation());

        itinerary.add(
                request.getDestinationLocation());

        response.setItinerary(
                itinerary);
        
        return response;
		
	}

	@Override
	public RouteResponse addStopAndOptimize(
	        RecalculateRouteRequest request) {

	    Coordinate source =
	            geocodingService.getCoordinates(
	                    request.getStartLocation());

	    Coordinate destination =
	            geocodingService.getCoordinates(
	                    request.getDestinationLocation());

	    Coordinate stop =
	            new Coordinate(
	                    request.getLatitude(),
	                    request.getLongitude());

	    RouteResponse response =
	            new RouteResponse();

	    OsrmResponse route1 =
	            osrmClient.getRoute(
	                    source.getLatitude(),
	                    source.getLongitude(),
	                    stop.getLatitude(),
	                    stop.getLongitude());

	    OsrmResponse route2 =
	            osrmClient.getRoute(
	                    stop.getLatitude(),
	                    stop.getLongitude(),
	                    destination.getLatitude(),
	                    destination.getLongitude());

	    List<CoordinateDto> coordinates =
	            new ArrayList<>();

	    route1.getRoutes()
	            .get(0)
	            .getGeometry()
	            .getCoordinates()
	            .forEach(coord -> {

	                CoordinateDto dto =
	                        new CoordinateDto();

	                dto.setLatitude(
	                        coord.get(1));

	                dto.setLongitude(
	                        coord.get(0));

	                coordinates.add(dto);
	            });

	    route2.getRoutes()
	            .get(0)
	            .getGeometry()
	            .getCoordinates()
	            .forEach(coord -> {

	                CoordinateDto dto =
	                        new CoordinateDto();

	                dto.setLatitude(
	                        coord.get(1));

	                dto.setLongitude(
	                        coord.get(0));

	                coordinates.add(dto);
	            });


	    response.setCoordinates(coordinates);
	    RouteDto firstRoute =
	            route1.getRoutes().get(0);

	    RouteDto secondRoute =
	            route2.getRoutes().get(0);

	    double totalDistance =
	            firstRoute.getDistance()
	            + secondRoute.getDistance();

	    double totalDuration =
	            firstRoute.getDuration()
	            + secondRoute.getDuration();

	    response.setTotalDistance(
	            totalDistance / 1000);

	    response.setTotalDuration(
	            totalDuration / 60);

	    response.setSelectedAlgorithm("OPTIMIZED");
	    
	    List<String> itinerary =
	            new ArrayList<>();

	    itinerary.add(
	            request.getStartLocation());

	    itinerary.add(
	            request.getPlaceName());

	    itinerary.add(
	            request.getDestinationLocation());

	    response.setItinerary(
	            itinerary);
	    
	    return response;
	}

	@Override
	public RouteResponse getRouteSummary(RouteRequest request) 
	{
		return findBestRoute(request);
	}

}
