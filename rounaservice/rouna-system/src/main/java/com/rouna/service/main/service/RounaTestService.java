package com.rouna.service.main.service;

import com.rouna.service.main.api.RounaTest;
import com.rouna.service.main.config.mybatis.CrudService;
import com.rouna.service.main.mapper.RounaTestMapper;
import com.rouna.service.main.model.RounaTestEntity;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * Created by Administrator on 2017/12/14.
 */
@Service
public class RounaTestService extends CrudService<RounaTestMapper,RounaTestEntity> {
    public int insert(String userId,RounaTest rounaTest){
        RounaTestEntity entity = new RounaTestEntity();
        BeanUtils.copyProperties(rounaTest,entity);
        entity.setCreateBy(userId);
        entity.setCreateUser(userId);
        entity.setCreateDate(new Date());
        return save(entity);
    }
    public int update(String id,RounaTest rounaTest){
        RounaTestEntity entity = get(id);
        if(entity!=null){
            BeanUtils.copyProperties(rounaTest,entity,"id");
            return update(entity);
        }
        return 0;
    }
}
