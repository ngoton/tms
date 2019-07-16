package com.tinhoctainha.tms.domain.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.Objects;
import java.util.Set;

@Entity
@IdClass(RouteId.class)
public class Route implements Serializable {
    @Id
    @ManyToOne
    @JoinColumn(name = "start", referencedColumnName = "id", nullable = false)
    private Place start;

    @Id
    @ManyToOne
    @JoinColumn(name = "finish", referencedColumnName = "id", nullable = false)
    private Place finish;

    @Id
    @Temporal(TemporalType.DATE)
    @Column(name = "start_date")
    private Date startDate;

    @ManyToMany(mappedBy = "routes")
    private Set<Road> roads;

    private Float distance;
    private Float time;
    private Integer way;
    private Float oil;
    private Double transFee;
    private Double salary;
    private Date endDate;

    @Basic
    @Column(name = "distance")
    public Float getDistance() {
        return distance;
    }

    public void setDistance(Float distance) {
        this.distance = distance;
    }

    @Basic
    @Column(name = "time")
    public Float getTime() {
        return time;
    }

    public void setTime(Float time) {
        this.time = time;
    }

    @Basic
    @Column(name = "way")
    public Integer getWay() {
        return way;
    }

    public void setWay(Integer way) {
        this.way = way;
    }

    @Basic
    @Column(name = "oil")
    public Float getOil() {
        return oil;
    }

    public void setOil(Float oil) {
        this.oil = oil;
    }

    @Basic
    @Column(name = "trans_fee", precision = 12, scale = 2)
    public Double getTransFee() {
        return transFee;
    }

    public void setTransFee(Double transFee) {
        this.transFee = transFee;
    }

    @Basic
    @Column(name = "salary", precision = 12, scale = 2)
    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }

    @Basic
    @Temporal(TemporalType.DATE)
    @Column(name = "end_date")
    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

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

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Set<Road> getRoads() {
        return roads;
    }

    public void setRoads(Set<Road> roads) {
        this.roads = roads;
    }

    @Override
    public boolean equals(Object o){
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Route route = (Route) o;
        return (Objects.equals(start, route.start) &&
                Objects.equals(finish, route.finish) &&
                Objects.equals(startDate, route.startDate) &&
                Objects.equals(endDate, route.endDate) &&
                Objects.equals(distance, route.distance) &&
                Objects.equals(time, route.time) &&
                Objects.equals(way, route.way) &&
                Objects.equals(oil, route.oil) &&
                Objects.equals(transFee, route.transFee) &&
                Objects.equals(salary, route.salary));
    }

    @Override
    public int hashCode(){
        return Objects.hash(start, finish, startDate, endDate, distance, time, way, oil, transFee, salary);
    }
}
