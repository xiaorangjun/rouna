package com.rouna.service.main.rest;

import com.rouna.service.main.api.Response;
import com.rouna.service.main.api.RounaUser;
import com.rouna.service.main.api.RounaUserInfo;
import com.rouna.service.main.api.RounaUserResetPwd;
import com.rouna.service.main.service.RounaUserService;
import com.rouna.service.main.utils.JwtToken;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Api(value = "用户相关",produces = "produces",consumes = "consumes",protocols = "protocals")
@RequestMapping(value = "api/v1/user/")
public class UserController extends BaseController {
    @Autowired
    RounaUserService userService;
    @ApiOperation(value = "用户登录",notes = "用于用户登录")
    @RequestMapping(value = "/login",method = RequestMethod.POST)
    public Response<String> login(@RequestBody RounaUser login){
        return userService.login(login);
    }

    @ApiOperation(value = "用户注册",notes = "用于用户注册")
    @RequestMapping(value = "/register",method = RequestMethod.POST)
    public Response<String> register(@RequestBody RounaUser register){
        return userService.register(register);
    }

    @ApiOperation(value = "用户列表",notes = "用于查看用户列表")
    @RequestMapping(value = "/list",method = RequestMethod.POST)
    public Response<List<RounaUser>> register(){
        Response response = new Response();
        List<RounaUser> list = userService.findList(new RounaUser());
        response.setResult(list);
        return response;
    }

    @ApiOperation(value = "用户信息",notes = "用于查看用户信息")
    @RequestMapping(value = "/info",method = RequestMethod.GET)
    public Response<RounaUser> register(@RequestHeader(value = "XAuthorization") String token){
        Response response = new Response();
        logger.info("userinfo");
        try{
           RounaUserInfo userInfo = JwtToken.validToken(token);
           response.setResult(userInfo);
        }catch (Exception e){
            e.printStackTrace();
        }
        return response;
    }

    @ApiOperation(value = "重置密码",notes = "用于重置用户密码")
    @RequestMapping(value = "/resetpwd",method = RequestMethod.POST)
    public Response<String> resetpwd(@RequestHeader(value = "Authorization") String token,@RequestBody RounaUserResetPwd repwd){
        return userService.resetPwd(token,repwd);
    }
}
