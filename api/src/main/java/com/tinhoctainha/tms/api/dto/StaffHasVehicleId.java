package com.tinhoctainha.tms.api.dto;

import javax.persistence.Embeddable;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

@Embeddable
public class StaffHasVehicleId implements Serializable {
    private Staff staff;
    private Vehicle vehicle;

    @Temporal(TemporalType.DATE)
    private Date startDate;

    public StaffHasVehicleId(){}
    public StaffHasVehicleId(Staff staff, Vehicle vehicle, Date startDate){
        this.staff = staff;
        this.vehicle = vehicle;
        this.startDate = startDate;
    }

    public Long getStaff() {
        return staff.getId();
    }

    public void setStaff(Staff staff) {
        this.staff = staff;
    }

    public Long getVehicle() {
        return vehicle.getId();
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
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
        StaffHasVehicleId that = (StaffHasVehicleId) o;
        return (Objects.equals(staff, that.staff) && Objects.equals(vehicle, that.vehicle) && Objects.equals(startDate, that.startDate));
    }

    @Override
    public int hashCode(){
        return Objects.hash(staff, vehicle, startDate);
    }
}
