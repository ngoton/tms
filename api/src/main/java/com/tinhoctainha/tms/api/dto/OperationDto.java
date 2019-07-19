package com.tinhoctainha.tms.api.dto;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.tinhoctainha.tms.api.util.CustomDateDeserializer;
import com.tinhoctainha.tms.api.util.CustomDateSerializer;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

public class OperationDto implements Serializable {
    private Long id;
    private String operationCode;
    private Date operationDate;
    private Float quantity;
    private Integer unit;
    private String note;
    private BookingDto booking;
    private VehicleDto vehicle;
    private RoadDto road;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getOperationCode() {
        return operationCode;
    }

    public void setOperationCode(String operationCode) {
        this.operationCode = operationCode;
    }

    @JsonSerialize(using = CustomDateSerializer.class)
    public Date getOperationDate() {
        return operationDate;
    }

    @JsonDeserialize(using = CustomDateDeserializer.class)
    public void setOperationDate(Date operationDate) {
        this.operationDate = operationDate;
    }

    public Float getQuantity() {
        return quantity;
    }

    public void setQuantity(Float quantity) {
        this.quantity = quantity;
    }

    public Integer getUnit() {
        return unit;
    }

    public void setUnit(Integer unit) {
        this.unit = unit;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public BookingDto getBooking() {
        return booking;
    }

    public void setBooking(BookingDto booking) {
        this.booking = booking;
    }

    public VehicleDto getVehicle() {
        return vehicle;
    }

    public void setVehicle(VehicleDto vehicle) {
        this.vehicle = vehicle;
    }

    public RoadDto getRoad() {
        return road;
    }

    public void setRoad(RoadDto road) {
        this.road = road;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OperationDto operation = (OperationDto) o;
        return (getId() == operation.getId() &&
                Objects.equals(operationCode, operation.operationCode) &&
                Objects.equals(operationDate, operation.operationDate) &&
                Objects.equals(quantity, operation.quantity) &&
                Objects.equals(unit, operation.unit) &&
                Objects.equals(note, operation.note));
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), operationCode, operationDate, quantity, unit, note);
    }

}
