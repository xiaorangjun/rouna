package com.rouna.service.main.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.rouna.service.main.utils.IdGen;
import io.swagger.annotations.ApiModelProperty;
import org.hibernate.validator.constraints.Length;

import java.util.Date;


/**
 * Description  数据Entity类
 */
public abstract class DataEntity<T> extends BaseEntity<T> {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(hidden = true)
    protected String remarks;	// 备注
    @ApiModelProperty(hidden = true)
    protected String createBy;	// 创建者
    @ApiModelProperty(hidden = true)
    protected String createUser;// 登录名
    @ApiModelProperty(hidden = true)
    protected Date createDate;	// 创建日期
    @ApiModelProperty(hidden = true)
    protected String updateBy;	// 更新者
    @ApiModelProperty(hidden = true)
    protected String updateUser;// 登录名
    @ApiModelProperty(hidden = true)
    protected Date updateDate;	// 更新日期
    @ApiModelProperty(hidden = true)
    protected String delFlag; 	// 删除标记（0：正常；1：删除；2：审核）

    public DataEntity() {
        super();
        this.delFlag = DEL_FLAG_NORMAL;
    }

    public DataEntity(String id) {
        super(id);
    }
    /**
     * 插入之前执行方法，需要手动调用
     */
    @Override
    public void preInsert() {
        // 不限制ID为UUID，调用setIsNewRecord()使用自定义ID
        if (!this.isNewRecord) {
            setId(IdGen.uuid());
        }
        this.updateDate = new Date();
        this.createDate = this.updateDate;
    }

    @Override
    public void preUpdate() {
        this.updateDate = new Date();
    }



    @Length(min=0, max=255)
    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }



    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }



    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    public Date getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }


    @JsonIgnore
    @Length(min=1, max=1)
    public String getDelFlag() {
        return delFlag;
    }

    public void setDelFlag(String delFlag) {
        this.delFlag = delFlag;
    }

    public String getCreateBy() {
        return createBy;
    }

    public void setCreateBy(String createBy) {
        this.createBy = createBy;
    }

    public String getCreateUser() {
        return createUser;
    }

    public void setCreateUser(String createUser) {
        this.createUser = createUser;
    }

    public String getUpdateBy() {
        return updateBy;
    }

    public void setUpdateBy(String updateBy) {
        this.updateBy = updateBy;
    }

    public String getUpdateUser() {
        return updateUser;
    }

    public void setUpdateUser(String updateUser) {
        this.updateUser = updateUser;
    }
}
