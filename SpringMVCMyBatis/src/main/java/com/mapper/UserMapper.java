package com.mapper;

import com.entity.User;

import java.util.List;

/**
 * @description: UserMapper
 * @date: 2020/5/15 15:22
 * @author: Finallap
 * @version: 1.0
 */
public interface UserMapper {
    int insertUser(User user);

    int updateUser(User user);

    int deleteUserById(int uid);

    List<User> listAllUser();

    User findByName(String uname);

    User findById(int uid);
}
