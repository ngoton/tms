package com.tinhoctainha.tms.api.dto;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.tinhoctainha.tms.api.util.CustomDateDeserializer;
import com.tinhoctainha.tms.api.util.CustomDateSerializer;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Objects;

public class VehicleDto implements Serializable {
    private Long id;
    private String vehicleNumber;
    private String vehicleSymbol;
    private String brand;
    private String modelCode;
    private Date yearManufacture;
    private Integer type;
    private String owner;
    private List<OperationDto> operations;
    private List<WaybillDetailDto> waybillDetails;
    private List<VehicleHasRomoocDto> vehicleHasRomoocs;
    private List<StaffHasVehicleDto> staffHasVehicles;
    private List<OilDto> oils;
    private List<LeaseDto> leases;
    private List<VehicleInsertDto> vehicleInserts;
    private List<VehicleRemovalDto> vehicleRemovals;
    private List<FeeDto> fees;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getVehicleNumber() {
        return vehicleNumber;
    }

    public void setVehicleNumber(String vehicleNumber) {
        this.vehicleNumber = vehicleNumber;
    }

    public String getVehicleSymbol() {
        return vehicleSymbol;
    }

    public void setVehicleSymbol(String vehicleSymbol) {
        this.vehicleSymbol = vehicleSymbol;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModelCode() {
        return modelCode;
    }

    public void setModelCode(String modelCode) {
        this.modelCode = modelCode;
    }

    @JsonSerialize(using = CustomDateSerializer.class)
    public Date getYearManufacture() {
        return yearManufacture;
    }

    @JsonDeserialize(using = CustomDateDeserializer.class)
    public void setYearManufacture(Date yearManufacture) {
        this.yearManufacture = yearManufacture;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public List<OperationDto> getOperations() {
        return operations;
    }

    public void setOperations(List<OperationDto> operations) {
        this.operations = operations;
    }

    public List<WaybillDetailDto> getWaybillDetails() {
        return waybillDetails;
    }

    public void setWaybillDetails(List<WaybillDetailDto> waybillDetails) {
        this.waybillDetails = waybillDetails;
    }

    public List<VehicleHasRomoocDto> getVehicleHasRomoocs() {
        return vehicleHasRomoocs;
    }

    public void setVehicleHasRomoocs(List<VehicleHasRomoocDto> vehicleHasRomoocs) {
        this.vehicleHasRomoocs = vehicleHasRomoocs;
    }

    public List<StaffHasVehicleDto> getStaffHasVehicles() {
        return staffHasVehicles;
    }

    public void setStaffHasVehicles(List<StaffHasVehicleDto> staffHasVehicles) {
        this.staffHasVehicles = staffHasVehicles;
    }

    public List<OilDto> getOils() {
        return oils;
    }

    public void setOils(List<OilDto> oils) {
        this.oils = oils;
    }

    public List<LeaseDto> getLeases() {
        return leases;
    }

    public void setLeases(List<LeaseDto> leases) {
        this.leases = leases;
    }

    public List<VehicleInsertDto> getVehicleInserts() {
        return vehicleInserts;
    }

    public void setVehicleInserts(List<VehicleInsertDto> vehicleInserts) {
        this.vehicleInserts = vehicleInserts;
    }

    public List<VehicleRemovalDto> getVehicleRemovals() {
        return vehicleRemovals;
    }

    public void setVehicleRemovals(List<VehicleRemovalDto> vehicleRemovals) {
        this.vehicleRemovals = vehicleRemovals;
    }

    public List<FeeDto> getFees() {
        return fees;
    }

    public void setFees(List<FeeDto> fees) {
        this.fees = fees;
    }

    @Override
    public boolean equals(Object o){
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        VehicleDto vehicle = (VehicleDto) o;
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
