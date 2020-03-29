package com.doctors.athome.jobs;

import java.util.ArrayList;

import org.springframework.batch.item.file.mapping.FieldSetMapper;
import org.springframework.batch.item.file.transform.FieldSet;
import org.springframework.validation.BindException;

import com.doctors.athome.repos.entities.ClinicianDTO;
import com.doctors.athome.repos.entities.OrganizationDTO;

public class ClinicianFromcsvMapper implements FieldSetMapper<ClinicianDTO>{

	@Override
	public ClinicianDTO mapFieldSet(FieldSet fieldSet) throws BindException {
		
		ClinicianDTO result = new ClinicianDTO(fieldSet.readString(1), 
							new ArrayList<OrganizationDTO>() {{
								new OrganizationDTO(fieldSet.readString(5))
									.setOrganizationID(fieldSet.readString(6));
							}}, null);
		result.setClinicianID(fieldSet.readString(2));
		result.setUserName(fieldSet.readString(3));
		result.setPassword(fieldSet.readString(4));
		return result;
	}

}
