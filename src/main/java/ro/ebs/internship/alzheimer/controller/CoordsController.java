package ro.ebs.internship.alzheimer.controller;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import ro.ebs.internship.alzheimer.entity.Coord;

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

}
