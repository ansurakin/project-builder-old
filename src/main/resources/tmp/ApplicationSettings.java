package com.alex.development.tools.project.builder.bean;

import lombok.Builder;

@Builder
public class ApplicationSettings {
    
    private String host;
    
    private Integer port;
    
    private Boolean useHttps;
    
    private Long connectTimeout;
    
    private Long readTimeout;
    
    private String username;
    
    private String password;

    public ApplicationSettings getDefaultConfig() {
        ApplicationSettings result = new ApplicationSettingsBuilder()
                .host("api.server.com")
                .port(443)
                .useHttps(true)
                .connectTimeout(15_000L)
                .readTimeout(5_000L)
                .username("myusername")
                .password("myPassword")
                .build();

        return result;
    }

}
