package com.SmartMaps.Smart.Route.Planner.algorithm.astar;

import com.SmartMaps.Smart.Route.Planner.algorithm.PathFindingAlgorithm;
import com.SmartMaps.Smart.Route.Planner.model.graph.Graph;
import com.SmartMaps.Smart.Route.Planner.model.graph.Node;
import com.SmartMaps.Smart.Route.Planner.model.graph.RoutePath;


import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.SmartMaps.Smart.Route.Planner.model.graph.*;

@Service
public class AStarService
        implements PathFindingAlgorithm {

	@Autowired
    private final HeuristicCalculator  heuristicCalculator;
	
    public AStarService(
            HeuristicCalculator heuristicCalculator) {

        this.heuristicCalculator = heuristicCalculator;
    }

    @Override
    public RoutePath findPath( Graph graph, Node source, Node destination) {

        long startTime = System.currentTimeMillis();

        Map<Node, Double> gScore = new HashMap<>();

        Map<Node, Double> fScore = new HashMap<>();

        Map<Node, Node> previous = new HashMap<>();

        for (Node node : graph.getAdjacencyList().keySet()) {

            gScore.put(node,Double.MAX_VALUE);

            fScore.put(node,Double.MAX_VALUE);
        }

        gScore.put(source, 0.0);

        fScore.put(
                source,
                heuristicCalculator.calculate(
                        source,
                        destination));

        PriorityQueue<Node> openSet =
                new PriorityQueue<>(
                        Comparator.comparingDouble(
                                fScore::get));

        openSet.add(source);

        long nodesVisited = 0;

        while (!openSet.isEmpty()) {

            Node current =
                    openSet.poll();

            nodesVisited++;

            if (current.equals(destination)) {
                break;
            }

            for (Edge edge :
                    graph.getAdjacencyList()
                         .get(current)) {

                Node neighbor =
                        edge.getDestination();

                double tentativeScore =
                        gScore.get(current)
                        + edge.getDistance();

                if (tentativeScore
                        < gScore.get(neighbor)) {

                    previous.put(
                            neighbor,
                            current);

                    gScore.put(
                            neighbor,
                            tentativeScore);

                    fScore.put(
                            neighbor,
                            tentativeScore
                            + heuristicCalculator
                            .calculate(
                                    neighbor,
                                    destination));

                    openSet.add(neighbor);
                }
            }
        }

        RoutePath path =
                buildPath(
                        previous,
                        source,
                        destination);

        path.setTotalDistance(
                gScore.get(destination));

        path.setNodesVisited(
                nodesVisited);

        path.setExecutionTime(
                System.currentTimeMillis()
                - startTime);

        path.setAlgorithmName(
                "ASTAR");

        return path;
    }

    private RoutePath buildPath(
            Map<Node, Node> previous,
            Node source,
            Node destination) {

        List<Node> nodes =
                new ArrayList<>();

        Node current =
                destination;

        while (current != null) {

            nodes.add(current);

            current =
                    previous.get(current);
        }

        Collections.reverse(nodes);

        RoutePath path =
                new RoutePath();

        path.setPath(nodes);

        return path;
    }
}
