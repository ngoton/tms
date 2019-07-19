package com.tinhoctainha.tms.api.dto;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.tinhoctainha.tms.api.util.CustomDateDeserializer;
import com.tinhoctainha.tms.api.util.CustomDateSerializer;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Objects;

public class ItemDto implements Serializable {
    private Long id;
    private String name;
    private String serial;
    private Date mfg;
    private Date exp;
    private AccessoryDto accessory;
    private List<VehicleInsertDto> vehicleInserts;
    private List<RomoocInsertDto> romoocInserts;
    private List<VehicleRemovalDto> vehicleRemovals;
    private List<RomoocRemovalDto> romoocRemovals;
    private List<IssueHasItemDto> issueHasItems;
    private List<ReceiptHasItemDto> receiptHasItems;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @JsonSerialize(using = CustomDateSerializer.class)
    public String getSerial() {
        return serial;
    }

    @JsonDeserialize(using = CustomDateDeserializer.class)
    public void setSerial(String serial) {
        this.serial = serial;
    }

    @JsonSerialize(using = CustomDateSerializer.class)
    public Date getMfg() {
        return mfg;
    }

    @JsonDeserialize(using = CustomDateDeserializer.class)
    public void setMfg(Date mfg) {
        this.mfg = mfg;
    }

    @JsonSerialize(using = CustomDateSerializer.class)
    public Date getExp() {
        return exp;
    }

    @JsonDeserialize(using = CustomDateDeserializer.class)
    public void setExp(Date exp) {
        this.exp = exp;
    }

    public AccessoryDto getAccessory() {
        return accessory;
    }

    public void setAccessory(AccessoryDto accessory) {
        this.accessory = accessory;
    }

    public List<VehicleInsertDto> getVehicleInserts() {
        return vehicleInserts;
    }

    public void setVehicleInserts(List<VehicleInsertDto> vehicleInserts) {
        this.vehicleInserts = vehicleInserts;
    }

    public List<RomoocInsertDto> getRomoocInserts() {
        return romoocInserts;
    }

    public void setRomoocInserts(List<RomoocInsertDto> romoocInserts) {
        this.romoocInserts = romoocInserts;
    }

    public List<VehicleRemovalDto> getVehicleRemovals() {
        return vehicleRemovals;
    }

    public void setVehicleRemovals(List<VehicleRemovalDto> vehicleRemovals) {
        this.vehicleRemovals = vehicleRemovals;
    }

    public List<RomoocRemovalDto> getRomoocRemovals() {
        return romoocRemovals;
    }

    public void setRomoocRemovals(List<RomoocRemovalDto> romoocRemovals) {
        this.romoocRemovals = romoocRemovals;
    }

    public List<IssueHasItemDto> getIssueHasItems() {
        return issueHasItems;
    }

    public void setIssueHasItems(List<IssueHasItemDto> issueHasItems) {
        this.issueHasItems = issueHasItems;
    }

    public List<ReceiptHasItemDto> getReceiptHasItems() {
        return receiptHasItems;
    }

    public void setReceiptHasItems(List<ReceiptHasItemDto> receiptHasItems) {
        this.receiptHasItems = receiptHasItems;
    }

    @Override
    public boolean equals(Object o){
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ItemDto item = (ItemDto) o;
        return (getId() == item.getId() &&
                Objects.equals(name, item.name) &&
                Objects.equals(serial, item.serial) &&
                Objects.equals(mfg, item.mfg) &&
                Objects.equals(exp, item.exp));
    }

    @Override
    public int hashCode(){
        return Objects.hash(getId(), name, serial, mfg, exp);
    }

}
