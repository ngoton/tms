package com.tinhoctainha.tms.domain.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "ledger_detail")
public class LedgerDetail extends IncrementIDBaseEntity {
    @MapsId
    @OneToOne
    @JoinColumn(name = "ledger_id", referencedColumnName = "id", nullable = false)
    private Ledger ledger;

    @ManyToOne
    @JoinColumn(name = "invoice_id", referencedColumnName = "id")
    private Invoice invoice;

    @ManyToOne
    @JoinColumn(name = "cost_id", referencedColumnName = "id")
    private Cost cost;

    @ManyToOne
    @JoinColumn(name = "waybill_id", referencedColumnName = "id")
    private Waybill waybill;

    @ManyToOne
    @JoinColumn(name = "fee_id", referencedColumnName = "id")
    private Fee fee;

    @ManyToOne
    @JoinColumn(name = "balance_id", referencedColumnName = "id")
    private Balance balance;

    @ManyToOne
    @JoinColumn(name = "receipt_id", referencedColumnName = "id")
    private Receipt receipt;

    @ManyToOne
    @JoinColumn(name = "issue_id", referencedColumnName = "id")
    private Issue issue;

    public Ledger getLedger() {
        return ledger;
    }

    public void setLedger(Ledger ledger) {
        this.ledger = ledger;
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

    public Waybill getWaybill() {
        return waybill;
    }

    public void setWaybill(Waybill waybill) {
        this.waybill = waybill;
    }

    public Fee getFee() {
        return fee;
    }

    public void setFee(Fee fee) {
        this.fee = fee;
    }

    public Balance getBalance() {
        return balance;
    }

    public void setBalance(Balance balance) {
        this.balance = balance;
    }

    public Receipt getReceipt() {
        return receipt;
    }

    public void setReceipt(Receipt receipt) {
        this.receipt = receipt;
    }

    public Issue getIssue() {
        return issue;
    }

    public void setIssue(Issue issue) {
        this.issue = issue;
    }

    @Override
    public boolean equals(Object o){
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LedgerDetail ledgerDetail = (LedgerDetail) o;
        return (Objects.equals(ledger, ledgerDetail.ledger));
    }

    @Override
    public int hashCode(){
        return Objects.hash(ledger);
    }
}
