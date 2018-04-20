package com.rouna.service.main.api;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.rouna.service.main.model.DataEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel
public class RounaUser extends DataEntity<RounaUser> {
    @ApiModelProperty(value = "登陆账号")
    private String loginId;
    @ApiModelProperty(value = "登录密码")
    private String passWd;
    @ApiModelProperty(value = "当前状态 0 锁定 1 可用",hidden = true)
    private String state;
    @ApiModelProperty(value = "在线状态 0 离线 1 在线0",hidden = true)
    private String online;

    public String getLoginId() {
        return loginId;
    }

    public void setLoginId(String loginId) {
        this.loginId = loginId;
    }

    public String getPassWd() {
        return passWd;
    }

    public void setPassWd(String passWd) {
        this.passWd = passWd;
    }
    @JsonIgnore
    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }
    @JsonIgnore
    public String getOnline() {
        return online;
    }

    public void setOnline(String online) {
        this.online = online;
    }
}
