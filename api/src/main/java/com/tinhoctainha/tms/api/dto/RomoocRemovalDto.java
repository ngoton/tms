package com.tinhoctainha.tms.api.dto;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.tinhoctainha.tms.api.util.CustomDateDeserializer;
import com.tinhoctainha.tms.api.util.CustomDateSerializer;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

public class RomoocRemovalDto implements Serializable {
    private Long id;
    private Date removalDate;
    private Float quantity;
    private RomoocDto romooc;
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

    public RomoocDto getRomooc() {
        return romooc;
    }

    public void setRomooc(RomoocDto romooc) {
        this.romooc = romooc;
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
        RomoocRemovalDto romoocRemoval = (RomoocRemovalDto) o;
        return (getId() == romoocRemoval.getId() &&
                Objects.equals(removalDate, romoocRemoval.removalDate) &&
                Objects.equals(quantity, romoocRemoval.quantity));
    }

    @Override
    public int hashCode(){
        return Objects.hash(getId(), removalDate, quantity);
    }

}
