package com.tinhoctainha.tms.domain.model;

import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class IssueHasItemId implements Serializable {
    private Issue issue;
    private Item item;

    public IssueHasItemId(){}
    public IssueHasItemId(Issue issue, Item item){
        this.issue = issue;
        this.item = item;
    }

    public Long getIssue() {
        return issue.getId();
    }

    public void setIssue(Issue issue) {
        this.issue = issue;
    }

    public Long getItem() {
        return item.getId();
    }

    public void setItem(Item item) {
        this.item = item;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        IssueHasItemId that = (IssueHasItemId) o;
        return Objects.equals(issue, that.issue) && Objects.equals(item, that.item);
    }

    @Override
    public int hashCode() {
        return Objects.hash(issue, item);
    }
}
