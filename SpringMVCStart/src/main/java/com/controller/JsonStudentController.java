package com.controller;

import com.bean.Student;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * @description: JsonStudentController
 * @date: 2020/4/28 20:48
 * @author: Finallap
 * @version: 1.0
 */
@Controller
@RequestMapping("jsonStudent")
public class JsonStudentController {
    @RequestMapping(value = "get/{name}", method = RequestMethod.GET)
    @ResponseBody
    public Student getJsonStudent(@PathVariable String name) {
        Student student = new Student();
        student.setName(name);
        student.setAge(24);
        student.setId(12);
        return student;
    }

    //用@RequestBody可以将输入的json映射成为对应对象
    @ResponseBody
    @RequestMapping(value = "jsonSource", method = RequestMethod.POST)
    public Student reflectStudent(@RequestBody Student student) {
        return student;
    }
}
