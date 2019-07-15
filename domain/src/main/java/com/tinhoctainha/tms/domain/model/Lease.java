package com.tinhoctainha.tms.domain.model;

import javax.persistence.*;
import java.util.Date;
import java.util.Objects;

@Entity
public class Lease extends IncrementIDBaseEntity {
    private Date leaseDate;
    private Date expiredDate;
    private Double price;

    @ManyToOne
    @JoinColumn(name = "vehicle_id", referencedColumnName = "id", nullable = false)
    private Vehicle vehicle;

    @Basic
    @Temporal(TemporalType.DATE)
    @Column(name = "lease_date")
    public Date getLeaseDate() {
        return leaseDate;
    }

    public void setLeaseDate(Date leaseDate) {
        this.leaseDate = leaseDate;
    }

    @Basic
    @Temporal(TemporalType.DATE)
    @Column(name = "expired_date")
    public Date getExpiredDate() {
        return expiredDate;
    }

    public void setExpiredDate(Date expiredDate) {
        this.expiredDate = expiredDate;
    }

    @Basic
    @Column(name = "price", precision = 12, scale = 2)
    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    @Override
    public boolean equals(Object o){
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Lease lease = (Lease) o;
        return (getId() == lease.getId() &&
                Objects.equals(leaseDate, lease.leaseDate) &&
                Objects.equals(expiredDate, lease.expiredDate) &&
                Objects.equals(price, lease.price));
    }

    @Override
    public int hashCode(){
        return Objects.hash(getId(), leaseDate, expiredDate, price);
    }
}
