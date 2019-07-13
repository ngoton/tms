package com.tinhoctainha.tms.domain.model;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import java.util.Objects;

@Entity
public class Accessory extends IncrementIDBaseEntity {
    private String accessoryCode;
    private String name;
    private String brand;
    private String manufacture;

    @Basic
    @Column(name = "accessory_code")
    public String getAccessoryCode() {
        return accessoryCode;
    }

    public void setAccessoryCode(String accessoryCode) {
        this.accessoryCode = accessoryCode;
    }

    @Basic
    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "brand")
    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    @Basic
    @Column(name = "manufacture")
    public String getManufacture() {
        return manufacture;
    }

    public void setManufacture(String manufacture) {
        this.manufacture = manufacture;
    }

    @Override
    public boolean equals(Object o){
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Accessory accessory = (Accessory) o;
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
}
