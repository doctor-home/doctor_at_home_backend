package com.doctors.athome.jobs;

import org.springframework.batch.item.file.mapping.FieldSetMapper;
import org.springframework.batch.item.file.transform.FieldSet;
import org.springframework.validation.BindException;

import com.doctors.athome.repos.entities.PatientDTO;

public class PatientFromcsvMapper implements FieldSetMapper<PatientDTO>{

	@Override
	public PatientDTO mapFieldSet(FieldSet fieldSet) throws BindException {
		
		PatientDTO result = null;
		return result;
	}

}
