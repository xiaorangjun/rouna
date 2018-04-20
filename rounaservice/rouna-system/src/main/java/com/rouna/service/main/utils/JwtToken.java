package com.rouna.service.main.utils;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.Claim;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.rouna.service.main.api.RounaUserInfo;
import org.apache.commons.codec.binary.Hex;
import org.joda.time.DateTime;

import java.security.MessageDigest;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class JwtToken {
    public static String SECRET = "rouna_cn";

    public static String craeteToken(RounaUserInfo user) throws Exception{
        Date date = DateTime.now().toDate();
        Date expireDate = DateTime.now().plusHours(2).toDate();//2小时过期
        Map<String,Object> map = new HashMap<>();
        map.put("alg","HS256");
        map.put("typ","JWT");
        String token = JWT.create().withHeader(map)
                .withClaim("uid",user.getLoginid())
                .withClaim("name",user.getName())
                .withExpiresAt(expireDate)
                .withIssuedAt(date)
                .sign(Algorithm.HMAC256(SECRET));
        return token;
    }



    public static RounaUserInfo validToken(String token) throws Exception{

        RounaUserInfo user = null;
        DecodedJWT jwt = null;
        try {
            JWTVerifier verifier = JWT.require(Algorithm.HMAC256(SECRET)).build();
            jwt = verifier.verify(token);
            user = new RounaUserInfo();
            Map<String,Claim> claimMap =  jwt.getClaims();
            Claim name = claimMap.get("name");
            if(name!=null){
                user.setName(name.asString());
            }
            Claim uid = claimMap.get("uid");
            if(uid!=null){
                user.setLoginid(uid.asString());
            }
        }catch (Exception e){
            e.printStackTrace();
            user = null;
        }
        return user;
    }

    public static String getLoginId(String token){
        DecodedJWT jwt = null;
        try {
            JWTVerifier verifier = JWT.require(Algorithm.HMAC256(SECRET)).build();
            jwt = verifier.verify(token);
            Map<String,Claim> claimMap =  jwt.getClaims();
            Claim uid = claimMap.get("uid");
            if(uid!=null){
                return uid.asString();
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 加盐MD5
     * @param sec
     * @return
     */
    public static String encrypt(String sec) {
        Random r = new Random();
        StringBuilder sb = new StringBuilder(16);
        sb.append(r.nextInt(99999999)).append(r.nextInt(99999999));
        int len = sb.length();
        if (len < 16) {
            for (int i = 0; i < 16 - len; i++) {
                sb.append("0");
            }
        }
        String salt = sb.toString();
        sec = md5Hex(sec + salt);
        char[] cs = new char[48];
        for (int i = 0; i < 48; i += 3) {
            cs[i] = sec.charAt(i / 3 * 2);
            char c = salt.charAt(i / 3);
            cs[i + 1] = c;
            cs[i + 2] = sec.charAt(i / 3 * 2 + 1);
        }
        return new String(cs);
    }

    /**
     * 校验加盐后是否和原文一致
     * @author daniel
     * @time 2016-6-11 下午8:45:39
     * @param password
     * @param md5
     * @return
     */
    public static boolean verify(String password, String md5) {
        char[] cs1 = new char[32];
        char[] cs2 = new char[16];
        for (int i = 0; i < 48; i += 3) {
            cs1[i / 3 * 2] = md5.charAt(i);
            cs1[i / 3 * 2 + 1] = md5.charAt(i + 2);
            cs2[i / 3] = md5.charAt(i + 1);
        }
        String salt = new String(cs2);
        return md5Hex(password + salt).equals(new String(cs1));
    }

    /**
     * 获取十六进制字符串形式的MD5摘要
     */
    private static String md5Hex(String src) {
        try {
            MessageDigest md5 = MessageDigest.getInstance("MD5");
            byte[] bs = md5.digest(src.getBytes());
            return new String(new Hex().encode(bs));
        } catch (Exception e) {
            return null;
        }
    }

}
