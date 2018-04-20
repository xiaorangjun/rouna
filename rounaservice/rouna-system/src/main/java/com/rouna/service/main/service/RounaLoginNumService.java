package com.rouna.service.main.service;

import com.rouna.service.main.config.mybatis.CrudService;
import com.rouna.service.main.mapper.RounaLoginNumMapper;
import com.rouna.service.main.model.RounaLoginNum;
import org.springframework.stereotype.Service;

@Service
public class RounaLoginNumService extends CrudService<RounaLoginNumMapper,RounaLoginNum> {
}
