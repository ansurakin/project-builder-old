package com.alex.development.tools.project.builder.core.crud.url_view;

import com.alex.development.tools.project.builder.common.crud.BaseController;
import com.alex.development.tools.project.builder.model.entity.UrlView;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import static org.springframework.web.bind.annotation.RequestMethod.GET;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/url-view")
public class UrlViewController extends BaseController<UrlView, Long> {

    @Autowired
    private UrlViewService service;

    @RequestMapping(value = "/getMap", method = GET)
    public Map getMap() {        
        return this.service.getMap();
    }
    
}
