package com.tinhoctainha.tms.api.dto;

import javax.persistence.*;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.Set;

@Entity
public class Vehicle extends IncrementIDBaseEntity {
    private String vehicleNumber;
    private String vehicleSymbol;
    private String brand;
    private String modelCode;
    private Date yearManufacture;
    private Integer type;
    private String owner;

    @OneToMany(mappedBy = "vehicle")
    private List<Operation> operations;

    @OneToMany(mappedBy = "vehicle")
    private List<WaybillDetail> waybillDetails;

    @OneToMany(mappedBy = "vehicle")
    private List<VehicleHasRomooc> vehicleHasRomoocs;

    @OneToMany(mappedBy = "vehicle")
    private List<StaffHasVehicle> staffHasVehicles;

    @OneToMany(mappedBy = "vehicle")
    private List<Oil> oils;

    @OneToMany(mappedBy = "vehicle")
    private  List<Lease> leases;

    @OneToMany(mappedBy = "vehicle")
    private List<VehicleInsert> vehicleInserts;

    @OneToMany(mappedBy = "vehicle")
    private List<VehicleRemoval> vehicleRemovals;

    @ManyToMany
    @JoinTable(name = "vehicle_has_fee",
            joinColumns = {@JoinColumn(name = "vehicle_id")},
            inverseJoinColumns = {@JoinColumn(name = "fee_id")}
    )
    private Set<Fee> fees;

    @Basic
    @Column(name = "vehicle_number")
    public String getVehicleNumber() {
        return vehicleNumber;
    }

    public void setVehicleNumber(String vehicleNumber) {
        this.vehicleNumber = vehicleNumber;
    }

    @Basic
    @Column(name = "vehicle_symbol")
    public String getVehicleSymbol() {
        return vehicleSymbol;
    }

    public void setVehicleSymbol(String vehicleSymbol) {
        this.vehicleSymbol = vehicleSymbol;
    }

    @Basic
    @Column(name = "brand")
    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    @Basic
    @Column(name = "model_code")
    public String getModelCode() {
        return modelCode;
    }

    public void setModelCode(String modelCode) {
        this.modelCode = modelCode;
    }

    @Basic
    @Temporal(TemporalType.DATE)
    @Column(name = "year_manufacture")
    public Date getYearManufacture() {
        return yearManufacture;
    }

    public void setYearManufacture(Date yearManufacture) {
        this.yearManufacture = yearManufacture;
    }

    @Basic
    @Column(name = "type")
    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    @Basic
    @Column(name = "owner")
    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public List<Operation> getOperations() {
        return operations;
    }

    public void setOperations(List<Operation> operations) {
        this.operations = operations;
    }

    public List<WaybillDetail> getWaybillDetails() {
        return waybillDetails;
    }

    public void setWaybillDetails(List<WaybillDetail> waybillDetails) {
        this.waybillDetails = waybillDetails;
    }

    public List<VehicleHasRomooc> getVehicleHasRomoocs() {
        return vehicleHasRomoocs;
    }

    public void setVehicleHasRomoocs(List<VehicleHasRomooc> vehicleHasRomoocs) {
        this.vehicleHasRomoocs = vehicleHasRomoocs;
    }

    public List<StaffHasVehicle> getStaffHasVehicles() {
        return staffHasVehicles;
    }

    public void setStaffHasVehicles(List<StaffHasVehicle> staffHasVehicles) {
        this.staffHasVehicles = staffHasVehicles;
    }

    public List<Oil> getOils() {
        return oils;
    }

    public void setOils(List<Oil> oils) {
        this.oils = oils;
    }

    public List<Lease> getLeases() {
        return leases;
    }

    public void setLeases(List<Lease> leases) {
        this.leases = leases;
    }

    public List<VehicleInsert> getVehicleInserts() {
        return vehicleInserts;
    }

    public void setVehicleInserts(List<VehicleInsert> vehicleInserts) {
        this.vehicleInserts = vehicleInserts;
    }

    public List<VehicleRemoval> getVehicleRemovals() {
        return vehicleRemovals;
    }

    public void setVehicleRemovals(List<VehicleRemoval> vehicleRemovals) {
        this.vehicleRemovals = vehicleRemovals;
    }

    public Set<Fee> getFees() {
        return fees;
    }

    public void setFees(Set<Fee> fees) {
        this.fees = fees;
    }

    @Override
    public boolean equals(Object o){
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Vehicle vehicle = (Vehicle) o;
        return (getId() == vehicle.getId() &&
                Objects.equals(vehicleNumber, vehicle.vehicleNumber) &&
                Objects.equals(vehicleSymbol, vehicle.vehicleSymbol) &&
                Objects.equals(brand, vehicle.brand) &&
                Objects.equals(modelCode, vehicle.modelCode) &&
                Objects.equals(yearManufacture, vehicle.yearManufacture) &&
                Objects.equals(type, vehicle.type) &&
                Objects.equals(owner, vehicle.owner));
    }

    @Override
    public int hashCode(){
        return Objects.hash(getId(), vehicleNumber, vehicleSymbol, brand, modelCode, yearManufacture, type, owner);
    }
}
