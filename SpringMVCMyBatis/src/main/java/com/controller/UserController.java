package com.controller;

import com.entity.User;
import com.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

/**
 * @description: UserController
 * @date: 2020/5/16 10:25
 * @author: Finallap
 * @version: 1.0
 */
@RestController
@RequestMapping("user")
public class UserController {
    @Autowired
    private UserService userService;

    @RequestMapping(value = "listAll", method = RequestMethod.GET)
    public ResponseEntity<List<User>> listAllUser() {
        List<User> userList = userService.listAllUser();
        if (userList.isEmpty()) {
            return new ResponseEntity<List<User>>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<List<User>>(userList, HttpStatus.OK);
    }

    @RequestMapping(value = "{uid}", method = RequestMethod.GET)
    public ResponseEntity<User> findById(@PathVariable int uid) {
        User user = userService.findById(uid);
        if (user == null) {
            return new ResponseEntity<User>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<User>(user, HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<Void> createUser(@RequestBody User user, UriComponentsBuilder uriComponentsBuilder) {
        System.out.println("Created user:" + user.getUname());
        if (userService.findById(user.getUid()) != null) {
            System.out.println("A User with id " + user.getUid() + " already exist");
            return new ResponseEntity<Void>(HttpStatus.CONFLICT);
        }
        userService.insertUser(user);
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(uriComponentsBuilder.path("/user/{id}").buildAndExpand(user.getUid()).toUri());
        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
    }

    @RequestMapping(value = "{uid}", method = RequestMethod.PUT)
    public ResponseEntity<User> updateUser(@PathVariable int uid, @RequestBody User user) {
        if (uid != user.getUid()) {
            return new ResponseEntity<User>(HttpStatus.CONFLICT);
        }
        userService.updateUser(user);
        return new ResponseEntity<User>(user, HttpStatus.OK);
    }

    @RequestMapping(value = "{uid}", method = RequestMethod.DELETE)
    public ResponseEntity<Void> deleteUserById(@PathVariable int uid) {
        User user = userService.findById(uid);
        if (user == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        userService.deleteUserById(uid);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
