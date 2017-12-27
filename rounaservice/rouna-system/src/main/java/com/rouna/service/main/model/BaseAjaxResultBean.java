package com.rouna.service.main.model;

/**
 *
 * @version 1
 * @Company: 上海光华冠群软件有限公司
 * @PROJECT_NAME easyview-im-master
 * @Package com.ghca.easyview.im.core.entity
 * @date 2016/07/04 13:01
 * @Description ajax返回对象
 */
public class BaseAjaxResultBean {

    private String status = "200";
    private String message = "common.message.option.success";
    public BaseAjaxResultBean(){}
    public BaseAjaxResultBean(String status, String message) {
        this.status = status;
        this.message = message;
    }

    public BaseAjaxResultBean(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
