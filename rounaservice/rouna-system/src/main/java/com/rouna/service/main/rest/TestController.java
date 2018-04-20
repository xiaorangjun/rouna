package com.rouna.service.main.rest;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.rouna.service.main.api.RounaMark;
import com.rouna.service.main.api.RounaStudent;
import com.rouna.service.main.api.RounaSubject;
import com.rouna.service.main.api.RounaTest;
import com.rouna.service.main.model.RounaClass;
import com.rouna.service.main.service.*;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Administrator on 2017/12/9.
 */
@RestController
@Api
public class TestController {
    @Autowired
    RounaClassService rounaClassService;
    @Autowired
    RounaTestService rounaTestService;
    @Autowired
    RounaSubjectService rounaSubjectService;
    @Autowired
    RounaStudentService rounaStudentService;
    @Autowired
    RounaMarkService rounaMarkService;
    @RequestMapping(value = "/class",method = RequestMethod.POST)
    public int create(@RequestBody @ApiParam(name = "联系对象",value = "传入JSON格式",required = true) RounaClass rounaClass){
        return rounaClassService.save(rounaClass);
    }

    @RequestMapping(value = "/test",method = RequestMethod.POST)
    public int createTest(@RequestBody @ApiParam(name = "考试信息",value = "传入JSON格式",required = true) RounaTest rounaTest){
        return rounaTestService.insert("root",rounaTest);
    }

    @RequestMapping(value = "/subject",method = RequestMethod.POST)
    public int createSubject(@RequestBody @ApiParam(name = "科目信息",value = "传入JSON格式",required = true) RounaSubject rounaSubject){
        return rounaSubjectService.insert("root",rounaSubject);
    }

    @RequestMapping(value = "/student",method = RequestMethod.POST)
    public int createStudent(@RequestBody @ApiParam(name = "学员信息",value = "传入JSON格式",required = true) RounaStudent rounaStudent){
        return rounaStudentService.insert("root",rounaStudent);
    }

    @RequestMapping(value = "/mark",method = RequestMethod.POST)
    public int createMark(@RequestBody @ApiParam(name = "考试成绩信息",value = "传入JSON格式",required = true) RounaMark rounaMark){
        return rounaMarkService.insert("root",rounaMark);
    }

    @RequestMapping(value = "/test",method = RequestMethod.GET)
    public Object getData(){
        JSONArray array = new JSONArray();
        JSONObject object =new JSONObject();
        object.put("defaultStudent","002");
        object.put("students",array);
        return object;
    }
}
