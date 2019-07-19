package com.tinhoctainha.tms.api.dto;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.tinhoctainha.tms.api.util.CustomDateDeserializer;
import com.tinhoctainha.tms.api.util.CustomDateSerializer;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Objects;

public class InvoiceDto implements Serializable {
    private Long id;
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
    private List<InvoiceDetailDto> invoiceDetails;
    private List<ShippingListDto> shippingLists;
    private List<IssueDto> issues;
    private List<LedgerDetailDto> ledgerDetails;
    private DebitDto debit;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getInvoiceNumber() {
        return invoiceNumber;
    }

    public void setInvoiceNumber(String invoiceNumber) {
        this.invoiceNumber = invoiceNumber;
    }

    @JsonSerialize(using = CustomDateSerializer.class)
    public Date getInvoiceDate() {
        return invoiceDate;
    }

    @JsonDeserialize(using = CustomDateDeserializer.class)
    public void setInvoiceDate(Date invoiceDate) {
        this.invoiceDate = invoiceDate;
    }

    public String getForm() {
        return form;
    }

    public void setForm(String form) {
        this.form = form;
    }

    public String getSerial() {
        return serial;
    }

    public void setSerial(String serial) {
        this.serial = serial;
    }

    public String getBuyer() {
        return buyer;
    }

    public void setBuyer(String buyer) {
        this.buyer = buyer;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getIdNumber() {
        return idNumber;
    }

    public void setIdNumber(String idNumber) {
        this.idNumber = idNumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPayment() {
        return payment;
    }

    public void setPayment(String payment) {
        this.payment = payment;
    }

    public Double getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(Double subtotal) {
        this.subtotal = subtotal;
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

    public List<InvoiceDetailDto> getInvoiceDetails() {
        return invoiceDetails;
    }

    public void setInvoiceDetails(List<InvoiceDetailDto> invoiceDetails) {
        this.invoiceDetails = invoiceDetails;
    }

    public List<ShippingListDto> getShippingLists() {
        return shippingLists;
    }

    public void setShippingLists(List<ShippingListDto> shippingLists) {
        this.shippingLists = shippingLists;
    }

    public List<IssueDto> getIssues() {
        return issues;
    }

    public void setIssues(List<IssueDto> issues) {
        this.issues = issues;
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
        InvoiceDto invoice = (InvoiceDto) o;
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
