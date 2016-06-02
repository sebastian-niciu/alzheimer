package ro.ebs.internship.alzheimer.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import ro.ebs.internship.alzheimer.entity.Location;
import ro.ebs.internship.alzheimer.entity.Patient;
import ro.ebs.internship.alzheimer.repository.LocationRepository;
import ro.ebs.internship.alzheimer.repository.PatientRepository;
import ro.ebs.internship.alzheimer.service.LocationService;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("locations")
public class LocationController {

    @Autowired
    private LocationService locationService;

    @RequestMapping(
            value = "patients/{patient}",
            method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    public void storeLocation(@PathVariable("patient") String patientUsername, @RequestBody Location location){
        locationService.saveLocation(location, patientUsername);
    }

    @RequestMapping(
            value = "patients/{patient}",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public List<Location> getLocations(@PathVariable("patient") String patient){
        return locationService.getLocationsFromService(patient);
    }

    /*@RequestMapping(
            value = "caretakers/{caretaker}",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public List<Location> getCaretaker(@PathVariable("caretaker") String caretaker){
        return locationService.getAllLocationsFromService(patient);
    }*/

}
