package com.neusoft.ump.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.apache.logging.log4j.LogManager;
import org.apache.commons.logging.LogFactory;
import org.apache.commons.logging.Log;

@Controller
public class ConsoleController {
    private final Log log = LogFactory.getLog(getClass());

    @RequestMapping(value="/console", method = RequestMethod.GET)
    public String toConsole(){
        log.info("Console");
        return "console";
    }
}
