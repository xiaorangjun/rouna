package com.rouna.service.main.service;

import com.rouna.service.main.config.mybatis.CrudService;
import com.rouna.service.main.mapper.RounaLoginLogMapper;
import com.rouna.service.main.model.RounaLoginlog;
import org.springframework.stereotype.Service;

@Service
public class RounaLoginLogService extends CrudService<RounaLoginLogMapper,RounaLoginlog> {
}
