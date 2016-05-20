package ro.ebs.internship.alzheimer.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import ro.ebs.internship.alzheimer.entity.User;

@RestController
public class RegisterController {

    @RequestMapping(
            value = "users",
            method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_JSON_VALUE
    )
    @ResponseStatus(HttpStatus.CREATED)
    public void registerUser(@RequestBody User user) {
        System.out.println(user);
    }
}