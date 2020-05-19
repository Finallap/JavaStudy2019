package redis;

import com.DemoApplication;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.dao.DataAccessException;
import org.springframework.data.redis.core.*;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.concurrent.TimeUnit;

/**
 * @description: RedisTemplateTests
 * @date: 2020/5/18 16:12
 * @author: Finallap
 * @version: 1.0
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = DemoApplication.class)
public class RedisTemplateTests {
    @Resource
    RedisTemplate redisTemplate;

    @Test
    public void stringTYpe() {
        //	改为String序列化方式
        redisTemplate.setKeySerializer(new StringRedisSerializer());
        redisTemplate.setValueSerializer(new StringRedisSerializer());

        //	redis命令：set key value
        redisTemplate.opsForValue().set("age", "19");

        // redis命令：get key
        String age = (String) redisTemplate.opsForValue().get("age");
        System.out.println("-->" + age);

        // redis命令：mset key value key value ...
        Map<String, Object> map = new HashMap<>();
        map.put("key1", "value1");
        map.put("key2", "value2");
        map.put("key3", "value3");
        redisTemplate.opsForValue().multiSet(map);

        // redis命令：mget key key key...
        List<String> keys = new ArrayList<>();
        keys.add("key1");
        keys.add("key2");
        keys.add("key3");
        List values = redisTemplate.opsForValue().multiGet(keys);
        System.out.println("mget -->" + values);

        // redis命令：del key
        Boolean boo = redisTemplate.delete("key1");

        // redis命令：strlen key - 可能会因为序列化的原因造成长度不准
        Long resultLong = redisTemplate.opsForValue().size("age");
        System.out.println("strlen --> " + resultLong);

        // redis命令：getset key value
        String oldValue = (String) redisTemplate.opsForValue().getAndSet("age", "25");
        System.out.println("getset --> " + oldValue);

        // redis命令：getrange key start end - 可能会因为序列化的原因造成长度不准
        String age1 = redisTemplate.opsForValue().get("age", 0, 1);
        System.out.println("getrange --> " + age1);

        // redis命令：append - 可能会因为序列化的原因造成长度不准
        Integer age2 = redisTemplate.opsForValue().append("age", "26");
        System.out.println("append --> " + age2);

        // redis命令：incr key - 自增 - 可能会因为序列化的原因造成长度不准
        Long age3 = redisTemplate.opsForValue().increment("age", 10);
        System.out.println("incr -->" + age3);

        // redis命令：decr key - 自减
        redisTemplate.opsForValue().decrement("age", 10);
        Long decr = redisTemplate.getConnectionFactory().getConnection().decr("age".getBytes());
        System.out.println("decr --> " + decr);
    }

    @Test
    public void hashType() {
        // redis命令：mset key field value
        redisTemplate.opsForHash().put("person", "name", "张三");
        redisTemplate.opsForHash().put("person", "age", 19);

        // redis命令：mget key field
        String value = (String) redisTemplate.opsForHash().get("person", "name");
        System.out.println("mget-->" + value);

        redisTemplate.delete("person");

        // redis命令：hmset key field1 value1 field2 value2 ...
        Map<String, String> map = new HashMap<>();
        map.put("bookname", "Java");
        map.put("price", "100");
        redisTemplate.opsForHash().putAll("book", map);

        // redis命令：hgetall key - field and value
        Map bookmap = redisTemplate.opsForHash().entries("book");
        System.out.println("hgetall-->" + bookmap);

        // redis命令：hkeys key - 展示key对应的所有字段名称
        Set keys = redisTemplate.opsForHash().keys("book");
        System.out.println("hkeys-->" + keys);

        // redis命令：hvals key - 展示key对应的所有字段的值
        List values = redisTemplate.opsForHash().values("book");
        System.out.println("hvals-->" + values);

        // redis命令：hexists key field
        Boolean bool = redisTemplate.opsForHash().hasKey("book", "price");
        System.out.println("hexists-->" + bool);

        redisTemplate.delete("book");
    }

    @Test
    public void listType() {
        redisTemplate.opsForList().leftPushAll("book", "C++", "C", "Java");
        redisTemplate.opsForList().rightPush("book", "Python");

        List<String> list = redisTemplate.opsForList().range("book", 0, redisTemplate.opsForList().size("book") - 1);
        System.out.println(list);

        String book0 = (String) redisTemplate.opsForList().index("book", 0);
        System.out.println("lindex-->" + book0);

        String leftBook = (String) redisTemplate.opsForList().leftPop("book");
        System.out.println("lpop-->" + leftBook);

        String rightBook = (String) redisTemplate.opsForList().rightPop("book");
        System.out.println("rpop-->" + rightBook);

        redisTemplate.opsForList().leftPush("book", "java", "pythod");
        redisTemplate.opsForList().rightPush("book", "java", "jquery");

        list = redisTemplate.opsForList().range("book", 0, redisTemplate.opsForList().size("book") - 1);
        System.out.println(list);

        redisTemplate.opsForList().set("book", 0, "MySQL");

        redisTemplate.opsForList().trim("book", 1, 3);

        list = redisTemplate.opsForList().range("book", 0, redisTemplate.opsForList().size("book") - 1);
        System.out.println(list);

        redisTemplate.delete("book");
    }

    @Test
    public void setType() {
        redisTemplate.opsForSet().add("book", "java", "c++", "python");
        System.out.println(redisTemplate.opsForSet().size("book"));
        System.out.println(redisTemplate.opsForSet().members("book"));
        System.out.println(redisTemplate.opsForSet().pop("book"));//移除并返回集合中的一个随机元素
        System.out.println(redisTemplate.opsForSet().members("book"));
        Cursor<Object> cursor = redisTemplate.opsForSet().scan("book", ScanOptions.scanOptions().build());//返回cursor，遍历set
        while (cursor.hasNext()) {
            System.out.println(cursor.next());
        }
        redisTemplate.delete("book");
    }

    @Test
    public void zsetType() {
        redisTemplate.opsForZSet().add("book", "mysql", 1.5);
        redisTemplate.opsForZSet().add("book", "java", 8.5);
        redisTemplate.opsForZSet().add("book", "html", 14);
        Set set = redisTemplate.opsForZSet().range("book", 0, redisTemplate.opsForZSet().size("book") - 1);
        System.out.println(set);

        ZSetOperations.TypedTuple<Object> objectTypedTuple1 = new DefaultTypedTuple<>("jquery", 13.0);
        ZSetOperations.TypedTuple<Object> objectTypedTuple2 = new DefaultTypedTuple<>("C++", 15.0);
        Set<ZSetOperations.TypedTuple<Object>> tuples = new HashSet<>();
        tuples.add(objectTypedTuple1);
        tuples.add(objectTypedTuple2);
        System.out.println(redisTemplate.opsForZSet().add("book", tuples));
        System.out.println(redisTemplate.opsForZSet().range("book", 0, -1));
        System.out.println(redisTemplate.opsForZSet().rank("book", "mysql"));
        Cursor<ZSetOperations.TypedTuple<Object>> cursor = redisTemplate.opsForZSet().scan("book", ScanOptions.scanOptions().build());
        while (cursor.hasNext()) {
            ZSetOperations.TypedTuple<Object> objectTypedTuple = cursor.next();
            System.out.println(objectTypedTuple.getValue() + ":" + objectTypedTuple.getScore());
        }
        System.out.println(redisTemplate.opsForZSet().range("book", 0, -1));
        System.out.println(redisTemplate.opsForZSet().rangeByScore("book", 0, 10));

        redisTemplate.delete("book");
    }

    @Test
    public void transcation() {
        List results = (List) redisTemplate.execute(new SessionCallback() {
            @Override
            public Object execute(RedisOperations redisOperations) throws DataAccessException {
                //开启事务
                redisOperations.multi();

                //进行操作
                redisOperations.opsForValue().set("name", "Finallap");
                redisOperations.opsForValue().get("name");
                //提交事务
                List list = redisOperations.exec();
                return list;
            }
        });
        System.out.println("-->" + results);
    }

    @Test
    public void pipeline() {
        long begin = System.currentTimeMillis();
        redisTemplate.executePipelined(new SessionCallback() {
            @Override
            public Object execute(RedisOperations redisOperations) throws DataAccessException {
                for (int i = 0; i < 100000; i++) {
                    redisOperations.opsForValue().set("key" + i, "value" + i);
                    redisOperations.opsForValue().get("key" + i);
                    redisOperations.delete("key" + i);
                }
                return null;
            }
        });
        long end = System.currentTimeMillis();
        System.out.println("耗时：" + (end - begin));
    }

    @Test
    public void expire() throws ParseException {
        redisTemplate.opsForValue().set("name", "fang");
        //设置超时时间
        redisTemplate.expire("name", 20, TimeUnit.SECONDS);
        //移除超时时间，永久不过期
        redisTemplate.persist("name");
        //获得还能活多久
        long pttl = redisTemplate.getExpire("name");
        System.out.println(pttl);
        //设置超时时间到指定的时间
        String time = "2020-05-18 20:00:00";
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = simpleDateFormat.parse(time);
        redisTemplate.expireAt("name", date);

        pttl = redisTemplate.getExpire("name");
        System.out.println(pttl);
    }
}
