package ro.ebs.internship.alzheimer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import ro.ebs.internship.alzheimer.entity.User;
import ro.ebs.internship.alzheimer.repository.RelationRepository;
import ro.ebs.internship.alzheimer.repository.UserRepository;

@RestController
public class UserController {

    @Autowired
    private UserRepository repository;

    @RequestMapping(
            value = "users",
            method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_JSON_VALUE
    )
    @ResponseStatus(HttpStatus.CREATED)
    public void registerUser(@RequestBody User user) {
        repository.save(user);
        System.out.println(user);
    }
}