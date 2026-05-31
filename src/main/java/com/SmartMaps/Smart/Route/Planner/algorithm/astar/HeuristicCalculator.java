package com.SmartMaps.Smart.Route.Planner.algorithm.astar;

import org.springframework.stereotype.Component;
import com.SmartMaps.Smart.Route.Planner.model.graph.Node;

@Component
public class HeuristicCalculator {

    public double calculate(Node current,Node destination) {

        double latDiff = current.getLatitude() - destination.getLatitude();

        double lonDiff = current.getLongitude() - destination.getLongitude();

        return Math.sqrt(latDiff * latDiff + lonDiff * lonDiff);
    }
}
