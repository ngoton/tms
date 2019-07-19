package com.tinhoctainha.tms.api.dto;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.tinhoctainha.tms.api.util.CustomDateDeserializer;
import com.tinhoctainha.tms.api.util.CustomDateSerializer;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Objects;

public class FeeDto implements Serializable {
    private Long id;
    private Date feeDate;
    private String description;
    private String documentNumber;
    private Date documentDate;
    private Double amount;
    private Double tax;
    private Float taxRate;
    private Double total;
    private Date actived;
    private Date expired;
    private Integer divided;
    private CustomerDto customer;
    private List<VehicleDto> vehicles;
    private List<RomoocDto> romoocs;
    private List<LedgerDetailDto> ledgerDetails;
    private DebitDto debit;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @JsonSerialize(using = CustomDateSerializer.class)
    public Date getFeeDate() {
        return feeDate;
    }

    @JsonDeserialize(using = CustomDateDeserializer.class)
    public void setFeeDate(Date feeDate) {
        this.feeDate = feeDate;
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

    @JsonSerialize(using = CustomDateSerializer.class)
    public Date getActived() {
        return actived;
    }

    @JsonDeserialize(using = CustomDateDeserializer.class)
    public void setActived(Date actived) {
        this.actived = actived;
    }

    @JsonSerialize(using = CustomDateSerializer.class)
    public Date getExpired() {
        return expired;
    }

    @JsonDeserialize(using = CustomDateDeserializer.class)
    public void setExpired(Date expired) {
        this.expired = expired;
    }

    public Integer getDivided() {
        return divided;
    }

    public void setDivided(Integer divided) {
        this.divided = divided;
    }

    public CustomerDto getCustomer() {
        return customer;
    }

    public void setCustomer(CustomerDto customer) {
        this.customer = customer;
    }

    public List<VehicleDto> getVehicles() {
        return vehicles;
    }

    public void setVehicles(List<VehicleDto> vehicles) {
        this.vehicles = vehicles;
    }

    public List<RomoocDto> getRomoocs() {
        return romoocs;
    }

    public void setRomoocs(List<RomoocDto> romoocs) {
        this.romoocs = romoocs;
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
        FeeDto fee = (FeeDto) o;
        return (getId() == fee.getId() &&
                Objects.equals(feeDate, fee.feeDate) &&
                Objects.equals(description, fee.description) &&
                Objects.equals(documentNumber, fee.documentNumber) &&
                Objects.equals(documentDate, fee.documentDate) &&
                Objects.equals(amount, fee.amount) &&
                Objects.equals(tax, fee.tax) &&
                Objects.equals(taxRate, fee.taxRate) &&
                Objects.equals(total, fee.total) &&
                Objects.equals(actived, fee.actived) &&
                Objects.equals(expired, fee.expired) &&
                Objects.equals(divided, fee.divided));
    }

    @Override
    public int hashCode(){
        return Objects.hash(getId(), feeDate, description, documentNumber, documentDate, amount, tax, taxRate, total, actived, expired, divided);
    }

}
