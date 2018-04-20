package com.rouna.service.main.service;

import com.rouna.service.main.api.Response;
import com.rouna.service.main.api.RounaUser;
import com.rouna.service.main.api.RounaUserInfo;
import com.rouna.service.main.api.RounaUserResetPwd;
import com.rouna.service.main.config.mybatis.CrudService;
import com.rouna.service.main.mapper.RounaUserMapper;
import com.rouna.service.main.model.RounaLoginNum;
import com.rouna.service.main.model.RounaLoginlog;
import com.rouna.service.main.utils.JwtToken;
import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RounaUserService extends CrudService<RounaUserMapper,RounaUser> {

    @Autowired RounaLoginLogService loginLogService;
    @Autowired RounaLoginNumService loginNumService;

    public Response<String> login(RounaUser user){
       Response response = new Response();
        RounaLoginlog loginlog = new RounaLoginlog();
       try {
           loginlog.setLoginDate(DateTime.now().toDate());
           loginlog.setLoginId(user.getLoginId());
           loginlog.setIp("127.0.0.1");
           RounaUser bean = get(user);
           //设置登录日志
           if(bean!=null){
               if("1".equals(bean.getState())){
                   RounaLoginNum query = new RounaLoginNum();
                   query.setLoginId(user.getLoginId());
                   RounaLoginNum num = loginNumService.get(query);
                   if(JwtToken.verify(user.getPassWd(),bean.getPassWd())){
                       RounaUserInfo info = new RounaUserInfo();
                       info.setLoginid(bean.getLoginId());
                       String token = JwtToken.craeteToken(info);
                       response.setResult(token);
                       loginlog.setResult("200");
                       loginlog.setDetail("登录成功");
                       //登录成功 重置错误登录次数
                       if(num == null){
                           query.setNum(0);
                           loginNumService.save(query);
                       }else if(num.getNum()>0){
                           num.setNum(0);
                           loginNumService.update(num);
                       }
                   }else{
                       response.setCode("401");
                       if(num == null){
                           query.setNum(1);
                           loginNumService.save(query);
                           response.setMessage("密码不正确,今日输入错误"+query.getNum()+"次,连续错误5次后账户将被锁定");
                       }else {
                           num.setNum(num.getNum()+1);
                           loginNumService.update(num);
                           if(num.getNum()>=5){
                               RounaUser lock = new RounaUser();
                               lock.setLoginId(user.getLoginId());
                               lock.setState("0");
                               mapper.update(lock);
                               response.setMessage("密码不正确，今日输入错误5次，账户已被锁定");
                           }else{
                               response.setMessage("密码不正确，今日输入错误"+num.getNum()+"次，连续错误5次后账户将被锁定");
                           }
                       }
                       loginlog.setResult("401");
                       loginlog.setDetail("密码错误");
                   }
               }else{
                   response.setCode("400");
                   response.setMessage("用户被锁定，请联系客服解锁");
                   loginlog.setResult("400");
                   loginlog.setDetail("账户锁定");
               }
           }else {
               response.setCode("404");
               response.setMessage("用户不存在");
               loginlog.setResult("404");
               loginlog.setDetail("用户不存在");
           }
       }catch (Exception e){
           logger.error(e.getMessage());
           response.setCode("500");
           response.setMessage(e.getMessage());
           loginlog.setResult("500");
           loginlog.setDetail("系统异常");
       }finally {
           //保存登录日志
           loginLogService.save(loginlog);
       }
       return response;
    }

    public Response<String> register(RounaUser user){
        Response response = new Response();
        try {
            RounaUser bean = get(user);
            //设置登录日志
            if(bean!=null){
                response.setCode("405");
                response.setMessage("用户名已经存在");
            }else {
                user.setPassWd(JwtToken.encrypt(user.getPassWd()));
                user.setCreateBy(user.getLoginId());
                int num =save(user);
                if(num>0){
                    response.setResult(user.getLoginId());
                    response.setMessage("注册成功");
                }else{
                    response.setCode("-1");
                    response.setMessage("注册失败");
                }
            }
        }catch (Exception e){
            logger.error(e.getMessage());
            response.setCode("500");
            response.setMessage(e.getMessage());
        }
        return response;
    }

    public Response<String> resetPwd(String accessToken, RounaUserResetPwd repwd){
        Response response = new Response();
        try {
            String loginId = JwtToken.getLoginId(accessToken);
            if(loginId!=null){
                RounaUser user = new RounaUser();
                user.setLoginId(loginId);
                if(repwd.getNewpwd().equals(repwd.getNewpwdconfirm())){
                    RounaUser bean = get(user);
                    if("1".equals(bean.getState())){
                        if(JwtToken.verify(repwd.getOldpwd(),bean.getPassWd())){
                            user.setPassWd(JwtToken.encrypt(repwd.getNewpwd()));
                            int num =update(user);
                            if(num>0){
                                response.setCode("200");
                                response.setMessage("密码已重置，请重新登录");
                            }else{
                                response.setCode("500");
                                response.setMessage("密码修改失败，请重试");
                            }
                        }else{
                            response.setCode("403");
                            response.setMessage("旧密码输入错误");
                        }
                    }else{
                        response.setCode("402");
                        response.setMessage("用户被锁定，请联系客服解锁");
                    }
                }else{
                    response.setCode("401");
                    response.setMessage("新密码输入不一致，请确认");
                }
            }else{
                response.setCode("400");
                response.setMessage("回话超时,请重新登录");
            }
        }catch (Exception e){
            logger.error(e.getMessage());
            response.setCode("500");
            response.setMessage(e.getMessage());
        }
        return response;
    }
}
