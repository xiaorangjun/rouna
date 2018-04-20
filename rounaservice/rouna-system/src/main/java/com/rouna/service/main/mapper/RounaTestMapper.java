package com.rouna.service.main.mapper;

import com.rouna.service.main.config.mybatis.CrudMapper;
import com.rouna.service.main.model.RounaTestEntity;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

/**
 * Created by Administrator on 2017/12/14.
 */
public interface RounaTestMapper extends CrudMapper<RounaTestEntity> {
    @Select("select * from rouna_test where id = #{id}")
    RounaTestEntity getById(String id);

    @Select("select * from rouna_test where id = #{id}")
    RounaTestEntity get(RounaTestEntity entity);

    @Select("select * from rouna_test")
    List<RounaTestEntity> findList(RounaTestEntity entity);

    @Insert("insert into rouna_test (id,name,start_time,create_by,create_user,create_date,del_flag) values(#{id},#{name},#{startTime},#{createBy},#{createUser},#{createDate},0)")
    int insert(RounaTestEntity entity);

    @Update("update rouna_test set name=#{name},start_time=#{startTime} where id=#{id}")
    int update(RounaTestEntity entity);

    @Delete("delete from rouna_test where id=#{id}")
    int delete(RounaTestEntity entity);
}
