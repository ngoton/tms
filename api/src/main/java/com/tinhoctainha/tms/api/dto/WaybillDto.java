package com.tinhoctainha.tms.api.dto;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.tinhoctainha.tms.api.util.CustomDateDeserializer;
import com.tinhoctainha.tms.api.util.CustomDateSerializer;
import com.tinhoctainha.tms.api.util.CustomDateTimeDeserializer;
import com.tinhoctainha.tms.api.util.CustomDateTimeSerializer;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Objects;

public class WaybillDto implements Serializable {
    private Long id;
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
    private WaybillDetailDto waybillDetail;
    private ShippingListDto shippingList;
    private List<CostDto> costs;
    private List<LedgerDetailDto> ledgerDetails;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @JsonSerialize(using = CustomDateSerializer.class)
    public Date getBillDate() {
        return billDate;
    }

    @JsonDeserialize(using = CustomDateDeserializer.class)
    public void setBillDate(Date billDate) {
        this.billDate = billDate;
    }

    public String getDO() {
        return DO;
    }

    public void setDO(String DO) {
        this.DO = DO;
    }

    public String getContNumber() {
        return contNumber;
    }

    public void setContNumber(String contNumber) {
        this.contNumber = contNumber;
    }

    public Float getReceiveQuantity() {
        return receiveQuantity;
    }

    public void setReceiveQuantity(Float receiveQuantity) {
        this.receiveQuantity = receiveQuantity;
    }

    public Float getDeliveryQuantity() {
        return deliveryQuantity;
    }

    public void setDeliveryQuantity(Float deliveryQuantity) {
        this.deliveryQuantity = deliveryQuantity;
    }

    public Integer getUnit() {
        return unit;
    }

    public void setUnit(Integer unit) {
        this.unit = unit;
    }

    @JsonSerialize(using = CustomDateTimeSerializer.class)
    public Date getReceiveDate() {
        return receiveDate;
    }

    @JsonDeserialize(using = CustomDateTimeDeserializer.class)
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

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public Integer getWaybillType() {
        return waybillType;
    }

    public void setWaybillType(Integer waybillType) {
        this.waybillType = waybillType;
    }

    public Integer getWaybillFrom() {
        return waybillFrom;
    }

    public void setWaybillFrom(Integer waybillFrom) {
        this.waybillFrom = waybillFrom;
    }

    public Integer getWaybillTo() {
        return waybillTo;
    }

    public void setWaybillTo(Integer waybillTo) {
        this.waybillTo = waybillTo;
    }

    public Integer getEmptyFrom() {
        return emptyFrom;
    }

    public void setEmptyFrom(Integer emptyFrom) {
        this.emptyFrom = emptyFrom;
    }

    public Integer getEmptyTo() {
        return emptyTo;
    }

    public void setEmptyTo(Integer emptyTo) {
        this.emptyTo = emptyTo;
    }

    public WaybillDetailDto getWaybillDetail() {
        return waybillDetail;
    }

    public void setWaybillDetail(WaybillDetailDto waybillDetail) {
        this.waybillDetail = waybillDetail;
    }

    public ShippingListDto getShippingList() {
        return shippingList;
    }

    public void setShippingList(ShippingListDto shippingList) {
        this.shippingList = shippingList;
    }

    public List<CostDto> getCosts() {
        return costs;
    }

    public void setCosts(List<CostDto> costs) {
        this.costs = costs;
    }

    public List<LedgerDetailDto> getLedgerDetails() {
        return ledgerDetails;
    }

    public void setLedgerDetails(List<LedgerDetailDto> ledgerDetails) {
        this.ledgerDetails = ledgerDetails;
    }

    @Override
    public boolean equals(Object o){
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        WaybillDto waybill = (WaybillDto) o;
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
