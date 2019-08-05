package com.alex.development.tools.project.builder.core.crud.settings;

import com.alex.development.tools.project.builder.common.crud.BaseRepository;
import com.alex.development.tools.project.builder.model.entity.Settings;

public interface SettingsRepository extends BaseRepository<Settings, Long> {
    
    public Settings findByName(String name);
    
}
