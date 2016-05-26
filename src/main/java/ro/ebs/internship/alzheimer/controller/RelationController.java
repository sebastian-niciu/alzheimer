package ro.ebs.internship.alzheimer.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import ro.ebs.internship.alzheimer.entity.Relation;
import ro.ebs.internship.alzheimer.repository.RelationRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

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

    @RequestMapping(
            value = "/relations",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    @ResponseStatus(HttpStatus.OK)
    public List<Relation> getRelations(){
        List<Relation> relations = new ArrayList<Relation>();
        for(Relation relation : repository.findAll()) {
            relations.add(relation);
        }
        return relations;
    }

}
