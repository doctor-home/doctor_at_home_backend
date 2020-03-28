package com.doctors.athome.repos;
import org.springframework.data.mongodb.repository.MongoRepository;

import com.doctors.athome.repos.entities.ClinicianDTO;

public interface ClinicianRepository extends MongoRepository<ClinicianDTO, Long> {

}
