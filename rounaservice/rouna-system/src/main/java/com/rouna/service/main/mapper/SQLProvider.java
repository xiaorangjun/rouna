package com.rouna.service.main.mapper;

import com.rouna.service.main.api.RounaUser;
import com.rouna.service.main.model.RounaLoginlog;
import org.apache.ibatis.jdbc.SQL;

public class SQLProvider {
    public String userfindList(RounaUser entity){
        return new SQL(){{
            SELECT("*");
            FROM("rouna_user");
            if(entity.getLoginId()!=null){
                WHERE("login_id = #{loginId}");
            }
            WHERE("del_flag>0");
        }}.toString();
    }

    public String userInsert(RounaUser entity){
        return new SQL(){{
            INSERT_INTO("rouna_user");
            VALUES("id","#{id}");
            VALUES("login_id","#{loginId}");
            VALUES("pass_wd","#{passWd}");
            VALUES("online","0");
            VALUES("state","1");
            VALUES("create_by","#{createBy}");
            VALUES("create_user","#{createUser}");
            VALUES("create_date","#{createDate}");
        }}.toString();
    }

    public String userUpdate(RounaUser entity){
        return new SQL(){{
            UPDATE("rouna_user");
            if(entity.getPassWd()!=null)
                SET("pass_wd = #{passWd}");
            if(entity.getOnline()!=null)
                SET("online = #{online}");
            if(entity.getState()!=null)
                SET("state = #{state}");
            SET("update_by = #{updateBy}");
            SET("update_user = #{updateUser}");
            SET("update_date = #{updateDate}");
            WHERE("login_id = #{loginId}");
            WHERE("del_flag>0");
        }}.toString();
    }

    public String loginLogfindList(RounaLoginlog entity){
        return new SQL(){{
            SELECT("*");
            FROM("rouna_loginlog");
            if(entity.getLoginId()!=null){
                WHERE("login_id = #{loginId}");
            }
            WHERE("del_flag>0");
        }}.toString();
    }

    public String loginLogInsert(RounaLoginlog entity){
        return new SQL(){{
            INSERT_INTO("rouna_loginlog");
            VALUES("id","#{id}");
            VALUES("login_id","#{loginId}");
            VALUES("ip","#{ip}");
            VALUES("result","#{result}");
            VALUES("detail","#{detail}");
            VALUES("login_date","#{loginDate}");
        }}.toString();
    }

}
