package com.alex.development.tools.project.builder.gui.core.config;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.stereotype.Component;
import com.alex.development.tools.project.builder.gui.core.config.scope.ScopeName;
import com.alex.development.tools.project.builder.gui.core.config.scope.ViewScope;

/**
 * BeanPostProcessor that registeres the view scope.
 * 
 */
@Component
public class CustomScopeRegisteringBeanFactoryPostProcessor implements BeanFactoryPostProcessor {

    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
        beanFactory.registerScope(ScopeName.VIEW, new ViewScope());
    }
}
