package com.tinhoctainha.tms.api.dto;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;

public class PlaceDto implements Serializable {
    private Long id;
    private String name;
    private Float longitude;
    private Float latitude;
    private ProvinceDto province;
    private List<RoadDto> startRoads;
    private List<RoadDto> finishRoads;
    private List<RouteDto> startRoutes;
    private List<RouteDto> finishRoutes;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Float getLongitude() {
        return longitude;
    }

    public void setLongitude(Float longitude) {
        this.longitude = longitude;
    }

    public Float getLatitude() {
        return latitude;
    }

    public void setLatitude(Float latitude) {
        this.latitude = latitude;
    }

    public ProvinceDto getProvince() {
        return province;
    }

    public void setProvince(ProvinceDto province) {
        this.province = province;
    }

    public List<RoadDto> getStartRoads() {
        return startRoads;
    }

    public void setStartRoads(List<RoadDto> startRoads) {
        this.startRoads = startRoads;
    }

    public List<RoadDto> getFinishRoads() {
        return finishRoads;
    }

    public void setFinishRoads(List<RoadDto> finishRoads) {
        this.finishRoads = finishRoads;
    }

    public List<RouteDto> getStartRoutes() {
        return startRoutes;
    }

    public void setStartRoutes(List<RouteDto> startRoutes) {
        this.startRoutes = startRoutes;
    }

    public List<RouteDto> getFinishRoutes() {
        return finishRoutes;
    }

    public void setFinishRoutes(List<RouteDto> finishRoutes) {
        this.finishRoutes = finishRoutes;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PlaceDto place = (PlaceDto) o;
        return (getId() == place.getId() &&
                Objects.equals(name, place.name) &&
                Objects.equals(longitude, place.longitude) &&
                Objects.equals(latitude, place.latitude));
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), name, longitude, latitude);
    }

}
