package com.alex.development.tools.project.builder.gui.view;

import com.alex.development.tools.project.builder.core.crud.template.TemplateService;
import com.alex.development.tools.project.builder.gui.core.config.scope.ScopeName;
import com.alex.development.tools.project.builder.model.entity.Template;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.primefaces.event.RowEditEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component("templateList")
@Scope(ScopeName.VIEW)//SESSION???
@Slf4j
public class TemplateListView {
    
    @Autowired
    private TemplateService service;

    @Getter
    @Setter
    private List<Template> list;
    
    @Getter
    @Setter
    private List<Template> filteredList;

    @PostConstruct
    public void init() {
        this.list = this.service.findAll();
    }
    
    public void onRowEdit(RowEditEvent event) {
        Template item = (Template) event.getObject();
        this.service.save(item);
        this.showMessage("Обновлено", item.getId());      
    }

    public void onRowCancel(RowEditEvent event) {
        Template item = (Template) event.getObject();
        this.showMessage("Отменено", item.getId());
    }
    
    public void delete(Template item) {
        log.info("" + item.toString());
        this.service.delete(item.getId());
        this.list.remove(item);
        this.showMessage("Удалено", item.getId());
    }
    
    private void showMessage(String message, Long id){
        FacesMessage facesMessage = new FacesMessage(message, String.valueOf(id));
        FacesContext.getCurrentInstance().addMessage(null, facesMessage);
    }

}
