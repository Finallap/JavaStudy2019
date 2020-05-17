package com.mapper;

import com.entity.Course;

public interface CourseMapper {
    int insert(Course record);

    int insertSelective(Course record);
}