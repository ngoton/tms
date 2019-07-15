package com.tinhoctainha.tms.domain.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.List;
import java.util.Objects;

@Entity
public class Cost extends IncrementIDBaseEntity {
    private String description;
    private String documentNumber;
    private Date documentDate;
    private Double amount;
    private Double tax;
    private Float taxRate;
    private Double total;
    private Integer driverPayed;
    private Integer costType;

    @ManyToOne
    @JoinColumn(name = "customer_id", referencedColumnName = "id")
    private Customer customer;

    @ManyToOne
    @JoinColumn(name = "waybill_id", referencedColumnName = "id", nullable = false)
    private Waybill waybill;

    @ManyToOne
    @JoinColumn(name = "cost_list_id", referencedColumnName = "id")
    private CostList costList;

    @OneToMany(mappedBy = "cost")
    private List<LedgerDetail> ledgerDetails;

    @OneToOne(mappedBy = "cost", cascade = CascadeType.ALL)
    private Debit debit;

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
    @NotNull
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
    @Column(name = "total", precision = 12, scale = 2)
    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    @Basic
    @Column(name = "driver_payed")
    public Integer getDriverPayed() {
        return driverPayed;
    }

    public void setDriverPayed(Integer driverPayed) {
        this.driverPayed = driverPayed;
    }

    @Basic
    @Column(name = "cost_type")
    public Integer getCostType() {
        return costType;
    }

    public void setCostType(Integer costType) {
        this.costType = costType;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Waybill getWaybill() {
        return waybill;
    }

    public void setWaybill(Waybill waybill) {
        this.waybill = waybill;
    }

    public CostList getCostList() {
        return costList;
    }

    public void setCostList(CostList costList) {
        this.costList = costList;
    }

    public List<LedgerDetail> getLedgerDetails() {
        return ledgerDetails;
    }

    public void setLedgerDetails(List<LedgerDetail> ledgerDetails) {
        this.ledgerDetails = ledgerDetails;
    }

    public Debit getDebit() {
        return debit;
    }

    public void setDebit(Debit debit) {
        this.debit = debit;
    }

    @Override
    public boolean equals(Object o){
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cost cost = (Cost) o;
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
