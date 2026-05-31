package com.SmartMaps.Smart.Route.Planner.service;

import com.SmartMaps.Smart.Route.Planner.model.Coordinate;
import com.SmartMaps.Smart.Route.Planner.model.graph.Graph;

public interface GraphBuilderService 
{
    Graph buildGraph(Coordinate source,Coordinate destination);
}
