package ro.ebs.internship.alzheimer.controller;

import org.springframework.http.MediaType;
import ro.ebs.internship.alzheimer.entity.Message;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;


/**
 * Created by Richard on 5/19/2016.
 */

@RestController
public class RESTController {

    @RequestMapping(value = "/hello/{player}", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public Message getMessage(@PathVariable String player) {
        Message msg = new Message();
        msg.setName(player);
        return msg;
    }

}
