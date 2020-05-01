package com.bean;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * @description: XmlMessage
 * @date: 2020/5/1 17:51
 * @author: Finallap
 * @version: 1.0
 */
@XmlRootElement
public class XmlMessage {
    private String name;
    private String message;

    @XmlElement
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @XmlElement
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
