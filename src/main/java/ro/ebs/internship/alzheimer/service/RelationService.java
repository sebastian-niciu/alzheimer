package ro.ebs.internship.alzheimer.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ro.ebs.internship.alzheimer.entity.Caretaker;
import ro.ebs.internship.alzheimer.entity.Patient;
import ro.ebs.internship.alzheimer.repository.CaretakerRepository;
import ro.ebs.internship.alzheimer.repository.PatientRepository;

import java.util.Iterator;

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
        patient.getCaretakers().add(caretaker);
    }

    @Transactional
    public void removeRelation(String patientUsername, String caretakerUsername) {
        Patient patient = patientRepository.findByUsername(patientUsername);
        Iterator<Caretaker> caretakerIterator = patient.getCaretakers().iterator();
        while (caretakerIterator.hasNext()) {
            Caretaker caretaker = caretakerIterator.next();
            if (caretaker.getUsername().equals(caretakerUsername)) {
                caretakerIterator.remove();
                break;
            }
        }
        patientRepository.save(patient);
    }

}
