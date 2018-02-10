package com.per.repository.entity;

import javax.persistence.*;
import java.util.Date;

@MappedSuperclass
public abstract class BaseEntity {

    private Date createDate;

    @PrePersist
    protected void baseEntityPrePersist() {
        if (createDate == null) {
            createDate = new Date();
        }
    }


    @Column(name = "CREATE_DATE", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }
}
