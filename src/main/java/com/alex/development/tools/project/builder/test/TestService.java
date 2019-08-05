package com.alex.development.tools.project.builder.test;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;


@Slf4j
@Service
public class TestService {
    
    public String doSomething(){
        log.debug("doSomething called!");
      return "Done";
    }
    
}
