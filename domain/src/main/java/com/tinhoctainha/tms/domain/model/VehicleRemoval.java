package com.tinhoctainha.tms.domain.model;

import javax.persistence.*;
import java.util.Date;
import java.util.Objects;

@Entity
@Table(name = "vehicle_removal")
public class VehicleRemoval extends IncrementIDBaseEntity {
    private Date removalDate;
    private Float quantity;

    @ManyToOne
    @JoinColumn(name = "vehicle_id", referencedColumnName = "id", nullable = false)
    private Vehicle vehicle;

    @ManyToOne
    @JoinColumn(name = "item_id", referencedColumnName = "id", nullable = false)
    private Item item;

    @Basic
    @Temporal(TemporalType.DATE)
    @Column(name = "removal_date")
    public Date getRemovalDate() {
        return removalDate;
    }

    public void setRemovalDate(Date removalDate) {
        this.removalDate = removalDate;
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

    @Override
    public boolean equals(Object o){
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        VehicleRemoval vehicleRemoval = (VehicleRemoval) o;
        return (getId() == vehicleRemoval.getId() &&
                Objects.equals(removalDate, vehicleRemoval.removalDate) &&
                Objects.equals(quantity, vehicleRemoval.quantity));
    }

    @Override
    public int hashCode(){
        return Objects.hash(getId(), removalDate, quantity);
    }
}
