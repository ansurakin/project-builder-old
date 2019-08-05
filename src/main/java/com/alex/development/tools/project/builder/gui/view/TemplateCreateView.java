package com.alex.development.tools.project.builder.gui.view;

import com.alex.development.tools.project.builder.core.crud.template.TemplateService;
import com.alex.development.tools.project.builder.gui.core.config.scope.ScopeName;
import com.alex.development.tools.project.builder.gui.util.NavigationUtil;
import com.alex.development.tools.project.builder.gui.model.ButtonType;
import com.alex.development.tools.project.builder.model.entity.Template;
import java.io.IOException;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component("newTemplate")
@Scope(ScopeName.VIEW)//SESSION???
@Slf4j
public class TemplateCreateView {
    
    @Autowired
    private TemplateService service;

    @Getter
    @Setter
    private Template obj;
    
    @PostConstruct
    public void init() {
        this.obj = new Template();
    }
    
    public void saveButtonAction() throws IOException {
        buttonHandler(ButtonType.SAVE);
    }

    public void cancellButtonAction() throws IOException {
        buttonHandler(ButtonType.CANCELL);
    }

    private void buttonHandler(ButtonType buttonType) throws IOException {
        switch (buttonType) {
            case SAVE:
                doSave();
                break;
            case CANCELL:
                doCancell();
                break;
            default:
                throw new UnsupportedOperationException();
        }

        complete();
    }
    
    private void doSave() throws IOException {
        this.service.save(this.obj);
        NavigationUtil.redirect("/template/create");
    }

    private void doCancell() throws IOException {
        NavigationUtil.redirect("/template/create");
    }

    private void complete() throws IOException {
        this.addMessage("Выполнено");
    }

    private void addMessage(String summary) {
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, summary, null);
        FacesContext.getCurrentInstance().addMessage(null, message);
    }

}
