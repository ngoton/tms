package com.tinhoctainha.tms.api.dto;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

@Entity
@IdClass(PriceId.class)
public class Price implements Serializable {
    @Id
    @ManyToOne
    @JoinColumn(name = "customer_id", referencedColumnName = "id", nullable = false)
    private Customer customer;

    @Id
    @ManyToOne
    @JoinColumn(name = "commodity_id", referencedColumnName = "id", nullable = false)
    private Commodity commodity;

    @Id
    @Temporal(TemporalType.DATE)
    @Column(name = "start_date")
    private Date startDate;

    private Date endDate;
    private Integer unit;
    private Double price;

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Commodity getCommodity() {
        return commodity;
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

    @Basic
    @Temporal(TemporalType.DATE)
    @Column(name = "end_date")
    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
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
    @Column(name = "price", precision = 12, scale = 2)
    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    @Override
    public boolean equals(Object o){
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Price price = (Price) o;
        return (Objects.equals(customer, price.customer) &&
                Objects.equals(commodity, price.commodity) &&
                Objects.equals(startDate, price.startDate) &&
                Objects.equals(endDate, price.endDate) &&
                Objects.equals(unit, price.unit) &&
                Objects.equals(price, price.price));
    }

    @Override
    public int hashCode(){
        return Objects.hash(customer, commodity, startDate, endDate, unit, price);
    }
}
