package com.liu.util;

/**
 * Created by liujiayu on 2017/9/9.
 */
public class FileUtil {

    public static String filePathConcat(String... path){
        StringBuilder sb = new StringBuilder();

        int length = path.length;
        for (int i = 0 ; i < length ; i++){
            sb.append(path[i]);
        }

        return sb.toString();

    }

}
