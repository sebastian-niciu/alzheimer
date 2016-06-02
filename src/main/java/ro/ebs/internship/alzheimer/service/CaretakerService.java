package ro.ebs.internship.alzheimer.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ro.ebs.internship.alzheimer.entity.Caretaker;
import ro.ebs.internship.alzheimer.entity.Patient;
import ro.ebs.internship.alzheimer.repository.CaretakerRepository;

@Service
public class CaretakerService {

    @Autowired
    private CaretakerRepository caretakerRepository;

    @Transactional
    public void registerCaretaker(Caretaker caretaker) {
        caretakerRepository.save(caretaker);
    }

    /*@Transactional
    public List<Caretaker> getCaretakersFromService(String caretaker) {
        return caretakerRepository.findByCaretakerUsername(caretaker);
    }*/
}
