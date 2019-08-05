package com.alex.development.tools.project.builder.gui.converter;

import com.alex.development.tools.project.builder.gui.view.catalog.url.UrlListView;
import com.alex.development.tools.project.builder.model.entity.UrlCatalog;
import javax.el.ValueExpression;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;

public class UrlCatalogConverter implements Converter {
    
    @Override
    public String getAsString(FacesContext fc, UIComponent uic, Object o) {
        return ((UrlCatalog)o).getId().toString();
    }

    @Override
    public Object getAsObject(FacesContext fc, UIComponent uic, String string) {
        ValueExpression vex =
                fc.getApplication().getExpressionFactory()
                        .createValueExpression(fc.getELContext(),
                                "#{urlListView}", UrlListView.class);

        UrlListView urlListView = (UrlListView)vex.getValue(fc.getELContext());
        return urlListView.get(Long.valueOf(string));
    }

}
