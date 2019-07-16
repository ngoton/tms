package com.tinhoctainha.tms.domain.model;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "invoice_detail")
public class InvoiceDetail extends IncrementIDBaseEntity {
    private String description;
    private Float quantity;
    private Double price;
    private String unit;
    private Double amount;

    @ManyToOne
    @JoinColumn(name = "invoice_id", referencedColumnName = "id", nullable = false)
    private Invoice invoice;

    @Basic
    @Column(name = "description")
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
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

    @Basic
    @Column(name = "amount", precision = 14, scale = 2)
    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public Invoice getInvoice() {
        return invoice;
    }

    public void setInvoice(Invoice invoice) {
        this.invoice = invoice;
    }

    @Override
    public boolean equals(Object o){
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        InvoiceDetail invoiceDetail = (InvoiceDetail) o;
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
