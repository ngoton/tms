package com.tinhoctainha.tms.api.dto;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;

public class CommodityDto implements Serializable {
    private Long id;
    private String name;
    private List<PriceDto> prices;
    private List<WaybillDetailDto> waybillDetails;

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

    public List<PriceDto> getPrices() {
        return prices;
    }

    public void setPrices(List<PriceDto> prices) {
        this.prices = prices;
    }

    public List<WaybillDetailDto> getWaybillDetails() {
        return waybillDetails;
    }

    public void setWaybillDetails(List<WaybillDetailDto> waybillDetails) {
        this.waybillDetails = waybillDetails;
    }

    @Override
    public boolean equals(Object o){
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CommodityDto commodity = (CommodityDto) o;
        return (getId() == commodity.getId() &&
                Objects.equals(name, commodity.name));
    }

    @Override
    public int hashCode(){
        return Objects.hash(getId(), name);
    }

}
