package com.alex.development.tools.project.builder.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import lombok.Data;

@Data
@Entity
@Table(name = "view_catalog")
public class ViewCatalog extends BaseEntity {

    @NotNull
    @Column(name = "name", unique = true)
    private String name;
    
    //TODO добавить FK
    @Column(name = "parent_id")
    private Long parentId;
        
    public Boolean hasParent(){
        return this.parentId != null;
    }

}
