package com.alex.development.tools.project.builder.service;

import com.alex.development.tools.project.builder.core.crud.settings.SettingsService;
import com.alex.development.tools.project.builder.core.crud.template.TemplateService;
import com.alex.development.tools.project.builder.model.project.Project;
import java.io.IOException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class PomService {
    
    @Autowired
    private SettingsService settingsService;
    
    @Autowired
    private TemplateService templateService;
    
    public String generate(Project project) throws IOException{
        
        return null;
    }
    
}
