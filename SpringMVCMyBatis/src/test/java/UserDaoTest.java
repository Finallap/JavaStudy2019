import dao.UserMapper;
import entity.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.Reader;
import java.util.List;

/**
 * @description: UserDaoTest
 * @date: 2020/5/15 15:47
 * @author: Finallap
 * @version: 1.0
 */
public class UserDaoTest {
    @Test
    public void shouldAnswerWithTrue() {
        try {
            //使用MyBatis提供的Resources类加载mybatis的配置文件
            Reader reader = Resources.getResourceAsReader("config/mybatis-conf.xml");
            //构建sqlSession的工厂
            SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(reader);

            SqlSession session = sessionFactory.openSession();
            UserMapper userMapper = session.getMapper(UserMapper.class);

            User user = new User();
            user.setUid(1);
            user.setUname("Java");
            user.setUsex("female");

            userMapper.insertUser(user);

            List<User> userList = userMapper.listAllUser();
            for (User userSelect : userList) {
                System.out.println(userSelect.toString());
            }

            userMapper.deleteUserByUid(1);

            userList = userMapper.listAllUser();
            for (User userSelect : userList) {
                System.out.println(userSelect.toString());
            }

            session.commit();
            session.close();
        } catch (IOException exception) {
            exception.printStackTrace();
        }
    }
}
