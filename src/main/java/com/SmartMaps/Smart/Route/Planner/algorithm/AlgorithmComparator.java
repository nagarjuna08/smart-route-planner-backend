package com.SmartMaps.Smart.Route.Planner.algorithm;

import org.springframework.stereotype.Component;

import com.SmartMaps.Smart.Route.Planner.model.graph.RoutePath;

@Component
public class AlgorithmComparator 
{
	public RoutePath compare(RoutePath dijkstra,RoutePath aStar) {

        if (aStar.getExecutionTime()<= dijkstra.getExecutionTime()) {

            return aStar;
        }

        return dijkstra;
    }
}
