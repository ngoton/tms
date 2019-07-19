package com.tinhoctainha.tms.api.dto;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.tinhoctainha.tms.api.util.CustomDateDeserializer;
import com.tinhoctainha.tms.api.util.CustomDateSerializer;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

public class StaffHasVehicleDto implements Serializable {
    private StaffDto staff;
    private VehicleDto vehicle;
    private Date startDate;
    private Date endDate;

    public StaffDto getStaff() {
        return staff;
    }

    public void setStaff(StaffDto staff) {
        this.staff = staff;
    }

    public VehicleDto getVehicle() {
        return vehicle;
    }

    public void setVehicle(VehicleDto vehicle) {
        this.vehicle = vehicle;
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
        StaffHasVehicleDto staffHasVehicle = (StaffHasVehicleDto) o;
        return (Objects.equals(staff, staffHasVehicle.staff) &&
                Objects.equals(vehicle, staffHasVehicle.vehicle) &&
                Objects.equals(startDate, staffHasVehicle.startDate) &&
                Objects.equals(endDate, staffHasVehicle.endDate));
    }

    @Override
    public int hashCode(){
        return Objects.hash(staff, vehicle, startDate, endDate);
    }
}
