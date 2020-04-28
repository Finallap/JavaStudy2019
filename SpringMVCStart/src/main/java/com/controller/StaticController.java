package com.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @description: StaticController
 * @date: 2020/4/26 11:13
 * @author: Finallap
 * @version: 1.0
 */
@Controller
public class StaticController {
    @RequestMapping("/staticIndex")
    public String staticIndex() {
        return "staticIndex";
    }

    @RequestMapping("/staticPage")
    public String redirect() {
        return "redirect:/html/final.html";
    }
}
