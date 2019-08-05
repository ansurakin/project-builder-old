package com.alex.development.tools.project.builder.gui.view.catalog.url;

import com.alex.development.tools.project.builder.core.crud.url.UrlService;
import com.alex.development.tools.project.builder.core.crud.url_catalog.UrlCatalogService;
import com.alex.development.tools.project.builder.gui.core.config.scope.ScopeName;
import com.alex.development.tools.project.builder.model.entity.Url;
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

@Scope(ScopeName.VIEW)
@Component
public class UrlListView {

    @Getter
    @Setter
    private List<Url> list;

    @Getter
    @Setter
    private List<Url> filteredList;
    
    @Getter
    @Setter
    private List<UrlCatalog> catalogList;

    @Autowired
    private UrlService service;

    @Autowired
    private UrlCatalogService urlCatalogService;

    @PostConstruct
    public void init() {
        this.list = this.service.findAll();
        this.catalogList = this.urlCatalogService.findAll();
    }

    public void onRowEdit(RowEditEvent event) {
        Url item = (Url) event.getObject();
        this.service.save(item);
        this.showMessage("Обновлено", item.getId());
    }

    public void onRowCancel(RowEditEvent event) {
        Url item = (Url) event.getObject();
        this.showMessage("Отменено", item.getId());
    }

    public void delete(Url item) {
        this.service.delete(item.getId());
        this.list.remove(item);
        this.showMessage("Удалено", item.getId());
    }

    public String fullname(Long id) {
        return this.service.getFullname(id);
    }
    
    public UrlCatalog get(Long id) {
        if (id == null){
            throw new IllegalArgumentException("no id provided");
        }
        for (UrlCatalog item : this.catalogList){
            if (id.equals(item.getId())){
                return item;
            }
        }
        return null;
    }

    private void showMessage(String message, Long id) {
        FacesMessage facesMessage = new FacesMessage(message, String.valueOf(id));
        FacesContext.getCurrentInstance().addMessage(null, facesMessage);
    }

}
