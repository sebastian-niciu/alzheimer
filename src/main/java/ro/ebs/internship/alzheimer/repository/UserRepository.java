package ro.ebs.internship.alzheimer.repository;

import org.springframework.data.repository.CrudRepository;
import ro.ebs.internship.alzheimer.entity.User;


public interface UserRepository  extends CrudRepository<User, String> {


}
