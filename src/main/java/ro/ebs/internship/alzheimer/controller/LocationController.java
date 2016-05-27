package ro.ebs.internship.alzheimer.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import ro.ebs.internship.alzheimer.entity.Location;
import ro.ebs.internship.alzheimer.entity.Patient;
import ro.ebs.internship.alzheimer.repository.LocationRepository;
import ro.ebs.internship.alzheimer.repository.PatientRepository;

import java.util.List;

@RestController
@RequestMapping("locations")
public class LocationController {

    @Autowired
    private LocationRepository locationRepository;

    @Autowired
    private PatientRepository patientRepository;

    @RequestMapping(
            value = "patients/{patient}",
            method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    public void storeLocation(@PathVariable("patient") String patientUsername, @RequestBody Location location){
        Patient patient = patientRepository.findByUsername(patientUsername);
        location.setPatient(patient);
        locationRepository.save(location);
    }

    @RequestMapping(
            value = "patients/{patient}",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public List<Location> getLocations(@PathVariable("patient") String patient){
        return locationRepository.findByPatientUsername(patient);
    }

}
