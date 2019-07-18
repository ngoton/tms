package com.tinhoctainha.tms.api.dto;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.List;
import java.util.Objects;

@Entity
public class Booking extends UIDBaseEntity {
    private String bookingNumber;
    private Date bookingDate;
    private Integer bookingType;
    private String note;

    @ManyToOne
    @JoinColumn(name = "staff_id", referencedColumnName = "id")
    private Staff staff;

    @ManyToOne
    @JoinColumn(name = "customer_id", referencedColumnName = "id", nullable = false)
    private Customer customer;

    @OneToMany(mappedBy = "booking")
    private List<Operation> operations;

    @Basic
    @NotNull
    @Column(name = "booking_number")
    public String getBookingNumber() {
        return bookingNumber;
    }

    public void setBookingNumber(String bookingNumber) {
        this.bookingNumber = bookingNumber;
    }

    @Basic
    @Temporal(TemporalType.DATE)
    @Column(name = "booking_date")
    public Date getBookingDate() {
        return bookingDate;
    }

    public void setBookingDate(Date bookingDate) {
        this.bookingDate = bookingDate;
    }

    @Basic
    @Column(name = "booking_type")
    public Integer getBookingType() {
        return bookingType;
    }

    public void setBookingType(Integer bookingType) {
        this.bookingType = bookingType;
    }

    @Basic
    @Column(name = "note")
    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public Staff getStaff() {
        return staff;
    }

    public void setStaff(Staff staff) {
        this.staff = staff;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public List<Operation> getOperations() {
        return operations;
    }

    public void setOperations(List<Operation> operations) {
        this.operations = operations;
    }

    @Override
    public boolean equals(Object o){
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Booking booking = (Booking) o;
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
