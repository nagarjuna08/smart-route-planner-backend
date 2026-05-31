package com.SmartMaps.Smart.Route.Planner.model.graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Graph 
{
    private Map<Node, List<Edge>> adjacencyList =new HashMap<>();
    
    public Map<Node, List<Edge>> getAdjacencyList() {
        return adjacencyList;
    }

    public void setAdjacencyList(
            Map<Node, List<Edge>> adjacencyList) {

        this.adjacencyList = adjacencyList;
    }

    public void addNode(Node node) 
    {
        adjacencyList.putIfAbsent(node,new ArrayList<>());
    }

    public void addEdge(Edge edge) 
    {
        adjacencyList.get(edge.getSource()).add(edge);
    }
    public Set<Node> getNodes() {

        return adjacencyList.keySet();
    }
    
    public Node getNearestNode(
            double latitude,
            double longitude) {

        Node nearest = null;

        double minDistance = Double.MAX_VALUE;

        for (Node node : getNodes()) {

            double distance = Math.sqrt(Math.pow(node.getLatitude()- latitude, 2)+ Math.pow(node.getLongitude()  - longitude,2));

            if (distance < minDistance) {

                minDistance = distance;

                nearest = node;
            }
        }

        return nearest;
    }
}
