package com.alex.development.tools.project.builder.model.entity;

import com.alex.development.tools.project.builder.model.common.Constant;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import lombok.Data;

@Data
@Entity
@Table(name = "step")
public class Step extends BaseEntity {

    @Column(name = "display_name", unique = true)
    private String displayName;
    
    @NotNull
    @Column(name = "current_view", unique = true)
    private String currentView;
    
    @Column(name = "next_view", unique = true)
    private String nextView;
    
    @Column(name = "previous_view", unique = true)
    private String previousView;
    
    @Column(name = "order_number")
    @org.hibernate.annotations.ColumnDefault(Constant.DEFAULT_ORDER_NUMBER)
    private Long orderNumber;
    
}
