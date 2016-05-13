package ro.ebs.internship.alzheimer.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by Richard on 5/13/2016.
 */
@Controller
public class MonitoringController {
    @RequestMapping(value = "hello", method = RequestMethod.GET)
    public ModelAndView getHello() {
        return new ModelAndView("hello", "name", "Spring");
    }
}
