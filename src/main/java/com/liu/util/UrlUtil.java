package com.liu.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by liujiayu on 2017/9/9.
 */
public class UrlUtil {

    public static void main(String[] args){
        HttpURLConnection con = null;
        OutputStreamWriter osw = null;
        BufferedReader br = null;
        try{
            URL url = new URL("http://202.205.102.27:8000/");
            con = (HttpURLConnection) url.openConnection();
            con.setRequestMethod("GET");
            con.setDoOutput(true);
            con.setDoInput(true);
            con.setUseCaches(false);
            con.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");

            br = new BufferedReader(new InputStreamReader(con.getInputStream(), "UTF-8"));
            String temp;
            while((temp = br.readLine()) != null){
                System.out.println(temp);
            }
        } catch (MalformedURLException e){
            e.printStackTrace();
        } catch (IOException e){
            e.printStackTrace();
        }
    }
}
