package com.SmartMaps.Smart.Route.Planner.service.Impl;

import org.springframework.stereotype.Service;

import com.SmartMaps.Smart.Route.Planner.model.Coordinate;
import com.SmartMaps.Smart.Route.Planner.model.graph.Edge;
import com.SmartMaps.Smart.Route.Planner.model.graph.Graph;
import com.SmartMaps.Smart.Route.Planner.model.graph.Node;
import com.SmartMaps.Smart.Route.Planner.service.GraphBuilderService;

@Service
public class GraphBuilderServiceImpl implements GraphBuilderService {

	@Override
	public Graph buildGraph(Coordinate source, Coordinate destination) 
	{
		Graph graph = new Graph();

        Node sourceNode =new Node(1L,source.getLatitude(),source.getLongitude());

        Node destinationNode =new Node(2L,destination.getLatitude(),destination.getLongitude());

        graph.addNode(sourceNode);
        graph.addNode(destinationNode);

        graph.addEdge(new Edge(sourceNode,destinationNode,100.0));

        return graph;
		
	}

}
