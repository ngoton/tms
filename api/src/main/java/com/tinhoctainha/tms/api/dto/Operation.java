package com.tinhoctainha.tms.api.dto;

import javax.persistence.*;
import java.util.Date;
import java.util.Objects;

@Entity
public class Operation extends IncrementIDBaseEntity {
    private String operationCode;
    private Date operationDate;
    private Float quantity;
    private Integer unit;
    private String note;

    @ManyToOne
    @JoinColumn(name = "booking_id", referencedColumnName = "id")
    private Booking booking;

    @ManyToOne
    @JoinColumn(name = "vehicle_id", referencedColumnName = "id", nullable = false)
    private Vehicle vehicle;

    @ManyToOne
    @JoinColumns({
            @JoinColumn(name = "road_start", referencedColumnName = "start", nullable = false),
            @JoinColumn(name = "road_finish", referencedColumnName = "finish", nullable = false)
    })
    private Road road;

    @Basic
    @Column(name = "operation_code")
    public String getOperationCode() {
        return operationCode;
    }

    public void setOperationCode(String operationCode) {
        this.operationCode = operationCode;
    }

    @Basic
    @Temporal(TemporalType.DATE)
    @Column(name = "operation_date")
    public Date getOperationDate() {
        return operationDate;
    }

    public void setOperationDate(Date operationDate) {
        this.operationDate = operationDate;
    }

    @Basic
    @Column(name = "quantity")
    public Float getQuantity() {
        return quantity;
    }

    public void setQuantity(Float quantity) {
        this.quantity = quantity;
    }

    @Basic
    @Column(name = "unit")
    public Integer getUnit() {
        return unit;
    }

    public void setUnit(Integer unit) {
        this.unit = unit;
    }

    @Basic
    @Column(name = "note")
    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public Booking getBooking() {
        return booking;
    }

    public void setBooking(Booking booking) {
        this.booking = booking;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    public Road getRoad() {
        return road;
    }

    public void setRoad(Road road) {
        this.road = road;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Operation operation = (Operation) o;
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
