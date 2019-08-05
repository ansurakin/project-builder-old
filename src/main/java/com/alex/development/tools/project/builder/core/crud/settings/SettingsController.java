package com.alex.development.tools.project.builder.core.crud.settings;

import com.alex.development.tools.project.builder.common.crud.BaseController;
import com.alex.development.tools.project.builder.model.entity.Settings;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("api/settings")
public class SettingsController extends BaseController<Settings, Long>{
    
}
