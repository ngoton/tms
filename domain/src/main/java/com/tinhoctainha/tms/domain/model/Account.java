package com.tinhoctainha.tms.domain.model;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import java.util.Objects;

@Entity
public class Account extends IncrementIDBaseEntity {
    private String name;
    private String description;
    private Integer parent;

    @Basic
    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
    @Column(name = "parent")
    public Integer getParent() {
        return parent;
    }

    public void setParent(Integer parent) {
        this.parent = parent;
    }

    @Override
    public boolean equals(Object o){
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Account account = (Account) o;
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
