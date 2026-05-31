package com.SmartMaps.Smart.Route.Planner.model;

public class RouteSegment 
{
    private Coordinate start;

    private Coordinate end;

    private Double distance;

    private Double duration;

	public Coordinate getStart() {
		return start;
	}

	public void setStart(Coordinate start) {
		this.start = start;
	}

	public Coordinate getEnd() {
		return end;
	}

	public void setEnd(Coordinate end) {
		this.end = end;
	}

	public Double getDistance() {
		return distance;
	}

	public void setDistance(Double distance) {
		this.distance = distance;
	}

	public Double getDuration() {
		return duration;
	}

	public void setDuration(Double duration) {
		this.duration = duration;
	}

	public RouteSegment(Coordinate start, Coordinate end, Double distance, Double duration) {
		super();
		this.start = start;
		this.end = end;
		this.distance = distance;
		this.duration = duration;
	}

	public RouteSegment() {
		super();
		// TODO Auto-generated constructor stub
	}
    
    
}
