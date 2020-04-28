package com.controller;

import com.bean.RssMessage;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @description: RssController
 * @date: 2020/4/28 17:53
 * @author: Finallap
 * @version: 1.0
 */
@Controller
public class RssController {
    @RequestMapping(value = "rssFeed", method = RequestMethod.GET)
    public ModelAndView getFeedInRss() {
        List<RssMessage> items = new ArrayList<RssMessage>();

        RssMessage content = new RssMessage();
        content.setTitle("Spring教程");
        content.setUrl("http://www.yiibai/spring");
        content.setSummary("Spring tutorial summary...");
        content.setCreatedDate(new Date());
        items.add(content);

        RssMessage content2 = new RssMessage();
        content2.setTitle("Spring MVC教程");
        content2.setUrl("http://www.yiibai/spring_mvc");
        content2.setSummary("Spring MVC tutorial summary...");
        content2.setCreatedDate(new Date());
        items.add(content2);

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("rssViewer");
        modelAndView.addObject("feedContent", items);

        return modelAndView;
    }
}
