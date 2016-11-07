package ua.recruitment.system.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by KIRIL on 06.11.2016.
 */
@Controller
public class IndexController {

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String viewHomePage(){
        return "index";
    }

    @RequestMapping(value = "/index", method = RequestMethod.GET)
    public String viewIndexPage(){
        return "index";
    }
}
