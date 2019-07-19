package com.tinhoctainha.tms.api.dto;

import java.io.Serializable;
import java.util.Objects;

public class WaybillDetailDto implements Serializable {
    private WaybillDto waybill;
    private VehicleDto vehicle;
    private RomoocDto romooc;
    private CustomerDto customer;
    private StaffDto staff;
    private CommodityDto commodity;

    public WaybillDto getWaybill() {
        return waybill;
    }

    public void setWaybill(WaybillDto waybill) {
        this.waybill = waybill;
    }

    public VehicleDto getVehicle() {
        return vehicle;
    }

    public void setVehicle(VehicleDto vehicle) {
        this.vehicle = vehicle;
    }

    public RomoocDto getRomooc() {
        return romooc;
    }

    public void setRomooc(RomoocDto romooc) {
        this.romooc = romooc;
    }

    public CustomerDto getCustomer() {
        return customer;
    }

    public void setCustomer(CustomerDto customer) {
        this.customer = customer;
    }

    public StaffDto getStaff() {
        return staff;
    }

    public void setStaff(StaffDto staff) {
        this.staff = staff;
    }

    public CommodityDto getCommodity() {
        return commodity;
    }

    public void setCommodity(CommodityDto commodity) {
        this.commodity = commodity;
    }

    @Override
    public boolean equals(Object o){
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        WaybillDetailDto waybillDetail = (WaybillDetailDto) o;
        return (Objects.equals(waybill, waybillDetail.waybill));
    }

    @Override
    public int hashCode(){
        return Objects.hash(waybill);
    }
}
