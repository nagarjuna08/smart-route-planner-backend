package com.SmartMaps.Smart.Route.Planner.client.response;


//Response received from OpenStreetMap Nominatim.
public class NominatimResponse 
{
    private String lat;

    private String lon;

    private String display_name;

	public String getLat() {
		return lat;
	}

	public void setLat(String lat) {
		this.lat = lat;
	}

	public String getLon() {
		return lon;
	}

	public void setLon(String lon) {
		this.lon = lon;
	}

	public String getDisplay_name() {
		return display_name;
	}

	public void setDisplay_name(String display_name) {
		this.display_name = display_name;
	}

	public NominatimResponse(String lat, String lon, String display_name) {
		super();
		this.lat = lat;
		this.lon = lon;
		this.display_name = display_name;
	}

	public NominatimResponse() {
		super();
		// TODO Auto-generated constructor stub
	}
    
    
}
