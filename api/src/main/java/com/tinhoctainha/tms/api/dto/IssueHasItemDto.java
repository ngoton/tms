package com.tinhoctainha.tms.api.dto;

import java.io.Serializable;
import java.util.Objects;

public class IssueHasItemDto implements Serializable {
    private Float quantity;
    private Double price;
    private String unit;
    private IssueDto issue;
    private ItemDto item;

    public Float getQuantity() {
        return quantity;
    }

    public void setQuantity(Float quantity) {
        this.quantity = quantity;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public IssueDto getIssue() {
        return issue;
    }

    public void setIssue(IssueDto issue) {
        this.issue = issue;
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
        IssueHasItemDto issueHasItem = (IssueHasItemDto) o;
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
