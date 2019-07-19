package com.tinhoctainha.tms.api.dto;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.tinhoctainha.tms.api.util.CustomDateDeserializer;
import com.tinhoctainha.tms.api.util.CustomDateSerializer;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Objects;

public class ReceiptDto implements Serializable {
    private Long id;
    private Date receiptDate;
    private String receiptNumber;
    private String description;
    private Float quantity;
    private Double total;
    private OrderDto order;
    private List<ReceiptHasItemDto> receiptHasItems;
    private List<LedgerDetailDto> ledgerDetails;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @JsonSerialize(using = CustomDateSerializer.class)
    public Date getReceiptDate() {
        return receiptDate;
    }

    @JsonDeserialize(using = CustomDateDeserializer.class)
    public void setReceiptDate(Date receiptDate) {
        this.receiptDate = receiptDate;
    }

    public String getReceiptNumber() {
        return receiptNumber;
    }

    public void setReceiptNumber(String receiptNumber) {
        this.receiptNumber = receiptNumber;
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

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    public OrderDto getOrder() {
        return order;
    }

    public void setOrder(OrderDto order) {
        this.order = order;
    }

    public List<ReceiptHasItemDto> getReceiptHasItems() {
        return receiptHasItems;
    }

    public void setReceiptHasItems(List<ReceiptHasItemDto> receiptHasItems) {
        this.receiptHasItems = receiptHasItems;
    }

    public List<LedgerDetailDto> getLedgerDetails() {
        return ledgerDetails;
    }

    public void setLedgerDetails(List<LedgerDetailDto> ledgerDetails) {
        this.ledgerDetails = ledgerDetails;
    }

    @Override
    public boolean equals(Object o){
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ReceiptDto receipt = (ReceiptDto) o;
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
