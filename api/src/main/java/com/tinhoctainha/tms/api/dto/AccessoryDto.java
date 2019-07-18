package com.tinhoctainha.tms.api.dto;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;

public class AccessoryDto implements Serializable {
    private Long id;
    private String accessoryCode;
    private String name;
    private String brand;
    private String manufacture;
    private List<ItemDto> items;

    @Override
    public boolean equals(Object o){
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AccessoryDto accessory = (AccessoryDto) o;
        return (getId() == accessory.getId() &&
                Objects.equals(accessoryCode, accessory.accessoryCode) &&
                Objects.equals(name, accessory.name) &&
                Objects.equals(brand, accessory.brand) &&
                Objects.equals(manufacture, accessory.manufacture));
    }

    @Override
    public int hashCode(){
        return Objects.hash(getId(), accessoryCode, name, brand, manufacture);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAccessoryCode(){
        return accessoryCode;
    }

    public void setAccessoryCode(String accessoryCode) {
        this.accessoryCode = accessoryCode;
    }

    public String getName(){
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBrand(){
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getManufacture(){
        return manufacture;
    }

    public void setManufacture(String manufacture) {
        this.manufacture = manufacture;
    }

    public List<ItemDto> getItems() {
        return items;
    }

    public void setItems(List<ItemDto> items) {
        this.items = items;
    }
}
