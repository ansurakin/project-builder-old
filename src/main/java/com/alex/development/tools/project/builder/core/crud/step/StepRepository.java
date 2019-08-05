package com.alex.development.tools.project.builder.core.crud.step;

import com.alex.development.tools.project.builder.common.crud.BaseRepository;
import com.alex.development.tools.project.builder.model.entity.Step;
import java.util.List;

public interface StepRepository extends BaseRepository<Step, Long> {
    
    public Step findByCurrentView(String url);
    
    public List<Step> findAllByOrderByOrderNumberAsc();
    
}
