package com.controller;

import com.Service.UserService;
import com.bean.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

/**
 * @description: UserRestController
 * @date: 2020/5/7 16:46
 * @author: Finallap
 * @version: 1.0
 */
@RestController
@RequestMapping("user")
public class UserRestController {
    @Autowired
    UserService userService;

    //-------------------Retrieve All Users--------------------------------------------------------
    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<User>> listAllUser(){
        List<User> users = userService.findAllUser();
        if (users.isEmpty()){
            return new ResponseEntity<List<User>>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<List<User>>(users,HttpStatus.OK);
    }

    //-------------------Retrieve Single User--------------------------------------------------------
    @RequestMapping(value = "{id}",method = RequestMethod.GET)
    public ResponseEntity<User> getUser(@PathVariable long id){
        User user = userService.findById(id);
        if (user==null){
            return new ResponseEntity<User>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<User>(user,HttpStatus.OK);
    }

    //-------------------Create a User--------------------------------------------------------
    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<Void> createUser(@RequestBody User user, UriComponentsBuilder ucBuilder){
        System.out.println("Created user:"+user.getName());
        if (userService.isUserExist(user)){
            System.out.println("A User with name " + user.getName() + " already exist");
            return new ResponseEntity<Void>(HttpStatus.CONFLICT);
        }
        userService.saveUser(user);
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(ucBuilder.path("/user/{id}").buildAndExpand(user.getId()).toUri());
        return new ResponseEntity<Void>(headers,HttpStatus.CREATED);
    }

    //------------------- Update a User --------------------------------------------------------
    @RequestMapping(value = "{id}",method = RequestMethod.PUT)
    public ResponseEntity<User> updateUser(@RequestBody User user,@PathVariable long id){
        System.out.println("Updating User " + id);

        User currUser = userService.findById(id);
        if (currUser==null){
            return new ResponseEntity<User>(HttpStatus.NOT_FOUND);
        }
        currUser.setName(user.getName());
        currUser.setAge(user.getAge());
        currUser.setSalary(user.getSalary());

        userService.updateUser(user);
        return new ResponseEntity<User>(user,HttpStatus.OK);
    }

    //------------------- Delete a User --------------------------------------------------------
    @RequestMapping(value = "{id}",method = RequestMethod.DELETE)
    public ResponseEntity<User> deleteUser(@PathVariable long id){
        System.out.println("Fetching & Deleting User with id " + id);

        if (userService.findById(id)==null){
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
        userService.deleteUserById(id);
        return new ResponseEntity<User>(HttpStatus.NO_CONTENT);
    }

    //------------------- Delete All Users --------------------------------------------------------
    @RequestMapping(method = RequestMethod.DELETE)
    public ResponseEntity<User> deleteAllUser(){
        System.out.println("Deleting All Users");

        userService.deleteAllUser();
        return new ResponseEntity<User>(HttpStatus.NO_CONTENT);
    }

}
