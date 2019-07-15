package com.tinhoctainha.tms.domain.model;

import javax.persistence.*;
import java.util.Date;
import java.util.List;
import java.util.Objects;

@Entity
public class Item extends IncrementIDBaseEntity {
    private String name;
    private String serial;
    private Date mfg;
    private Date exp;

    @ManyToOne
    @JoinColumn(name = "accessory_id", referencedColumnName = "id", nullable = false)
    private Accessory accessory;

    @OneToMany(mappedBy = "item")
    private List<VehicleInsert> vehicleInserts;

    @OneToMany(mappedBy = "item")
    private List<RomoocInsert> romoocInserts;

    @OneToMany(mappedBy = "item")
    private List<VehicleRemoval> vehicleRemovals;

    @OneToMany(mappedBy = "item")
    private List<RomoocRemoval> romoocRemovals;

    @OneToMany(mappedBy = "item")
    private List<IssueHasItem> issueHasItems;

    @OneToMany(mappedBy = "item")
    private List<ReceiptHasItem> receiptHasItems;

    @Basic
    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "serial")
    public String getSerial() {
        return serial;
    }

    public void setSerial(String serial) {
        this.serial = serial;
    }

    @Basic
    @Temporal(TemporalType.DATE)
    @Column(name = "mfg")
    public Date getMfg() {
        return mfg;
    }

    public void setMfg(Date mfg) {
        this.mfg = mfg;
    }

    @Basic
    @Temporal(TemporalType.DATE)
    @Column(name = "exp")
    public Date getExp() {
        return exp;
    }

    public void setExp(Date exp) {
        this.exp = exp;
    }

    public Accessory getAccessory() {
        return accessory;
    }

    public void setAccessory(Accessory accessory) {
        this.accessory = accessory;
    }

    public List<VehicleInsert> getVehicleInserts() {
        return vehicleInserts;
    }

    public void setVehicleInserts(List<VehicleInsert> vehicleInserts) {
        this.vehicleInserts = vehicleInserts;
    }

    public List<RomoocInsert> getRomoocInserts() {
        return romoocInserts;
    }

    public void setRomoocInserts(List<RomoocInsert> romoocInserts) {
        this.romoocInserts = romoocInserts;
    }

    public List<VehicleRemoval> getVehicleRemovals() {
        return vehicleRemovals;
    }

    public void setVehicleRemovals(List<VehicleRemoval> vehicleRemovals) {
        this.vehicleRemovals = vehicleRemovals;
    }

    public List<RomoocRemoval> getRomoocRemovals() {
        return romoocRemovals;
    }

    public void setRomoocRemovals(List<RomoocRemoval> romoocRemovals) {
        this.romoocRemovals = romoocRemovals;
    }

    public List<IssueHasItem> getIssueHasItems() {
        return issueHasItems;
    }

    public void setIssueHasItems(List<IssueHasItem> issueHasItems) {
        this.issueHasItems = issueHasItems;
    }

    public List<ReceiptHasItem> getReceiptHasItems() {
        return receiptHasItems;
    }

    public void setReceiptHasItems(List<ReceiptHasItem> receiptHasItems) {
        this.receiptHasItems = receiptHasItems;
    }

    @Override
    public boolean equals(Object o){
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Item item = (Item) o;
        return (getId() == item.getId() &&
                Objects.equals(name, item.name) &&
                Objects.equals(serial, item.serial) &&
                Objects.equals(mfg, item.mfg) &&
                Objects.equals(exp, item.exp));
    }

    @Override
    public int hashCode(){
        return Objects.hash(getId(), name, serial, mfg, exp);
    }
}
