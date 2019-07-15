package com.tinhoctainha.tms.domain.model;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Entity
public class Place extends IncrementIDBaseEntity {
    private String name;
    private Float longitude;
    private Float latitude;

    @ManyToOne
    @JoinColumn(name = "province_id", referencedColumnName = "id", nullable = false)
    private Province province;

    @OneToMany(mappedBy = "start")
    private List<Road> startRoads;

    @OneToMany(mappedBy = "finish")
    private List<Road> finishRoads;

    @OneToMany(mappedBy = "start")
    private List<Route> startRoutes;

    @OneToMany(mappedBy = "finish")
    private List<Route> finishRoutes;

    @Basic
    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "longitude")
    public Float getLongitude() {
        return longitude;
    }

    public void setLongitude(Float longitude) {
        this.longitude = longitude;
    }

    @Basic
    @Column(name = "latitude")
    public Float getLatitude() {
        return latitude;
    }

    public void setLatitude(Float latitude) {
        this.latitude = latitude;
    }

    public Province getProvince() {
        return province;
    }

    public void setProvince(Province province) {
        this.province = province;
    }

    public List<Road> getStartRoads() {
        return startRoads;
    }

    public void setStartRoads(List<Road> startRoads) {
        this.startRoads = startRoads;
    }

    public List<Road> getFinishRoads() {
        return finishRoads;
    }

    public void setFinishRoads(List<Road> finishRoads) {
        this.finishRoads = finishRoads;
    }

    public List<Route> getStartRoutes() {
        return startRoutes;
    }

    public void setStartRoutes(List<Route> startRoutes) {
        this.startRoutes = startRoutes;
    }

    public List<Route> getFinishRoutes() {
        return finishRoutes;
    }

    public void setFinishRoutes(List<Route> finishRoutes) {
        this.finishRoutes = finishRoutes;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Place place = (Place) o;
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
