package com.service;

import com.entity.Student;
import com.mapper.StudentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @description: StudentService
 * @date: 2020/5/17 15:22
 * @author: Finallap
 * @version: 1.0
 */
@Service
public class StudentService {
    @Autowired
    private StudentMapper studentMapper;

    public List<Student> listAll() {
        return studentMapper.listAll();
    }

    public Student findBySid(String sid) {
        return studentMapper.findBySid(sid);
    }

    public Student findBySname(String sname) {
        return studentMapper.findBySid(sname);
    }
}
