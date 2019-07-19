package com.tinhoctainha.tms.api.dto;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.tinhoctainha.tms.api.util.CustomDateDeserializer;
import com.tinhoctainha.tms.api.util.CustomDateSerializer;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Objects;

public class BookingDto implements Serializable {
    private String id;
    private String bookingNumber;
    private Date bookingDate;
    private Integer bookingType;
    private String note;
    private StaffDto staff;
    private CustomerDto customer;
    private List<OperationDto> operations;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getBookingNumber() {
        return bookingNumber;
    }

    public void setBookingNumber(String bookingNumber) {
        this.bookingNumber = bookingNumber;
    }

    @JsonSerialize(using = CustomDateSerializer.class)
    public Date getBookingDate() {
        return bookingDate;
    }

    @JsonDeserialize(using = CustomDateDeserializer.class)
    public void setBookingDate(Date bookingDate) {
        this.bookingDate = bookingDate;
    }

    public Integer getBookingType() {
        return bookingType;
    }

    public void setBookingType(Integer bookingType) {
        this.bookingType = bookingType;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public StaffDto getStaff() {
        return staff;
    }

    public void setStaff(StaffDto staff) {
        this.staff = staff;
    }

    public CustomerDto getCustomer() {
        return customer;
    }

    public void setCustomer(CustomerDto customer) {
        this.customer = customer;
    }

    public List<OperationDto> getOperations() {
        return operations;
    }

    public void setOperations(List<OperationDto> operations) {
        this.operations = operations;
    }

    @Override
    public boolean equals(Object o){
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BookingDto booking = (BookingDto) o;
        return (getId() == booking.getId() &&
                Objects.equals(bookingNumber, booking.bookingNumber) &&
                Objects.equals(bookingDate, booking.bookingDate) &&
                Objects.equals(bookingType, booking.bookingType) &&
                Objects.equals(note, booking.note));
    }

    @Override
    public int hashCode(){
        return Objects.hash(getId(), bookingNumber, bookingDate, bookingType, note);
    }

}
