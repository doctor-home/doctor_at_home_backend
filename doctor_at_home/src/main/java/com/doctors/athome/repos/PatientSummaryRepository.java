package com.doctors.athome.repos;
import org.springframework.data.mongodb.repository.MongoRepository;

import com.doctors.athome.repos.entities.PatientSummaryDTO;

public interface PatientSummaryRepository extends MongoRepository<PatientSummaryDTO, String> {

}
