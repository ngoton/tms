package com.tinhoctainha.tms.api.dto;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.*;

@Entity
public class User extends IncrementIDBaseEntity implements UserDetails {
    @NotNull
    @Basic
    @Column(name = "username")
    private String username;

    @NotNull
    @Basic
    @Column(name = "password")
    private String password;

    @Basic
    @Column(name = "enabled")
    private Boolean enabled;

    @OneToOne
    @JoinColumn(name = "staff_id", referencedColumnName = "id")
    private Staff staff;

    @OneToMany(mappedBy = "user")
    private List<ActionDto> actions;

    @ManyToMany
    @JoinTable(name = "user_has_role",
            joinColumns = {@JoinColumn(name = "user_id")},
            inverseJoinColumns = {@JoinColumn(name = "role_id")}
    )
    private Set<Role> roles = new HashSet<>();

    @ManyToMany
    @JoinTable(name = "user_has_permission",
            joinColumns = {@JoinColumn(name = "user_id")},
            inverseJoinColumns = {@JoinColumn(name = "permission_id")}
    )
    private Set<Permission> permissions;

    @Transient
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        List<SimpleGrantedAuthority> authorities = new ArrayList<>();
        for(Role userRoles : roles){
            authorities.add(new SimpleGrantedAuthority(userRoles.getName()));
        }
        return authorities;
    }

    @Override
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setEnabled(Boolean enabled) {
        this.enabled = enabled;
    }

    @Transient
    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Transient
    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Transient
    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Transient
    @Override
    public boolean isEnabled() {
        return true;
    }

    public Staff getStaff() {
        return staff;
    }

    public void setStaff(Staff staff) {
        this.staff = staff;
    }

    public List<ActionDto> getActions() {
        return actions;
    }

    public void setActions(List<ActionDto> actions) {
        this.actions = actions;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }

    public void addRoles(Role role){
        this.roles.add(role);
    }

    public Set<Permission> getPermissions() {
        return permissions;
    }

    public void setPermissions(Set<Permission> permissions) {
        this.permissions = permissions;
    }

    public void addPermissions(Permission permission){
        this.permissions.add(permission);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return (getId() == user.getId() &&
                Objects.equals(username, user.username) &&
                Objects.equals(password, user.password) &&
                Objects.equals(enabled, user.enabled));
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), username, password, enabled);
    }
}
