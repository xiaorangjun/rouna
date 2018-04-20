package com.rouna.service.main.mapper;

import com.rouna.service.main.config.mybatis.CrudMapper;
import com.rouna.service.main.model.RounaSubjectEntity;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

/**
 * Created by Administrator on 2017/12/15.
 */
public interface RounaSubjectMapper extends CrudMapper<RounaSubjectEntity> {
    @Override
    @Select("select * from rouna_subject where id = #{id}")
    RounaSubjectEntity getById(String id);

    @Override
    @Select("select * from rouna_subject where id = #{id}")
    RounaSubjectEntity get(RounaSubjectEntity entity);

    @Override
    @Select("select * from rouna_subject")
    List<RounaSubjectEntity> findList(RounaSubjectEntity entity);

    @Override
    @Insert("insert into rouna_subject (id,name,create_by,create_user,create_date,del_flag) values(#{id},#{name},#{createBy},#{createUser},#{createDate},0)")
    int insert(RounaSubjectEntity entity);

    @Override
    @Update("update rouna_subject set name=#{name} where id=#{id}")
    int update(RounaSubjectEntity entity);

    @Override
    @Delete("delete from rouna_subject where id=#{id}")
    int delete(RounaSubjectEntity entity);
}
