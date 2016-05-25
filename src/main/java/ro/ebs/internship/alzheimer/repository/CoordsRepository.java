package ro.ebs.internship.alzheimer.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ro.ebs.internship.alzheimer.entity.Coord;

@Repository
public interface CoordsRepository extends CrudRepository<Coord, Long> {

}
