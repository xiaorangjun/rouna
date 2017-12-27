package com.rouna.service.main.utils.http;

import java.util.HashMap;
import java.util.Map;


public class HttpResponseVO {
    private String statusCode;
    private String responseBody;
    private String desc;
    private Map<String, String> responseHeader;
    private Map<String, String> result = new HashMap();

    public HttpResponseVO() {
    }

    public Map<String, String> getResult() {
        return this.result;
    }

    public void setResult(Map<String, String> result) {
        this.result = result;
    }

    public String getStatusCode() {
        return this.statusCode;
    }

    public void setStatusCode(String statusCode) {
        this.statusCode = statusCode;
    }

    public String getResponseBody() {
        return this.responseBody;
    }

    public void setResponseBody(String responseBody) {
        this.responseBody = responseBody;
    }

    public void setResponseHeader(Map<String, String> responseHeader) {
        this.responseHeader = responseHeader;
    }

    public Map<String, String> getResponseHeader() {
        return this.responseHeader;
    }

    public String getDesc() {
        return this.desc;
    }

    public void setDesc(String descs) {
        this.desc = descs;
    }
}
