package ro.ebs.internship.alzheimer.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ro.ebs.internship.alzheimer.entity.Relation;

@Repository
public interface RelationRepository extends CrudRepository<Relation, Long> {

    
}
