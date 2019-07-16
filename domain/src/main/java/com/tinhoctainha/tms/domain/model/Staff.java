package com.tinhoctainha.tms.domain.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.List;
import java.util.Objects;

@Entity
public class Staff extends IncrementIDBaseEntity {
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

    @OneToMany(mappedBy = "staff")
    private List<Booking> bookings;

    @OneToMany(mappedBy = "staff")
    private List<Customer> customers;

    @OneToMany(mappedBy = "staff", cascade = CascadeType.ALL)
    private List<StaffHasVehicle> staffHasVehicles;

    @OneToMany(mappedBy = "staff")
    private List<WaybillDetail> waybillDetails;

    @OneToOne(mappedBy = "staff")
    private User user;

    @Basic
    @Column(name = "staff_code")
    public String getStaffCode() {
        return staffCode;
    }

    public void setStaffCode(String staffCode) {
        this.staffCode = staffCode;
    }

    @NotNull
    @Basic
    @Column(name = "full_name")
    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    @Basic
    @Temporal(TemporalType.DATE)
    @Column(name = "birth_date")
    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    @Basic
    @Column(name = "gender")
    public Integer getGender() {
        return gender;
    }

    public void setGender(Integer gender) {
        this.gender = gender;
    }

    @Basic
    @Column(name = "address")
    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Basic
    @Column(name = "phone")
    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Basic
    @Column(name = "email")
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Basic
    @Column(name = "id_number")
    public String getIdNumber() {
        return idNumber;
    }

    public void setIdNumber(String idNumber) {
        this.idNumber = idNumber;
    }

    @Basic
    @Column(name = "driver_license")
    public String getDriverLicense() {
        return driverLicense;
    }

    public void setDriverLicense(String driverLicense) {
        this.driverLicense = driverLicense;
    }

    @Basic
    @Column(name = "bank_account")
    public String getBankAccount() {
        return bankAccount;
    }

    public void setBankAccount(String bankAccount) {
        this.bankAccount = bankAccount;
    }

    @Basic
    @Column(name = "bank_name")
    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    @Basic
    @Column(name = "bank_branch")
    public String getBankBranch() {
        return bankBranch;
    }

    public void setBankBranch(String bankBranch) {
        this.bankBranch = bankBranch;
    }

    @Basic
    @Column(name = "position")
    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    @Basic
    @Column(name = "department")
    public Integer getDepartment() {
        return department;
    }

    public void setDepartment(Integer department) {
        this.department = department;
    }

    @Basic
    @Temporal(TemporalType.DATE)
    @Column(name = "start_working")
    public Date getStartWorking() {
        return startWorking;
    }

    public void setStartWorking(Date startWorking) {
        this.startWorking = startWorking;
    }

    @Basic
    @Temporal(TemporalType.DATE)
    @Column(name = "end_working")
    public Date getEndWorking() {
        return endWorking;
    }

    public void setEndWorking(Date endWorking) {
        this.endWorking = endWorking;
    }

    public List<Booking> getBookings() {
        return bookings;
    }

    public void setBookings(List<Booking> bookings) {
        this.bookings = bookings;
    }

    public List<Customer> getCustomers() {
        return customers;
    }

    public void setCustomers(List<Customer> customers) {
        this.customers = customers;
    }

    public List<StaffHasVehicle> getStaffHasVehicles() {
        return staffHasVehicles;
    }

    public void setStaffHasVehicles(List<StaffHasVehicle> staffHasVehicles) {
        this.staffHasVehicles = staffHasVehicles;
    }

    public List<WaybillDetail> getWaybillDetails() {
        return waybillDetails;
    }

    public void setWaybillDetails(List<WaybillDetail> waybillDetails) {
        this.waybillDetails = waybillDetails;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public boolean equals(Object o){
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Staff staff = (Staff) o;
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
