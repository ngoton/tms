package com.tinhoctainha.tms.api.dto;

import javax.persistence.*;
import java.util.Date;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "cost_list")
public class CostList extends IncrementIDBaseEntity {
    private Date costListDate;
    private String costListNumber;
    private Date startDate;
    private Date endDate;
    private Double amount;

    @OneToMany(mappedBy = "costList")
    private List<Cost> costs;

    @OneToOne(mappedBy = "costList", cascade = CascadeType.ALL)
    private Debit debit;

    @Basic
    @Temporal(TemporalType.DATE)
    @Column(name = "cost_list_date")
    public Date getCostListDate() {
        return costListDate;
    }

    public void setCostListDate(Date costListDate) {
        this.costListDate = costListDate;
    }

    @Basic
    @Column(name = "cost_list_number")
    public String getCostListNumber() {
        return costListNumber;
    }

    public void setCostListNumber(String costListNumber) {
        this.costListNumber = costListNumber;
    }

    @Basic
    @Temporal(TemporalType.DATE)
    @Column(name = "start_date")
    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    @Basic
    @Temporal(TemporalType.DATE)
    @Column(name = "end_date")
    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    @Basic
    @Column(name = "amount", precision = 14, scale = 2)
    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public List<Cost> getCosts() {
        return costs;
    }

    public void setCosts(List<Cost> costs) {
        this.costs = costs;
    }

    public Debit getDebit() {
        return debit;
    }

    public void setDebit(Debit debit) {
        this.debit = debit;
    }

    @Override
    public boolean equals(Object o){
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CostList costList = (CostList) o;
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
