package ro.ebs.internship.alzheimer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import ro.ebs.internship.alzheimer.entity.Caretaker;
import ro.ebs.internship.alzheimer.entity.Patient;
import ro.ebs.internship.alzheimer.repository.CaretakerRepository;
import ro.ebs.internship.alzheimer.repository.PatientRepository;

import java.util.List;

@RestController
public class RelationController {

    @Autowired
    private CaretakerRepository caretakerRepository;

    @Autowired
    private PatientRepository patientRepository;

    @RequestMapping(
            value = "/caretakers/{caretaker}/patients/{patient}",
            method = RequestMethod.PUT
    )
    @ResponseStatus(HttpStatus.CREATED)
    @Transactional
    public void createRelation(@PathVariable("caretaker") String caretakerUsername,
                               @PathVariable("patient") String patientUsername) {
        Caretaker caretaker = caretakerRepository.findByUsername(caretakerUsername);
        Patient patient = patientRepository.findByUsername(patientUsername);
        caretaker.getPatients().add(patient);
    }

    @RequestMapping(
            value = "/caretakers/{caretaker}/patients",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    @ResponseStatus(HttpStatus.OK)
    public List<String> getPatientsForCaretaker(@PathVariable("caretaker") String caretakerUsername){
        return patientRepository.findPatientUserNamesByCaretaker(caretakerUsername);
    }

}
