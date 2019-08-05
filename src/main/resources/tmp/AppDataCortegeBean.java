package com.alex.development.tools.project.builder.bean;

import com.alex.development.tools.project.builder.gui.model.ButtonType;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.ApplicationScope;

@ApplicationScope
@Component("appData")
public class AppDataCortegeBean {

    @Getter
    @Setter
    private ButtonType buttonType;

}
