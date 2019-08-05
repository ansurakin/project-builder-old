package com.alex.development.tools.project.builder.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import lombok.Data;


@Data
@Entity
@Table(name = "settings")
public class Settings extends BaseEntity{
    
    @NotNull
    @Column(name = "name")
    private String name;
    
    @Column(name = "description")
    private String description;
    
    @NotNull
    @Column(name = "pom_template")
    private String pomTemplate;
    
    @NotNull
    @Column(name = "start_step_url")
    private String startStepUrl;
    
    @NotNull
    @Column(name = "finish_step_url")
    private String finishStepUrl;
    
    @NotNull
    @Column(name = "cancell_step_url")
    private String cancellStepUrl;
    
}
