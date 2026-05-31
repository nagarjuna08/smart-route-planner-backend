package com.SmartMaps.Smart.Route.Planner.client.response;

import java.util.List;

public class GeoapifyResponse {

    private List<Feature> features;

    public List<Feature> getFeatures() {
        return features;
    }

    public void setFeatures(List<Feature> features) {
        this.features = features;
    }
}
