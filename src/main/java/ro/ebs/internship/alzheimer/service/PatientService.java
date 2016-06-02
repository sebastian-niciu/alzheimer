package ro.ebs.internship.alzheimer.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ro.ebs.internship.alzheimer.entity.Patient;
import ro.ebs.internship.alzheimer.repository.PatientRepository;

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
}
