package com.tinhoctainha.tms.api.dto;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "issue_has_item")
@IdClass(IssueHasItemId.class)
public class IssueHasItem implements Serializable {
    private Float quantity;
    private Double price;
    private String unit;

    @Id
    @ManyToOne
    @JoinColumn(name = "issue_id", referencedColumnName = "id", nullable = false)
    private Issue issue;

    @Id
    @ManyToOne
    @JoinColumn(name = "item_id", referencedColumnName = "id", nullable = false)
    private Item item;

    @Basic
    @Column(name = "quantity")
    public Float getQuantity() {
        return quantity;
    }

    public void setQuantity(Float quantity) {
        this.quantity = quantity;
    }

    @Basic
    @Column(name = "price", precision = 14, scale = 2)
    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    @Basic
    @Column(name = "unit")
    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public Issue getIssue() {
        return issue;
    }

    public void setIssue(Issue issue) {
        this.issue = issue;
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
        IssueHasItem issueHasItem = (IssueHasItem) o;
        return (Objects.equals(issue, issueHasItem.issue) &&
                Objects.equals(item, issueHasItem.item) &&
                Objects.equals(quantity, issueHasItem.quantity) &&
                Objects.equals(price, issueHasItem.price) &&
                Objects.equals(unit, issueHasItem.unit));
    }

    @Override
    public int hashCode(){
        return Objects.hash(issue, item, quantity, price, unit);
    }
}
