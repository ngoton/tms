package com.tinhoctainha.tms.api.dto;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.Objects;

@Entity
public class Commodity extends IncrementIDBaseEntity {
    private String name;

    @OneToMany(mappedBy = "commodity")
    private List<Price> prices;

    @OneToMany(mappedBy = "commodity")
    private List<WaybillDetail> waybillDetails;

    @Basic
    @NotNull
    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Price> getPrices() {
        return prices;
    }

    public void setPrices(List<Price> prices) {
        this.prices = prices;
    }

    public List<WaybillDetail> getWaybillDetails() {
        return waybillDetails;
    }

    public void setWaybillDetails(List<WaybillDetail> waybillDetails) {
        this.waybillDetails = waybillDetails;
    }

    @Override
    public boolean equals(Object o){
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Commodity commodity = (Commodity) o;
        return (getId() == commodity.getId() &&
                Objects.equals(name, commodity.name));
    }

    @Override
    public int hashCode(){
        return Objects.hash(getId(), name);
    }
}
