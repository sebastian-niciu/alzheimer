package ro.ebs.internship.alzheimer.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ro.ebs.internship.alzheimer.entity.Caretaker;
import ro.ebs.internship.alzheimer.entity.Location;
import ro.ebs.internship.alzheimer.entity.Patient;
import ro.ebs.internship.alzheimer.repository.CaretakerRepository;
import ro.ebs.internship.alzheimer.repository.LocationRepository;
import ro.ebs.internship.alzheimer.repository.PatientRepository;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.List;

@Service
public class LocationService {

    @Autowired
    private PatientRepository patientRepository;

    @Autowired
    private CaretakerRepository caretakerRepository;

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

    @Transactional
    public Map<String, List<Location>> getAllLocationsFromService(String caretakerUsername) {
        Map<String, List<Location>> locationsForPatients = new HashMap<String, List<Location>>();
        Caretaker caretaker = caretakerRepository.findByUsername(caretakerUsername);
        for (Patient patient : caretaker.getPatients()) {
            locationsForPatients.put(patient.getUsername(), patient.getLocations());
        }
        return locationsForPatients;
    }

    @Transactional
    public Map<String, List<Location>> getLastLocationFromService(String caretakerUsername) {
        Map<String, List<Location>> lastLocationForPatients = new HashMap<>();
        Caretaker caretaker = caretakerRepository.findByUsername(caretakerUsername);
        for (Patient patient : caretaker.getPatients()) {
            String patientUsername = patient.getUsername();
            List<Location> lastLocation = getLastLocationAsList(patient);
            lastLocationForPatients.put(patientUsername, lastLocation);
        }
        return lastLocationForPatients;
    }

    public List<Location> getAllLocationsForPatient(String patientUsername, String caretakerUsername) {
        return locationRepository.findByPatientAndCaretakerUsername(patientUsername, caretakerUsername);
    }

    private List<Location> getLastLocationAsList(Patient patient) {
        List<Location> locations = patient.getLocations();
        List<Location> lastLocation = Collections.emptyList();
        if(locations != null && locations.size() > 0) {
            lastLocation = Collections.singletonList(locations.get(0));
        }
        return lastLocation;
    }

}
