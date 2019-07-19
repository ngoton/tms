package com.tinhoctainha.tms.api.dto;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.tinhoctainha.tms.api.util.CustomDateDeserializer;
import com.tinhoctainha.tms.api.util.CustomDateSerializer;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

public class LeaseDto implements Serializable {
    private Long id;
    private Date leaseDate;
    private Date expiredDate;
    private Double price;
    private VehicleDto vehicle;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @JsonSerialize(using = CustomDateSerializer.class)
    public Date getLeaseDate() {
        return leaseDate;
    }

    @JsonDeserialize(using = CustomDateDeserializer.class)
    public void setLeaseDate(Date leaseDate) {
        this.leaseDate = leaseDate;
    }

    @JsonSerialize(using = CustomDateSerializer.class)
    public Date getExpiredDate() {
        return expiredDate;
    }

    @JsonDeserialize(using = CustomDateDeserializer.class)
    public void setExpiredDate(Date expiredDate) {
        this.expiredDate = expiredDate;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public VehicleDto getVehicle() {
        return vehicle;
    }

    public void setVehicle(VehicleDto vehicle) {
        this.vehicle = vehicle;
    }

    @Override
    public boolean equals(Object o){
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LeaseDto lease = (LeaseDto) o;
        return (getId() == lease.getId() &&
                Objects.equals(leaseDate, lease.leaseDate) &&
                Objects.equals(expiredDate, lease.expiredDate) &&
                Objects.equals(price, lease.price));
    }

    @Override
    public int hashCode(){
        return Objects.hash(getId(), leaseDate, expiredDate, price);
    }

}
