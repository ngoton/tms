package com.tinhoctainha.tms.api.dto;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.tinhoctainha.tms.api.util.CustomDateDeserializer;
import com.tinhoctainha.tms.api.util.CustomDateSerializer;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

public class PriceDto implements Serializable {
    private CustomerDto customer;
    private CommodityDto commodity;
    private Date startDate;
    private Date endDate;
    private Integer unit;
    private Double price;

    public CustomerDto getCustomer() {
        return customer;
    }

    public void setCustomer(CustomerDto customer) {
        this.customer = customer;
    }

    public CommodityDto getCommodity() {
        return commodity;
    }

    public void setCommodity(CommodityDto commodity) {
        this.commodity = commodity;
    }

    @JsonSerialize(using = CustomDateSerializer.class)
    public Date getStartDate() {
        return startDate;
    }

    @JsonDeserialize(using = CustomDateDeserializer.class)
    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    @JsonSerialize(using = CustomDateSerializer.class)
    public Date getEndDate() {
        return endDate;
    }

    @JsonDeserialize(using = CustomDateDeserializer.class)
    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public Integer getUnit() {
        return unit;
    }

    public void setUnit(Integer unit) {
        this.unit = unit;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    @Override
    public boolean equals(Object o){
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PriceDto price = (PriceDto) o;
        return (Objects.equals(customer, price.customer) &&
                Objects.equals(commodity, price.commodity) &&
                Objects.equals(startDate, price.startDate) &&
                Objects.equals(endDate, price.endDate) &&
                Objects.equals(unit, price.unit) &&
                Objects.equals(price, price.price));
    }

    @Override
    public int hashCode(){
        return Objects.hash(customer, commodity, startDate, endDate, unit, price);
    }
}
