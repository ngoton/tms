package com.tinhoctainha.tms.api.dto;

import javax.persistence.Embeddable;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

@Embeddable
public class PriceId implements Serializable {
    private Customer customer;
    private Commodity commodity;

    @Temporal(TemporalType.DATE)
    private Date startDate;

    public PriceId(){}
    public PriceId(Customer customer, Commodity commodity, Date startDate){
        this.customer = customer;
        this.commodity = commodity;
        this.startDate = startDate;
    }

    public Long getCustomer() {
        return customer.getId();
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Long getCommodity() {
        return commodity.getId();
    }

    public void setCommodity(Commodity commodity) {
        this.commodity = commodity;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    @Override
    public boolean equals(Object o){
        if(this == o) return true;
        if(o == null || getClass() != o.getClass()) return false;
        PriceId that = (PriceId) o;
        return (Objects.equals(customer, that.customer) && Objects.equals(commodity, that.commodity) && Objects.equals(startDate, that.startDate));
    }

    @Override
    public int hashCode(){
        return Objects.hash(customer, commodity, startDate);
    }
}
