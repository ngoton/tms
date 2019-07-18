package com.tinhoctainha.tms.api.dto;

import javax.persistence.*;
import java.util.Date;
import java.util.List;
import java.util.Objects;

@Entity
public class Receipt extends IncrementIDBaseEntity {
    private Date receiptDate;
    private String receiptNumber;
    private String description;
    private Float quantity;
    private Double total;

    @ManyToOne
    @JoinColumn(name = "order_id", referencedColumnName = "id")
    private Order order;

    @OneToMany(mappedBy = "receipt", cascade = CascadeType.ALL)
    private List<ReceiptHasItem> receiptHasItems;

    @OneToMany(mappedBy = "receipt")
    private List<LedgerDetail> ledgerDetails;

    @Basic
    @Temporal(TemporalType.DATE)
    @Column(name = "receipt_date")
    public Date getReceiptDate() {
        return receiptDate;
    }

    public void setReceiptDate(Date receiptDate) {
        this.receiptDate = receiptDate;
    }

    @Basic
    @Column(name = "receipt_number")
    public String getReceiptNumber() {
        return receiptNumber;
    }

    public void setReceiptNumber(String receiptNumber) {
        this.receiptNumber = receiptNumber;
    }

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
    @Column(name = "total", precision = 14, scale = 2)
    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public List<ReceiptHasItem> getReceiptHasItems() {
        return receiptHasItems;
    }

    public void setReceiptHasItems(List<ReceiptHasItem> receiptHasItems) {
        this.receiptHasItems = receiptHasItems;
    }

    public List<LedgerDetail> getLedgerDetails() {
        return ledgerDetails;
    }

    public void setLedgerDetails(List<LedgerDetail> ledgerDetails) {
        this.ledgerDetails = ledgerDetails;
    }

    @Override
    public boolean equals(Object o){
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Receipt receipt = (Receipt) o;
        return (getId() == receipt.getId() &&
                Objects.equals(receiptDate, receipt.receiptDate) &&
                Objects.equals(receiptNumber, receipt.receiptNumber) &&
                Objects.equals(description, receipt.description) &&
                Objects.equals(quantity, receipt.quantity) &&
                Objects.equals(total, receipt.total));
    }

    @Override
    public int hashCode(){
        return Objects.hash(getId(), receiptDate, receiptNumber, description, quantity, total);
    }
}
