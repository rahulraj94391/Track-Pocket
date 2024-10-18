package com.org.trackpocket;

import com.org.trackpocket.Configuration.AppConfig;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class MyApplicationInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {
    @Override
    protected Class<?>[] getRootConfigClasses() {
        System.out.println("Getting getRootConfigClasses");
        return null;
    }

    @Override
    protected Class<?>[] getServletConfigClasses() {
        System.out.println("Getting getServletConfigClasses");
        return new Class[]{AppConfig.class};
    }

    @Override
    protected String[] getServletMappings() {
        System.out.println("Getting getServletMappings");
        return new String[]{"/"};
    }
}
