package com.tinhoctainha.tms.domain.model;

import javax.persistence.*;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.Set;

@Entity
public class Fee extends IncrementIDBaseEntity {
    private Date feeDate;
    private String description;
    private String documentNumber;
    private Date documentDate;
    private Long amount;
    private Long tax;
    private Float taxRate;
    private Long total;
    private Date actived;
    private Date expired;
    private Integer divided;

    @ManyToOne
    @JoinColumn(name = "customer_id", referencedColumnName = "id", nullable = false)
    private Customer customer;

    @ManyToMany(mappedBy = "fees")
    private Set<Vehicle> vehicles;

    @ManyToMany(mappedBy = "fees")
    private Set<Romooc> romoocs;

    @OneToMany(mappedBy = "fee")
    private List<LedgerDetail> ledgerDetails;

    @OneToOne(mappedBy = "fee", cascade = CascadeType.ALL)
    private Debit debit;

    @Basic
    @Temporal(TemporalType.DATE)
    @Column(name = "fee_date")
    public Date getFeeDate() {
        return feeDate;
    }

    public void setFeeDate(Date feeDate) {
        this.feeDate = feeDate;
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
    @Column(name = "amount", precision = 10, scale = 2)
    public Long getAmount() {
        return amount;
    }

    public void setAmount(Long amount) {
        this.amount = amount;
    }

    @Basic
    @Column(name = "tax", precision = 10, scale = 2)
    public Long getTax() {
        return tax;
    }

    public void setTax(Long tax) {
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
    @Column(name = "total", precision = 10, scale = 2)
    public Long getTotal() {
        return total;
    }

    public void setTotal(Long total) {
        this.total = total;
    }

    @Basic
    @Temporal(TemporalType.DATE)
    @Column(name = "actived")
    public Date getActived() {
        return actived;
    }

    public void setActived(Date actived) {
        this.actived = actived;
    }

    @Basic
    @Temporal(TemporalType.DATE)
    @Column(name = "expired")
    public Date getExpired() {
        return expired;
    }

    public void setExpired(Date expired) {
        this.expired = expired;
    }

    @Basic
    @Column(name = "divided")
    public Integer getDivided() {
        return divided;
    }

    public void setDivided(Integer divided) {
        this.divided = divided;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Set<Vehicle> getVehicles() {
        return vehicles;
    }

    public void setVehicles(Set<Vehicle> vehicles) {
        this.vehicles = vehicles;
    }

    public Set<Romooc> getRomoocs() {
        return romoocs;
    }

    public void setRomoocs(Set<Romooc> romoocs) {
        this.romoocs = romoocs;
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
        Fee fee = (Fee) o;
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
