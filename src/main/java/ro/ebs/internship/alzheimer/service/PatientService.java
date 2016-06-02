package ro.ebs.internship.alzheimer.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ro.ebs.internship.alzheimer.entity.Caretaker;
import ro.ebs.internship.alzheimer.entity.Patient;
import ro.ebs.internship.alzheimer.repository.PatientRepository;

import java.util.Iterator;
import java.util.List;

@Service
public class PatientService {

    @Autowired
    private PatientRepository patientRepository;

    @Transactional
    public void registerPatient(Patient patient) {
        patientRepository.save(patient);
    }

    @Transactional
    public List<String> getPatientsForCaretaker(String caretakerUsername) {
        return patientRepository.findPatientUserNamesByCaretaker(caretakerUsername);
    }

    @Transactional
    public void removeCaretakerFromPatient(String patientUsername, String caretakerUsername) {
        Patient patient = patientRepository.findByUsername(patientUsername);

        Iterator<Caretaker> caretakerIterator = patient.getCaretakers().iterator();
        while (caretakerIterator.hasNext()) {
            Caretaker caretaker = caretakerIterator.next();
            if (caretaker.getUsername().equals(caretakerUsername)) {
                caretakerIterator.remove();
                break;
            }
        }
    }
}
