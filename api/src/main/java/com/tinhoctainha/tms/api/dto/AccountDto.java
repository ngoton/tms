package com.tinhoctainha.tms.api.dto;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;

public class AccountDto implements Serializable {
    private Long id;
    private String name;
    private String description;
    private Integer parent;
    private List<LedgerDto> debitLedgers;
    private List<LedgerDto> creditLedgers;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getParent() {
        return parent;
    }

    public void setParent(Integer parent) {
        this.parent = parent;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<LedgerDto> getDebitLedgers() {
        return debitLedgers;
    }

    public void setDebitLedgers(List<LedgerDto> debitLedgers) {
        this.debitLedgers = debitLedgers;
    }

    public List<LedgerDto> getCreditLedgers() {
        return creditLedgers;
    }

    public void setCreditLedgers(List<LedgerDto> creditLedgers) {
        this.creditLedgers = creditLedgers;
    }

    @Override
    public boolean equals(Object o){
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AccountDto account = (AccountDto) o;
        return (getId() == account.getId() &&
                Objects.equals(name, account.name) &&
                Objects.equals(description, account.description) &&
                Objects.equals(parent, account.parent));
    }

    @Override
    public int hashCode(){
        return Objects.hash(getId(), name, description, parent);
    }
}
