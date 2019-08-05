package com.alex.development.tools.project.builder.model.project;

import com.alex.development.tools.project.builder.model.BaseModel;
import com.alex.development.tools.project.builder.model.project.content.pom.Pom;
import lombok.Data;

@Data
public class Content extends BaseModel{
    
    private Pom pom;
    
}
