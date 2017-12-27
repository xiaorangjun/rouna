package com.rouna.service.main.service;

import com.rouna.service.main.api.RounaStudent;
import com.rouna.service.main.api.RounaSubject;
import com.rouna.service.main.config.mybatis.CrudService;
import com.rouna.service.main.mapper.RounaStudentMapper;
import com.rouna.service.main.model.RounaStudentEntity;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * Created by Administrator on 2017/12/15.
 */
@Service
public class RounaStudentService extends CrudService<RounaStudentMapper,RounaStudentEntity> {
    public int insert(String userId,RounaStudent rounaStudent){
        RounaStudentEntity entity = new RounaStudentEntity();
        BeanUtils.copyProperties(rounaStudent,entity);
        entity.setCreateBy(userId);
        entity.setCreateUser(userId);
        entity.setCreateDate(new Date());
        return save(entity);
    }
    public int update(String id,RounaSubject rounaTest){
        RounaStudentEntity entity = get(id);
        if(entity!=null){
            BeanUtils.copyProperties(rounaTest,entity,"id");
            return update(entity);
        }
        return 0;
    }
}
