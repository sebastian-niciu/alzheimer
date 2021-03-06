package ro.ebs.internship.alzheimer.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import ro.ebs.internship.alzheimer.entity.Location;

import java.util.List;

@Repository
public interface LocationRepository extends CrudRepository<Location, Long> {

    @Query("SELECT l FROM Location l where l.patient.username = :username")
    List<Location> findByPatientUsername(@Param("username") String patient);

    @Query("SELECT l FROM Location l join l.patient.caretakers c where l.patient.username = :patientUsername and c.username =:caretakerUsername")
    List<Location> findByPatientAndCaretakerUsername(@Param("patientUsername") String patient, @Param("caretakerUsername") String caretaker);

}