//package com.alex.development.tools.project.builder.test;
//
//import com.alex.development.tools.project.builder.common.lib.AppContextUtil;
//import com.alex.development.tools.project.builder.core.crud.navigation_case.NavigationCaseService;
//import com.alex.development.tools.project.builder.gui.util.FacesContextUtil;
//import com.alex.development.tools.project.builder.gui.util.NavigationUtil;
//import java.io.IOException;
//import java.util.Map;
//import java.util.Set;
//import javax.faces.application.ConfigurableNavigationHandler;
//import javax.faces.application.NavigationCase;
//import javax.faces.application.NavigationHandler;
//import javax.faces.context.FacesContext;
//import lombok.extern.slf4j.Slf4j;
//
////Основано на redirect
//@Slf4j
//public class MyNavigationHandler extends ConfigurableNavigationHandler {
//
//    private final NavigationHandler parent;
//    
//    private NavigationCaseService navigationService;
//
//    public MyNavigationHandler(NavigationHandler parent) {
//        this.parent = parent;
//    }
//
//    @Override
//    public void handleNavigation(FacesContext context, String fromAction, String outcome) {
//        initSpringBean();//TODO Костыль
//        
//        try {
//            String currentUrl = FacesContextUtil.getCurrentUrl();
//            String nextUrl = this.navigationService.getNextUrl(currentUrl);
//            NavigationUtil.redirect(nextUrl);
//        } catch (IOException ex) {
//            throw new RuntimeException("Ошибка навигации");
//        }
//
//        this.parent.handleNavigation(context, fromAction, outcome);
//    }
//
//    @Override
//    public NavigationCase getNavigationCase(FacesContext context, String fromAction, String outcome) {
//        if (this.parent instanceof ConfigurableNavigationHandler) {
//            return ((ConfigurableNavigationHandler) this.parent).getNavigationCase(context, fromAction, outcome);
//        } else {
//            return null;
//        }
//    }
//
//    @Override
//    public Map<String, Set<NavigationCase>> getNavigationCases() {
//        if (this.parent instanceof ConfigurableNavigationHandler) {
//            return ((ConfigurableNavigationHandler) this.parent).getNavigationCases();
//        } else {
//            return null;
//        }
//    }
//
//    private void initSpringBean() {
//        if (this.navigationService == null) {
//            this.navigationService = AppContextUtil.getBean(NavigationCaseService.class);
//        }
//    }
//
//}
