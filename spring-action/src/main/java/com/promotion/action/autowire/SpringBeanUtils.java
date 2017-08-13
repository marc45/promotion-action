package com.promotion.action.autowire;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

public class SpringBeanUtils implements ApplicationContextAware {

    private static ApplicationContext context;


    public void setApplicationContext(ApplicationContext context) throws BeansException {
        this.context = context;
    }

    public static ApplicationContext getContext() {
        return context;
    }

    public static <T> T getBean(String name) {

        if (null != context) {
            return (T) context.getBean(name);
        }
        return null;
    }

    public static <T> T getBean(Class<T> clz) {
        if (null != clz) {
            return context.getBean(clz);
        }
        return null;
    }


}
