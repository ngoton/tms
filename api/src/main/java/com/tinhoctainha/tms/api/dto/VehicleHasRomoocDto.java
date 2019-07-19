package com.tinhoctainha.tms.api.dto;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.tinhoctainha.tms.api.util.CustomDateDeserializer;
import com.tinhoctainha.tms.api.util.CustomDateSerializer;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

public class VehicleHasRomoocDto implements Serializable {
    private VehicleDto vehicle;
    private RomoocDto romooc;
    private Date startDate;
    private Date endDate;

    public VehicleDto getVehicle() {
        return vehicle;
    }

    public void setVehicle(VehicleDto vehicle) {
        this.vehicle = vehicle;
    }

    public RomoocDto getRomooc() {
        return romooc;
    }

    public void setRomooc(RomoocDto romooc) {
        this.romooc = romooc;
    }

    @JsonSerialize(using = CustomDateSerializer.class)
    public Date getStartDate() {
        return startDate;
    }

    @JsonDeserialize(using = CustomDateDeserializer.class)
    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    @JsonSerialize(using = CustomDateSerializer.class)
    public Date getEndDate() {
        return endDate;
    }

    @JsonDeserialize(using = CustomDateDeserializer.class)
    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    @Override
    public boolean equals(Object o){
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        VehicleHasRomoocDto vehicleHasRomooc = (VehicleHasRomoocDto) o;
        return (Objects.equals(vehicle, vehicleHasRomooc.vehicle) &&
                Objects.equals(romooc, vehicleHasRomooc.romooc) &&
                Objects.equals(startDate, vehicleHasRomooc.startDate) &&
                Objects.equals(endDate, vehicleHasRomooc.endDate));
    }

    @Override
    public int hashCode(){
        return Objects.hash(vehicle, romooc, startDate, endDate);
    }
}
