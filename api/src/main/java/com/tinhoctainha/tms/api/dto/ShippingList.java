package com.tinhoctainha.tms.api.dto;

import javax.persistence.*;
import java.util.Date;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "shipping_list")
public class ShippingList extends IncrementIDBaseEntity {
    private Date shippingListDate;
    private String shippingListNumber;
    private Date startDate;
    private Date endDate;
    private Double amount;

    @ManyToOne
    @JoinColumn(name = "invoice_id", referencedColumnName = "id")
    private Invoice invoice;

    @OneToMany(mappedBy = "shippingList")
    private List<Waybill> waybills;

    @Basic
    @Temporal(TemporalType.DATE)
    @Column(name = "shipping_list_date")
    public Date getShippingListDate() {
        return shippingListDate;
    }

    public void setShippingListDate(Date shippingListDate) {
        this.shippingListDate = shippingListDate;
    }

    @Basic
    @Column(name = "shipping_list_number")
    public String getShippingListNumber() {
        return shippingListNumber;
    }

    public void setShippingListNumber(String shippingListNumber) {
        this.shippingListNumber = shippingListNumber;
    }

    @Basic
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "start_date")
    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    @Basic
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "end_date")
    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    @Basic
    @Column(name = "amount", precision = 14, scale = 2)
    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public Invoice getInvoice() {
        return invoice;
    }

    public void setInvoice(Invoice invoice) {
        this.invoice = invoice;
    }

    public List<Waybill> getWaybills() {
        return waybills;
    }

    public void setWaybills(List<Waybill> waybills) {
        this.waybills = waybills;
    }

    @Override
    public boolean equals(Object o){
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ShippingList shippingList = (ShippingList) o;
        return (getId() == shippingList.getId() &&
                Objects.equals(shippingListDate, shippingList.shippingListDate) &&
                Objects.equals(shippingListNumber, shippingList.shippingListNumber) &&
                Objects.equals(startDate, shippingList.startDate) &&
                Objects.equals(endDate, shippingList.endDate) &&
                Objects.equals(amount, shippingList.amount));
    }

    @Override
    public int hashCode(){
        return Objects.hash(getId(), shippingListDate, shippingListNumber, startDate, endDate, amount);
    }
}
