package com.tinhoctainha.tms.domain.model;

import javax.persistence.*;
import java.util.Date;
import java.util.Objects;

@Entity
@Table(name = "romooc_removal")
public class RomoocRemoval extends IncrementIDBaseEntity {
    private Date removalDate;
    private Float quantity;

    @ManyToOne
    @JoinColumn(name = "romooc_id", referencedColumnName = "id", nullable = false)
    private Romooc romooc;

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

    public Romooc getRomooc() {
        return romooc;
    }

    public void setRomooc(Romooc romooc) {
        this.romooc = romooc;
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
        RomoocRemoval romoocRemoval = (RomoocRemoval) o;
        return (getId() == romoocRemoval.getId() &&
                Objects.equals(removalDate, romoocRemoval.removalDate) &&
                Objects.equals(quantity, romoocRemoval.quantity));
    }

    @Override
    public int hashCode(){
        return Objects.hash(getId(), removalDate, quantity);
    }
}
