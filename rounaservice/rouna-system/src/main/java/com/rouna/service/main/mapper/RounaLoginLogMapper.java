package com.rouna.service.main.mapper;

import com.rouna.service.main.config.mybatis.CrudMapper;
import com.rouna.service.main.model.RounaLoginlog;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.SelectProvider;

import java.util.List;

public interface RounaLoginLogMapper extends CrudMapper<RounaLoginlog> {
    @Override
    @SelectProvider(type = SQLProvider.class,method = "loginLogfindList")
    List<RounaLoginlog> findList(RounaLoginlog entity);

    @Override
    @InsertProvider(type = SQLProvider.class,method = "loginLogInsert")
    int insert(RounaLoginlog entity);
}
