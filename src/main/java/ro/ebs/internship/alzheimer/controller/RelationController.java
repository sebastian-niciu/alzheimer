package ro.ebs.internship.alzheimer.controller;


import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import ro.ebs.internship.alzheimer.entity.Relation;

@RestController
public class RelationController {

    @RequestMapping(
            value = "/relations",
            method = RequestMethod.PUT,
            consumes = MediaType.APPLICATION_JSON_VALUE
    )
    @ResponseStatus(HttpStatus.CREATED)
    public void createRelation(@RequestBody Relation relation) {
        System.out.println(relation);
    }
}
