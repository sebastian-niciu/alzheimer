package ro.ebs.internship.alzheimer.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ro.ebs.internship.alzheimer.entity.Caretaker;

@Repository
public interface CaretakerRepository extends CrudRepository<Caretaker, Long> {
    Caretaker findByUsername(String username);
}
