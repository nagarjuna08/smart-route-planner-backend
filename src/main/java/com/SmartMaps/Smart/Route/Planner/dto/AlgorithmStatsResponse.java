package com.SmartMaps.Smart.Route.Planner.dto;

public class AlgorithmStatsResponse 
{
    private String algorithmName;

    private Double distance;

    private Long nodesVisited;

    private Long executionTime;

	public String getAlgorithmName() {
		return algorithmName;
	}

	public void setAlgorithmName(String algorithmName) {
		this.algorithmName = algorithmName;
	}

	public Double getDistance() {
		return distance;
	}

	public void setDistance(Double distance) {
		this.distance = distance;
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

	public AlgorithmStatsResponse(String algorithmName, Double distance, Long nodesVisited, Long executionTime) {
		super();
		this.algorithmName = algorithmName;
		this.distance = distance;
		this.nodesVisited = nodesVisited;
		this.executionTime = executionTime;
	}

	public AlgorithmStatsResponse() {
		super();
		// TODO Auto-generated constructor stub
	}
    
    
}
