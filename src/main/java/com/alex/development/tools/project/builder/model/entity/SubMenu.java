package com.alex.development.tools.project.builder.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import lombok.Data;

@Data
@Entity
@Table(name = "sub_menu")
public class SubMenu extends BaseEntity {

    @NotNull
    @Column(name = "label", unique = true)
    private String label;

}
