package com.tinhoctainha.tms.domain.model;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.Objects;

@Entity
public class Province extends IncrementIDBaseEntity {
    private String name;

    @OneToMany(mappedBy = "province")
    private Customer customer;

    @OneToMany(mappedBy = "place")
    private Place place;

    @Basic
    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Place getPlace() {
        return place;
    }

    public void setPlace(Place place) {
        this.place = place;
    }

    @Override
    public boolean equals(Object o){
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Province province = (Province) o;
        return (getId() == province.getId() &&
                Objects.equals(name, province.name));
    }

    @Override
    public int hashCode(){
        return Objects.hash(getId(), name);
    }
}
