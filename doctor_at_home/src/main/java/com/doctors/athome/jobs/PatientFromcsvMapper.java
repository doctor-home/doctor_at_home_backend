package com.doctors.athome.jobs;

import org.springframework.batch.item.file.mapping.FieldSetMapper;
import org.springframework.batch.item.file.transform.FieldSet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Component;
import org.springframework.validation.BindException;

import com.doctors.athome.repos.entities.HealthReportDTO;
import com.doctors.athome.repos.entities.PatientDTO;
import com.doctors.athome.repos.entities.PatientSummaryDTO;


public class PatientFromcsvMapper implements FieldSetMapper<PatientDTO>{
	
	@Override
	public PatientDTO mapFieldSet(FieldSet fieldSet) throws BindException {
		PatientDTO result = new PatientDTO();
		if(fieldSet.getFieldCount() > 0) {
			result = new PatientDTO(fieldSet.readString(1),
					fieldSet.readString(2) + " " + fieldSet.readString(3),
					fieldSet.readString(4),
					fieldSet.readString(5),
					fieldSet.readString(6),
					fieldSet.readInt(7),
					0,
					fieldSet.readInt(9),
					fieldSet.readBoolean(10),
					fieldSet.readBoolean(15),
					convertArrayFileToSingle(fieldSet.readString(12)),
					fieldSet.readString(8));
		}
		
		return result;
	}
	
	
	private String convertArrayFileToSingle (String field) {
		return field.substring(2, field.length()-2);
	}
	
	
	
	

}
