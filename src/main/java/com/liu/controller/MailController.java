package com.liu.controller;

import com.alibaba.druid.util.Base64;
import com.liu.Constant.ConstantPath;
import com.liu.configure.MailConf;
import com.liu.model.People;
import com.liu.service.IPeopleService;
import com.liu.util.Base64Util;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import sun.rmi.transport.Transport;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * Created by liujiayu on 2017/9/9.
 */
@Controller
@RequestMapping("/mail")
@ComponentScan(basePackageClasses = com.liu.configure.MailConf.class)
public class MailController {

    private static Logger logger = LoggerFactory.getLogger(MailController.class);

    @Autowired
    private IPeopleService peopleService;

    @RequestMapping("/recive/register")
    public String mail(@RequestParam("value") String value, Model model, HttpServletRequest request){
        String[] str = Base64Util.decode64(value).split(";");
        int uid = Integer.parseInt(str[0]);
        long startTime = Integer.parseInt(str[1]);
        long endTime = System.currentTimeMillis();

        People people = peopleService.selectPeopleById(uid);
        if (people == null){
            model.addAttribute(ConstantPath.RESPONSE_MESSAGE, "激活失败");
            return "/main/register";
        }

        if ((endTime - startTime) > 30 * 60 * 1000){
            model.addAttribute(ConstantPath.RESPONSE_MESSAGE, "激活超时");
            return "/main/register";
        }

        peopleService.activePeople(uid);

        HttpSession session = request.getSession();
        session.setAttribute("uid", uid);
        session.setAttribute("username", people.getName());

        model.addAttribute(ConstantPath.RESPONSE_MESSAGE, "激活成功");
        return "/main/index";
    }



}
