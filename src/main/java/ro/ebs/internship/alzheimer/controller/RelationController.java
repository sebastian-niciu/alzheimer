package ro.ebs.internship.alzheimer.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import ro.ebs.internship.alzheimer.entity.Relation;
import ro.ebs.internship.alzheimer.repository.RelationRepository;

@RestController
public class RelationController {

    @Autowired
    private RelationRepository repository;

    @RequestMapping(
            value = "/relations",
            method = RequestMethod.PUT,
            consumes = MediaType.APPLICATION_JSON_VALUE
    )
    @ResponseStatus(HttpStatus.CREATED)
    public void createRelation(@RequestBody Relation relation) {
        repository.save(relation);
        System.out.println(relation);
    }
}
