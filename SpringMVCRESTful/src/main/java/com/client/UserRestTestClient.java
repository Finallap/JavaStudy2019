package com.client;

import com.bean.User;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.util.LinkedHashMap;
import java.util.List;

/**
 * @description: UserRestTestClient
 * @date: 2020/5/7 18:31
 * @author: Finallap
 * @version: 1.0
 */
public class UserRestTestClient {
    public static final String REST_SERVICE_URI = "http://localhost:8080/SpringMVCRESTful_war_exploded";

    @SuppressWarnings("unchecked")
    private static void listAllUsers() {
        System.out.println("Testing listAllUsers API-----------");

        RestTemplate restTemplate = new RestTemplate();
        List<LinkedHashMap<String, Object>> userMap = restTemplate.getForObject(REST_SERVICE_URI + "/user", List.class);
        if (userMap != null) {
            for (LinkedHashMap<String, Object> map : userMap) {
                System.out.println("User : id=" + map.get("id") + ", Name=" + map.get("name") + ", Age=" + map.get("age") + ", Salary=" + map.get("salary"));
            }
        } else {
            System.out.println("No user exist----------------=");
        }
    }

    private static void getUser(long id) {
        System.out.println("Testing getUser API----------");
        RestTemplate restTemplate = new RestTemplate();
        User user = restTemplate.getForObject(REST_SERVICE_URI + "/user/" + id, User.class);
        System.out.println(user);
    }

    private static void createUser() {
        System.out.println("Testing createUser API----------");
        RestTemplate restTemplate = new RestTemplate();
        User user = new User(0, "Sarah", 51, 134);
        URI uri = restTemplate.postForLocation(REST_SERVICE_URI + "/user", user, User.class);
        System.out.println("Location : " + uri.toASCIIString());
    }

    private static void updateUser() {
        RestTemplate restTemplate = new RestTemplate();
        User user = new User(1, "Tomy", 33, 70000);
        restTemplate.put(REST_SERVICE_URI + "/user/1", user);
        System.out.println(user);
    }

    private static void deleteUser(long id) {
        System.out.println("Testing delete User API----------");
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.delete(REST_SERVICE_URI + "/user/" + id);
    }

    private static void deleteAllUsers() {
        System.out.println("Testing all delete Users API----------");
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.delete(REST_SERVICE_URI + "/user");
    }

    public static void main(String[] args) {
        listAllUsers();
        getUser(1);
        createUser();
        listAllUsers();
        updateUser();
        listAllUsers();
        deleteUser(3);
        listAllUsers();
        deleteAllUsers();
        listAllUsers();
    }
}
