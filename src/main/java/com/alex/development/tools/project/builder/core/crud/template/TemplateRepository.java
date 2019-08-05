package com.alex.development.tools.project.builder.core.crud.template;

import com.alex.development.tools.project.builder.common.crud.BaseRepository;
import com.alex.development.tools.project.builder.model.entity.Template;
import java.util.List;

public interface TemplateRepository extends BaseRepository<Template, Long> {

    public List<Template> findAllByOrderByOrderNumberAsc();
    
    public Template findByName(String name);
    
    
    
}
