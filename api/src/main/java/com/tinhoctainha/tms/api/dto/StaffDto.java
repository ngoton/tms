package com.tinhoctainha.tms.api.dto;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.tinhoctainha.tms.api.util.CustomDateDeserializer;
import com.tinhoctainha.tms.api.util.CustomDateSerializer;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Objects;

public class StaffDto implements Serializable {
    private Long id;
    private String staffCode;
    private String fullName;
    private Date birthDate;
    private Integer gender;
    private String address;
    private String phone;
    private String email;
    private String idNumber;
    private String driverLicense;
    private String bankAccount;
    private String bankName;
    private String bankBranch;
    private String position;
    private Integer department;
    private Date startWorking;
    private Date endWorking;
    private List<BookingDto> bookings;
    private List<CustomerDto> customers;
    private List<StaffHasVehicleDto> staffHasVehicles;
    private List<WaybillDetailDto> waybillDetails;
    private UserDto user;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getStaffCode() {
        return staffCode;
    }

    public void setStaffCode(String staffCode) {
        this.staffCode = staffCode;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    @JsonSerialize(using = CustomDateSerializer.class)
    public Date getBirthDate() {
        return birthDate;
    }

    @JsonDeserialize(using = CustomDateDeserializer.class)
    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public Integer getGender() {
        return gender;
    }

    public void setGender(Integer gender) {
        this.gender = gender;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getIdNumber() {
        return idNumber;
    }

    public void setIdNumber(String idNumber) {
        this.idNumber = idNumber;
    }

    public String getDriverLicense() {
        return driverLicense;
    }

    public void setDriverLicense(String driverLicense) {
        this.driverLicense = driverLicense;
    }

    public String getBankAccount() {
        return bankAccount;
    }

    public void setBankAccount(String bankAccount) {
        this.bankAccount = bankAccount;
    }

    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    public String getBankBranch() {
        return bankBranch;
    }

    public void setBankBranch(String bankBranch) {
        this.bankBranch = bankBranch;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public Integer getDepartment() {
        return department;
    }

    public void setDepartment(Integer department) {
        this.department = department;
    }

    @JsonSerialize(using = CustomDateSerializer.class)
    public Date getStartWorking() {
        return startWorking;
    }

    @JsonDeserialize(using = CustomDateDeserializer.class)
    public void setStartWorking(Date startWorking) {
        this.startWorking = startWorking;
    }

    @JsonSerialize(using = CustomDateSerializer.class)
    public Date getEndWorking() {
        return endWorking;
    }

    @JsonDeserialize(using = CustomDateDeserializer.class)
    public void setEndWorking(Date endWorking) {
        this.endWorking = endWorking;
    }

    public List<BookingDto> getBookings() {
        return bookings;
    }

    public void setBookings(List<BookingDto> bookings) {
        this.bookings = bookings;
    }

    public List<CustomerDto> getCustomers() {
        return customers;
    }

    public void setCustomers(List<CustomerDto> customers) {
        this.customers = customers;
    }

    public List<StaffHasVehicleDto> getStaffHasVehicles() {
        return staffHasVehicles;
    }

    public void setStaffHasVehicles(List<StaffHasVehicleDto> staffHasVehicles) {
        this.staffHasVehicles = staffHasVehicles;
    }

    public List<WaybillDetailDto> getWaybillDetails() {
        return waybillDetails;
    }

    public void setWaybillDetails(List<WaybillDetailDto> waybillDetails) {
        this.waybillDetails = waybillDetails;
    }

    public UserDto getUser() {
        return user;
    }

    public void setUser(UserDto user) {
        this.user = user;
    }

    @Override
    public boolean equals(Object o){
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        StaffDto staff = (StaffDto) o;
        return (getId() == staff.getId() &&
                Objects.equals(staffCode, staff.staffCode) &&
                Objects.equals(fullName, staff.fullName) &&
                Objects.equals(birthDate, staff.birthDate) &&
                Objects.equals(gender, staff.gender) &&
                Objects.equals(address, staff.address) &&
                Objects.equals(phone, staff.phone) &&
                Objects.equals(email, staff.email) &&
                Objects.equals(idNumber, staff.idNumber) &&
                Objects.equals(driverLicense, staff.driverLicense) &&
                Objects.equals(bankAccount, staff.bankAccount) &&
                Objects.equals(bankName, staff.bankName) &&
                Objects.equals(bankBranch, staff.bankBranch) &&
                Objects.equals(position, staff.position) &&
                Objects.equals(department, staff.department) &&
                Objects.equals(startWorking, staff.startWorking) &&
                Objects.equals(endWorking, staff.endWorking));
    }

    @Override
    public int hashCode(){
        return Objects.hash(getId(), staffCode, fullName, birthDate, gender, address, phone, email, idNumber, driverLicense, bankAccount, bankName, bankBranch, position, department, startWorking, endWorking);
    }

}
