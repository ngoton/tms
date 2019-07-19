package com.tinhoctainha.tms.api.dto;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.tinhoctainha.tms.api.util.CustomDateDeserializer;
import com.tinhoctainha.tms.api.util.CustomDateSerializer;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.Set;

public class RouteDto implements Serializable {
    private PlaceDto start;
    private PlaceDto finish;
    private Date startDate;
    private List<RoadDto> roads;
    private Float distance;
    private Float time;
    private Integer way;
    private Float oil;
    private Double transFee;
    private Double salary;
    private Date endDate;

    public Float getDistance() {
        return distance;
    }

    public void setDistance(Float distance) {
        this.distance = distance;
    }

    public Float getTime() {
        return time;
    }

    public void setTime(Float time) {
        this.time = time;
    }

    public Integer getWay() {
        return way;
    }

    public void setWay(Integer way) {
        this.way = way;
    }

    public Float getOil() {
        return oil;
    }

    public void setOil(Float oil) {
        this.oil = oil;
    }

    public Double getTransFee() {
        return transFee;
    }

    public void setTransFee(Double transFee) {
        this.transFee = transFee;
    }

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }

    @JsonSerialize(using = CustomDateSerializer.class)
    public Date getEndDate() {
        return endDate;
    }

    @JsonDeserialize(using = CustomDateDeserializer.class)
    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

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

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public List<RoadDto> getRoads() {
        return roads;
    }

    public void setRoads(List<RoadDto> roads) {
        this.roads = roads;
    }

    @Override
    public boolean equals(Object o){
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RouteDto route = (RouteDto) o;
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
