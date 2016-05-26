package ro.ebs.internship.alzheimer.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ro.ebs.internship.alzheimer.entity.User;

@Repository
public interface UserRepository  extends CrudRepository<User, String> {

}
