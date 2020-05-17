package com.controller;

import com.entity.Student;
import com.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @description: StudentController
 * @date: 2020/5/17 15:30
 * @author: Finallap
 * @version: 1.0
 */
@RestController
@RequestMapping("student")
public class StudentController {
    @Autowired
    StudentService studentService;

    @RequestMapping(value = "{sid}", method = RequestMethod.GET)
    public ResponseEntity<Student> findBySid(@PathVariable String sid) {
        Student student = studentService.findBySid(sid);
        if (student == null) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<Student>(student, HttpStatus.OK);
    }

    @RequestMapping(value = "listAll", method = RequestMethod.GET)
    public ResponseEntity<List<Student>> listAll() {
        List<Student> list = studentService.listAll();
        if (list.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<List<Student>>(list, HttpStatus.OK);
    }
}
