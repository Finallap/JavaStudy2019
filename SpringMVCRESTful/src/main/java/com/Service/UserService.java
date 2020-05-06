package com.Service;

import com.bean.User;

import java.util.List;

/**
 * @description: UserService
 * @date: 2020/5/7 15:57
 * @author: Finallap
 * @version: 1.0
 */
public interface UserService {
    User findById(long id);
    User findByName(String name);
    void saveUser(User user);
    void updateUser(User user);
    void deleteUserById(long id);
    List<User> findAllUser();
    void deleteAllUser();
    public boolean isUserExist(User user);
}
