package com.tinhoctainha.tms.api.dto;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.tinhoctainha.tms.api.util.CustomDateDeserializer;
import com.tinhoctainha.tms.api.util.CustomDateSerializer;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

public class RomoocInsertDto implements Serializable {
    private Long id;
    private Date insertDate;
    private Float quantity;
    private RomoocDto romooc;
    private ItemDto item;
    private IssueDto issue;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @JsonSerialize(using = CustomDateSerializer.class)
    public Date getInsertDate() {
        return insertDate;
    }

    @JsonDeserialize(using = CustomDateDeserializer.class)
    public void setInsertDate(Date insertDate) {
        this.insertDate = insertDate;
    }

    public Float getQuantity() {
        return quantity;
    }

    public void setQuantity(Float quantity) {
        this.quantity = quantity;
    }

    public RomoocDto getRomooc() {
        return romooc;
    }

    public void setRomooc(RomoocDto romooc) {
        this.romooc = romooc;
    }

    public ItemDto getItem() {
        return item;
    }

    public void setItem(ItemDto item) {
        this.item = item;
    }

    public IssueDto getIssue() {
        return issue;
    }

    public void setIssue(IssueDto issue) {
        this.issue = issue;
    }

    @Override
    public boolean equals(Object o){
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RomoocInsertDto romoocInsert = (RomoocInsertDto) o;
        return (getId() == romoocInsert.getId() &&
                Objects.equals(insertDate, romoocInsert.insertDate) &&
                Objects.equals(quantity, romoocInsert.quantity));
    }

    @Override
    public int hashCode(){
        return Objects.hash(getId(), insertDate, quantity);
    }

}
