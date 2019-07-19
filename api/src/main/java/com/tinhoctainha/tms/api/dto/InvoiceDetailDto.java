package com.tinhoctainha.tms.api.dto;

import java.io.Serializable;
import java.util.Objects;

public class InvoiceDetailDto implements Serializable {
    private Long id;
    private String description;
    private Float quantity;
    private Double price;
    private String unit;
    private Double amount;
    private InvoiceDto invoice;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

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

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public InvoiceDto getInvoice() {
        return invoice;
    }

    public void setInvoice(InvoiceDto invoice) {
        this.invoice = invoice;
    }

    @Override
    public boolean equals(Object o){
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        InvoiceDetailDto invoiceDetail = (InvoiceDetailDto) o;
        return (getId() == invoiceDetail.getId() &&
                Objects.equals(description, invoiceDetail.description) &&
                Objects.equals(quantity, invoiceDetail.quantity) &&
                Objects.equals(price, invoiceDetail.price) &&
                Objects.equals(unit, invoiceDetail.unit) &&
                Objects.equals(amount, invoiceDetail.amount));
    }

    @Override
    public int hashCode(){
        return Objects.hash(getId(), description, quantity, price, unit, amount);
    }

}
