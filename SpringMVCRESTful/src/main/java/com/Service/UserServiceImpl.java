package com.Service;

import com.bean.User;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

/**
 * @description: UserServiceImpl
 * @date: 2020/5/7 15:58
 * @author: Finallap
 * @version: 1.0
 */
@Service("userService")
@Transactional
public class UserServiceImpl implements UserService{
    private static AtomicLong counter = new AtomicLong();
    private static List<User> users;
    static {
        users = populateDummyUsers();
    }

    private static List<User> populateDummyUsers(){
        List<User> users = new ArrayList<User>();
        users.add(new User(counter.incrementAndGet(),"Sam",30, 70000));
        users.add(new User(counter.incrementAndGet(),"Tom",40, 50000));
        users.add(new User(counter.incrementAndGet(),"Jerome",45, 30000));
        users.add(new User(counter.incrementAndGet(),"Silvia",50, 40000));
        return users ;
    }
    public User findById(long id) {
        for (User user:users){
            if (user.getId() == id) {
                return user;
            }
        }
        return null;
    }

    public User findByName(String name) {
        for (User user:users){
            if (user.getName() == name) {
                return user;
            }
        }
        return null;
    }

    public void saveUser(User user) {
        user.setId(counter.incrementAndGet());
        users.add(user);
    }

    public void updateUser(User user) {
        int index = users.indexOf(user);
        users.set(index,user);
    }

    public void deleteUserById(long id) {
        Iterator<User> iterator = users.iterator();
        while (iterator.hasNext()){
            User currUser = iterator.next();
            if (currUser.getId() == id){
                iterator.remove();
            }
        }
    }

    public List<User> findAllUser() {
        return users;
    }

    public void deleteAllUser() {
        users.clear();
    }

    public boolean isUserExist(User user) {
        return findByName(user.getName())!=null;
    }
}
