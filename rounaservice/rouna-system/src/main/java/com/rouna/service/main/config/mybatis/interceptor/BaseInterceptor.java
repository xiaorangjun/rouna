package com.rouna.service.main.config.mybatis.interceptor;



import com.rouna.service.main.config.mybatis.dialect.Dialect;
import com.rouna.service.main.config.mybatis.dialect.MySQLDialect;
import com.rouna.service.main.utils.Reflections;
import org.apache.ibatis.plugin.Interceptor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.Serializable;
import java.util.Properties;


/**
 * Description Mybatis分页拦截器基类
 */
public abstract class BaseInterceptor implements Interceptor, Serializable {
    private static final Logger logger = LoggerFactory.getLogger(BaseInterceptor.class);
    private static final long serialVersionUID = 1L;

    /**
     * 对应 BaseEntity PageResponseBean<T> pageData 属性;
     */
    protected static final String PAGE = "pageData";

    protected static final String DELEGATE = "delegate";

    protected static final String MAPPED_STATEMENT = "mappedStatement";


    protected static Dialect DIALECT;

    protected static String dbname;


    /**
     * 对参数进行转换和检查
     *
     * @param parameterObject 参数对象
     * @param page            分页对象
     * @return 分页对象
     * @throws NoSuchFieldException 无法找到参数
     */
    @SuppressWarnings("unchecked")
    protected static PageResponseBean<Object> convertParameter(Object parameterObject, PageResponseBean<Object> page) {
        try {
            if (parameterObject instanceof PageResponseBean) {
                return (PageResponseBean<Object>) parameterObject;
            } else {
                return (PageResponseBean<Object>) Reflections.getFieldValue(parameterObject, PAGE);
            }
        } catch (Exception e) {
            return null;
        }
    }

    /**
     * 设置属性，支持自定义方言类和制定数据库的方式
     * <code>dialectClass</code>,自定义方言类。可以不配置这项
     * <ode>dbms</ode> 数据库类型，插件支持的数据库
     * <code>sqlPattern</code> 需要拦截的SQL ID
     *
     * @param p 属性
     */
    protected void initProperties(Properties p) {
        Dialect dialect = null;
        String databaseType = p.getProperty("databaseType");
        logger.info("databasetype===============" + databaseType);
        if ("mysql".equals(databaseType)) {
            dialect = new MySQLDialect();
        }
        DIALECT = dialect;
        dbname = databaseType;
        logger.info("dialect===============" + dialect);

    }


}
