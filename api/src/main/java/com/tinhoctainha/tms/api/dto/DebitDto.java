package com.tinhoctainha.tms.api.dto;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.tinhoctainha.tms.api.util.CustomDateDeserializer;
import com.tinhoctainha.tms.api.util.CustomDateSerializer;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

public class DebitDto implements Serializable {
    private Long id;
    private Date debitDate;
    private Double total;
    private String description;
    private Integer debitType;
    private InvoiceDto invoice;
    private CostDto cost;
    private CostListDto costList;
    private FeeDto fee;
    private OrderDto order;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @JsonSerialize(using = CustomDateSerializer.class)
    public Date getDebitDate() {
        return debitDate;
    }

    @JsonDeserialize(using = CustomDateDeserializer.class)
    public void setDebitDate(Date debitDate) {
        this.debitDate = debitDate;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getDebitType() {
        return debitType;
    }

    public void setDebitType(Integer debitType) {
        this.debitType = debitType;
    }

    public InvoiceDto getInvoice() {
        return invoice;
    }

    public void setInvoice(InvoiceDto invoice) {
        this.invoice = invoice;
    }

    public CostDto getCost() {
        return cost;
    }

    public void setCost(CostDto cost) {
        this.cost = cost;
    }

    public CostListDto getCostList() {
        return costList;
    }

    public void setCostList(CostListDto costList) {
        this.costList = costList;
    }

    public FeeDto getFee() {
        return fee;
    }

    public void setFee(FeeDto fee) {
        this.fee = fee;
    }

    public OrderDto getOrder() {
        return order;
    }

    public void setOrder(OrderDto order) {
        this.order = order;
    }

    @Override
    public boolean equals(Object o){
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DebitDto debit = (DebitDto) o;
        return (getId() == debit.getId() &&
                Objects.equals(debitDate, debit.debitDate) &&
                Objects.equals(total, debit.total) &&
                Objects.equals(description, debit.description) &&
                Objects.equals(debitType, debit.debitType));
    }

    @Override
    public int hashCode(){
        return Objects.hash(getId(), debitDate, total, description, debitType);
    }

}
