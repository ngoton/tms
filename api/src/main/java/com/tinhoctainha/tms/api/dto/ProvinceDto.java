package com.tinhoctainha.tms.api.dto;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;

public class ProvinceDto implements Serializable {
    private Long id;
    private String name;
    private List<CustomerDto> customers;
    private List<PlaceDto> places;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<CustomerDto> getCustomers() {
        return customers;
    }

    public void setCustomers(List<CustomerDto> customers) {
        this.customers = customers;
    }

    public List<PlaceDto> getPlaces() {
        return places;
    }

    public void setPlaces(List<PlaceDto> places) {
        this.places = places;
    }

    @Override
    public boolean equals(Object o){
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProvinceDto province = (ProvinceDto) o;
        return (getId() == province.getId() &&
                Objects.equals(name, province.name));
    }

    @Override
    public int hashCode(){
        return Objects.hash(getId(), name);
    }

}
