package com.alex.development.tools.project.builder.core.crud.url_catalog;

import com.alex.development.tools.project.builder.common.crud.BaseRepository;
import com.alex.development.tools.project.builder.model.entity.UrlCatalog;
import java.util.List;

public interface UrlCatalogRepository extends BaseRepository<UrlCatalog, Long> {

    List<UrlCatalog> findByIdNot(Long id);
    
}
