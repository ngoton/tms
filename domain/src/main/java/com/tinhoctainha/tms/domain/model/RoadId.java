package com.tinhoctainha.tms.domain.model;

import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class RoadId implements Serializable {
    private Place start;
    private Place finish;

    public RoadId(){}
    public RoadId(Place start, Place finish){
        this.start = start;
        this.finish = finish;
    }

    public Place getStart() {
        return start;
    }

    public void setStart(Place start) {
        this.start = start;
    }

    public Place getFinish() {
        return finish;
    }

    public void setFinish(Place finish) {
        this.finish = finish;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RoadId that = (RoadId) o;
        return Objects.equals(start, that.start) && Objects.equals(finish, that.finish);
    }

    @Override
    public int hashCode() {
        return Objects.hash(start, finish);
    }
}
