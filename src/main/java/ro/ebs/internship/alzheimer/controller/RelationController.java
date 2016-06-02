package ro.ebs.internship.alzheimer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import ro.ebs.internship.alzheimer.service.RelationService;

import java.util.List;

@RestController
public class RelationController {

    @Autowired
    private RelationService relationService;

    @RequestMapping(
            value = "/patients/{patient}/caretakers/{caretaker}",
            method = RequestMethod.PUT
    )
    @ResponseStatus(HttpStatus.CREATED)
    public void createPatientCaretakerRelation(@PathVariable("patient") String patientUsername,
                               @PathVariable("caretaker") String caretakerUsername) {
        relationService.createRelation(caretakerUsername, patientUsername);
    }

    @RequestMapping(
            value = "/caretakers/{caretaker}/patients/{patient}",
            method = RequestMethod.PUT
    )
    @ResponseStatus(HttpStatus.CREATED)
    public void createCaretakerPatientRelation(@PathVariable("caretaker") String caretakerUsername,
                               @PathVariable("patient") String patientUsername) {
        relationService.createRelation(caretakerUsername, patientUsername);
    }

    @RequestMapping(
            value = "/caretakers/{caretaker}/patients",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    @ResponseStatus(HttpStatus.OK)
    public List<String> getPatientsForCaretaker(@PathVariable("caretaker") String caretakerUsername) {
        return relationService.getPatientsForCaretaker(caretakerUsername);
    }

    @RequestMapping(
            value = "/patients/{patient}/caretakers",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    @ResponseStatus(HttpStatus.OK)
    public List<String> getCaretakersForPatient(@PathVariable("patient") String patientUsername) {
        return relationService.getCaretakersForPatient(patientUsername);
    }

    @RequestMapping(
            value = "/caretakers/{caretaker}/patients/{patient}",
            method = RequestMethod.DELETE
    )
    @ResponseStatus(HttpStatus.OK)
    public void removePatientFromCaretaker(@PathVariable("caretaker") String caretakerUsername,
                                           @PathVariable("patient") String patientUsername) {
        relationService.removePatientFromCaretaker(caretakerUsername, patientUsername);
    }

    @RequestMapping(
            value = "/patients/{patient}/caretakers/{caretaker}",
            method = RequestMethod.DELETE
    )
    @ResponseStatus(HttpStatus.OK)
    public void removeCaretakerFromPatient(@PathVariable("patient") String patientUsername,
                                           @PathVariable("caretaker") String caretakerUsername) {
        relationService.removePatientFromCaretaker(caretakerUsername, patientUsername);
    }
}
