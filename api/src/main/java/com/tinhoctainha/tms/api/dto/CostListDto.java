package com.tinhoctainha.tms.api.dto;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.tinhoctainha.tms.api.util.CustomDateDeserializer;
import com.tinhoctainha.tms.api.util.CustomDateSerializer;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Objects;

public class CostListDto implements Serializable {
    private Long id;
    private Date costListDate;
    private String costListNumber;
    private Date startDate;
    private Date endDate;
    private Double amount;
    private List<CostDto> costs;
    private DebitDto debit;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @JsonSerialize(using = CustomDateSerializer.class)
    public Date getCostListDate() {
        return costListDate;
    }

    @JsonDeserialize(using = CustomDateDeserializer.class)
    public void setCostListDate(Date costListDate) {
        this.costListDate = costListDate;
    }

    public String getCostListNumber() {
        return costListNumber;
    }

    public void setCostListNumber(String costListNumber) {
        this.costListNumber = costListNumber;
    }

    @JsonSerialize(using = CustomDateSerializer.class)
    public Date getStartDate() {
        return startDate;
    }

    @JsonDeserialize(using = CustomDateDeserializer.class)
    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    @JsonSerialize(using = CustomDateSerializer.class)
    public Date getEndDate() {
        return endDate;
    }

    @JsonDeserialize(using = CustomDateDeserializer.class)
    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public List<CostDto> getCosts() {
        return costs;
    }

    public void setCosts(List<CostDto> costs) {
        this.costs = costs;
    }

    public DebitDto getDebit() {
        return debit;
    }

    public void setDebit(DebitDto debit) {
        this.debit = debit;
    }

    @Override
    public boolean equals(Object o){
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CostListDto costList = (CostListDto) o;
        return (getId() == costList.getId() &&
                Objects.equals(costListDate, costList.costListDate) &&
                Objects.equals(costListNumber, costList.costListNumber) &&
                Objects.equals(startDate, costList.startDate) &&
                Objects.equals(endDate, costList.endDate)  &&
                Objects.equals(amount, costList.amount));
    }

    @Override
    public int hashCode(){
        return Objects.hash(getId(), costListDate, costListNumber, startDate, endDate, amount);
    }

}
