package com.doctors.athome.repos;
import org.springframework.data.mongodb.repository.MongoRepository;
import com.doctors.athome.repos.entities.PatientDTO;

public interface PatientRepository extends MongoRepository<PatientDTO, String> {

}
