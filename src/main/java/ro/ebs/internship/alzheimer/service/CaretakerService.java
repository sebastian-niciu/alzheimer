package ro.ebs.internship.alzheimer.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ro.ebs.internship.alzheimer.entity.Caretaker;
import ro.ebs.internship.alzheimer.entity.Patient;
import ro.ebs.internship.alzheimer.repository.CaretakerRepository;

import java.util.Iterator;
import java.util.List;

@Service
public class CaretakerService {

    @Autowired
    private CaretakerRepository caretakerRepository;

    @Transactional
    public void registerCaretaker(Caretaker caretaker) {
        caretakerRepository.save(caretaker);
    }

    @Transactional
    public List<String> getCaretakersForPatient(String caretaker) {
        return caretakerRepository.findCaretakerUserNamesByPatientUsername(caretaker);
    }

    @Transactional
    public void removePatientFromCaretaker(String caretakerUsername, String patientUsername) {
        Caretaker caretaker = caretakerRepository.findByUsername(caretakerUsername);

        Iterator<Patient> patientIterator = caretaker.getPatients().iterator();
        while (patientIterator.hasNext()) {
            Patient patient = patientIterator.next();
            if (patient.getUsername().equals(patientUsername)) {
                patientIterator.remove();
                break;
            }
        }
    }
}
