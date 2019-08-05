package com.alex.development.tools.project.builder.model.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotNull;
import lombok.Data;
import org.hibernate.annotations.OnDeleteAction;

@Data
@Entity
@Table(
        name = "url_view",
        uniqueConstraints = @UniqueConstraint(columnNames = {"url_id", "view_id"})
)
public class UrlView extends BaseEntity {

    @org.hibernate.annotations.OnDelete(action=OnDeleteAction.CASCADE)
    @NotNull    
    @JoinColumn(name = "url_id")
    @ManyToOne
    private Url url;    
    
    @org.hibernate.annotations.OnDelete(action=OnDeleteAction.CASCADE)
    @NotNull
    @JoinColumn(name = "view_id")
    @ManyToOne
    private ViewPage view;

}
