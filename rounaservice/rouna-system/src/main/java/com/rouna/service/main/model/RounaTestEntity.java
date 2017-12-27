package com.rouna.service.main.model;

import java.util.Date;

/**
 * Created by Administrator on 2017/12/14.
 */
public class RounaTestEntity extends DataEntity<RounaTestEntity> {
    private String name;

    private Date startTime;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }
}
