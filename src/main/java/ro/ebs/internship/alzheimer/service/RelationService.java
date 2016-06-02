package ro.ebs.internship.alzheimer.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ro.ebs.internship.alzheimer.entity.Caretaker;
import ro.ebs.internship.alzheimer.entity.Patient;
import ro.ebs.internship.alzheimer.repository.CaretakerRepository;
import ro.ebs.internship.alzheimer.repository.PatientRepository;

@Service
public class RelationService {

    @Autowired
    private CaretakerRepository caretakerRepository;

    @Autowired
    private PatientRepository patientRepository;

    @Transactional
    public void createRelation(String caretakerUsername, String patientUsername) {
        Caretaker caretaker = caretakerRepository.findByUsername(caretakerUsername);
        Patient patient = patientRepository.findByUsername(patientUsername);
        caretaker.getPatients().add(patient);
    }

}
