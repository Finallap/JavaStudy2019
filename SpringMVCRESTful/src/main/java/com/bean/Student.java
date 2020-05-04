package com.bean;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.*;

/**
 * @description: Student
 * @date: 2020/5/4 16:27
 * @author: Finallap
 * @version: 1.0
 */
@Getter
@Setter
public class Student {
    @NotBlank(message = "姓名不能为空")
    private String name;

    @Size(min = 6, max = 10, message = "密码长度为6-10位")
    @NotBlank(message = "密码不能为空")
    private String password;

    @Max(value = 60, message = "年龄最大为60")
    @Min(value = 0, message = "年龄最小为0")
    private int age;

    @Email(message = "Email格式不正确")
    @NotBlank(message = "Email不能为空")
    private String email;
}
