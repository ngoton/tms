package com.tinhoctainha.tms.domain.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

@Entity
@Table(name = "staff_has_vehicle")
@IdClass(StaffHasVehicleId.class)
public class StaffHasVehicle implements Serializable {
    @Id
    @ManyToOne
    @JoinColumn(name = "staff_id", referencedColumnName = "id", nullable = false)
    private Staff staff;

    @Id
    @ManyToOne
    @JoinColumn(name = "vehicle_id", referencedColumnName = "id", nullable = false)
    private Vehicle vehicle;

    @Id
    @Temporal(TemporalType.DATE)
    @Column(name = "start_date")
    private Date startDate;

    @Basic
    @Temporal(TemporalType.DATE)
    @Column(name = "end_date")
    private Date endDate;

    public Staff getStaff() {
        return staff;
    }

    public void setStaff(Staff staff) {
        this.staff = staff;
    }

    public Vehicle getVehicle() {
        return vehicle;
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

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    @Override
    public boolean equals(Object o){
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        StaffHasVehicle staffHasVehicle = (StaffHasVehicle) o;
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
