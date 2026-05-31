package com.SmartMaps.Smart.Route.Planner.client.response;

public class OverpassResponse 
{
    private Long id;

    private Double lat;

    private Double lon;

    private Tags tags;

    
    
    
    public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Double getLat() {
		return lat;
	}

	public void setLat(Double lat) {
		this.lat = lat;
	}

	public Double getLon() {
		return lon;
	}

	public void setLon(Double lon) {
		this.lon = lon;
	}

	public Tags getTags() {
		return tags;
	}

	public void setTags(Tags tags) {
		this.tags = tags;
	}
	

	public OverpassResponse() {
		super();
		// TODO Auto-generated constructor stub
	}

	public OverpassResponse(Long id, Double lat, Double lon, Tags tags) {
		super();
		this.id = id;
		this.lat = lat;
		this.lon = lon;
		this.tags = tags;
	}


	public static class Tags {

        private String name;

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public Tags(String name) {
			super();
			this.name = name;
		}

		public Tags() {
			super();
			// TODO Auto-generated constructor stub
		}
        
        
    }
}
