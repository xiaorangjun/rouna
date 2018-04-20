package com.rouna.service.main.api;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModelProperty;

@Api
public class Response<T> {

    @ApiModelProperty(value = "返回码 默认0 401 信息错误 404 不存在 405 已存在 500 系统错误")
    private String code;
    @ApiModelProperty(value ="返回消息")
    private String message;
    @ApiModelProperty(value = "返回结果")
    private T result;

    public Response(T result) {
        this.code = "200";
        this.result = result;
    }

    public Response() {
        this.code = "200";
        this.message = "success";
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getResult() {
        return result;
    }

    public void setResult(T result) {
        this.result = result;
    }
}
