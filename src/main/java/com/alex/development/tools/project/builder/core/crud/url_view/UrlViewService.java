package com.alex.development.tools.project.builder.core.crud.url_view;

import com.alex.development.tools.project.builder.common.crud.BaseService;
import com.alex.development.tools.project.builder.core.crud.url.UrlService;
import com.alex.development.tools.project.builder.core.crud.view_page.ViewPageService;
import com.alex.development.tools.project.builder.model.entity.UrlView;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UrlViewService extends BaseService<UrlView, Long> {
    
    @Autowired
    private UrlService urlService;
    
    @Autowired
    private ViewPageService viewService;
    
    public Map getMap() {
        Map<String, String> result = new HashMap<>();
        List<UrlView> urlViewList = this.findAll();
        
        for (UrlView item : urlViewList) {
            String url = this.urlService.getFullname(item.getUrl().getId());            
            String view = this.viewService.getFullname(item.getView().getId()); 
            
            result.put(url, view);
        }
        
        return result;
    }

}
