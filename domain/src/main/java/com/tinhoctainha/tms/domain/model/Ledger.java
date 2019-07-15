package com.tinhoctainha.tms.domain.model;

import javax.persistence.*;
import java.util.Date;
import java.util.Objects;

@Entity
public class Ledger extends IncrementIDBaseEntity {
    private Date ledgerDate;
    private Double money;
    private String description;
    private String documentNumber;
    private Date documentDate;

    @OneToOne(mappedBy = "ledger", cascade = CascadeType.ALL)
    private LedgerDetail ledgerDetail;

    @ManyToOne
    @JoinColumn(name = "debit", referencedColumnName = "id", nullable = false)
    private Account debit;

    @ManyToOne
    @JoinColumn(name = "credit", referencedColumnName = "id", nullable = false)
    private Account credit;

    @Basic
    @Temporal(TemporalType.DATE)
    @Column(name = "ledger_date")
    public Date getLedgerDate() {
        return ledgerDate;
    }

    public void setLedgerDate(Date ledgerDate) {
        this.ledgerDate = ledgerDate;
    }

    @Basic
    @Column(name = "money", precision = 14, scale = 2)
    public Double getMoney() {
        return money;
    }

    public void setMoney(Double money) {
        this.money = money;
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
    @Column(name = "document_number")
    public String getDocumentNumber() {
        return documentNumber;
    }

    public void setDocumentNumber(String documentNumber) {
        this.documentNumber = documentNumber;
    }

    @Basic
    @Temporal(TemporalType.DATE)
    @Column(name = "document_date")
    public Date getDocumentDate() {
        return documentDate;
    }

    public void setDocumentDate(Date documentDate) {
        this.documentDate = documentDate;
    }

    public LedgerDetail getLedgerDetail() {
        return ledgerDetail;
    }

    public void setLedgerDetail(LedgerDetail ledgerDetail) {
        this.ledgerDetail = ledgerDetail;
    }

    public Account getDebit() {
        return debit;
    }

    public void setDebit(Account debit) {
        this.debit = debit;
    }

    public Account getCredit() {
        return credit;
    }

    public void setCredit(Account credit) {
        this.credit = credit;
    }

    @Override
    public boolean equals(Object o){
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ledger ledger = (Ledger) o;
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
