package com.alex.development.tools.project.builder.core.crud.url;

import com.alex.development.tools.project.builder.common.crud.BaseService;
import com.alex.development.tools.project.builder.core.crud.url_catalog.UrlCatalogService;
import com.alex.development.tools.project.builder.model.entity.Url;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UrlService extends BaseService<Url, Long> {

    @Autowired
    private UrlCatalogService urlCatalogService;

    public String getFullname(Long id) {
        Url url = this.findOne(id);
        String prefix = this.urlCatalogService.getFullname(url.getUrlCatalog().getId());
        
        String result = prefix + url.getName();

        return result;
    }

}
