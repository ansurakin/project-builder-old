package com.alex.development.tools.project.builder.gui.view.catalog.url;

import com.alex.development.tools.project.builder.core.crud.url.UrlService;
import com.alex.development.tools.project.builder.core.crud.url_catalog.UrlCatalogService;
import com.alex.development.tools.project.builder.gui.core.config.scope.ScopeName;
import com.alex.development.tools.project.builder.gui.util.NavigationUtil;
import com.alex.development.tools.project.builder.model.entity.Url;
import com.alex.development.tools.project.builder.model.entity.UrlCatalog;
import java.io.IOException;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope(ScopeName.VIEW)
public class UrlCreateView {
    
    public static final String CURRENT_URL = "/catalog/url/create";
    
    @Autowired
    private UrlService service;

    @Getter
    @Setter
    private Url obj;
    
    @Getter
    @Setter
    private Long selectedCatalogId;
    
    @Getter
    @Setter
    private List<UrlCatalog> catalogList;
    
    @Autowired
    private UrlCatalogService urlCatalogService;
    
    @PostConstruct
    public void init() {        
        this.obj = new Url();
        this.catalogList = this.urlCatalogService.findAll();
    }
    
    public void save() throws IOException {
       UrlCatalog catalog = this.urlCatalogService.findOne(this.selectedCatalogId);
       this.obj.setUrlCatalog(catalog);
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
