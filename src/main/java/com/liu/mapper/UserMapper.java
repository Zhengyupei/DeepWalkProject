package com.liu.mapper;

import com.liu.model.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by Administrator on 2017/5/3.
 */
public interface UserMapper {

    public List<User> selectUser();
}
