package com.controller;

import com.bean.Student;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * @description: StudentController
 * @date: 2020/4/25 22:01
 * @author: Finallap
 * @version: 1.0
 */
@Controller
public class StudentController {
    @RequestMapping(value = "/student", method = RequestMethod.GET)
    public ModelAndView student() {
        return new ModelAndView("jsp/student", "command", new Student(66, "方垣闰", 25));
    }

    @RequestMapping(value = "/addStudent", method = RequestMethod.POST)
    public String addStudent(@ModelAttribute("SpringWeb") Student student, ModelMap modelMap) {
        modelMap.addAttribute("id", student.getId());
        modelMap.addAttribute("name", student.getName());
        modelMap.addAttribute("age", student.getAge());
        return "jsp/result";
    }
}
