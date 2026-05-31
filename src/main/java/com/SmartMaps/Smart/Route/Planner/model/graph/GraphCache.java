package com.SmartMaps.Smart.Route.Planner.model.graph;


import org.springframework.stereotype.Component;

@Component
public class GraphCache {

    private Graph graph;

    public Graph getGraph() {
        return graph;
    }

    public void setGraph(Graph graph) {
        this.graph = graph;
    }

    public boolean hasGraph() {
        return graph != null;
    }

    public void clear() {
        this.graph = null;
    }
}
