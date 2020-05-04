package com.controller;

import com.bean.Student;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @description: ValidationController
 * @date: 2020/5/4 16:38
 * @author: Finallap
 * @version: 1.0
 */
@Controller
@RequestMapping(value = "validation")
@Slf4j
public class ValidationController {
    @ResponseBody
    @RequestMapping(value = "student", method = RequestMethod.POST)
    public Student studentValidation(@RequestBody @Validated Student student, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            List<ObjectError> errorList = bindingResult.getAllErrors();
            for (ObjectError error : errorList) {
//                System.out.println(error.getDefaultMessage());
                log.warn(error.getDefaultMessage());
            }
            return new Student();
        }
        return student;
    }
}
