package com.promotion.action;


import com.promotion.action.autowire.SpringBeanUtils;
import com.promotion.action.autowire.bean.init.InitBean;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:application.xml"})
public class BeanTest {

    @Test
    public void name() throws Exception {

        ApplicationContext context = SpringBeanUtils.getContext();

        InitBean bean = SpringBeanUtils.getBean("initBean");

        System.out.println(bean);

    }
}
