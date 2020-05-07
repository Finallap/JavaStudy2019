package com.configuration;

import com.filter.CorsFilter;
import com.filter.EncodingFilter;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import javax.servlet.Filter;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;

/**
 * @description: com.configuration.HelloWorldRestInitialization
 * @date: 2020/5/1 15:36
 * @author: Finallap
 * @version: 1.0
 */
public class HelloWorldRestInitialization extends AbstractAnnotationConfigDispatcherServletInitializer {

    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class[]{HelloWorldRestConfiguration.class};
    }

    @Override
    protected Class<?>[] getServletConfigClasses() {
        return null;
    }

    @Override
    protected String[] getServletMappings() {
        return new String[]{"/"};
    }

    @Override
    public void onStartup(ServletContext servletContext) throws ServletException {
        servletContext.addFilter("encodingFilter", EncodingFilter.class)
                .addMappingForUrlPatterns(null, false, "/*");
        //必须调用回父类的onStartup方法，否则不会初始化DispatcherServlet
        super.onStartup(servletContext);
    }

    @Override
    protected Filter[] getServletFilters() {
        Filter[] filters = {new CorsFilter()};
        return filters;
    }
}
