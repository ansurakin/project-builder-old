package com.alex.development.tools.project.builder.gui.view.catalog.url_catalog;

import com.alex.development.tools.project.builder.core.crud.url_catalog.UrlCatalogService;
import com.alex.development.tools.project.builder.gui.core.config.scope.ScopeName;
import com.alex.development.tools.project.builder.gui.util.NavigationUtil;
import com.alex.development.tools.project.builder.model.entity.UrlCatalog;
import java.io.IOException;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@Scope(ScopeName.VIEW)
public class UrlCatalogCreateView {
    
    private static final String CURRENT_URL = "/catalog/url-catalog/create";
    
    @Autowired
    private UrlCatalogService service;

    @Getter
    @Setter
    private UrlCatalog obj;
    
    @Getter
    @Setter
    private List<UrlCatalog> list;
    
    @PostConstruct
    public void init() {        
        this.obj = new UrlCatalog();
        this.list = this.service.findAll();
    }
    
    public void save() throws IOException {
       this.service.save(this.obj);
       this.addMessage("Выполнено");
       NavigationUtil.redirect(CURRENT_URL);
    }

    public void cancell() throws IOException {
        NavigationUtil.redirect(CURRENT_URL);
    }

    private void addMessage(String summary) {
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, summary, null);
        FacesContext.getCurrentInstance().addMessage(null, message);
    }

}
