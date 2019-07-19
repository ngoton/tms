package com.tinhoctainha.tms.api.dto;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;

public class BankDto implements Serializable {
    private Long id;
    private String name;
    private String bankAccount;
    private String bankName;
    private String bankBranch;
    private Double openingBalance;
    private List<TransferDto> transfers;

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

    public String getBankAccount() {
        return bankAccount;
    }

    public void setBankAccount(String bankAccount) {
        this.bankAccount = bankAccount;
    }

    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    public String getBankBranch() {
        return bankBranch;
    }

    public void setBankBranch(String bankBranch) {
        this.bankBranch = bankBranch;
    }

    public Double getOpeningBalance() {
        return openingBalance;
    }

    public void setOpeningBalance(Double openingBalance) {
        this.openingBalance = openingBalance;
    }

    public List<TransferDto> getTransfers() {
        return transfers;
    }

    public void setTransfers(List<TransferDto> transfers) {
        this.transfers = transfers;
    }
    @Override
    public boolean equals(Object o){
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BankDto bank = (BankDto) o;
        return (getId() == bank.getId() &&
                Objects.equals(name, bank.name) &&
                Objects.equals(bankAccount, bank.bankAccount) &&
                Objects.equals(bankName, bank.bankName) &&
                Objects.equals(bankBranch, bank.bankBranch) &&
                Objects.equals(openingBalance, bank.openingBalance));
    }

    @Override
    public int hashCode(){
        return Objects.hash(getId(), name, bankAccount, bankName, bankBranch, openingBalance);
    }

}
