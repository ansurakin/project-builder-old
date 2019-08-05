package com.alex.development.tools.project.builder.core.crud.settings;

import com.alex.development.tools.project.builder.common.crud.BaseService;
import com.alex.development.tools.project.builder.model.common.Constant;
import com.alex.development.tools.project.builder.model.entity.Settings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SettingsService extends BaseService<Settings, Long>{
    
    private static final String DEFAULT_SETTINGS_NAME = Constant.MAIN;

    @Autowired
    private SettingsRepository repository;
    
    public Settings getCurrentSettings(){
        return this.repository.findByName(DEFAULT_SETTINGS_NAME);
    }

    public Settings findByName(String name) {
        return this.repository.findByName(name);
    }

}
