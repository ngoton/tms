package com.tinhoctainha.tms.api.dto;

import javax.persistence.Embeddable;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

@Embeddable
public class RouteId implements Serializable {
    private Place start;
    private Place finish;

    @Temporal(TemporalType.DATE)
    private Date startDate;

    public RouteId(){}
    public RouteId(Place start, Place finish, Date startDate){
        this.start = start;
        this.finish = finish;
        this.startDate = startDate;
    }

    public Long getStart() {
        return start.getId();
    }

    public void setStart(Place start) {
        this.start = start;
    }

    public Long getFinish() {
        return finish.getId();
    }

    public void setFinish(Place finish) {
        this.finish = finish;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    @Override
    public boolean equals(Object o){
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RouteId that = (RouteId) o;
        return (Objects.equals(start, that.start) && Objects.equals(finish, that.finish) && Objects.equals(startDate, that.startDate));
    }

    @Override
    public int hashCode(){
        return Objects.hash(start, finish, startDate);
    }
}
