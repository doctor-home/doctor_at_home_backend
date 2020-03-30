package com.doctors.athome.jobs;

import org.springframework.batch.item.file.mapping.FieldSetMapper;
import org.springframework.batch.item.file.transform.FieldSet;
import org.springframework.validation.BindException;

import com.doctors.athome.repos.entities.OrganizationDTO;

public class OrganizationFromcsvMapper implements FieldSetMapper<OrganizationDTO>{

	@Override
	public OrganizationDTO mapFieldSet(FieldSet fieldSet) throws BindException {
		OrganizationDTO result = new OrganizationDTO(fieldSet.readString(2), fieldSet.readString(1));
		return result;
	}

}
