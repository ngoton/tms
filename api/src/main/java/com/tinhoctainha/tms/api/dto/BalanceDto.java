package com.tinhoctainha.tms.api.dto;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.tinhoctainha.tms.api.util.CustomDateDeserializer;
import com.tinhoctainha.tms.api.util.CustomDateSerializer;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Objects;

public class BalanceDto implements Serializable {
    private Long id;
    private Date balanceDate;
    private Double amount;
    private Float exchangeRate;
    private Double total;
    private String currency;
    private String description;
    private DebitDto debit;
    private TransferDto transfer;
    private List<LedgerDetailDto> ledgerDetails;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @JsonSerialize(using = CustomDateSerializer.class)
    public Date getBalanceDate() {
        return balanceDate;
    }

    @JsonDeserialize(using = CustomDateDeserializer.class)
    public void setBalanceDate(Date balanceDate) {
        this.balanceDate = balanceDate;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public Float getExchangeRate() {
        return exchangeRate;
    }

    public void setExchangeRate(Float exchangeRate) {
        this.exchangeRate = exchangeRate;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public DebitDto getDebit() {
        return debit;
    }

    public void setDebit(DebitDto debit) {
        this.debit = debit;
    }

    public TransferDto getTransfer() {
        return transfer;
    }

    public void setTransfer(TransferDto transfer) {
        this.transfer = transfer;
    }

    public List<LedgerDetailDto> getLedgerDetails() {
        return ledgerDetails;
    }

    public void setLedgerDetails(List<LedgerDetailDto> ledgerDetails) {
        this.ledgerDetails = ledgerDetails;
    }

    @Override
    public boolean equals(Object o){
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BalanceDto balance = (BalanceDto) o;
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
