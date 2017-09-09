package com.liu.util;

import org.apache.commons.lang.StringUtils;
import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

/**
 * Created by liujiayu on 2017/9/9.
 */
public class Base64Util {

    public static String encode64(String str){
        byte[] b = null;
        if (str == null || StringUtils.isEmpty(str.trim())){
            return "";
        }

        try{
            b = str.getBytes("UTF-8");
        } catch (UnsupportedEncodingException e){
            e.printStackTrace();
        }

        if (b == null){
            return "";
        }

        String result = new BASE64Encoder().encode(b);
        return result;
    }

    public static String decode64(String str){
        byte[] b = null;
        String result = null;
        if (str == null || StringUtils.isEmpty(str.trim())){
            return "";
        }

        try{
            b = new BASE64Decoder().decodeBuffer(str);
            result = new String(b, "UTF-8");
        } catch (IOException e){
            e.printStackTrace();
        }

        return result;

    }

}
