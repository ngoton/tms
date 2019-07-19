package com.tinhoctainha.tms.api.dto;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.tinhoctainha.tms.api.util.CustomDateDeserializer;
import com.tinhoctainha.tms.api.util.CustomDateSerializer;
import com.tinhoctainha.tms.api.util.CustomDateTimeDeserializer;
import com.tinhoctainha.tms.api.util.CustomDateTimeSerializer;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Objects;

public class ShippingListDto implements Serializable {
    private Long id;
    private Date shippingListDate;
    private String shippingListNumber;
    private Date startDate;
    private Date endDate;
    private Double amount;
    private InvoiceDto invoice;
    private List<WaybillDto> waybills;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @JsonSerialize(using = CustomDateSerializer.class)
    public Date getShippingListDate() {
        return shippingListDate;
    }

    @JsonDeserialize(using = CustomDateDeserializer.class)
    public void setShippingListDate(Date shippingListDate) {
        this.shippingListDate = shippingListDate;
    }

    public String getShippingListNumber() {
        return shippingListNumber;
    }

    public void setShippingListNumber(String shippingListNumber) {
        this.shippingListNumber = shippingListNumber;
    }

    @JsonSerialize(using = CustomDateTimeSerializer.class)
    public Date getStartDate() {
        return startDate;
    }

    @JsonDeserialize(using = CustomDateTimeDeserializer.class)
    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    @JsonSerialize(using = CustomDateTimeSerializer.class)
    public Date getEndDate() {
        return endDate;
    }

    @JsonDeserialize(using = CustomDateTimeDeserializer.class)
    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public InvoiceDto getInvoice() {
        return invoice;
    }

    public void setInvoice(InvoiceDto invoice) {
        this.invoice = invoice;
    }

    public List<WaybillDto> getWaybills() {
        return waybills;
    }

    public void setWaybills(List<WaybillDto> waybills) {
        this.waybills = waybills;
    }

    @Override
    public boolean equals(Object o){
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ShippingListDto shippingList = (ShippingListDto) o;
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
