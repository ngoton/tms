package com.tinhoctainha.tms.api.dto;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.deser.std.DateDeserializers;
import com.tinhoctainha.tms.api.util.CustomDateSerializer;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

public class ContactDto implements Serializable {
    private Long id;
    private String name;
    private Date birthDate;
    private Integer gender;
    private String phone;
    private String email;
    private String position;
    private CustomerDto customer;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @JsonSerialize(using = CustomDateSerializer.class)
    public Date getBirthDate() {
        return birthDate;
    }

    @JsonDeserialize(using = DateDeserializers.CalendarDeserializer.class)
    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public Integer getGender() {
        return gender;
    }

    public void setGender(Integer gender) {
        this.gender = gender;
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

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public CustomerDto getCustomer() {
        return customer;
    }

    public void setCustomer(CustomerDto customer) {
        this.customer = customer;
    }

    @Override
    public boolean equals(Object o){
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ContactDto contact = (ContactDto) o;
        return (getId() == contact.getId() &&
                Objects.equals(name, contact.name) &&
                Objects.equals(birthDate, contact.birthDate) &&
                Objects.equals(gender, contact.gender) &&
                Objects.equals(phone, contact.phone) &&
                Objects.equals(email, contact.email) &&
                Objects.equals(position, contact.position));
    }

    @Override
    public int hashCode(){
        return Objects.hash(getId(), name, birthDate, gender, phone, email, position);
    }

}
