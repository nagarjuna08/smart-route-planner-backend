package com.SmartMaps.Smart.Route.Planner.algorithm.dijkstra;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

import org.springframework.stereotype.Service;

import com.SmartMaps.Smart.Route.Planner.algorithm.PathFindingAlgorithm;
import com.SmartMaps.Smart.Route.Planner.model.graph.Edge;
import com.SmartMaps.Smart.Route.Planner.model.graph.Graph;
import com.SmartMaps.Smart.Route.Planner.model.graph.Node;
import com.SmartMaps.Smart.Route.Planner.model.graph.RoutePath;

@Service
public class DijkstraService implements PathFindingAlgorithm {

	@Override
	public RoutePath findPath(Graph graph, Node source, Node destination) {
		long startTime =
                System.currentTimeMillis();

        Map<Node, Double> distance =
                new HashMap<>();

        Map<Node, Node> previous =
                new HashMap<>();

        PriorityQueue<Node> queue =
                new PriorityQueue<>(
                        Comparator.comparingDouble(
                                distance::get));

        for (Node node :
                graph.getAdjacencyList().keySet()) {

            distance.put(
                    node,
                    Double.MAX_VALUE);
        }

        distance.put(source, 0.0);

        queue.add(source);

        long nodesVisited = 0;

        while (!queue.isEmpty()) {

            Node current =
                    queue.poll();

            nodesVisited++;

            if (current.equals(destination)) {
                break;
            }

            for (Edge edge :
                    graph.getAdjacencyList()
                         .get(current)) {

                Node neighbor =
                        edge.getDestination();

                double newDistance =
                        distance.get(current)
                        + edge.getDistance();

                if (newDistance
                        < distance.get(neighbor)) {

                    distance.put(
                            neighbor,
                            newDistance);

                    previous.put(
                            neighbor,
                            current);

                    queue.add(neighbor);
                }
            }
        }

        RoutePath path =
                buildPath(
                        previous,
                        source,
                        destination);

        path.setTotalDistance(
                distance.get(destination));

        path.setNodesVisited(
                nodesVisited);

        path.setExecutionTime(
                System.currentTimeMillis()
                - startTime);

        path.setAlgorithmName(
                "DIJKSTRA");

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
