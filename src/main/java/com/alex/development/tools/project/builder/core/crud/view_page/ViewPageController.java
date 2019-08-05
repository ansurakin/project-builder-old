package com.alex.development.tools.project.builder.core.crud.view_page;

import com.alex.development.tools.project.builder.common.crud.BaseController;
import com.alex.development.tools.project.builder.model.entity.ViewPage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import static org.springframework.web.bind.annotation.RequestMethod.GET;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("api/view-page")
public class ViewPageController extends BaseController<ViewPage, Long>{
    
    @Autowired
    private ViewPageService service;

    @RequestMapping(value = "/getFullname", params = {"id"}, method = GET)
    public String getFullname(@RequestParam Long id) {
        return this.service.getFullname(id);
    }
    
}
