package com.tinhoctainha.tms.domain.model;

import javax.persistence.*;
import java.util.Date;
import java.util.List;
import java.util.Objects;

@Entity
public class Balance extends IncrementIDBaseEntity {
    private Date balanceDate;
    private Double amount;
    private Float exchangeRate;
    private Double total;
    private String currency;
    private String description;

    @ManyToOne
    @JoinColumn(name = "debit_id", referencedColumnName = "id")
    private Debit debit;

    @ManyToOne
    @JoinColumn(name = "transfer_id", referencedColumnName = "id", nullable = false)
    private Transfer transfer;

    @OneToMany(mappedBy = "balance")
    private List<LedgerDetail> ledgerDetails;

    @Basic
    @Temporal(TemporalType.DATE)
    @Column(name = "balance_date")
    public Date getBalanceDate() {
        return balanceDate;
    }

    public void setBalanceDate(Date balanceDate) {
        this.balanceDate = balanceDate;
    }

    @Basic
    @Column(name = "amount", precision = 12, scale = 2)
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
    @Column(name = "total", precision = 12, scale = 2)
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
    @Column(name = "description")
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Debit getDebit() {
        return debit;
    }

    public void setDebit(Debit debit) {
        this.debit = debit;
    }

    public Transfer getTransfer() {
        return transfer;
    }

    public void setTransfer(Transfer transfer) {
        this.transfer = transfer;
    }

    public List<LedgerDetail> getLedgerDetails() {
        return ledgerDetails;
    }

    public void setLedgerDetails(List<LedgerDetail> ledgerDetails) {
        this.ledgerDetails = ledgerDetails;
    }

    @Override
    public boolean equals(Object o){
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Balance balance = (Balance) o;
        return (getId() == balance.getId() &&
                Objects.equals(balanceDate, balance.balanceDate) &&
                Objects.equals(amount, balance.amount) &&
                Objects.equals(exchangeRate, balance.exchangeRate) &&
                Objects.equals(total, balance.total) &&
                Objects.equals(currency, balance.currency) &&
                Objects.equals(description, balance.description));
    }

    @Override
    public int hashCode(){
        return Objects.hash(getId(), balanceDate, amount, exchangeRate, total, currency, description);
    }
}
