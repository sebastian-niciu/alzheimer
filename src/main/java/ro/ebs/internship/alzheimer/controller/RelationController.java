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

import java.util.Iterator;
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
            value = "patients/{patient}/caretakers/{caretaker}",
            method = RequestMethod.PUT
    )
    @ResponseStatus(HttpStatus.CREATED)
    @Transactional
    public void createARelation(@PathVariable("patient") String patientUsername,
                                @PathVariable("caretaker") String caretakerUsername) {
        Patient patient = patientRepository.findByUsername(patientUsername);
        Caretaker caretaker = caretakerRepository.findByUsername(caretakerUsername);
        patient.getCaretakers().add(caretaker);
    }

    @RequestMapping(
            value = "patients/{patient}/caretakers/{caretaker}",
            method = RequestMethod.DELETE
    )
    @ResponseStatus(HttpStatus.OK)
    @Transactional
    public void removeCaretakerFromPatient(@PathVariable("patient") String patientUsername,
                                           @PathVariable("caretaker") String caretakerUsername) {
        Patient patient = patientRepository.findByUsername(patientUsername);

        Iterator<Caretaker> caretakerIterator = patient.getCaretakers().iterator();

        while (caretakerIterator.hasNext()) {
            Caretaker caretaker = caretakerIterator.next();
            if (caretaker.getUsername().equals(caretakerUsername))
            caretakerIterator.remove();
            break;
        }
    }


    @RequestMapping(
            value = "/caretakers/{caretaker}/patients",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    @ResponseStatus(HttpStatus.OK)
    public List<String> getPatientsForCaretaker(@PathVariable("caretaker") String caretakerUsername) {
        return patientRepository.findPatientUserNamesByCaretaker(caretakerUsername);
    }

    @RequestMapping(
            value = "/patient/{patient}/caretakers",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    @ResponseStatus(HttpStatus.OK)
    public List<String> getCaretakerForCaretaker(@PathVariable("patient") String patientUsername) {
        return caretakerRepository.findCaretakerUserNamesByPatientUsername(patientUsername);
    }

}
