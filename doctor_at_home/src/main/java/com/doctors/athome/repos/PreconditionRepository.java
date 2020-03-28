package com.doctors.athome.repos;
import org.springframework.data.mongodb.repository.MongoRepository;

import com.doctors.athome.repos.entities.PreconditionDTO;

public interface PreconditionRepository extends MongoRepository<PreconditionDTO, Long> {

}
