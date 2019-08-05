package com.alex.development.tools.project.builder.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotNull;
import lombok.Data;
import org.hibernate.annotations.OnDeleteAction;

@Data
@Entity
@Table(
        name = "view_page",
        uniqueConstraints = @UniqueConstraint(columnNames = {"name", "view_catalog_id"})
)
public class ViewPage extends BaseEntity {

    @NotNull
    @Column(name = "name")
    private String name;

    @org.hibernate.annotations.OnDelete(action=OnDeleteAction.CASCADE)
    @NotNull    
    @JoinColumn(name = "view_catalog_id")
    @ManyToOne
    private ViewCatalog viewCatalog;

}
