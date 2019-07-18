package com.tinhoctainha.tms.api.dto;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "receipt_has_item")
@IdClass(ReceiptHasItemId.class)
public class ReceiptHasItem implements Serializable {
    @Id
    @ManyToOne
    @JoinColumn(name = "receipt_id", referencedColumnName = "id", nullable = false)
    private Receipt receipt;

    @Id
    @ManyToOne
    @JoinColumn(name = "item_id", referencedColumnName = "id", nullable = false)
    private Item item;

    private Float quantity;
    private Double price;
    private String unit;

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

    public Receipt getReceipt() {
        return receipt;
    }

    public void setReceipt(Receipt receipt) {
        this.receipt = receipt;
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
        ReceiptHasItem receiptHasItem = (ReceiptHasItem) o;
        return (Objects.equals(receipt, receiptHasItem.receipt) &&
                Objects.equals(item, receiptHasItem.item) &&
                Objects.equals(quantity, receiptHasItem.quantity) &&
                Objects.equals(price, receiptHasItem.price) &&
                Objects.equals(unit, receiptHasItem.unit));
    }

    @Override
    public int hashCode(){
        return Objects.hash(receipt, item, quantity, price, unit);
    }
}
