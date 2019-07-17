package com.tinhoctainha.tms.domain.model;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.List;
import java.util.Objects;

@Entity
public class Province extends IncrementIDBaseEntity {
    private String name;

    @OneToMany(mappedBy = "province")
    private List<Customer> customers;

    @OneToMany(mappedBy = "province")
    private List<Place> places;

    @Basic
    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Customer> getCustomers() {
        return customers;
    }

    public void setCustomers(List<Customer> customers) {
        this.customers = customers;
    }

    public List<Place> getPlaces() {
        return places;
    }

    public void setPlaces(List<Place> places) {
        this.places = places;
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
