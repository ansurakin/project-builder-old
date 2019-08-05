package com.alex.development.tools.project.builder.gui.view.component.menu;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import org.primefaces.model.menu.DefaultMenuItem;
import org.primefaces.model.menu.DefaultMenuModel;
import org.primefaces.model.menu.DefaultSubMenu;
import org.primefaces.model.menu.MenuModel;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.SessionScope;

@SessionScope
@Component
public class MenuVc {

    private MenuModel model;
 
    @PostConstruct
    public void init() {
        this.model = new DefaultMenuModel();
 
        //First submenu
        DefaultSubMenu firstSubmenu = new DefaultSubMenu("Справочники");
 
        DefaultMenuItem item = new DefaultMenuItem("Каталоги URL");
        item.setUrl("/catalog/url-catalog/list");        
        firstSubmenu.addElement(item);
        
        DefaultMenuItem item2 = new DefaultMenuItem("URL");
        item2.setUrl("/catalog/url-catalog/create");        
        firstSubmenu.addElement(item2);
 
        model.addElement(firstSubmenu);
 
        //Second submenu
        DefaultSubMenu secondSubmenu = new DefaultSubMenu("Dynamic Actions");
 
        item = new DefaultMenuItem("Save");
        item.setIcon("ui-icon-home");
        item.setCommand("#{customMenuVc.save}");
        item.setUpdate("messages");
        secondSubmenu.addElement(item);
 
        item = new DefaultMenuItem("Delete");
        item.setIcon("pi pi-times");
        item.setCommand("#{customMenuVc.delete}");
        item.setAjax(false);
        secondSubmenu.addElement(item);
 
        item = new DefaultMenuItem("Redirect");
        item.setIcon("pi pi-search");
        item.setCommand("#{customMenuVc.redirect}");
        secondSubmenu.addElement(item);
 
        model.addElement(secondSubmenu);
    }
 
    public MenuModel getModel() {
        return model;
    }
 
    public void save() {
        addMessage("Success", "Data saved");
    }
 
    public void update() {
        addMessage("Success", "Data updated");
    }
 
    public void delete() {
        addMessage("Success", "Data deleted");
    }
 
    public void addMessage(String summary, String detail) {
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, summary, detail);
        FacesContext.getCurrentInstance().addMessage(null, message);
    }

}
