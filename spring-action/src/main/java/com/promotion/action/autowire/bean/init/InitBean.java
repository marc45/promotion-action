package com.promotion.action.autowire.bean.init;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

public class InitBean implements BeanNameAware, ApplicationContextAware {


    public void setBeanName(String s) {
        System.out.println("------> bean id=" + s);
    }


    public void setApplicationContext(ApplicationContext context) throws BeansException {
        System.out.println("---context---");
    }
}
