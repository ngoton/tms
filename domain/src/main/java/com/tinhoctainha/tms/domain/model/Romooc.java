package com.tinhoctainha.tms.domain.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

@Entity
public class Romooc extends IncrementIDBaseEntity {
    private String romoocNumber;
    private String romoocSymbol;
    private String contNumber;

    @OneToMany(mappedBy = "romooc")
    private List<WaybillDetail> waybillDetails;

    @OneToMany(mappedBy = "romooc")
    private List<RomoocInsert> romoocInserts;

    @OneToMany(mappedBy = "romooc")
    private List<RomoocRemoval> romoocRemovals;

    @OneToMany(mappedBy = "romooc")
    private List<VehicleHasRomooc> vehicleHasRomoocs;

    @ManyToMany
    @JoinTable(name = "romooc_has_fee",
            joinColumns = {@JoinColumn(name = "romooc_id")},
            inverseJoinColumns = {@JoinColumn(name = "fee_id")}
    )
    private Set<Fee> fees = new HashSet<>();

    @NotNull
    @Basic
    @Column(name = "romooc_number")
    public String getRomoocNumber() {
        return romoocNumber;
    }

    public void setRomoocNumber(String romoocNumber) {
        this.romoocNumber = romoocNumber;
    }

    @Basic
    @Column(name = "romooc_symbol")
    public String getRomoocSymbol() {
        return romoocSymbol;
    }

    public void setRomoocSymbol(String romoocSymbol) {
        this.romoocSymbol = romoocSymbol;
    }

    @Basic
    @Column(name = "cont_number")
    public String getContNumber() {
        return contNumber;
    }

    public void setContNumber(String contNumber) {
        this.contNumber = contNumber;
    }

    public List<WaybillDetail> getWaybillDetails() {
        return waybillDetails;
    }

    public void setWaybillDetails(List<WaybillDetail> waybillDetails) {
        this.waybillDetails = waybillDetails;
    }

    public List<RomoocInsert> getRomoocInserts() {
        return romoocInserts;
    }

    public void setRomoocInserts(List<RomoocInsert> romoocInserts) {
        this.romoocInserts = romoocInserts;
    }

    public List<RomoocRemoval> getRomoocRemovals() {
        return romoocRemovals;
    }

    public void setRomoocRemovals(List<RomoocRemoval> romoocRemovals) {
        this.romoocRemovals = romoocRemovals;
    }

    public List<VehicleHasRomooc> getVehicleHasRomoocs() {
        return vehicleHasRomoocs;
    }

    public void setVehicleHasRomoocs(List<VehicleHasRomooc> vehicleHasRomoocs) {
        this.vehicleHasRomoocs = vehicleHasRomoocs;
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
        Romooc romooc = (Romooc) o;
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
