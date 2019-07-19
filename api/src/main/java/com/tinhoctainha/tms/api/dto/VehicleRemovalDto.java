package com.tinhoctainha.tms.api.dto;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.tinhoctainha.tms.api.util.CustomDateDeserializer;
import com.tinhoctainha.tms.api.util.CustomDateSerializer;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

public class VehicleRemovalDto implements Serializable {
    private Long id;
    private Date removalDate;
    private Float quantity;
    private VehicleDto vehicle;
    private ItemDto item;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @JsonSerialize(using = CustomDateSerializer.class)
    public Date getRemovalDate() {
        return removalDate;
    }

    @JsonDeserialize(using = CustomDateDeserializer.class)
    public void setRemovalDate(Date removalDate) {
        this.removalDate = removalDate;
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

    @Override
    public boolean equals(Object o){
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        VehicleRemovalDto vehicleRemoval = (VehicleRemovalDto) o;
        return (getId() == vehicleRemoval.getId() &&
                Objects.equals(removalDate, vehicleRemoval.removalDate) &&
                Objects.equals(quantity, vehicleRemoval.quantity));
    }

    @Override
    public int hashCode(){
        return Objects.hash(getId(), removalDate, quantity);
    }

}
