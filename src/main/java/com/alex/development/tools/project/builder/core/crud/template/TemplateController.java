package com.alex.development.tools.project.builder.core.crud.template;

import com.alex.development.tools.project.builder.common.crud.BaseController;
import com.alex.development.tools.project.builder.model.entity.Template;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("api/template")
public class TemplateController extends BaseController<Template, Long>{
        
}
