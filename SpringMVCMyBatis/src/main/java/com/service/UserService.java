package com.service;

import com.entity.User;

import java.util.List;

/**
 * @description: UserService
 * @date: 2020/5/16 15:21
 * @author: Finallap
 * @version: 1.0
 */
public interface UserService {
    void insertUser(User user);

    void updateUser(User user);

    void deleteUserById(int uid);

    List<User> listAllUser();

    User findById(int uid);

    User findByName(String name);
}
