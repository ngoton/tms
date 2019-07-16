package com.tinhoctainha.tms.domain.model;

import javax.persistence.*;
import java.util.Date;
import java.util.List;
import java.util.Objects;

@Entity
public class Waybill extends IncrementIDBaseEntity {
    private Date billDate;
    private String DO;
    private String contNumber;
    private Float receiveQuantity;
    private Float deliveryQuantity;
    private Integer unit;
    private Date receiveDate;
    private Date deliveryDate;
    private String note;
    private Integer waybillType;
    private Integer waybillFrom;
    private Integer waybillTo;
    private Integer emptyFrom;
    private Integer emptyTo;

    @OneToOne(mappedBy = "waybill")
    private WaybillDetail waybillDetail;

    @ManyToOne
    @JoinColumn(name = "shipping_list_id", referencedColumnName = "id")
    private ShippingList shippingList;

    @OneToMany(mappedBy = "waybill")
    private List<Cost> costs;

    @OneToMany(mappedBy = "waybill")
    private List<LedgerDetail> ledgerDetails;

    @Basic
    @Temporal(TemporalType.DATE)
    @Column(name = "bill_date")
    public Date getBillDate() {
        return billDate;
    }

    public void setBillDate(Date billDate) {
        this.billDate = billDate;
    }

    @Basic
    @Column(name = "DO")
    public String getDO() {
        return DO;
    }

    public void setDO(String DO) {
        this.DO = DO;
    }

    @Basic
    @Column(name = "cont_number")
    public String getContNumber() {
        return contNumber;
    }

    public void setContNumber(String contNumber) {
        this.contNumber = contNumber;
    }

    @Basic
    @Column(name = "receive_quantity")
    public Float getReceiveQuantity() {
        return receiveQuantity;
    }

    public void setReceiveQuantity(Float receiveQuantity) {
        this.receiveQuantity = receiveQuantity;
    }

    @Basic
    @Column(name = "delivery_quantity")
    public Float getDeliveryQuantity() {
        return deliveryQuantity;
    }

    public void setDeliveryQuantity(Float deliveryQuantity) {
        this.deliveryQuantity = deliveryQuantity;
    }

    @Basic
    @Column(name = "unit")
    public Integer getUnit() {
        return unit;
    }

    public void setUnit(Integer unit) {
        this.unit = unit;
    }

    @Basic
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "receive_date")
    public Date getReceiveDate() {
        return receiveDate;
    }

    public void setReceiveDate(Date receiveDate) {
        this.receiveDate = receiveDate;
    }

    @Basic
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "delivery_date")
    public Date getDeliveryDate() {
        return deliveryDate;
    }

    public void setDeliveryDate(Date deliveryDate) {
        this.deliveryDate = deliveryDate;
    }

    @Basic
    @Column(name = "note")
    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    @Basic
    @Column(name = "waybill_type")
    public Integer getWaybillType() {
        return waybillType;
    }

    public void setWaybillType(Integer waybillType) {
        this.waybillType = waybillType;
    }

    @Basic
    @Column(name = "waybill_from")
    public Integer getWaybillFrom() {
        return waybillFrom;
    }

    public void setWaybillFrom(Integer waybillFrom) {
        this.waybillFrom = waybillFrom;
    }

    @Basic
    @Column(name = "waybill_to")
    public Integer getWaybillTo() {
        return waybillTo;
    }

    public void setWaybillTo(Integer waybillTo) {
        this.waybillTo = waybillTo;
    }

    @Basic
    @Column(name = "empty_from")
    public Integer getEmptyFrom() {
        return emptyFrom;
    }

    public void setEmptyFrom(Integer emptyFrom) {
        this.emptyFrom = emptyFrom;
    }

    @Basic
    @Column(name = "empty_to")
    public Integer getEmptyTo() {
        return emptyTo;
    }

    public void setEmptyTo(Integer emptyTo) {
        this.emptyTo = emptyTo;
    }

    public WaybillDetail getWaybillDetail() {
        return waybillDetail;
    }

    public void setWaybillDetail(WaybillDetail waybillDetail) {
        this.waybillDetail = waybillDetail;
    }

    public ShippingList getShippingList() {
        return shippingList;
    }

    public void setShippingList(ShippingList shippingList) {
        this.shippingList = shippingList;
    }

    public List<Cost> getCosts() {
        return costs;
    }

    public void setCosts(List<Cost> costs) {
        this.costs = costs;
    }

    public List<LedgerDetail> getLedgerDetails() {
        return ledgerDetails;
    }

    public void setLedgerDetails(List<LedgerDetail> ledgerDetails) {
        this.ledgerDetails = ledgerDetails;
    }

    @Override
    public boolean equals(Object o){
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Waybill waybill = (Waybill) o;
        return (getId() == waybill.getId() &&
                Objects.equals(billDate, waybill.billDate) &&
                Objects.equals(DO, waybill.DO) &&
                Objects.equals(contNumber, waybill.contNumber) &&
                Objects.equals(receiveQuantity, waybill.receiveQuantity) &&
                Objects.equals(deliveryQuantity, waybill.deliveryQuantity) &&
                Objects.equals(unit, waybill.unit) &&
                Objects.equals(receiveDate, waybill.receiveDate) &&
                Objects.equals(deliveryDate, waybill.deliveryDate) &&
                Objects.equals(note, waybill.note) &&
                Objects.equals(waybillType, waybill.waybillType) &&
                Objects.equals(waybillFrom, waybill.waybillFrom) &&
                Objects.equals(waybillTo, waybill.waybillTo) &&
                Objects.equals(emptyFrom, waybill.emptyFrom) &&
                Objects.equals(emptyTo, waybill.emptyTo));
    }

    @Override
    public int hashCode(){
        return Objects.hash(getId(), billDate, DO, contNumber, receiveQuantity, deliveryQuantity, unit, receiveDate, deliveryDate, note, waybillType, waybillFrom, waybillTo, emptyFrom, emptyTo);
    }
}
