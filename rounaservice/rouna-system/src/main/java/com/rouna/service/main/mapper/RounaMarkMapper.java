package com.rouna.service.main.mapper;

import com.rouna.service.main.config.mybatis.CrudMapper;
import com.rouna.service.main.model.RounaMarkEntity;
import com.rouna.service.main.model.RounaStudentEntity;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

/**
 * Created by Administrator on 2017/12/10.
 */
public interface RounaMarkMapper extends CrudMapper<RounaMarkEntity> {
    @Override
    @Select("select * from rouna_Mark where id = #{id}")
    RounaMarkEntity getById(String id);

    @Override
    @Select("select * from rouna_Mark where id = #{id}")
    RounaMarkEntity get(RounaMarkEntity entity);

    @Override
    @Select("select * from rouna_mark")
    List<RounaMarkEntity> findList(RounaMarkEntity entity);

    @Override
    @Select("select * from rouna_mark")
    List<RounaMarkEntity> findAllList(RounaMarkEntity entity);

    @Override
    @Insert("insert into rouna_mark (id,test_id,student_id,subject_id,subject_mark,create_by,create_user,create_date,del_flag) " +
            "values(#{id},#{testId},#{studentId},#{subjectId},#{subjectMark},#{createBy},#{createUser},#{createDate},0)")
    int insert(RounaMarkEntity entity);

    @Override
    @Update("update rouna_mark set subject_mark=#{subjectMark} where id=#{id}")
    int update(RounaMarkEntity entity);

    @Override
    @Delete("delete from rouna_mark where id=#{id}")
    int delete(RounaMarkEntity entity);
}
