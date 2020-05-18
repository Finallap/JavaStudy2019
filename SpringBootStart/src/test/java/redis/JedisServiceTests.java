package redis;

import com.DemoApplication;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.service.JedisService;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * @description: JedisServiceTests
 * @date: 2020/5/18 13:14
 * @author: Finallap
 * @version: 1.0
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = {DemoApplication.class})
public class JedisServiceTests {

    private final JSONObject json = new JSONObject();

    @Resource
    private JedisService jedisService;

    @Test
    public void contextLoads() throws Exception {
    }


    /**
     * 插入字符串
     */
    @Test
    public void setString() {
        jedisService.set("redis_string_test", "springboot redis test");
    }

    /**
     * 获取字符串
     */
    @Test
    public void getString() {
        String result = jedisService.get("redis_string_test");
        System.out.println(result);
    }

    /**
     * 插入对象
     */
    @Test
    public void setObject() {
        Person person = new Person("person", "male");
        jedisService.set("redis_obj_test", JSON.toJSONString(person));
    }

    /**
     * 获取对象
     */
    @Test
    public void getObject() {
        String result = jedisService.get("redis_obj_test");
        System.out.println(result);
//        Person person = json.parseObject(result, Person.class);
//        System.out.println(json.toJSONString(person));
    }

    /**
     * 插入对象List
     */
    @Test
    public void setList() {
        Person person1 = new Person("person1", "male");
        Person person2 = new Person("person2", "female");
        Person person3 = new Person("person3", "male");
        List<Person> list = new ArrayList<>();
        list.add(person1);
        list.add(person2);
        list.add(person3);
        jedisService.set("redis_list_test", JSON.toJSONString(list));
    }

    /**
     * 获取list
     */
    @Test
    public void getList() {
        String result = jedisService.get("redis_list_test");
        List<String> list = JSON.parseArray(result, String.class);
        System.out.println(list);
    }

    @Test
    public void remove() {
        jedisService.remove("redis_test");
    }

}

@Data
@AllArgsConstructor
class Person {
    private String name;
    private String sex;
}
