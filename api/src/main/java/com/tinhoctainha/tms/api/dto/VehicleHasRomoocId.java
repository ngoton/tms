package com.tinhoctainha.tms.api.dto;

import javax.persistence.Embeddable;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

@Embeddable
public class VehicleHasRomoocId implements Serializable {
    private Vehicle vehicle;
    private Romooc romooc;

    @Temporal(TemporalType.DATE)
    private Date startDate;

    public VehicleHasRomoocId(){}
    public VehicleHasRomoocId(Vehicle vehicle, Romooc romooc, Date startDate){
        this.vehicle = vehicle;
        this.romooc = romooc;
        this.startDate = startDate;
    }

    public Long getVehicle() {
        return vehicle.getId();
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    public Long getRomooc() {
        return romooc.getId();
    }

    public void setRomooc(Romooc romooc) {
        this.romooc = romooc;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    @Override
    public boolean equals(Object o){
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        VehicleHasRomoocId that = (VehicleHasRomoocId) o;
        return (Objects.equals(vehicle, that.vehicle) && Objects.equals(romooc, that.romooc) && Objects.equals(startDate, that.startDate));
    }

    @Override
    public int hashCode(){
        return Objects.hash(vehicle, romooc, startDate);
    }
}
