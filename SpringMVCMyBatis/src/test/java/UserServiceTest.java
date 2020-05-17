import com.entity.User;
import com.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @description: UserServiceTest
 * @date: 2020/5/16 19:50
 * @author: Finallap
 * @version: 1.0
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:config/springmvc-config.xml")
@Transactional
@Rollback
public class UserServiceTest {
    @Autowired
    private UserService userService;

//    使用SpringJUnit4ClassRunner就不用手动的获取Bean了
//    @Before
//    public void before(){
//        ApplicationContext context = new ClassPathXmlApplicationContext("config/springmvc-config.xml");
//        userService = (UserService) context.getBean("userService");
//    }

    @Test
    public void test() {
        User user = new User();
        user.setUid(10);
        user.setUname("fang");
        user.setUsex("man");
        userService.insertUser(user);
        List<User> userList = userService.listAllUser();
        for (User userGet : userList) {
            System.out.println(userGet);
        }
    }
}
