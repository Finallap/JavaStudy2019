package cache;

import com.entity.Teacher;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Map;

/**
 * @description: ObjectMapperTests
 * @date: 2020/5/20 12:28
 * @author: Finallap
 * @version: 1.0
 */
public class ObjectMapperTests {
    private final ObjectMapper mapper = new ObjectMapper();

    @Before
    public void before() {
        // 转换为格式化的json
        mapper.enable(SerializationFeature.INDENT_OUTPUT);
        // 如果json中有新增的字段并且是实体类类中不存在的，不报错
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        //取消时间的转化格式,默认是时间戳,可以取消,同时需要设置要表现的时间格式
        mapper.setDateFormat(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"));
        mapper.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false);
    }

    @Test
    public void testObject() throws IOException {
        Teacher teacher = new Teacher("100", "Fang");

        String jsonStr = mapper.writeValueAsString(teacher);
        System.out.println(jsonStr);

        byte[] values = mapper.writeValueAsBytes(teacher);

        Teacher teacher1 = mapper.readValue(jsonStr, Teacher.class);
        System.out.println(teacher1);

        Teacher teacher2 = mapper.readValue(values, Teacher.class);
        System.out.println(teacher2);
    }

    @Test
    public void testMap() {
        Map<String, Teacher> map = new HashMap<>();
        map.put("100", new Teacher("100", "fang"));
        map.put("101", new Teacher("101", "Fianllap"));
        map.put("102", new Teacher("102", "Yuanrun"));

        try {
            String jsonStr = mapper.writeValueAsString(map);
            System.out.println("Map转为字符串：" + jsonStr);
            try {
                Map<String, Object> testMapDes = mapper.readValue(jsonStr, Map.class);
                System.out.println("字符串转Map：" + testMapDes);
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
    }
}
