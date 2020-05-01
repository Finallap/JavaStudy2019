package com.configuration;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

/**
 * @description: HelloWorldConfiguration
 * @date: 2020/5/1 15:29
 * @author: Finallap
 * @version: 1.0
 */
@Configuration
@EnableWebMvc
@ComponentScan(basePackages = "com.controller")
public class HelloWorldRestConfiguration extends WebMvcConfigurationSupport {

}
