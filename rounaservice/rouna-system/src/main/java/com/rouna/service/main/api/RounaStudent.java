package com.rouna.service.main.api;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * Created by Administrator on 2017/12/15.
 */
@ApiModel(value = "RounaStudent",description = "学生信息")
public class RounaStudent {
    @ApiModelProperty(name = "name",notes = "姓名",required = true,example = "张三")
    private String name;
    @ApiModelProperty(name = "classId",notes = "班级",required = true,example = "e19d5bb955ed4155b932eb135cfcbe97")
    private String classId;
    @ApiModelProperty(name = "no",notes = "学号",required = true,example = "100")
    private String no;
    @ApiModelProperty(name = "identityNo",notes = "身份证号",required = false,example = "513000000000000000")
    private String identityNo;
    @ApiModelProperty(name = "sex",notes = "性别(1:男，2：女)",required = true,example = "1")
    private String sex;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getClassId() {
        return classId;
    }

    public void setClassId(String classId) {
        this.classId = classId;
    }

    public String getNo() {
        return no;
    }

    public void setNo(String no) {
        this.no = no;
    }

    public String getIdentityNo() {
        return identityNo;
    }

    public void setIdentityNo(String identityNo) {
        this.identityNo = identityNo;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }
}
