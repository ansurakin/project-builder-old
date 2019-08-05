package com.alex.development.tools.project.builder.core.crud.url_catalog;

import com.alex.development.tools.project.builder.common.crud.BaseController;
import com.alex.development.tools.project.builder.model.entity.UrlCatalog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import static org.springframework.web.bind.annotation.RequestMethod.GET;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/url-catalog")
public class UrlCatalogController extends BaseController<UrlCatalog, Long> {

    @Autowired
    private UrlCatalogService service;

    @RequestMapping(value = "/getFullname", params = {"id"}, method = GET)
    public String getFullname(@RequestParam Long id) {
        return this.service.getFullname(id);
    }

}
