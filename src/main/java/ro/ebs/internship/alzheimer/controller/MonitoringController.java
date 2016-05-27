package ro.ebs.internship.alzheimer.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MonitoringController {

    @RequestMapping(value = "monitoring/ping", method = RequestMethod.GET)
    public ModelAndView getHello() {
        return new ModelAndView("hello", "name", "Spring");
    }

}
