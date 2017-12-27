package com.rouna.service.main.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * Created by Administrator on 2017/12/10.
 */
@ApiModel(description = "班级对象")
public class RounaClass extends DataEntity<RounaClass> {
    @ApiModelProperty(value = "名称",name = "name",example = "一班")
    private String name;
    @ApiModelProperty(value = "年级",name = "gradeId",example = "年级")
    private String gradeId;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGradeId() {
        return gradeId;
    }

    public void setGradeId(String gradeId) {
        this.gradeId = gradeId;
    }
}
