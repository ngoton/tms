package com.tinhoctainha.tms.domain.model;

import javax.persistence.*;
import java.util.Date;
import java.util.List;
import java.util.Objects;

@Entity
public class Invoice extends IncrementIDBaseEntity {
    private String invoiceNumber;
    private Date invoiceDate;
    private String form;
    private String serial;
    private String buyer;
    private String company;
    private String idNumber;
    private String address;
    private String payment;
    private Double subtotal;
    private Double tax;
    private Float taxRate;
    private Double total;

    @OneToMany(mappedBy = "invoice", cascade = CascadeType.ALL)
    private List<InvoiceDetail> invoiceDetails;

    @OneToMany(mappedBy = "invoice")
    private List<ShippingList> shippingLists;

    @OneToMany(mappedBy = "invoice")
    private List<Issue> issues;

    @OneToMany(mappedBy = "invoice")
    private List<LedgerDetail> ledgerDetails;

    @OneToOne(mappedBy = "invoice",cascade = CascadeType.ALL)
    private Debit debit;

    @Basic
    @Column(name = "invoice_number")
    public String getInvoiceNumber() {
        return invoiceNumber;
    }

    public void setInvoiceNumber(String invoiceNumber) {
        this.invoiceNumber = invoiceNumber;
    }

    @Basic
    @Temporal(TemporalType.DATE)
    @Column(name = "invoice_date")
    public Date getInvoiceDate() {
        return invoiceDate;
    }

    public void setInvoiceDate(Date invoiceDate) {
        this.invoiceDate = invoiceDate;
    }

    @Basic
    @Column(name = "form")
    public String getForm() {
        return form;
    }

    public void setForm(String form) {
        this.form = form;
    }

    @Basic
    @Column(name = "serial")
    public String getSerial() {
        return serial;
    }

    public void setSerial(String serial) {
        this.serial = serial;
    }

    @Basic
    @Column(name = "buyer")
    public String getBuyer() {
        return buyer;
    }

    public void setBuyer(String buyer) {
        this.buyer = buyer;
    }

    @Basic
    @Column(name = "company")
    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    @Basic
    @Column(name = "id_number")
    public String getIdNumber() {
        return idNumber;
    }

    public void setIdNumber(String idNumber) {
        this.idNumber = idNumber;
    }

    @Basic
    @Column(name = "address")
    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Basic
    @Column(name = "payment")
    public String getPayment() {
        return payment;
    }

    public void setPayment(String payment) {
        this.payment = payment;
    }

    @Basic
    @Column(name = "subtotal", precision = 12, scale = 2)
    public Double getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(Double subtotal) {
        this.subtotal = subtotal;
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

    public List<InvoiceDetail> getInvoiceDetails() {
        return invoiceDetails;
    }

    public void setInvoiceDetails(List<InvoiceDetail> invoiceDetails) {
        this.invoiceDetails = invoiceDetails;
    }

    public List<ShippingList> getShippingLists() {
        return shippingLists;
    }

    public void setShippingLists(List<ShippingList> shippingLists) {
        this.shippingLists = shippingLists;
    }

    public List<Issue> getIssues() {
        return issues;
    }

    public void setIssues(List<Issue> issues) {
        this.issues = issues;
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
        Invoice invoice = (Invoice) o;
        return (getId() == invoice.getId() &&
                Objects.equals(invoiceNumber, invoice.invoiceNumber) &&
                Objects.equals(invoiceDate, invoice.invoiceDate) &&
                Objects.equals(form, invoice.form) &&
                Objects.equals(serial, invoice.serial) &&
                Objects.equals(buyer, invoice.buyer) &&
                Objects.equals(company, invoice.company) &&
                Objects.equals(idNumber, invoice.idNumber) &&
                Objects.equals(address, invoice.address) &&
                Objects.equals(payment, invoice.payment) &&
                Objects.equals(subtotal, invoice.subtotal) &&
                Objects.equals(tax, invoice.tax) &&
                Objects.equals(taxRate, invoice.taxRate) &&
                Objects.equals(total, invoice.total));
    }

    @Override
    public int hashCode(){
        return Objects.hash(getId(), invoiceNumber, invoiceDate, form, serial, buyer, company, idNumber, address, payment, subtotal, tax, taxRate, total);
    }
}
