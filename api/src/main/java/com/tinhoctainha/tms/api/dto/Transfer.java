package com.tinhoctainha.tms.api.dto;

import javax.persistence.*;
import java.util.Date;
import java.util.List;
import java.util.Objects;

@Entity
public class Transfer extends IncrementIDBaseEntity {
    private Date transferDate;
    private String transferNumber;
    private String description;
    private Double amount;
    private Float exchangeRate;
    private Double total;
    private String currency;
    private Integer transferType;

    @ManyToOne
    @JoinColumn(name = "bank_id", referencedColumnName = "id", nullable = false)
    private Bank bank;

    @OneToMany(mappedBy = "transfer")
    private List<BalanceDto> balances;

    @Basic
    @Temporal(TemporalType.DATE)
    @Column(name = "transfer_date")
    public Date getTransferDate() {
        return transferDate;
    }

    public void setTransferDate(Date transferDate) {
        this.transferDate = transferDate;
    }

    @Basic
    @Column(name = "transfer_number")
    public String getTransferNumber() {
        return transferNumber;
    }

    public void setTransferNumber(String transferNumber) {
        this.transferNumber = transferNumber;
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
    @Column(name = "amount", precision = 14, scale = 2)
    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    @Basic
    @Column(name = "exchange_rate")
    public Float getExchangeRate() {
        return exchangeRate;
    }

    public void setExchangeRate(Float exchangeRate) {
        this.exchangeRate = exchangeRate;
    }

    @Basic
    @Column(name = "total", precision = 14, scale = 2)
    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    @Basic
    @Column(name = "currency")
    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    @Basic
    @Column(name = "transfer_type")
    public Integer getTransferType() {
        return transferType;
    }

    public void setTransferType(Integer transferType) {
        this.transferType = transferType;
    }

    public Bank getBank() {
        return bank;
    }

    public void setBank(Bank bank) {
        this.bank = bank;
    }

    public List<BalanceDto> getBalances() {
        return balances;
    }

    public void setBalances(List<BalanceDto> balances) {
        this.balances = balances;
    }

    @Override
    public boolean equals(Object o){
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Transfer transfer = (Transfer) o;
        return (getId() == transfer.getId() &&
                Objects.equals(transferDate, transfer.transferDate) &&
                Objects.equals(transferNumber, transfer.transferNumber) &&
                Objects.equals(description, transfer.description) &&
                Objects.equals(amount, transfer.amount) &&
                Objects.equals(exchangeRate, transfer.exchangeRate) &&
                Objects.equals(total, transfer.total) &&
                Objects.equals(currency, transfer.currency) &&
                Objects.equals(transferType, transfer.transferType));
    }

    @Override
    public int hashCode(){
        return Objects.hash(getId(), transferDate, transferNumber, description, amount, exchangeRate, total, currency, transferType);
    }
}
