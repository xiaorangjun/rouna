package com.rouna.service.main.service;

import com.rouna.service.main.api.RounaSubject;
import com.rouna.service.main.config.mybatis.CrudService;
import com.rouna.service.main.mapper.RounaSubjectMapper;
import com.rouna.service.main.model.RounaSubjectEntity;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * Created by Administrator on 2017/12/15.
 */
@Service
public class RounaSubjectService extends CrudService<RounaSubjectMapper,RounaSubjectEntity> {
    public int insert(String userId,RounaSubject rounaSubject){
        RounaSubjectEntity entity = new RounaSubjectEntity();
        BeanUtils.copyProperties(rounaSubject,entity);
        entity.setCreateBy(userId);
        entity.setCreateUser(userId);
        entity.setCreateDate(new Date());
        return save(entity);
    }
    public int update(String id,RounaSubject rounaTest){
        RounaSubjectEntity entity = get(id);
        if(entity!=null){
            BeanUtils.copyProperties(rounaTest,entity,"id");
            return update(entity);
        }
        return 0;
    }
}
