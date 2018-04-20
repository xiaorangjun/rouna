package com.rouna.service.main.api;

import com.rouna.service.main.model.DataEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel("用户信息")
public class RounaUserInfo extends DataEntity<RounaUserInfo> {
    @ApiModelProperty("登录账号")
    private String loginid;
    @ApiModelProperty("用户名称")
    private String name;
    @ApiModelProperty("用户类型")
    private String type;
    @ApiModelProperty("用户角色")
    private String role;
    @ApiModelProperty("用户状态")
    private String state;

    public String getLoginid() {
        return loginid;
    }

    public void setLoginid(String loginid) {
        this.loginid = loginid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }
}
