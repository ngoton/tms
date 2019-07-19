package com.tinhoctainha.tms.api.dto;

import java.io.Serializable;
import java.util.Objects;

public class LedgerDetailDto implements Serializable {
    private LedgerDto ledger;
    private InvoiceDto invoice;
    private CostDto cost;
    private WaybillDto waybill;
    private FeeDto fee;
    private BalanceDto balance;
    private ReceiptDto receipt;
    private IssueDto issue;

    public LedgerDto getLedger() {
        return ledger;
    }

    public void setLedger(LedgerDto ledger) {
        this.ledger = ledger;
    }

    public InvoiceDto getInvoice() {
        return invoice;
    }

    public void setInvoice(InvoiceDto invoice) {
        this.invoice = invoice;
    }

    public CostDto getCost() {
        return cost;
    }

    public void setCost(CostDto cost) {
        this.cost = cost;
    }

    public WaybillDto getWaybill() {
        return waybill;
    }

    public void setWaybill(WaybillDto waybill) {
        this.waybill = waybill;
    }

    public FeeDto getFee() {
        return fee;
    }

    public void setFee(FeeDto fee) {
        this.fee = fee;
    }

    public BalanceDto getBalance() {
        return balance;
    }

    public void setBalance(BalanceDto balance) {
        this.balance = balance;
    }

    public ReceiptDto getReceipt() {
        return receipt;
    }

    public void setReceipt(ReceiptDto receipt) {
        this.receipt = receipt;
    }

    public IssueDto getIssue() {
        return issue;
    }

    public void setIssue(IssueDto issue) {
        this.issue = issue;
    }

    @Override
    public boolean equals(Object o){
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LedgerDetailDto ledgerDetail = (LedgerDetailDto) o;
        return (Objects.equals(ledger, ledgerDetail.ledger));
    }

    @Override
    public int hashCode(){
        return Objects.hash(ledger);
    }
}
