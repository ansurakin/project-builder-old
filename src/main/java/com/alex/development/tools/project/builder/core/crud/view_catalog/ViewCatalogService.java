package com.alex.development.tools.project.builder.core.crud.view_catalog;

import com.alex.development.tools.project.builder.common.crud.BaseService;
import com.alex.development.tools.project.builder.model.entity.ViewCatalog;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ViewCatalogService extends BaseService<ViewCatalog, Long> {

    @Autowired
    private ViewCatalogRepository repository;

    public String getFullname(Long id) {
        List<String> tree = this.getTree(id);

        String result = "";
        for (String item : tree) {
            result += item + "/";
        }

        return result;
    }

    private List<String> getTree(Long id) {
        List<String> result = new ArrayList<>();

        ViewCatalog catalog = this.repository.findOne(id);
        if (catalog.hasParent()) {
            result.addAll(this.getTree(catalog.getParentId()));
        }
        result.add(catalog.getName());

        return result;
    }

}
