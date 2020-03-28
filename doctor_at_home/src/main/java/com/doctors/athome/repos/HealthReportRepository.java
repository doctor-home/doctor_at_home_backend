package com.doctors.athome.repos;
import org.springframework.data.mongodb.repository.MongoRepository;

import com.doctors.athome.repos.entities.HealthReportDTO;

public interface HealthReportRepository extends MongoRepository<HealthReportDTO, String> {

}
