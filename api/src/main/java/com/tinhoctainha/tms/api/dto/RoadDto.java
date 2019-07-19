package com.tinhoctainha.tms.api.dto;

import java.io.Serializable;
import java.util.*;

public class RoadDto implements Serializable {
    private PlaceDto start;
    private PlaceDto finish;
    private List<OperationDto> operations;
    private List<RouteDto> routes = new ArrayList<>();

    public PlaceDto getStart() {
        return start;
    }

    public void setStart(PlaceDto start) {
        this.start = start;
    }

    public PlaceDto getFinish() {
        return finish;
    }

    public void setFinish(PlaceDto finish) {
        this.finish = finish;
    }

    public List<OperationDto> getOperations() {
        return operations;
    }

    public void setOperations(List<OperationDto> operations) {
        this.operations = operations;
    }

    public List<RouteDto> getRoutes() {
        return routes;
    }

    public void setRoutes(List<RouteDto> routes) {
        this.routes = routes;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RoadDto that = (RoadDto) o;
        return Objects.equals(start, that.start) && Objects.equals(finish, that.finish);
    }

    @Override
    public int hashCode() {
        return Objects.hash(start, finish);
    }
}
