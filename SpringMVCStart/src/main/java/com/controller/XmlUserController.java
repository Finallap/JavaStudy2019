package com.controller;

import com.bean.XmlUser;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @description: XmlUserController
 * @date: 2020/4/28 20:09
 * @author: Finallap
 * @version: 1.0
 */
@Controller
@RequestMapping("user")
public class XmlUserController {
    @ResponseBody
    @RequestMapping(value = "{userName}", method = RequestMethod.GET)
    public XmlUser getXmlUser(@PathVariable String userName) {
        XmlUser xmlUser = new XmlUser();
        xmlUser.setId(15);
        xmlUser.setName(userName);
        return xmlUser;
    }
}
