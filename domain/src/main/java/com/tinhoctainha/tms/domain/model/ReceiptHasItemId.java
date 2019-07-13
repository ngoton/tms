package com.tinhoctainha.tms.domain.model;

import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class ReceiptHasItemId implements Serializable {
    private Receipt receipt;
    private Item item;

    public ReceiptHasItemId(){}
    public ReceiptHasItemId(Receipt receipt, Item item){
        this.receipt = receipt;
        this.item = item;
    }

    public Long getReceipt() {
        return receipt.getId();
    }

    public void setReceipt(Receipt receipt) {
        this.receipt = receipt;
    }

    public Long getItem() {
        return item.getId();
    }

    public void setItem(Item item) {
        this.item = item;
    }

    @Override
    public boolean equals(Object o){
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ReceiptHasItemId that = (ReceiptHasItemId) o;
        return (Objects.equals(receipt, that.receipt) && Objects.equals(item, that.item));
    }

    @Override
    public int hashCode(){
        return Objects.hash(receipt, item);
    }
}
