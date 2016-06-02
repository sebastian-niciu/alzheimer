package ro.ebs.internship.alzheimer.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import ro.ebs.internship.alzheimer.entity.Caretaker;

import java.util.List;

@Repository
public interface CaretakerRepository extends CrudRepository<Caretaker, Long> {

    @Query("SELECT c from Caretaker c where c.username = :username")
    Caretaker findByUsername(@Param("username") String username);

    @Query("SELECT c.username from Caretaker c join c.patients p where p.username = :username")
    List<String> findCaretakerUserNamesByPatientUsername(@Param("username") String username);

}
