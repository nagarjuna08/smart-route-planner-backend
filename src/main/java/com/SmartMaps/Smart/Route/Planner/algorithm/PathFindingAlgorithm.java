package com.SmartMaps.Smart.Route.Planner.algorithm;

import com.SmartMaps.Smart.Route.Planner.model.graph.Graph;
import com.SmartMaps.Smart.Route.Planner.model.graph.Node;
import com.SmartMaps.Smart.Route.Planner.model.graph.RoutePath;

public interface PathFindingAlgorithm 
{
    RoutePath findPath(Graph graph,Node source,Node destination);
}
