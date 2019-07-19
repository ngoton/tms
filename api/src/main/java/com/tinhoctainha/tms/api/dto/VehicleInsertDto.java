package com.tinhoctainha.tms.api.dto;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.tinhoctainha.tms.api.util.CustomDateDeserializer;
import com.tinhoctainha.tms.api.util.CustomDateSerializer;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

public class VehicleInsertDto implements Serializable {
    private Long id;
    private Date insertDate;
    private Float quantity;
    private VehicleDto vehicle;
    private ItemDto item;
    private IssueDto issue;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @JsonSerialize(using = CustomDateSerializer.class)
    public Date getInsertDate() {
        return insertDate;
    }

    @JsonDeserialize(using = CustomDateDeserializer.class)
    public void setInsertDate(Date insertDate) {
        this.insertDate = insertDate;
    }

    public Float getQuantity() {
        return quantity;
    }

    public void setQuantity(Float quantity) {
        this.quantity = quantity;
    }

    public VehicleDto getVehicle() {
        return vehicle;
    }

    public void setVehicle(VehicleDto vehicle) {
        this.vehicle = vehicle;
    }

    public ItemDto getItem() {
        return item;
    }

    public void setItem(ItemDto item) {
        this.item = item;
    }

    public IssueDto getIssue() {
        return issue;
    }

    public void setIssue(IssueDto issue) {
        this.issue = issue;
    }

    @Override
    public boolean equals(Object o){
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        VehicleInsertDto vehicleInsert = (VehicleInsertDto) o;
        return (getId() == vehicleInsert.getId() &&
                Objects.equals(insertDate, vehicleInsert.insertDate) &&
                Objects.equals(quantity, vehicleInsert.quantity));
    }

    @Override
    public int hashCode(){
        return Objects.hash(getId(), insertDate, quantity);
    }

}
