package com.tinhoctainha.tms.api.dto;

import javax.persistence.*;
import java.util.Date;
import java.util.Objects;

@Entity
@Table(name = "vehicle_insert")
public class VehicleInsert extends IncrementIDBaseEntity {
    private Date insertDate;
    private Float quantity;

    @ManyToOne
    @JoinColumn(name = "vehicle_id", referencedColumnName = "id", nullable = false)
    private Vehicle vehicle;

    @ManyToOne
    @JoinColumn(name = "item_id", referencedColumnName = "id", nullable = false)
    private Item item;

    @ManyToOne
    @JoinColumn(name = "issue_id", referencedColumnName = "id")
    private Issue issue;

    @Basic
    @Temporal(TemporalType.DATE)
    @Column(name = "insert_date")
    public Date getInsertDate() {
        return insertDate;
    }

    public void setInsertDate(Date insertDate) {
        this.insertDate = insertDate;
    }

    @Basic
    @Column(name = "quantity")
    public Float getQuantity() {
        return quantity;
    }

    public void setQuantity(Float quantity) {
        this.quantity = quantity;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    public Issue getIssue() {
        return issue;
    }

    public void setIssue(Issue issue) {
        this.issue = issue;
    }

    @Override
    public boolean equals(Object o){
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        VehicleInsert vehicleInsert = (VehicleInsert) o;
        return (getId() == vehicleInsert.getId() &&
                Objects.equals(insertDate, vehicleInsert.insertDate) &&
                Objects.equals(quantity, vehicleInsert.quantity));
    }

    @Override
    public int hashCode(){
        return Objects.hash(getId(), insertDate, quantity);
    }
}
