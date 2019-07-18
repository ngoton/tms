package com.tinhoctainha.tms.api.dto;

import javax.persistence.*;
import java.util.Date;
import java.util.List;
import java.util.Objects;

@Entity
public class Issue extends IncrementIDBaseEntity {
    private Date issueDate;
    private String issueNumber;
    private String description;
    private Float quantity;
    private Double total;

    @ManyToOne
    @JoinColumn(name = "invoice_id", referencedColumnName = "id")
    private Invoice invoice;

    @OneToMany(mappedBy = "issue")
    private List<VehicleInsert> vehicleInserts;

    @OneToMany(mappedBy = "issue")
    private List<RomoocInsert> romoocInserts;

    @OneToMany(mappedBy = "issue")
    private List<LedgerDetail> ledgerDetails;

    @OneToMany(mappedBy = "issue", cascade = CascadeType.ALL)
    private List<IssueHasItem> issueHasItems;

    @Basic
    @Temporal(TemporalType.DATE)
    @Column(name = "issue_date")
    public Date getIssueDate() {
        return issueDate;
    }

    public void setIssueDate(Date issueDate) {
        this.issueDate = issueDate;
    }

    @Basic
    @Column(name = "issue_number")
    public String getIssueNumber() {
        return issueNumber;
    }

    public void setIssueNumber(String issueNumber) {
        this.issueNumber = issueNumber;
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
    @Column(name = "quantity")
    public Float getQuantity() {
        return quantity;
    }

    public void setQuantity(Float quantity) {
        this.quantity = quantity;
    }

    @Basic
    @Column(name = "total", precision = 14, scale = 2)
    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    public Invoice getInvoice() {
        return invoice;
    }

    public void setInvoice(Invoice invoice) {
        this.invoice = invoice;
    }

    public List<VehicleInsert> getVehicleInserts() {
        return vehicleInserts;
    }

    public void setVehicleInserts(List<VehicleInsert> vehicleInserts) {
        this.vehicleInserts = vehicleInserts;
    }

    public List<RomoocInsert> getRomoocInserts() {
        return romoocInserts;
    }

    public void setRomoocInserts(List<RomoocInsert> romoocInserts) {
        this.romoocInserts = romoocInserts;
    }

    public List<LedgerDetail> getLedgerDetails() {
        return ledgerDetails;
    }

    public void setLedgerDetails(List<LedgerDetail> ledgerDetails) {
        this.ledgerDetails = ledgerDetails;
    }

    public List<IssueHasItem> getIssueHasItems() {
        return issueHasItems;
    }

    public void setIssueHasItems(List<IssueHasItem> issueHasItems) {
        this.issueHasItems = issueHasItems;
    }

    @Override
    public boolean equals(Object o){
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Issue issue = (Issue) o;
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
