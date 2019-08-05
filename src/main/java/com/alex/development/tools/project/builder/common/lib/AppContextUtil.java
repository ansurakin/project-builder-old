package com.alex.development.tools.project.builder.common.lib;

import lombok.extern.log4j.Log4j;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

@Log4j
@Component
public class AppContextUtil implements ApplicationContextAware{
    
    private static ApplicationContext context;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        context = applicationContext;
    }
    
    public static ApplicationContext getApplicationContext() {
        return context;
    }
    
    public static <T> T getBean(Class<T> beanClass) {
        if(context == null){
            throw new RuntimeException("Контекст ещё не успел проинициализироваться");
        }
        return context.getBean(beanClass);
    }
    
    public static Object getBean(String beanName) {
        if(context == null){
            throw new RuntimeException("Контекст ещё не успел проинициализироваться");
        }
        return context.getBean(beanName);
    }
    
    public static String[] getBeanNames() {   
        if(context == null){
            throw new RuntimeException("Контекст ещё не успел проинициализироваться");
        }
        return context.getBeanDefinitionNames();
    }

}
