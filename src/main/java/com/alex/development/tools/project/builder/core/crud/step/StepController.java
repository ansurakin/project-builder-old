package com.alex.development.tools.project.builder.core.crud.step;

import com.alex.development.tools.project.builder.common.crud.BaseController;
import com.alex.development.tools.project.builder.model.entity.Step;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("api/step")
public class StepController extends BaseController<Step, Long>{
    
}
