package com.alex.development.tools.project.builder.gui.test;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@Slf4j
public class TestController {

    @RequestMapping("/test")
    public String page() {
        log.info("info message");
        log.debug("debug message");
        log.warn("warn message");
        log.error("error message");
        return "forward:/view/test.xhtml";
    }

}
