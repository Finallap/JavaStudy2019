package com.controller;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

/**
 * @description: com.controller.MyHandler
 * @date: 2020/4/25 17:11
 * @author: Finallap
 * @version: 1.0
 */
public class MyHandler implements Controller {

    @Override
    public ModelAndView handleRequest(javax.servlet.http.HttpServletRequest httpServletRequest, javax.servlet.http.HttpServletResponse httpServletResponse) throws Exception {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("name", "Finallap");
        modelAndView.setViewName("show");
        return modelAndView;
    }
}
