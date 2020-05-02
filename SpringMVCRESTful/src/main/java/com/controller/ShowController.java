package com.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * @description: ShowController
 * @date: 2020/5/2 14:06
 * @author: Finallap
 * @version: 1.0
 */
@Controller
public class ShowController {
    @RequestMapping(value = "index")
    public ModelAndView showIndex(){
        ModelAndView modelAndView = new ModelAndView("show");
        modelAndView.addObject("title","Finallap");
        modelAndView.addObject("message","Hello Finallap!");
        return modelAndView;
    }
}
