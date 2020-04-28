package com.controller;

import com.bean.Student;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
        return new ModelAndView("student", "command", student);
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
        modelMap.addAttribute("favoriteNumber", student.getFavoriteNumber());
        modelMap.addAttribute("country", student.getCountry());
        return "result";
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

    @ModelAttribute("numberList")
    public List<Integer> getNumberList() {
        List<Integer> numberList = new ArrayList<>();
        for (int i = 1; i <= 9; i++) {
            numberList.add(i);
        }
        return numberList;
    }

    @ModelAttribute("countryList")
    public Map<String, String> getCountryList() {
        HashMap<String, String> countryList = new HashMap<>(8);
        countryList.put("US", "United States");
        countryList.put("CH", "China");
        countryList.put("SG", "Singapore");
        countryList.put("MY", "Malaysia");
        return countryList;
    }
}
