package com.alex.development.tools.project.builder.core.crud.view_page;

import com.alex.development.tools.project.builder.common.crud.BaseService;
import com.alex.development.tools.project.builder.core.crud.view_catalog.ViewCatalogService;
import com.alex.development.tools.project.builder.model.entity.ViewPage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ViewPageService extends BaseService<ViewPage, Long> {

    @Autowired
    private ViewCatalogService viewCatalogService;

    public String getFullname(Long id) {
        ViewPage viewPage = this.findOne(id);
        String prefix = this.viewCatalogService.getFullname(viewPage.getViewCatalog().getId());
        
        String result = prefix + viewPage.getName();

        return result;
    }

}
