package com.tinhoctainha.tms.domain.model;

import javax.persistence.*;
import java.util.Date;
import java.util.Objects;

@Entity
public class Action extends IncrementIDBaseEntity {
    private String act;
    private String data;
    private Date time;

    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id", nullable = false)
    private User user;

    @Basic
    @Column(name = "act")
    public String getAct() {
        return act;
    }

    public void setAct(String act) {
        this.act = act;
    }

    @Basic
    @Column(name = "data")
    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    @Basic
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "time")
    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public boolean equals(Object o){
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Action action = (Action) o;
        return (getId() == action.getId() &&
                Objects.equals(act, action.act) &&
                Objects.equals(data, action.data) &&
                Objects.equals(time, action.time));
    }

    @Override
    public int hashCode(){
        return Objects.hash(getId(), act, data, time);
    }
}
