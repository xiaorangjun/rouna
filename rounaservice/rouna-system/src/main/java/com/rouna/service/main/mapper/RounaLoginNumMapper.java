package com.rouna.service.main.mapper;

import com.rouna.service.main.config.mybatis.CrudMapper;
import com.rouna.service.main.model.RounaLoginNum;
import org.apache.ibatis.annotations.*;

public interface RounaLoginNumMapper extends CrudMapper<RounaLoginNum> {

    @Override
    @Select("select * from rouna_loginnum where login_id = #{loginId}")
    @Results({
            @Result(column = "login_id",property = "loginId")
    })
    RounaLoginNum get(RounaLoginNum entity);

    @Override
    @Insert("insert into rouna_loginnum(login_id,num) values(#{loginId},#{num})")
    int insert(RounaLoginNum entity);

    @Override
    @Update("update rouna_loginnum set num = #{num} where login_id = #{loginId}")
    int update(RounaLoginNum entity);
}
