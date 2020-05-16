package com.service;

import com.dao.UserMapper;
import com.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @description: UserService
 * @date: 2020/5/16 15:15
 * @author: Finallap
 * @version: 1.0
 */
@Service("userService")
@Transactional
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;

    @Override
    public void insertUser(User user) {
        if (userMapper.findById(user.getUid()) == null) {
            userMapper.insertUser(user);
        }
    }

    @Override
    public void updateUser(User user) {
        if (userMapper.findById(user.getUid()) != null) {
            userMapper.updateUser(user);
        }
    }

    @Override
    public void deleteUserById(int uid) {
        userMapper.deleteUserById(uid);
    }

    @Override
    public List<User> listAllUser() {
        return userMapper.listAllUser();
    }

    @Override
    public User findById(int uid) {
        return userMapper.findById(uid);
    }

    @Override
    public User findByName(String name) {
        return userMapper.findByName(name);
    }
}
