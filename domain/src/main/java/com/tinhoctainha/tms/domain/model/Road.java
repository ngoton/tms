package com.tinhoctainha.tms.domain.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

@Entity
@IdClass(RoadId.class)
public class Road implements Serializable {
    @Id
    @ManyToOne
    @JoinColumn(name = "start",referencedColumnName = "id", nullable = false)
    private Place start;

    @Id
    @ManyToOne
    @JoinColumn(name = "finish", referencedColumnName = "id", nullable = false)
    private Place finish;

    @OneToMany(mappedBy = "road")
    private List<Operation> operations;

    @ManyToMany
    @JoinTable(name = "road_has_route",
            joinColumns = {@JoinColumn(name = "road_start"), @JoinColumn(name = "road_finish")},
            inverseJoinColumns = {@JoinColumn(name = "route_start"), @JoinColumn(name = "route_finish"), @JoinColumn(name = "route_start_date")}
    )
    private Set<Route> routes = new HashSet<>();

    public Place getStart() {
        return start;
    }

    public void setStart(Place start) {
        this.start = start;
    }

    public Place getFinish() {
        return finish;
    }

    public void setFinish(Place finish) {
        this.finish = finish;
    }

    public List<Operation> getOperations() {
        return operations;
    }

    public void setOperations(List<Operation> operations) {
        this.operations = operations;
    }

    public Set<Route> getRoutes() {
        return routes;
    }

    public void setRoutes(Set<Route> routes) {
        this.routes = routes;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Road that = (Road) o;
        return Objects.equals(start, that.start) && Objects.equals(finish, that.finish);
    }

    @Override
    public int hashCode() {
        return Objects.hash(start, finish);
    }
}
