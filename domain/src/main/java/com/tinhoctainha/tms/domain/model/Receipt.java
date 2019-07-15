package com.tinhoctainha.tms.domain.model;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
public class Receipt extends IncrementIDBaseEntity {
    private Date receiptDate;
    private String receiptNumber;
    private String description;
    private Float quantity;
    private Double total;

    @ManyToOne
    @JoinColumn(name = "order_id", referencedColumnName = "id")
    private Order order;

    @OneToMany(mappedBy = "receipt")
    private List<ReceiptHasItem> receiptHasItems;

    @OneToMany(mappedBy = "receipt")
    private List<LedgerDetail> ledgerDetails;
}
