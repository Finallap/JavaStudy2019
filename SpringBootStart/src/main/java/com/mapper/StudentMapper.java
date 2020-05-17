package com.mapper;

import com.entity.Student;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentMapper {
    int insert(Student record);

    int insertSelective(Student record);

    Student findBySid(String sid);

    Student findBySname(String sname);

    List<Student> listAll();
}