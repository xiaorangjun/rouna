package com.rouna.service.main.config.mybatis;

import com.rouna.service.main.config.mybatis.interceptor.PageResponseBean;
import com.rouna.service.main.model.DataEntity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


public  abstract class CrudService<M extends CrudMapper<T>,T extends DataEntity<T>> {

    protected Logger logger = LoggerFactory.getLogger(getClass());


    /**
     * 持久层对象
     */
    @Autowired
    protected M mapper;


    /**
     * 获取单条数据
     *
     * @param id
     * @return
     */
    public T get(String id) {
        return mapper.getById(id);
    }

    /**
     * 获取单条数据
     *
     * @param entity
     * @return
     */
    public T get(T entity) {
        return mapper.get(entity);
    }

    /**
     * 查询列表数据
     *
     * @param entity
     * @return
     */
    public List<T> findList(T entity) {
        return mapper.findList(entity);
    }

    /**
     * 查询分页数据
     *
     * @param page   分页对象
     * @param entity
     * @return
     */
    public PageResponseBean<T> findPage(PageResponseBean<T> page, T entity) {
        entity.setPageData(page);
        page.setRows(mapper.findList(entity));
        return page;
    }

    /**
     * 保存数据（插入或更新）
     *
     * @param entity
     */
    @Transactional(readOnly = false)
    public int save(T entity) {
        entity.preInsert();
       return mapper.insert(entity);
    }


    @Transactional(readOnly = false)
    public int update(T entity) {
        entity.preUpdate();
        return mapper.update(entity);
    }

    /**
     * 删除数据
     *
     * @param entity
     */
    @Transactional(readOnly = false)
    public int delete(T entity) {
       return mapper.delete(entity);
    }

    /**
     * 删除数据
     *
     * @param entity
     */
    @Transactional(readOnly = false)
    public int deleteById(String id) {
        return mapper.deleteById(id);
    }


}
