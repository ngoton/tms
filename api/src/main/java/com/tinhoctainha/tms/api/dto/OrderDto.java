package com.tinhoctainha.tms.api.dto;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.tinhoctainha.tms.api.util.CustomDateDeserializer;
import com.tinhoctainha.tms.api.util.CustomDateSerializer;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Objects;

public class OrderDto implements Serializable {
    private Long id;
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
    private CustomerDto customer;
    private List<ReceiptDto> receipts;
    private DebitDto debit;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @JsonSerialize(using = CustomDateSerializer.class)
    public Date getOrderDate() {
        return orderDate;
    }

    @JsonDeserialize(using = CustomDateDeserializer.class)
    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    public String getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(String orderNumber) {
        this.orderNumber = orderNumber;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDocumentNumber() {
        return documentNumber;
    }

    public void setDocumentNumber(String documentNumber) {
        this.documentNumber = documentNumber;
    }

    @JsonSerialize(using = CustomDateSerializer.class)
    public Date getDocumentDate() {
        return documentDate;
    }

    @JsonDeserialize(using = CustomDateDeserializer.class)
    public void setDocumentDate(Date documentDate) {
        this.documentDate = documentDate;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public Double getTax() {
        return tax;
    }

    public void setTax(Double tax) {
        this.tax = tax;
    }

    public Float getTaxRate() {
        return taxRate;
    }

    public void setTaxRate(Float taxRate) {
        this.taxRate = taxRate;
    }

    public Float getExchangeRate() {
        return exchangeRate;
    }

    public void setExchangeRate(Float exchangeRate) {
        this.exchangeRate = exchangeRate;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    public CustomerDto getCustomer() {
        return customer;
    }

    public void setCustomer(CustomerDto customer) {
        this.customer = customer;
    }

    public List<ReceiptDto> getReceipts() {
        return receipts;
    }

    public void setReceipts(List<ReceiptDto> receipts) {
        this.receipts = receipts;
    }

    public DebitDto getDebit() {
        return debit;
    }

    public void setDebit(DebitDto debit) {
        this.debit = debit;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OrderDto order = (OrderDto) o;
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
