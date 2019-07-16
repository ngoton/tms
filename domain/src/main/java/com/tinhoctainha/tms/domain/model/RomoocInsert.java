package com.tinhoctainha.tms.domain.model;

import javax.persistence.*;
import java.util.Date;
import java.util.Objects;

@Entity
@Table(name = "romooc_insert")
public class RomoocInsert extends IncrementIDBaseEntity {
    private Date insertDate;
    private Float quantity;

    @ManyToOne
    @JoinColumn(name = "romooc_id", referencedColumnName = "id", nullable = false)
    private Romooc romooc;

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
        RomoocInsert romoocInsert = (RomoocInsert) o;
        return (getId() == romoocInsert.getId() &&
                Objects.equals(insertDate, romoocInsert.insertDate) &&
                Objects.equals(quantity, romoocInsert.quantity));
    }

    @Override
    public int hashCode(){
        return Objects.hash(getId(), insertDate, quantity);
    }
}
