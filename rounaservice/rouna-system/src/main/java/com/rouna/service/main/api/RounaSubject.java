package com.rouna.service.main.api;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * Created by Administrator on 2017/12/15.
 */
@ApiModel(value = "RounaSubject",description = "考试信息")
public class RounaSubject {
    @ApiModelProperty(name = "name",required = true,example = "语文")
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
