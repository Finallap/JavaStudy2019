package com.controller;

import com.bean.Student;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

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
        Student student = new Student();
        student.setFavoriteFramework(new String[]{"Spring MVC", "Struts 2"});
        student.setGender("M");
        return new ModelAndView("jsp/student", "command", student);
    }

    @RequestMapping(value = "/addStudent", method = RequestMethod.POST)
    public String addStudent(@ModelAttribute("SpringWeb") Student student, ModelMap modelMap) {
        modelMap.addAttribute("id", student.getId());
        modelMap.addAttribute("name", student.getName());
        modelMap.addAttribute("age", student.getAge());
        modelMap.addAttribute("password", student.getPassword());
        modelMap.addAttribute("receivePaper", student.isReceivePaper());
        modelMap.addAttribute("favoriteFramework", student.getFavoriteFramework());
        modelMap.addAttribute("gender", student.getGender());
        return "jsp/result";
    }

    @ModelAttribute("webFrameworkList")
    public List<String> getWebFrameworkList() {
        List<String> webFrameworkList = new ArrayList<String>();
        webFrameworkList.add("Spring MVC");
        webFrameworkList.add("Spring Boot");
        webFrameworkList.add("Struts 2");
        webFrameworkList.add("Apache Hadoop");
        return webFrameworkList;
    }
}
