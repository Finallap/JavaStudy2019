package cache;

import com.DemoApplication;
import com.service.TeacherCacheService;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @description: CacheTests
 * @date: 2020/5/19 15:17
 * @author: Finallap
 * @version: 1.0
 */
@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest(classes = DemoApplication.class)
public class CacheTests {

    @Autowired
    TeacherCacheService teacherCacheService;

    @Test
    public void teacherCacheTest() {
        log.info(teacherCacheService + "");
        log.info("" + teacherCacheService.getTeacher("101"));
        log.info("" + teacherCacheService.getTeacher("102"));
        log.info("" + teacherCacheService.getTeacher("103"));
        //后面3个打印 取缓存数据
        log.info("" + teacherCacheService.getTeacher("101"));
        log.info("" + teacherCacheService.getTeacher("102"));
        log.info("" + teacherCacheService.getTeacher("103"));
    }
}
