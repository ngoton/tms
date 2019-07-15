package com.tinhoctainha.tms.domain.model;

import javax.persistence.*;
import java.util.Date;
import java.util.List;
import java.util.Objects;

@Entity
public class Order extends IncrementIDBaseEntity {
    private Date orderDate;
    private String orderNumber;
    private String description;
    private String documentNumber;
    private Date documentDate;
    private Double amount;
    private Double tax;
    private Float taxRate;
    private Float exchangeRate;
    private String currency;
    private Double total;

    @ManyToOne
    @JoinColumn(name = "customer_id", referencedColumnName = "id", nullable = false)
    private Customer customer;

    @OneToMany(mappedBy = "order")
    private List<Receipt> receipts;

    @OneToOne(mappedBy = "order", cascade = CascadeType.ALL)
    private Debit debit;

    @Basic
    @Temporal(TemporalType.DATE)
    @Column(name = "order_date")
    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    @Basic
    @Column(name = "order_number")
    public String getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(String orderNumber) {
        this.orderNumber = orderNumber;
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
    @Column(name = "document_number")
    public String getDocumentNumber() {
        return documentNumber;
    }

    public void setDocumentNumber(String documentNumber) {
        this.documentNumber = documentNumber;
    }

    @Basic
    @Temporal(TemporalType.DATE)
    @Column(name = "document_date")
    public Date getDocumentDate() {
        return documentDate;
    }

    public void setDocumentDate(Date documentDate) {
        this.documentDate = documentDate;
    }

    @Basic
    @Column(name = "amount", precision = 12, scale = 2)
    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    @Basic
    @Column(name = "tax", precision = 12, scale = 2)
    public Double getTax() {
        return tax;
    }

    public void setTax(Double tax) {
        this.tax = tax;
    }

    @Basic
    @Column(name = "tax_rate")
    public Float getTaxRate() {
        return taxRate;
    }

    public void setTaxRate(Float taxRate) {
        this.taxRate = taxRate;
    }

    @Basic
    @Column(name = "exchange_rate")
    public Float getExchangeRate() {
        return exchangeRate;
    }

    public void setExchangeRate(Float exchangeRate) {
        this.exchangeRate = exchangeRate;
    }

    @Basic
    @Column(name = "currency")
    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    @Basic
    @Column(name = "total", precision = 14, scale = 2)
    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public List<Receipt> getReceipts() {
        return receipts;
    }

    public void setReceipts(List<Receipt> receipts) {
        this.receipts = receipts;
    }

    public Debit getDebit() {
        return debit;
    }

    public void setDebit(Debit debit) {
        this.debit = debit;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Order order = (Order) o;
        return (getId() == order.getId() &&
                Objects.equals(orderDate, order.orderDate) &&
                Objects.equals(orderNumber, order.orderNumber) &&
                Objects.equals(description, order.description) &&
                Objects.equals(documentNumber, order.documentNumber) &&
                Objects.equals(documentDate, order.documentDate) &&
                Objects.equals(amount, order.amount) &&
                Objects.equals(tax, order.tax) &&
                Objects.equals(taxRate, order.taxRate) &&
                Objects.equals(exchangeRate, order.exchangeRate) &&
                Objects.equals(currency, order.currency) &&
                Objects.equals(total, order.total));
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), orderDate, orderNumber, description, documentNumber, documentDate, amount, tax, taxRate, exchangeRate, currency, total);
    }
}
