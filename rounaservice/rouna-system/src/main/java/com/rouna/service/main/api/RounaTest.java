package com.rouna.service.main.api;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.Date;

/**
 * Created by Administrator on 2017/12/14.
 */
@ApiModel(value = "RounaTest",description = "考试信息")
public class RounaTest {
    @ApiModelProperty(name = "name",required = true,example = "11月考试")
    private String name;
    @ApiModelProperty(name = "startTime",required = true)
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
