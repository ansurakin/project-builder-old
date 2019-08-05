package com.alex.development.tools.project.builder.core.crud.template;

import com.alex.development.tools.project.builder.common.crud.BaseService;
import com.alex.development.tools.project.builder.model.entity.Template;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TemplateService extends BaseService<Template, Long>{

    @Autowired
    private TemplateRepository repository;
    
    public Template findByName(String name) {        
        return this.repository.findByName(name);
    }

    @Override
    public List<Template> findAll() {
        return this.repository.findAllByOrderByOrderNumberAsc();
    }

}
