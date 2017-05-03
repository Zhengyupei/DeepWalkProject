package com.liu.controller;

import com.liu.model.User;
import com.liu.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

/**
 * Created by Administrator on 2017/5/3.
 */
@Controller
@RequestMapping("/user")
public class UserController {

    private static final Logger logger = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private IUserService userService;

    @RequestMapping("list")
    public String listUser(){
        List<User> list = userService.selectUser();
        for (User user : list){
            logger.info("{}, {}", user.getName(), user.getPassword());
        }
        return "/index";
    }
}
