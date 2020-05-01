package com.controller;

import com.bean.Message;
import com.bean.XmlMessage;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @description: HelloWorldRestController
 * @date: 2020/5/1 15:26
 * @author: Finallap
 * @version: 1.0
 */
@RestController
public class HelloWorldRestController {
    @RequestMapping(value = "hello/{player}", method = RequestMethod.GET)
    public Message message(@PathVariable String player) {
        Message message = new Message();
        message.setName(player);
        message.setText("Hello " + player);
        return message;
    }

    @RequestMapping(value = "helloXml/{name}/{message}")
    public XmlMessage xmlElement(@PathVariable String name, @PathVariable String message) {
        XmlMessage xmlMessage = new XmlMessage();
        xmlMessage.setName(name);
        xmlMessage.setMessage(message);
        return xmlMessage;
    }
}
