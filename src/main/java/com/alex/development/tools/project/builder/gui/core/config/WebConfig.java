package com.alex.development.tools.project.builder.gui.core.config;

import com.alex.development.tools.project.builder.core.crud.url_view.UrlViewService;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
public class WebConfig extends WebMvcConfigurerAdapter {

    @Autowired
    private UrlViewService urlViewService;

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        Map<String, String> map = this.urlViewService.getMap();
        
        for (Map.Entry<String, String> item : map.entrySet()) {
            String url = item.getKey();
            String view = item.getValue();
            
            registry.addViewController(url)
                    .setViewName("forward:" + view);
        }

        registry.setOrder(Ordered.HIGHEST_PRECEDENCE);
        super.addViewControllers(registry);
    }

}
