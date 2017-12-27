package com.rouna.service.main.service;

import com.rouna.service.main.api.RounaMark;
import com.rouna.service.main.config.mybatis.CrudService;
import com.rouna.service.main.mapper.RounaMarkMapper;
import com.rouna.service.main.model.RounaMarkEntity;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * Created by Administrator on 2017/12/15.
 */
@Service
public class RounaMarkService extends CrudService<RounaMarkMapper,RounaMarkEntity> {
    public int insert(String userId,RounaMark rounaMark){
        RounaMarkEntity entity = new RounaMarkEntity();
        BeanUtils.copyProperties(rounaMark,entity);
        entity.setCreateBy(userId);
        entity.setCreateUser(userId);
        entity.setCreateDate(new Date());
        return save(entity);
    }
    public int update(String id,RounaMark rounaMark){
        RounaMarkEntity entity = get(id);
        if(entity!=null){
            BeanUtils.copyProperties(rounaMark,entity,"id");
            return update(entity);
        }
        return 0;
    }
}
