package com.alex.development.tools.project.builder.gui.view.catalog.url_catalog;

import com.alex.development.tools.project.builder.core.crud.url_catalog.UrlCatalogService;
import com.alex.development.tools.project.builder.gui.core.config.scope.ScopeName;
import com.alex.development.tools.project.builder.model.entity.UrlCatalog;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import lombok.Getter;
import lombok.Setter;
import org.primefaces.event.RowEditEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

//Эталон
@Scope(ScopeName.VIEW)
@Component
public class UrlCatalogListView {
    
    @Getter
    @Setter
    private List<UrlCatalog> list;
    
    @Getter
    @Setter
    private List<UrlCatalog> filteredList;
    
    @Autowired
    private UrlCatalogService service;

    @PostConstruct
    public void init() {
        this.list = this.service.findAll();
    }
    
    public void onRowEdit(RowEditEvent event) {
        UrlCatalog item = (UrlCatalog) event.getObject();
        this.service.save(item);
        this.showMessage("Обновлено", item.getId());      
    }

    public void onRowCancel(RowEditEvent event) {
        UrlCatalog item = (UrlCatalog) event.getObject();
        this.showMessage("Отменено", item.getId());
    }
    
    public void delete(UrlCatalog item) {
        this.service.delete(item.getId());
        this.list.remove(item);
        this.showMessage("Удалено", item.getId());
    }
    
    public String fullname(Long id) {
        return this.service.getFullname(id);
    }
    
    public List<UrlCatalog> getParentList(Long id) {        
        return this.service.getAvailableParentList(id);
    }
    
    private void showMessage(String message, Long id){
        FacesMessage facesMessage = new FacesMessage(message, String.valueOf(id));
        FacesContext.getCurrentInstance().addMessage(null, facesMessage);
    }
    
}
