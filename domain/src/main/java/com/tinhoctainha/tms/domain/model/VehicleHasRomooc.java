package com.tinhoctainha.tms.domain.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

@Entity
@Table(name = "vehicle_has_romooc")
@IdClass(VehicleHasRomoocId.class)
public class VehicleHasRomooc implements Serializable {
    @Id
    @ManyToOne
    @JoinColumn(name = "vehicle_id", referencedColumnName = "id", nullable = false)
    private Vehicle vehicle;

    @Id
    @ManyToOne
    @JoinColumn(name = "romooc_id", referencedColumnName = "id", nullable = false)
    private Romooc romooc;

    @Id
    @Temporal(TemporalType.DATE)
    @Column(name = "start_date")
    private Date startDate;

    @Basic
    @Column(name = "end_date")
    private Date endDate;

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    public Romooc getRomooc() {
        return romooc;
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
        VehicleHasRomooc vehicleHasRomooc = (VehicleHasRomooc) o;
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
