package com.alex.development.tools.project.builder.core.crud.url_view;

import com.alex.development.tools.project.builder.common.crud.BaseRepository;
import com.alex.development.tools.project.builder.model.entity.UrlView;

public interface UrlViewRepository extends BaseRepository<UrlView, Long> {
    
    public UrlView findByUrlId(Long id);
    
    public UrlView findByViewId(Long id);
    
}
