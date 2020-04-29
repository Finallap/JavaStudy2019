package com.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.Map;

/**
 * @description: UserPdfController
 * @date: 2020/4/29 18:46
 * @author: Finallap
 * @version: 1.0
 */
@Controller
public class UserPdfController {
    @RequestMapping(value = "userPdf", method = RequestMethod.GET)
    public ModelAndView userPdfHandler() {
        //user data
        Map<String, String> userData = new HashMap<String, String>();
        userData.put("100", "Xiao.Lu");
        userData.put("102", "User 102");
        userData.put("301", "User 301");
        userData.put("400", "User 400");
        return new ModelAndView("userSummary", "userData", userData);
    }
}
