package com.rouna.service.main.mapper;

import com.rouna.service.main.config.mybatis.CrudMapper;
import com.rouna.service.main.model.RounaStudentEntity;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

/**
 * Created by Administrator on 2017/12/10.
 */
public interface RounaStudentMapper extends CrudMapper<RounaStudentEntity> {
    @Override
    @Select("select * from rouna_student where id = #{id}")
    RounaStudentEntity getById(String id);

    @Override
    @Select("select * from rouna_student where id = #{id}")
    RounaStudentEntity get(RounaStudentEntity entity);

    @Override
    @Select("select * from rouna_student")
    List<RounaStudentEntity> findList(RounaStudentEntity entity);

    @Override
    @Insert("insert into rouna_student (id,name,classid,no,identity_no,sex,create_by,create_user,create_date,del_flag) " +
            "values(#{id},#{name},#{classId},#{no},#{identityNo},#{sex},#{createBy},#{createUser},#{createDate},0)")
    int insert(RounaStudentEntity entity);

    @Override
    @Update("update rouna_student set name=#{name},gradeid=#{gradeId} where id=#{id}")
    int update(RounaStudentEntity entity);

    @Override
    @Delete("delete from rouna_student where id=#{id}")
    int delete(RounaStudentEntity entity);
}
