package com.tinhoctainha.tms.api.dto;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.tinhoctainha.tms.api.util.CustomDateDeserializer;
import com.tinhoctainha.tms.api.util.CustomDateSerializer;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

public class LedgerDto implements Serializable {
    private Long id;
    private Date ledgerDate;
    private Double money;
    private String description;
    private String documentNumber;
    private Date documentDate;
    private LedgerDetailDto ledgerDetail;
    private AccountDto debit;
    private AccountDto credit;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @JsonSerialize(using = CustomDateSerializer.class)
    public Date getLedgerDate() {
        return ledgerDate;
    }

    @JsonDeserialize(using = CustomDateDeserializer.class)
    public void setLedgerDate(Date ledgerDate) {
        this.ledgerDate = ledgerDate;
    }

    public Double getMoney() {
        return money;
    }

    public void setMoney(Double money) {
        this.money = money;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDocumentNumber() {
        return documentNumber;
    }

    public void setDocumentNumber(String documentNumber) {
        this.documentNumber = documentNumber;
    }

    @JsonSerialize(using = CustomDateSerializer.class)
    public Date getDocumentDate() {
        return documentDate;
    }

    @JsonDeserialize(using = CustomDateDeserializer.class)
    public void setDocumentDate(Date documentDate) {
        this.documentDate = documentDate;
    }

    public LedgerDetailDto getLedgerDetail() {
        return ledgerDetail;
    }

    public void setLedgerDetail(LedgerDetailDto ledgerDetail) {
        this.ledgerDetail = ledgerDetail;
    }

    public AccountDto getDebit() {
        return debit;
    }

    public void setDebit(AccountDto debit) {
        this.debit = debit;
    }

    public AccountDto getCredit() {
        return credit;
    }

    public void setCredit(AccountDto credit) {
        this.credit = credit;
    }

    @Override
    public boolean equals(Object o){
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LedgerDto ledger = (LedgerDto) o;
        return (getId() == ledger.getId() &&
                Objects.equals(ledgerDate, ledger.ledgerDate) &&
                Objects.equals(money, ledger.money) &&
                Objects.equals(description, ledger.description) &&
                Objects.equals(documentNumber, ledger.documentNumber) &&
                Objects.equals(documentDate, ledger.documentDate) &&
                Objects.equals(debit, ledger.debit) &&
                Objects.equals(credit, ledger.credit));
    }

    @Override
    public int hashCode(){
        return Objects.hash(getId(), ledgerDate, money, description, documentNumber, documentDate, debit, credit);
    }

}
