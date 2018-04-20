package com.rouna.service.main.api;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel
public class RounaUserResetPwd {
    @ApiModelProperty("旧密码")
    private String oldpwd;
    @ApiModelProperty("新密码")
    private String newpwd;
    @ApiModelProperty("确认密码")
    private String newpwdconfirm;


    public String getOldpwd() {
        return oldpwd;
    }

    public void setOldpwd(String oldpwd) {
        this.oldpwd = oldpwd;
    }

    public String getNewpwd() {
        return newpwd;
    }

    public void setNewpwd(String newpwd) {
        this.newpwd = newpwd;
    }

    public String getNewpwdconfirm() {
        return newpwdconfirm;
    }

    public void setNewpwdconfirm(String newpwdconfirm) {
        this.newpwdconfirm = newpwdconfirm;
    }
}
