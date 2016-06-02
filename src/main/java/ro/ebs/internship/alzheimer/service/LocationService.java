package ro.ebs.internship.alzheimer.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ro.ebs.internship.alzheimer.entity.Location;
import ro.ebs.internship.alzheimer.entity.Patient;
import ro.ebs.internship.alzheimer.repository.LocationRepository;
import ro.ebs.internship.alzheimer.repository.PatientRepository;

import java.util.List;

@Service
public class LocationService {

    @Autowired
    private PatientRepository patientRepository;

    @Autowired
    private LocationRepository locationRepository;

    @Transactional
    public void saveLocation(Location location, String patientUsername) {
        Patient patient = patientRepository.findByUsername(patientUsername);
        location.setPatient(patient);
        locationRepository.save(location);
    }

    @Transactional
    public List<Location> getLocationsFromService(String patient) {
        return locationRepository.findByPatientUsername(patient);
    }

}
