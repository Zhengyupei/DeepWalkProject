package com.liu.service.impl;

import com.liu.mapper.UserMapper;
import com.liu.model.User;
import com.liu.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/5/3.
 */
public class UserServiceImpl implements IUserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public List<User> selectUser(){
        List<User> list = userMapper.selectUser();
        if (list == null){
            return new ArrayList<>();
        }
        return list;
    }
}
