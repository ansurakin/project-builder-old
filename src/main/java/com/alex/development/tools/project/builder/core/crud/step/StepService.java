package com.alex.development.tools.project.builder.core.crud.step;

import com.alex.development.tools.project.builder.common.crud.BaseService;
import com.alex.development.tools.project.builder.model.entity.Step;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StepService extends BaseService<Step, Long>{
     
    @Autowired(required = true)
    private StepRepository repository;
    
    //TODO WHERE ORDER_NUMBER = 1;
    public Step getStart(String currentName) {
        return get("/new-project/new-application");
    }
    
    public Step get(String currentName) {
        return this.repository.findByCurrentView(currentName);
    }

    @Override
    public List<Step> findAll() {
        return this.repository.findAllByOrderByOrderNumberAsc();
    }

}
