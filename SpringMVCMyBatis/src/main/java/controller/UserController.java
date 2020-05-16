package controller;

import dao.UserMapper;
import entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @description: UserController
 * @date: 2020/5/16 10:25
 * @author: Finallap
 * @version: 1.0
 */
@Controller
@RequestMapping("user")
public class UserController {
    @Autowired
    private UserMapper userMapper;

    @ResponseBody
    @RequestMapping(value = "listAll", method = RequestMethod.GET)
    List<User> listAllUser() {
        return userMapper.listAllUser();
    }
}
