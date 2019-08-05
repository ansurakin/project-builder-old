package com.alex.development.tools.project.builder.core.crud.view_catalog;

import com.alex.development.tools.project.builder.common.crud.BaseController;
import com.alex.development.tools.project.builder.model.entity.ViewCatalog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import static org.springframework.web.bind.annotation.RequestMethod.GET;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/view-catalog")
public class ViewCatalogController extends BaseController<ViewCatalog, Long> {

    @Autowired
    private ViewCatalogService service;

    @RequestMapping(value = "/getFullname", params = {"id"}, method = GET)
    public String getFullname(@RequestParam Long id) {
        return this.service.getFullname(id);
    }

}
