package com.SmartMaps.Smart.Route.Planner.model.graph;

import java.util.List;

public class RoutePath 
{
    private List<Node> path;

    private Double totalDistance;

    private Long nodesVisited;

    private Long executionTime;
    
    private String algorithmName;

	public String getAlgorithmName() {
		return algorithmName;
	}

	public void setAlgorithmName(String algorithmName) {
		this.algorithmName = algorithmName;
	}

	public List<Node> getPath() {
		return path;
	}

	public void setPath(List<Node> path) {
		this.path = path;
	}

	public Double getTotalDistance() {
		return totalDistance;
	}

	public void setTotalDistance(Double totalDistance) {
		this.totalDistance = totalDistance;
	}

	public Long getNodesVisited() {
		return nodesVisited;
	}

	public void setNodesVisited(Long nodesVisited) {
		this.nodesVisited = nodesVisited;
	}

	public Long getExecutionTime() {
		return executionTime;
	}

	public void setExecutionTime(Long executionTime) {
		this.executionTime = executionTime;
	}

	public RoutePath(List<Node> path, Double totalDistance, Long nodesVisited, Long executionTime,String algorithmName) {
		super();
		this.path = path;
		this.totalDistance = totalDistance;
		this.nodesVisited = nodesVisited;
		this.executionTime = executionTime;
		this.algorithmName = algorithmName;
	}

	public RoutePath() {
		super();
		// TODO Auto-generated constructor stub
	}
    
    
}
