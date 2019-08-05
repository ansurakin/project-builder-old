package com.alex.development.tools.project.builder.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import lombok.Data;
import org.hibernate.annotations.OnDeleteAction;

@Data
@Entity
@Table(name = "menu_item")
public class MenuItem extends BaseEntity {

    @NotNull
    @Column(name = "value", unique = true)
    private String value;

    @org.hibernate.annotations.OnDelete(action = OnDeleteAction.CASCADE)
    @NotNull
    @JoinColumn(name = "url_id")
    @ManyToOne
    private Url url;
    
    @org.hibernate.annotations.OnDelete(action = OnDeleteAction.CASCADE)
    @NotNull
    @JoinColumn(name = "sub_menu_id")
    @ManyToOne
    private SubMenu subMenu;

}
