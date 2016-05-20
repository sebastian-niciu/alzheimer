package ro.ebs.internship.alzheimer.controller;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import ro.ebs.internship.alzheimer.entity.Coord;

import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping("coords")
public class CoordsController {

    @RequestMapping(
            value = "patients/{patient}",
            method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_JSON_VALUE
    )
    @ResponseStatus(HttpStatus.CREATED)
    public void createCoords(@PathVariable("patient") String patient, @RequestBody Coord coord){
        System.out.println(patient + " is at " + coord.toString());
    }

    @RequestMapping(
            value = "caretakers/{caretaker}",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    @ResponseStatus(HttpStatus.OK)
    public List<Coord> getCoords(@PathVariable("caretaker") String caretaker){
        System.out.println(caretaker);
        Coord coord = new Coord();
        coord.setLatitude("45.98");
        coord.setLongitude("25.89");
        coord.setTimestamp(1234L);
        return Collections.singletonList(coord);
    }

}
