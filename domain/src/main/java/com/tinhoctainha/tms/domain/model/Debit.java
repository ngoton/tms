package com.tinhoctainha.tms.domain.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.Objects;

@Entity
public class Debit extends IncrementIDBaseEntity {
    private Date debitDate;
    private Long total;
    private String description;
    private Integer debitType;

    @OneToOne
    @JoinColumn(name = "invoice_id", referencedColumnName = "id")
    private Invoice invoice;

    @OneToOne
    @JoinColumn(name = "cost_id", referencedColumnName = "id")
    private Cost cost;

    @OneToOne
    @JoinColumn(name = "cost_list_id", referencedColumnName = "id")
    private CostList costList;

    @OneToOne
    @JoinColumn(name = "fee_id", referencedColumnName = "id")
    private Fee fee;

    @OneToOne
    @JoinColumn(name = "order_id", referencedColumnName = "id")
    private Order order;

    @Basic
    @NotNull
    @Temporal(TemporalType.DATE)
    @Column(name = "debit_date")
    public Date getDebitDate() {
        return debitDate;
    }

    public void setDebitDate(Date debitDate) {
        this.debitDate = debitDate;
    }

    @Basic
    @Column(name = "total", precision = 14, scale = 2)
    public Long getTotal() {
        return total;
    }

    public void setTotal(Long total) {
        this.total = total;
    }

    @Basic
    @Column(name = "description")
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Basic
    @Column(name = "debit_type")
    public Integer getDebitType() {
        return debitType;
    }

    public void setDebitType(Integer debitType) {
        this.debitType = debitType;
    }

    public Invoice getInvoice() {
        return invoice;
    }

    public void setInvoice(Invoice invoice) {
        this.invoice = invoice;
    }

    public Cost getCost() {
        return cost;
    }

    public void setCost(Cost cost) {
        this.cost = cost;
    }

    public CostList getCostList() {
        return costList;
    }

    public void setCostList(CostList costList) {
        this.costList = costList;
    }

    public Fee getFee() {
        return fee;
    }

    public void setFee(Fee fee) {
        this.fee = fee;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    @Override
    public boolean equals(Object o){
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Debit debit = (Debit) o;
        return (getId() == debit.getId() &&
                Objects.equals(debitDate, debit.debitDate) &&
                Objects.equals(total, debit.total) &&
                Objects.equals(description, debit.description) &&
                Objects.equals(debitType, debit.debitType));
    }

    @Override
    public int hashCode(){
        return Objects.hash(getId(), debitDate, total, description, debitType);
    }
}
