package com.liu.controller;

import com.liu.Constant.ConstantCode;
import com.liu.Constant.ConstantPath;
import com.liu.configure.MailConf;
import com.liu.model.People;
import com.liu.service.IPeopleService;
import com.liu.util.Base64Util;
import com.liu.util.MailUtil;
import org.apache.commons.lang.StringUtils;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.slf4j.Logger;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Enumeration;

/**
 * Created by liujiayu on 2017/9/9.
 */
@Controller
@RequestMapping("/")
public class LoginController {

    private static final Logger logger = LoggerFactory.getLogger(LoginController.class);

    @Autowired
    private IPeopleService peopleService;

    @Autowired
    private MailConf mailConf;

    @RequestMapping(value = {"/", "/index"})
    public String index(HttpServletRequest request, Model model){
        HttpSession session = request.getSession();
        String username = (String) session.getAttribute("username");
        int uid = (int) session.getAttribute("uid");

        People people = peopleService.selectPeopleById(uid);

        if (username == null || StringUtils.isEmpty(username.trim())){
            return "/main/register";
        }

        if (people == null){
            model.addAttribute(ConstantPath.RESPONSE_MESSAGE, "登录失败");
            return "/main/register";
        }

        if (people.getStatus() == ConstantCode.INVAILD){
            model.addAttribute(ConstantPath.RESPONSE_MESSAGE, "用户未激活");
            return "/main/register";
        }
        return "/main/index";
    }


    @RequestMapping("/register")
    public String login(@RequestParam("username") String username, @RequestParam("password") String password,
                        @RequestParam("mail") String mail, HttpServletRequest request, Model model){

        if (username == null || StringUtils.isEmpty(username.trim()) || peopleExist(username)){
            model.addAttribute(ConstantPath.RESPONSE_MESSAGE, "用户名或错误");
            return "/main/register";
        }

        if (password == null || StringUtils.isEmpty(password.trim())){
            model.addAttribute(ConstantPath.RESPONSE_MESSAGE, "用户名或密码错误");
            return "/main/register";
        }

        if (mail == null || StringUtils.isEmpty(mail.trim()) || !mail.matches("/^[a-zA-Z0-9_-]+@[a-zA-Z0-9_-]+(\\.[a-zA-Z0-9_-]+)+$/")){
            model.addAttribute(ConstantPath.RESPONSE_MESSAGE, "邮箱不正确");
            return "/main/register";
        }

        if (StringUtils.isEmpty(password = Base64Util.encode64(password).trim())){
            model.addAttribute(ConstantPath.RESPONSE_MESSAGE, "用户名或密码错误");
            return "/main/register";
        }

        People people = new People();
        people.setName(username);
        people.setPassword(password);
        people.setMail(mail);
        people.setStatus(ConstantCode.INVAILD);
        peopleService.insertPeople(people);

        HttpSession session = request.getSession();

        MailUtil.sendRegister(mailConf, people, request.getRemoteAddr());
        model.addAttribute(ConstantPath.RESPONSE_MESSAGE, "注册成功");
        return "/main/index";

    }

    @RequestMapping("/login")
    public String login(@RequestParam("emailNum") String emailNum, @RequestParam("emailPassword") String emailPassword,
                        Model model, HttpServletRequest request){

        if (emailNum == null || StringUtils.isEmpty(emailNum.trim()) || !mailExist(emailNum.trim())){
            model.addAttribute(ConstantPath.RESPONSE_MESSAGE, "邮箱或密码错误");
            return "/main/register";
        }

        if (emailPassword == null || StringUtils.isEmpty(emailPassword.trim())){
            model.addAttribute(ConstantPath.RESPONSE_MESSAGE, "邮箱或密码错误");
            return "/main/register";
        }

        People people = peopleService.selectPeopleByMail(emailNum);
        String password = Base64Util.decode64(people.getPassword());
        if (!password.equals(emailPassword)){
            model.addAttribute(ConstantPath.RESPONSE_MESSAGE, "邮箱或密码错误");
            return "/main/register";
        }

        HttpSession session = request.getSession();
        session.setAttribute("username", people.getName());
        session.setAttribute("uid", people.getId());

        model.addAttribute(ConstantPath.RESPONSE_MESSAGE, "登录成功");
        return "/main/index";

    }

    @RequestMapping("/logout")
    public String logout(Model model, HttpServletRequest request){
        Enumeration enums = request.getSession().getAttributeNames();
        while(enums.hasMoreElements()){
            String sessionName = (String) enums.nextElement();
            request.getSession().removeAttribute(sessionName);
        }

        model.addAttribute(ConstantPath.RESPONSE_MESSAGE, "成功退出");
        return "/main/register";
    }


    private boolean peopleExist(String username){
        People people = peopleService.selectPeopleByName(username);
        if (people == null){
            return false;
        }
        return true;
    }

    private boolean mailExist(String mail){
        People people = peopleService.selectPeopleByMail(mail);
        if (people == null){
            return false;
        }
        return true;
    }

}
