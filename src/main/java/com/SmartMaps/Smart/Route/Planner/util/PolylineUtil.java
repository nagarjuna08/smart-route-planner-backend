package com.SmartMaps.Smart.Route.Planner.util;

import java.util.List;
import java.util.stream.Collectors;

import com.SmartMaps.Smart.Route.Planner.dto.CoordinateDto;
import com.SmartMaps.Smart.Route.Planner.model.graph.Node;

public class PolylineUtil {

    public static List<CoordinateDto>
    convertNodesToCoordinates(
            List<Node> nodes) {

        return nodes.stream()
                .map(node ->
                        new CoordinateDto(
                                node.getLatitude(),
                                node.getLongitude()))
                .collect(Collectors.toList());
    }
}
