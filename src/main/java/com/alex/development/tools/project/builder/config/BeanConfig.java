package com.alex.development.tools.project.builder.config;

import com.alex.development.tools.project.builder.core.crud.settings.SettingsService;
import com.alex.development.tools.project.builder.model.entity.Settings;
import com.alex.development.tools.project.builder.model.project.Project;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.web.context.annotation.ApplicationScope;
import org.springframework.web.context.annotation.SessionScope;

@Configuration
public class BeanConfig {

    @Autowired
    private SettingsService settingsService;

    @Primary
    @ApplicationScope
    @Bean("appSettings")
    public Settings getApplicationSettings() {
        return this.settingsService.getCurrentSettings();
    }

    @Primary
    @SessionScope
    @Bean("project")
    public Project getProject() {
        return new Project();
    }

}
//@Configuration
//public class AppContext {
//    @Bean(initMethod = "setup", destroyMethod = "cleanup")
//    @Scope("prototype")
//    public Course course() {
//        Course course = new Course();
//        course.setModule(module());
//        return course;
//    }
//    ...
//}

//
//@Builder
//public class ApiClientConfiguration {
// 
//    // ... everything else remains the same
// 
//}
//Leaving the class definition above as such (no declare constructors nor setters + @Builder) we can end up using it as:
//
//
//ApiClientConfiguration config = 
//    new ApiClientConfigurationBuilder()
//        .host("api.server.com")
//        .port(443)
//        .useHttps(true)
//        .connectTimeout(15_000L)
//        .readTimeout(5_000L)
//        .username("myusername")
//        .password("secret")
//    .build();
