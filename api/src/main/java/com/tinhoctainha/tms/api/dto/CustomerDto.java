package com.tinhoctainha.tms.api.dto;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;

public class CustomerDto implements Serializable {
    private Long id;
    private String customerCode;
    private String name;
    private String company;
    private String idNumber;
    private String address;
    private String phone;
    private String fax;
    private String email;
    private String bankAccount;
    private String bankName;
    private String bankBranch;
    private Integer isSupplier;
    private StaffDto staff;
    private ProvinceDto province;
    private List<ContactDto> contacts;
    private List<BookingDto> bookings;
    private List<PriceDto> prices;
    private List<CostDto> costs;
    private List<WaybillDetailDto> waybillDetails;
    private List<OrderDto> orders;
    private List<FeeDto> fees;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCustomerCode() {
        return customerCode;
    }

    public void setCustomerCode(String customerCode) {
        this.customerCode = customerCode;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getIdNumber() {
        return idNumber;
    }

    public void setIdNumber(String idNumber) {
        this.idNumber = idNumber;
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

    public String getFax() {
        return fax;
    }

    public void setFax(String fax) {
        this.fax = fax;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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

    public Integer getIsSupplier() {
        return isSupplier;
    }

    public void setIsSupplier(Integer isSupplier) {
        this.isSupplier = isSupplier;
    }

    public StaffDto getStaff() {
        return staff;
    }

    public void setStaff(StaffDto staff) {
        this.staff = staff;
    }

    public ProvinceDto getProvince() {
        return province;
    }

    public void setProvince(ProvinceDto province) {
        this.province = province;
    }

    public List<ContactDto> getContacts() {
        return contacts;
    }

    public void setContacts(List<ContactDto> contacts) {
        this.contacts = contacts;
    }

    public List<BookingDto> getBookings() {
        return bookings;
    }

    public void setBookings(List<BookingDto> bookings) {
        this.bookings = bookings;
    }

    public List<PriceDto> getPrices() {
        return prices;
    }

    public void setPrices(List<PriceDto> prices) {
        this.prices = prices;
    }

    public List<CostDto> getCosts() {
        return costs;
    }

    public void setCosts(List<CostDto> costs) {
        this.costs = costs;
    }

    public List<WaybillDetailDto> getWaybillDetails() {
        return waybillDetails;
    }

    public void setWaybillDetails(List<WaybillDetailDto> waybillDetails) {
        this.waybillDetails = waybillDetails;
    }

    public List<OrderDto> getOrders() {
        return orders;
    }

    public void setOrders(List<OrderDto> orders) {
        this.orders = orders;
    }

    public List<FeeDto> getFees() {
        return fees;
    }

    public void setFees(List<FeeDto> fees) {
        this.fees = fees;
    }

    @Override
    public boolean equals(Object o){
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CustomerDto customer = (CustomerDto) o;
        return (getId() == customer.getId() &&
                Objects.equals(customerCode, customer.customerCode) &&
                Objects.equals(name, customer.name) &&
                Objects.equals(company, customer.company) &&
                Objects.equals(idNumber, customer.idNumber) &&
                Objects.equals(address, customer.address) &&
                Objects.equals(phone, customer.phone) &&
                Objects.equals(fax, customer.fax) &&
                Objects.equals(email, customer.email) &&
                Objects.equals(bankAccount, customer.bankAccount) &&
                Objects.equals(bankName, customer.bankName) &&
                Objects.equals(bankBranch, customer.bankBranch) &&
                Objects.equals(isSupplier, customer.isSupplier));
    }

    @Override
    public int hashCode(){
        return Objects.hash(getId(), customerCode, name, company, idNumber, address, phone, fax, email, bankAccount, bankName, bankBranch, isSupplier);
    }

}
