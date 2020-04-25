package com.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.Map;

/**
 * @description: AnnotationHandler
 * @date: 2020/4/25 18:33
 * @author: Finallap
 * @version: 1.0
 */
@Controller
public class AnnotationHandler {
    @RequestMapping("/ModelAndViewTest")
    public ModelAndView modelAndViewTest() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("name", "Jack");
        modelAndView.setViewName("show");
        return modelAndView;
    }

    @RequestMapping("/modelTest")
    public String modelTest(Model model) {
        model.addAttribute("name", "Lucy");
        return "show";
    }

    @RequestMapping("/mapTest")
    public String mapTest(Map<String, String> map) {
        map.put("name", "Lilei");
        return "show";
    }
}
