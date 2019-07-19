package com.tinhoctainha.tms.api.dto;

import java.io.Serializable;
import java.util.*;

public class RomoocDto implements Serializable {
    private Long id;
    private String romoocNumber;
    private String romoocSymbol;
    private String contNumber;
    private List<WaybillDetailDto> waybillDetails;
    private List<RomoocInsertDto> romoocInserts;
    private List<RomoocRemovalDto> romoocRemovals;
    private List<VehicleHasRomoocDto> vehicleHasRomoocs;
    private List<FeeDto> fees = new ArrayList<>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRomoocNumber() {
        return romoocNumber;
    }

    public void setRomoocNumber(String romoocNumber) {
        this.romoocNumber = romoocNumber;
    }

    public String getRomoocSymbol() {
        return romoocSymbol;
    }

    public void setRomoocSymbol(String romoocSymbol) {
        this.romoocSymbol = romoocSymbol;
    }

    public String getContNumber() {
        return contNumber;
    }

    public void setContNumber(String contNumber) {
        this.contNumber = contNumber;
    }

    public List<WaybillDetailDto> getWaybillDetails() {
        return waybillDetails;
    }

    public void setWaybillDetails(List<WaybillDetailDto> waybillDetails) {
        this.waybillDetails = waybillDetails;
    }

    public List<RomoocInsertDto> getRomoocInserts() {
        return romoocInserts;
    }

    public void setRomoocInserts(List<RomoocInsertDto> romoocInserts) {
        this.romoocInserts = romoocInserts;
    }

    public List<RomoocRemovalDto> getRomoocRemovals() {
        return romoocRemovals;
    }

    public void setRomoocRemovals(List<RomoocRemovalDto> romoocRemovals) {
        this.romoocRemovals = romoocRemovals;
    }

    public List<VehicleHasRomoocDto> getVehicleHasRomoocs() {
        return vehicleHasRomoocs;
    }

    public void setVehicleHasRomoocs(List<VehicleHasRomoocDto> vehicleHasRomoocs) {
        this.vehicleHasRomoocs = vehicleHasRomoocs;
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
        RomoocDto romooc = (RomoocDto) o;
        return (getId() == romooc.getId() &&
                Objects.equals(romoocNumber, romooc.romoocNumber) &&
                Objects.equals(romoocSymbol, romooc.romoocSymbol) &&
                Objects.equals(contNumber, romooc.contNumber));
    }

    @Override
    public int hashCode(){
        return Objects.hash(getId(), romoocNumber, romoocSymbol, contNumber);
    }

}
