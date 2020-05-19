package com.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

/**
 * @description: RdisSessionController
 * @date: 2020/5/19 16:51
 * @author: Finallap
 * @version: 1.0
 */
@RestController
@RequestMapping("redisSession")
public class RedisSessionController {
    @RequestMapping("set")
    public Map<String, Object> setSession(HttpServletRequest request) {
        Map<String, Object> map = new HashMap<>();
        request.getSession().setAttribute("request Url", request.getRequestURL());
        map.put("request url", request.getRequestURI());
        return map;
    }

    @RequestMapping("get")
    public Map<String, Object> getSession(HttpServletRequest request) {
        Map<String, Object> map = new HashMap<>();
        map.put("sessionIdUrl", request.getSession().getAttribute("request Url"));
        map.put("sessionId", request.getSession().getId());
        return map;
    }
}
