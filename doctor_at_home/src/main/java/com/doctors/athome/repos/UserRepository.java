package com.doctors.athome.repos;

import org.springframework.data.mongodb.repository.MongoRepository;
import com.doctors.athome.repos.entities.UserDTO;

public interface UserRepository extends MongoRepository<UserDTO, String>  {

}
