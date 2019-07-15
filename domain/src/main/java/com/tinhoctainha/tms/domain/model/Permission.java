package com.tinhoctainha.tms.domain.model;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import java.util.Objects;
import java.util.Set;

@Entity
public class Permission extends IncrementIDBaseEntity {
    private String name;

    @ManyToMany(mappedBy = "permission")
    private Set<User> users;

    @ManyToMany(mappedBy = "permission")
    private Set<Role> roles;

    @Basic
    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<User> getUsers() {
        return users;
    }

    public void setUsers(Set<User> users) {
        this.users = users;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Permission permission = (Permission) o;
        return getId() == permission.getId() && Objects.equals(name, permission.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), name);
    }
}
