package com.tinhoctainha.tms.domain.model;

import javax.persistence.*;
import java.util.Date;
import java.util.Objects;

@Entity
public class Oil extends IncrementIDBaseEntity {
    private Date oilDate;
    private Float volume;
    private Integer contermet;
    private Integer gpsContermet;

    @ManyToOne
    @JoinColumn(name = "vehicle_id", referencedColumnName = "id", nullable = false)
    private Vehicle vehicle;

    @Basic
    @Temporal(TemporalType.DATE)
    @Column(name = "oil_date")
    public Date getOilDate() {
        return oilDate;
    }

    public void setOilDate(Date oilDate) {
        this.oilDate = oilDate;
    }

    @Basic
    @Column(name = "volume")
    public Float getVolume() {
        return volume;
    }

    public void setVolume(Float volume) {
        this.volume = volume;
    }

    @Basic
    @Column(name = "contermet")
    public Integer getContermet() {
        return contermet;
    }

    public void setContermet(Integer contermet) {
        this.contermet = contermet;
    }

    @Basic
    @Column(name = "gps_contermet")
    public Integer getGpsContermet() {
        return gpsContermet;
    }

    public void setGpsContermet(Integer gpsContermet) {
        this.gpsContermet = gpsContermet;
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
        Oil oil = (Oil) o;
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
