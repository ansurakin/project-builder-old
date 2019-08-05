package com.alex.development.tools.project.builder.gui.util;

import java.io.IOException;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;

public class NavigationUtil {
    
    public static void redirect(String url) throws IOException {
        FacesContextUtil.getExternalContext().redirect(url);
    }
    
}
