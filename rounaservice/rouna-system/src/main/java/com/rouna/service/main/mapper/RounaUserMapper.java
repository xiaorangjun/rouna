package com.rouna.service.main.mapper;

import com.rouna.service.main.api.RounaUser;
import com.rouna.service.main.config.mybatis.CrudMapper;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface RounaUserMapper extends CrudMapper<RounaUser> {

    @Override
    @Select("select * from rouna_user where del_flag>0 and id = #{id}")
    @Results(id = "rounauser",value = {
            @Result(column = "login_id",property = "loginId"),
            @Result(column = "pass_wd",property = "passWd"),
            @Result(column = "create_by",property = "createBy"),
            @Result(column = "create_date",property = "createDate"),
            @Result(column = "update_by",property = "updateBy"),
            @Result(column = "update_date",property = "updateDate")
    })
    RounaUser getById(String id);

    @Override
    @Select("select * from rouna_user where del_flag>0 and login_id = #{loginId}")
    @ResultMap("rounauser")
    RounaUser get(RounaUser entity);

    @Override
    @SelectProvider(type = SQLProvider.class,method = "userfindList")
    @ResultMap("rounauser")
    List<RounaUser> findList(RounaUser entity);

    @Override
    @InsertProvider(type = SQLProvider.class,method = "userInsert")
    int insert(RounaUser entity);

    @Override
    @UpdateProvider(type = SQLProvider.class,method = "userUpdate")
    int update(RounaUser entity);

    @Override
    @Update("update rouna_user set del_flag = 0 where del_flag>0 and id = #{id}")
    int delete(RounaUser entity);

    @Override
    @Update("update rouna_user set del_flag = 0 where del_flag>0 and id = #{id}")
    int deleteById(String id);
}
