package com.rouna.service.main.utils;

import org.apache.commons.lang3.StringEscapeUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.HttpServletRequest;
import java.io.UnsupportedEncodingException;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


/**
 * Description 字符串工具类, 继承org.apache.commons.lang3.StringUtils类
 *
 * @version 1.0
 * @Company: 上海光华冠群软件有限公司
 * @PROJECT_NAME easyview-vdc-master
 * @Package com.ghca.easyview.cloud.core.utils
 * @date 2016/1/14 15:25
 */
public class StringUtil extends org.apache.commons.lang3.StringUtils {

    private static final Logger logger = LoggerFactory.getLogger(StringUtil.class);

    private static final String CHARSET_NAME = "UTF-8";

    /**
     * 转换为字节数组
     *
     * @param str
     * @return
     */
    public static byte[] getBytes(String str) {
        if (str != null) {
            try {
                return str.getBytes(CHARSET_NAME);
            } catch (UnsupportedEncodingException e) {
                return null;
            }
        } else {
            return null;
        }
    }

    /**
     * 转换为字节数组
     *
     * @param bytes
     * @return
     */
    public static String toString(byte[] bytes) {
        try {
            return new String(bytes, CHARSET_NAME);
        } catch (UnsupportedEncodingException e) {
            return EMPTY;
        }
    }


    /**
     * 替换掉HTML标签方法
     */
    public static String replaceHtml(String html) {
        if (isBlank(html)) {
            return "";
        }
        String regEx = "<.+?>";
        Pattern p = Pattern.compile(regEx);
        Matcher m = p.matcher(html);
        String s = m.replaceAll("");
        return s;
    }


//    /**
//     * 缩略字符串（不区分中英文字符）
//     *
//     * @param str    目标字符串
//     * @param length 截取长度
//     * @return
//     */
//    public static String abbr(String str, int length) {
//        if (str == null) {
//            return "";
//        }
//        try {
//            StringBuilder sb = new StringBuilder();
//            int currentLength = 0;
//            for (char c : replaceHtml(StringEscapeUtils.unescapeHtml4(str)).toCharArray()) {
//                currentLength += String.valueOf(c).getBytes("GBK").length;
//                if (currentLength <= length - 3) {
//                    sb.append(c);
//                } else {
//                    sb.append("...");
//                    break;
//                }
//            }
//            return sb.toString();
//        } catch (UnsupportedEncodingException e) {
//            logger.error(e.getMessage());
//
//        }
//        return "";
//    }


    /**
     * 获得i18n字符串
     */


    /**
     * 获得用户远程地址
     */
    public static String getRemoteAddr(HttpServletRequest request) {
        return getIpAddr(request);
    }


    public static String getIpAddr(HttpServletRequest request) {
        if (null == request) {
            return null;
        }
        String ipAddress = request.getHeader("X-Real-IP");
        if (ipAddress == null || ipAddress.length() == 0 || "unknown".equalsIgnoreCase(ipAddress)) {
            ipAddress = request.getHeader("x-forwarded-for");
        }
        if (ipAddress == null || ipAddress.length() == 0 || "unknown".equalsIgnoreCase(ipAddress)) {
            ipAddress = request.getHeader("Proxy-Client-IP");
        }
        if (ipAddress == null || ipAddress.length() == 0 || "unknown".equalsIgnoreCase(ipAddress)) {
            ipAddress = request.getHeader("WL-Proxy-Client-IP");
        }
        if (ipAddress == null || ipAddress.length() == 0 || "unknown".equalsIgnoreCase(ipAddress)) {
            ipAddress = request.getRemoteAddr();
            if (ipAddress != null && (ipAddress.equals("127.0.0.1") || ipAddress.equals("0:0:0:0:0:0:0:1"))) {
                //根据网卡取本机配置的IP
                InetAddress inet = null;
                try {
                    inet = InetAddress.getLocalHost();
                    if (null != inet) {
                        ipAddress = inet.getHostAddress();
                    }
                } catch (UnknownHostException e) {

                    logger.error(e.getMessage());

                }
            }
        }

        //对于通过多个代理的情况，第一个IP为客户端真实IP,多个IP按照','分割
        if (ipAddress != null && ipAddress.length() > 15) {
            if (ipAddress.indexOf(",") > 0) {
                ipAddress = ipAddress.substring(0, ipAddress.indexOf(","));
            }
        }

        return ipAddress;
    }


    /**
     * 影藏电话号码中间4位
     *
     * @param phone
     * @return
     */
    public static String phone(String phone) {
        if (isNotBlank(phone)) {
            phone = phone.replaceAll("(\\d{3})\\d{4}(\\d{4})", "$1****$2");
        }
        return phone;
    }


    public static String hideStr(String str) {


        if (isNotBlank(str)) {
            int length = str.length();
            if (length > 2) {

                str = str.substring(0, 2) + "******";

            } else {
                str = str + "*******";
            }

        }
        return str;
    }


    /**
     * 隐藏邮箱：只显示@前面的首位和末位
     *
     * @param email
     * @return
     */
    public static String email(String email) {
        if (isNotBlank(email)) {
            if (email.indexOf("@") != -1) {
                email = email.replaceAll(email.substring(0, email.lastIndexOf("@")), "*****");

            }


        }
        return email;
    }

    public static String htmlEncode(String source) {
        StringBuffer result = new StringBuffer();
        for (int i = 0; i < source.length(); i++) {
            char c = source.charAt(i);
            switch (c) {
                case '&':
                    result.append("&amp;");
                    break;
                case '<':
                    result.append("&lt;");
                    break;
                case '>':
                    result.append("&gt;");
                    break;
                default:
                    result.append(c);
                    break;
            }
        }
        return result.toString();
    }

}
