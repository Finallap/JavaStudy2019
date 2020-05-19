package com.service;

import com.entity.Teacher;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @description: TeacherCacheService
 * @date: 2020/5/19 15:08
 * @author: Finallap
 * @version: 1.0
 */
@Slf4j
@Service
public class TeacherCacheService {
    private final List<Teacher> teacherList = new ArrayList<>();

    public TeacherCacheService() {
        init();
    }

    private void init() {
        teacherList.add(new Teacher("101", "Fang"));
        teacherList.add(new Teacher("102", "Finallap"));
        teacherList.add(new Teacher("103", "Yuanrun"));
    }

    @Cacheable(value = "redis_cache", keyGenerator = "customCacheKeyGenerator")
    public Teacher getTeacher(String tid) {
        log.info("----find----" + tid);
        for (Teacher teacher : teacherList) {
            if (teacher.getTid().equals(tid)) {
                return teacher;
            }
        }
        return null;
    }
}
