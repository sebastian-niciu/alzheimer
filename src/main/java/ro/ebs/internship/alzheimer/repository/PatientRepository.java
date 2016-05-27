package ro.ebs.internship.alzheimer.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import ro.ebs.internship.alzheimer.entity.Patient;

import java.util.List;

@Repository
public interface PatientRepository extends CrudRepository<Patient, Long> {

    Patient findByUsername(String username);

    @Query("Select p.username from Patient p join p.caretakers c where c.username = :username" )
    List<String> findPatientUserNamesByCaretaker(@Param("username") String username);
}
