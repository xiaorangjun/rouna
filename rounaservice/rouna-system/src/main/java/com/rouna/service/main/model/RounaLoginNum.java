package com.rouna.service.main.model;

public class RounaLoginNum  extends DataEntity<RounaLoginNum>{
    private String loginId;
    private Integer num;

    public String getLoginId() {
        return loginId;
    }

    public void setLoginId(String loginId) {
        this.loginId = loginId;
    }

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }
}
