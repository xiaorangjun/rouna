package com.rouna.service.main.mapper;

import com.rouna.service.main.config.mybatis.CrudMapper;
import com.rouna.service.main.model.RounaClass;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

/**
 * Created by Administrator on 2017/12/10.
 */
public interface RounaClassMapper extends CrudMapper<RounaClass> {
    @Override
    @Select("select * from rouna_class where id = #{id}")
    RounaClass getById(String id);

    @Override
    @Select("select * from rouna_class where id = #{id}")
    RounaClass get(RounaClass entity);

    @Override
    @Select("select * from rouna_class")
    List<RounaClass> findList(RounaClass entity);

    @Override
    @Select("select * from rouna_class")
    List<RounaClass> findAllList(RounaClass entity);

    @Override
    @Insert("insert into rouna_class (id,name,gradeId) values(#{id},#{name},#{gradeId})")
    int insert(RounaClass entity);

    @Override
    @Update("update rouna_class set name=#{name},gradeid=#{gradeId} where id=#{id}")
    int update(RounaClass entity);

    @Override
    @Delete("delete from rouna_class where id=#{id}")
    int delete(RounaClass entity);
}
