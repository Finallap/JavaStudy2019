package com.bean;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * @description: XMLUser
 * @date: 2020/4/28 20:07
 * @author: Finallap
 * @version: 1.0
 */
@XmlRootElement(name = "user")
public class XmlUser {
    private int id;
    private String name;

    public String getName() {
        return name;
    }

    @XmlElement
    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    @XmlElement
    public void setId(int id) {
        this.id = id;
    }
}
