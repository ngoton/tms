package com.tinhoctainha.tms.domain.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
public class WaybillDetail implements Serializable {
    @Id
    @OneToOne
    @JoinColumn(name = "waybill_id", referencedColumnName = "id", nullable = false)
    private Waybill waybill;

    @ManyToOne
    @JoinColumn(name = "vehicle_id", referencedColumnName = "id", nullable = false)
    private Vehicle vehicle;

    @ManyToOne
    @JoinColumn(name = "romooc_id", referencedColumnName = "id", nullable = false)
    private Romooc romooc;

    @ManyToOne
    @JoinColumn(name = "customer_id", referencedColumnName = "id", nullable = false)
    private Customer customer;

    @ManyToOne
    @JoinColumn(name = "staff_id", referencedColumnName = "id", nullable = false)
    private Staff staff;

    @ManyToOne
    @JoinColumn(name = "commodity_id", referencedColumnName = "id", nullable = false)
    private Commodity commodity;

    public Waybill getWaybill() {
        return waybill;
    }

    public void setWaybill(Waybill waybill) {
        this.waybill = waybill;
    }

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

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Staff getStaff() {
        return staff;
    }

    public void setStaff(Staff staff) {
        this.staff = staff;
    }

    public Commodity getCommodity() {
        return commodity;
    }

    public void setCommodity(Commodity commodity) {
        this.commodity = commodity;
    }

    @Override
    public boolean equals(Object o){
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        WaybillDetail waybillDetail = (WaybillDetail) o;
        return (Objects.equals(waybill, waybillDetail.waybill));
    }

    @Override
    public int hashCode(){
        return Objects.hash(waybill);
    }
}
