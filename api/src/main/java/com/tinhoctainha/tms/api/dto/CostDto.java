package com.tinhoctainha.tms.api.dto;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.tinhoctainha.tms.api.util.CustomDateDeserializer;
import com.tinhoctainha.tms.api.util.CustomDateSerializer;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Objects;

public class CostDto implements Serializable {
    private Long id;
    private String description;
    private String documentNumber;
    private Date documentDate;
    private Double amount;
    private Double tax;
    private Float taxRate;
    private Double total;
    private Integer driverPayed;
    private Integer costType;
    private CustomerDto customer;
    private WaybillDto waybill;
    private CostListDto costList;
    private List<LedgerDetailDto> ledgerDetails;
    private DebitDto debit;

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

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    public Integer getDriverPayed() {
        return driverPayed;
    }

    public void setDriverPayed(Integer driverPayed) {
        this.driverPayed = driverPayed;
    }

    public Integer getCostType() {
        return costType;
    }

    public void setCostType(Integer costType) {
        this.costType = costType;
    }

    public CustomerDto getCustomer() {
        return customer;
    }

    public void setCustomer(CustomerDto customer) {
        this.customer = customer;
    }

    public WaybillDto getWaybill() {
        return waybill;
    }

    public void setWaybill(WaybillDto waybill) {
        this.waybill = waybill;
    }

    public CostListDto getCostList() {
        return costList;
    }

    public void setCostList(CostListDto costList) {
        this.costList = costList;
    }

    public List<LedgerDetailDto> getLedgerDetails() {
        return ledgerDetails;
    }

    public void setLedgerDetails(List<LedgerDetailDto> ledgerDetails) {
        this.ledgerDetails = ledgerDetails;
    }

    public DebitDto getDebit() {
        return debit;
    }

    public void setDebit(DebitDto debit) {
        this.debit = debit;
    }

    @Override
    public boolean equals(Object o){
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CostDto cost = (CostDto) o;
        return (getId() == cost.getId() &&
                Objects.equals(description, cost.description) &&
                Objects.equals(documentNumber, cost.documentNumber) &&
                Objects.equals(documentDate, cost.documentDate) &&
                Objects.equals(amount, cost.amount) &&
                Objects.equals(tax, cost.tax) &&
                Objects.equals(taxRate, cost.taxRate) &&
                Objects.equals(total, cost.total) &&
                Objects.equals(driverPayed, cost.driverPayed) &&
                Objects.equals(costType, cost.costType));
    }

    @Override
    public int hashCode(){
        return Objects.hash(getId(), description, documentNumber, documentDate, amount, tax, taxRate, total, driverPayed, costType);
    }

}
