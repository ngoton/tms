package com.tinhoctainha.tms.domain.model;

import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class PriceId implements Serializable {
    private Customer customer;
    private Commodity commodity;

    public PriceId(){}
    public PriceId(Customer customer, Commodity commodity){
        this.customer = customer;
        this.commodity = commodity;
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

    @Override
    public boolean equals(Object o){
        if(this == o) return true;
        if(o == null || getClass() != o.getClass()) return false;
        PriceId that = (PriceId) o;
        return (Objects.equals(customer, that.customer) && Objects.equals(commodity, that.commodity));
    }

    @Override
    public int hashCode(){
        return Objects.hash(customer, commodity);
    }
}
