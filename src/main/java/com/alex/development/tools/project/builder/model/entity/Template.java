package com.alex.development.tools.project.builder.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Lob;
import javax.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "template")
public class Template extends BaseEntity  {
    
    @Column(name = "name", unique = true)
    private String name;
    
    @Lob
    @Column(name = "content")
    private String content;
    
    @Column(name = "order_number")
    private Long orderNumber;
    
    @Column(name = "template_type")
    private String templateType;
    
    @Column(name = "parent_id")
    private Long parentId;

}
