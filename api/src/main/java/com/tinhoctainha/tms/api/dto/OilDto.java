package com.tinhoctainha.tms.api.dto;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.tinhoctainha.tms.api.util.CustomDateDeserializer;
import com.tinhoctainha.tms.api.util.CustomDateSerializer;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

public class OilDto implements Serializable {
    private Long id;
    private Date oilDate;
    private Float volume;
    private Integer contermet;
    private Integer gpsContermet;
    private VehicleDto vehicle;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @JsonSerialize(using = CustomDateSerializer.class)
    public Date getOilDate() {
        return oilDate;
    }

    @JsonDeserialize(using = CustomDateDeserializer.class)
    public void setOilDate(Date oilDate) {
        this.oilDate = oilDate;
    }

    public Float getVolume() {
        return volume;
    }

    public void setVolume(Float volume) {
        this.volume = volume;
    }

    public Integer getContermet() {
        return contermet;
    }

    public void setContermet(Integer contermet) {
        this.contermet = contermet;
    }

    public Integer getGpsContermet() {
        return gpsContermet;
    }

    public void setGpsContermet(Integer gpsContermet) {
        this.gpsContermet = gpsContermet;
    }

    public VehicleDto getVehicle() {
        return vehicle;
    }

    public void setVehicle(VehicleDto vehicle) {
        this.vehicle = vehicle;
    }

    @Override
    public boolean equals(Object o){
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OilDto oil = (OilDto) o;
        return (getId() == oil.getId() &&
                Objects.equals(oilDate, oil.oilDate) &&
                Objects.equals(volume, oil.volume) &&
                Objects.equals(contermet, oil.contermet) &&
                Objects.equals(gpsContermet, oil.gpsContermet));
    }

    @Override
    public int hashCode(){
        return Objects.hash(getId(), oilDate, volume, contermet, gpsContermet);
    }

}
