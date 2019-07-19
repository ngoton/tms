package com.tinhoctainha.tms.api.dto;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.tinhoctainha.tms.api.util.CustomDateDeserializer;
import com.tinhoctainha.tms.api.util.CustomDateSerializer;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Objects;

public class IssueDto implements Serializable {
    private Long id;
    private Date issueDate;
    private String issueNumber;
    private String description;
    private Float quantity;
    private Double total;
    private InvoiceDto invoice;
    private List<VehicleInsertDto> vehicleInserts;
    private List<RomoocInsertDto> romoocInserts;
    private List<LedgerDetailDto> ledgerDetails;
    private List<IssueHasItemDto> issueHasItems;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @JsonSerialize(using = CustomDateSerializer.class)
    public Date getIssueDate() {
        return issueDate;
    }

    @JsonDeserialize(using = CustomDateDeserializer.class)
    public void setIssueDate(Date issueDate) {
        this.issueDate = issueDate;
    }

    public String getIssueNumber() {
        return issueNumber;
    }

    public void setIssueNumber(String issueNumber) {
        this.issueNumber = issueNumber;
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

    public InvoiceDto getInvoice() {
        return invoice;
    }

    public void setInvoice(InvoiceDto invoice) {
        this.invoice = invoice;
    }

    public List<VehicleInsertDto> getVehicleInserts() {
        return vehicleInserts;
    }

    public void setVehicleInserts(List<VehicleInsertDto> vehicleInserts) {
        this.vehicleInserts = vehicleInserts;
    }

    public List<RomoocInsertDto> getRomoocInserts() {
        return romoocInserts;
    }

    public void setRomoocInserts(List<RomoocInsertDto> romoocInserts) {
        this.romoocInserts = romoocInserts;
    }

    public List<LedgerDetailDto> getLedgerDetails() {
        return ledgerDetails;
    }

    public void setLedgerDetails(List<LedgerDetailDto> ledgerDetails) {
        this.ledgerDetails = ledgerDetails;
    }

    public List<IssueHasItemDto> getIssueHasItems() {
        return issueHasItems;
    }

    public void setIssueHasItems(List<IssueHasItemDto> issueHasItems) {
        this.issueHasItems = issueHasItems;
    }

    @Override
    public boolean equals(Object o){
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        IssueDto issue = (IssueDto) o;
        return (getId() == issue.getId() &&
                Objects.equals(issueNumber, issue.issueNumber) &&
                Objects.equals(issueDate, issue.issueDate) &&
                Objects.equals(description, issue.description) &&
                Objects.equals(quantity, issue.quantity) &&
                Objects.equals(total, issue.total));
    }

    @Override
    public int hashCode(){
        return Objects.hash(getId(), issueNumber, issueDate, description, quantity, total);
    }

}
