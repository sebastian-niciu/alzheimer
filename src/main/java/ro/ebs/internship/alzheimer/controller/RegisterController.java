package ro.ebs.internship.alzheimer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import ro.ebs.internship.alzheimer.entity.Caretaker;
import ro.ebs.internship.alzheimer.entity.Patient;
import ro.ebs.internship.alzheimer.repository.CaretakerRepository;
import ro.ebs.internship.alzheimer.repository.PatientRepository;

@RestController
public class RegisterController {

    @Autowired
    private PatientRepository patientRepository;

    @Autowired
    private CaretakerRepository caretakerRepository;

    @RequestMapping(
            value = "caretakers",
            method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_JSON_VALUE
    )
    @ResponseStatus(HttpStatus.CREATED)
    public void registerCaretaker(@RequestBody Caretaker caretaker) {
        caretakerRepository.save(caretaker);
    }

    @RequestMapping(
            value = "patients",
            method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_JSON_VALUE
    )
    @ResponseStatus(HttpStatus.CREATED)
    public void registerPatient(@RequestBody Patient patient) {
        patientRepository.save(patient);
    }
}