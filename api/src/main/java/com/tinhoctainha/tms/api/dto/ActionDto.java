package com.tinhoctainha.tms.api.dto;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.tinhoctainha.tms.api.util.CustomDateDeserializer;
import com.tinhoctainha.tms.api.util.CustomDateSerializer;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

public class ActionDto implements Serializable {
    private Long id;
    private String act;
    private String data;
    private Date time;
    private UserDto user;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAct() {
        return act;
    }

    public void setAct(String act) {
        this.act = act;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    @JsonSerialize(using = CustomDateSerializer.class)
    public Date getTime() {
        return time;
    }

    @JsonDeserialize(using = CustomDateDeserializer.class)
    public void setTime(Date time) {
        this.time = time;
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
        ActionDto action = (ActionDto) o;
        return (getId() == action.getId() &&
                Objects.equals(act, action.act) &&
                Objects.equals(data, action.data) &&
                Objects.equals(time, action.time));
    }

    @Override
    public int hashCode(){
        return Objects.hash(getId(), act, data, time);
    }
}
