package com.tinhoctainha.tms.api.dto;

import java.io.Serializable;
import java.util.*;

public class RoleDto implements Serializable {
    private Long id;
    private String name;
    private List<UserDto> users;
    private List<PermissionDto> permissions = new ArrayList<>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<UserDto> getUsers() {
        return users;
    }

    public void setUsers(List<UserDto> users) {
        this.users = users;
    }

    public List<PermissionDto> getPermissions() {
        return permissions;
    }

    public void setPermissions(List<PermissionDto> permissions) {
        this.permissions = permissions;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RoleDto role = (RoleDto) o;
        return getId() == role.getId() && Objects.equals(name, role.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), name);
    }

}
