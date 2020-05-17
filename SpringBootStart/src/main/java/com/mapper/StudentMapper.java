package com.mapper;

import com.entity.Student;

public interface StudentMapper {
    int insert(Student record);

    int insertSelective(Student record);
}