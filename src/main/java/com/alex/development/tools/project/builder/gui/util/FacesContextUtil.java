package com.alex.development.tools.project.builder.gui.util;

import java.io.IOException;
import javax.faces.application.FacesMessage;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;

public class FacesContextUtil {
    
    public static String getCurrentJsfUrl() throws IOException {
        HttpServletRequest request = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
        return request.getRequestURI();
    }
    
    public static String getCurrentUrl() throws IOException {
        String result = FacesContext.getCurrentInstance().getExternalContext().getRequestHeaderMap().get("referer");
        return result;
    }
    
    public static ExternalContext getExternalContext(){
        return FacesContext.getCurrentInstance().getExternalContext();
    }
    
    public static void addMessage(String summary) {
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, summary, null);
        FacesContext.getCurrentInstance().addMessage(null, message);
    }
    
}
