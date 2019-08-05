package com.alex.development.tools.project.builder.core.crud.url_catalog;

import com.alex.development.tools.project.builder.common.crud.BaseService;
import com.alex.development.tools.project.builder.model.entity.UrlCatalog;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UrlCatalogService extends BaseService<UrlCatalog, Long> {

    @Autowired
    private UrlCatalogRepository repository;

    public String getFullname(Long id) {
        List<String> tree = this.getTree(id);

        String result = "";
        for (String item : tree) {
            result += item + "/";
        }

        return result;
    }
    
    public List<UrlCatalog> getAvailableParentList(Long id){
        return this.repository.findByIdNot(id);
    }

    private List<String> getTree(Long id) {
        List<String> result = new ArrayList<>();

        UrlCatalog catalog = this.repository.findOne(id);
        if (catalog.hasParent()) {
            result.addAll(this.getTree(catalog.getParentId()));
        }
        result.add(catalog.getName());

        return result;
    }

}
