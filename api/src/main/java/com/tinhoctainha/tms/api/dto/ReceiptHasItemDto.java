package com.tinhoctainha.tms.api.dto;

import java.io.Serializable;
import java.util.Objects;

public class ReceiptHasItemDto implements Serializable {
    private ReceiptDto receipt;
    private ItemDto item;
    private Float quantity;
    private Double price;
    private String unit;

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

    public ReceiptDto getReceipt() {
        return receipt;
    }

    public void setReceipt(ReceiptDto receipt) {
        this.receipt = receipt;
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
        ReceiptHasItemDto receiptHasItem = (ReceiptHasItemDto) o;
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
