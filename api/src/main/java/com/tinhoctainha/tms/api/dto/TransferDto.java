package com.tinhoctainha.tms.api.dto;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.tinhoctainha.tms.api.util.CustomDateDeserializer;
import com.tinhoctainha.tms.api.util.CustomDateSerializer;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Objects;

public class TransferDto implements Serializable {
    private Long id;
    private Date transferDate;
    private String transferNumber;
    private String description;
    private Double amount;
    private Float exchangeRate;
    private Double total;
    private String currency;
    private Integer transferType;
    private BankDto bank;
    private List<BalanceDto> balances;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @JsonSerialize(using = CustomDateSerializer.class)
    public Date getTransferDate() {
        return transferDate;
    }

    @JsonDeserialize(using = CustomDateDeserializer.class)
    public void setTransferDate(Date transferDate) {
        this.transferDate = transferDate;
    }

    public String getTransferNumber() {
        return transferNumber;
    }

    public void setTransferNumber(String transferNumber) {
        this.transferNumber = transferNumber;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
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

    public Integer getTransferType() {
        return transferType;
    }

    public void setTransferType(Integer transferType) {
        this.transferType = transferType;
    }

    public BankDto getBank() {
        return bank;
    }

    public void setBank(BankDto bank) {
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
        TransferDto transfer = (TransferDto) o;
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
