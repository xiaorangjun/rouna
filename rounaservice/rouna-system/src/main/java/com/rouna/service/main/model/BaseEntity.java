package com.rouna.service.main.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.common.collect.Maps;
import com.rouna.service.main.config.mybatis.interceptor.PageResponseBean;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ReflectionToStringBuilder;

import javax.xml.bind.annotation.XmlTransient;
import java.io.Serializable;
import java.util.Map;


/**
 * Description Entity支持类Mybatis扫描，一般情况下实体类都需要集成此类，以便于mybatis扫描到对于的类
 */
public abstract class BaseEntity<T> implements Serializable {

    private static final long serialVersionUID = 1L;
    protected String orderBy;//排序字段

    protected String sord = "desc";//默认排序

    /**
     * 实体编号（唯一标识）
     */
    @JsonProperty("ID")
    protected String id;

    /**
     * 当前实体分页对象
     */
    protected PageResponseBean<T> pageData;


    /**
     * 自定义SQL（SQL标识，SQL内容）
     */
    protected Map<String, String> sqlMap;

    /**
     * 是否是新记录（默认：false），调用setIsNewRecord()设置新记录，使用自定义ID。
     * 设置为true后强制执行插入语句，ID不会自动生成，需从手动传入。
     */
    protected boolean isNewRecord = false;


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public BaseEntity() {

    }

    public BaseEntity(String id) {
        this();
        this.id = id;
    }

    @JsonIgnore
    @XmlTransient
    public PageResponseBean<T> getPageData() {
        if (pageData == null) {
            pageData = new PageResponseBean<T>();
        }
        return pageData;

    }

    public PageResponseBean<T> setPageData(PageResponseBean<T> pageData) {
        this.pageData = pageData;
        return pageData;
    }

    @JsonIgnore
    @XmlTransient
    public Map<String, String> getSqlMap() {
        if (sqlMap == null) {
            sqlMap = Maps.newHashMap();
        }
        return sqlMap;
    }

    public void setSqlMap(Map<String, String> sqlMap) {
        this.sqlMap = sqlMap;
    }

    /**
     * 插入之前执行方法，子类实现
     */
    public abstract void preInsert();


    /**
     * 更新之前执行方法，子类实现
     */
    public abstract void preUpdate();

    /**
     * 是否是新记录（默认：false），调用setIsNewRecord()设置新记录，使用自定义ID。
     * 设置为true后强制执行插入语句，ID不会自动生成，需从手动传入。
     *
     * @return
     */
    @JsonIgnore
    public boolean getIsNewRecord() {
        return isNewRecord || StringUtils.isBlank(getId());
    }

    /**
     * 是否是新记录（默认：false），调用setIsNewRecord()设置新记录，使用自定义ID。
     * 设置为true后强制执行插入语句，ID不会自动生成，需从手动传入。
     */
    public void setIsNewRecord(boolean isNewRecord) {
        this.isNewRecord = isNewRecord;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (o == null || getClass() != o.getClass()) return false;

        BaseEntity<?> that = (BaseEntity<?>) o;

        return new EqualsBuilder()
                .append(id, that.id)
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37)
                .append(id)
                .toHashCode();
    }

    /**
     * 从写toString方法
     *
     * @return
     */
    @Override
    public String toString() {
        return ReflectionToStringBuilder.toString(this);
    }

    /**
     * 删除标记:正常{@value}
     */
    public static final String DEL_FLAG_NORMAL = "0";
    /**
     * 删除标记:删除{@value}
     */
    public static final String DEL_FLAG_DELETE = "1";


    @JsonIgnore
    public String getSord() {
        return  sord;
    }

    public void setSord(String sord) {
        this.sord = sord;
    }
    @JsonIgnore
    public String getOrderBy() {
        return orderBy;
    }

    public void setOrderBy(String orderBy) {
        this.orderBy = orderBy;
    }
}
