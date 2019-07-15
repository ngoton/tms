package com.tinhoctainha.tms.domain.model;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.Objects;

@Entity
public class Bank extends IncrementIDBaseEntity {
    private String name;
    private String bankAccount;
    private String bankName;
    private String bankBranch;
    private Double openingBalance;

    @OneToMany(mappedBy = "bank")
    private List<Transfer> transfers;

    @Basic
    @NotNull
    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "bank_account")
    public String getBankAccount() {
        return bankAccount;
    }

    public void setBankAccount(String bankAccount) {
        this.bankAccount = bankAccount;
    }

    @Basic
    @Column(name = "bank_name")
    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    @Basic
    @Column(name = "bank_branch")
    public String getBankBranch() {
        return bankBranch;
    }

    public void setBankBranch(String bankBranch) {
        this.bankBranch = bankBranch;
    }

    @Basic
    @Column(name = "opening_balance", precision = 14, scale = 2)
    public Double getOpeningBalance() {
        return openingBalance;
    }

    public void setOpeningBalance(Double openingBalance) {
        this.openingBalance = openingBalance;
    }

    public List<Transfer> getTransfers() {
        return transfers;
    }

    public void setTransfers(List<Transfer> transfers) {
        this.transfers = transfers;
    }
    @Override
    public boolean equals(Object o){
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Bank bank = (Bank) o;
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
