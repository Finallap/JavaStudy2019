package com.bean;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * @description: Message
 * @date: 2020/5/1 15:24
 * @author: Finallap
 * @version: 1.0
 */
@Getter
@Setter
@ToString
@EqualsAndHashCode(exclude = {})
public class Message {
    String name;
    String text;
}
