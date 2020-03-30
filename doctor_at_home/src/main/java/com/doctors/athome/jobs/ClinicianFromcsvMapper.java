package com.doctors.athome.jobs;

import java.util.ArrayList;
import java.util.List;

import org.springframework.batch.item.file.mapping.FieldSetMapper;
import org.springframework.batch.item.file.transform.FieldSet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.validation.BindException;

import com.doctors.athome.repos.entities.ClinicianDTO;
import com.doctors.athome.repos.entities.OrganizationDTO;
import com.doctors.athome.repos.entities.PatientSummaryDTO;

public class ClinicianFromcsvMapper implements FieldSetMapper<ClinicianDTO>{

	@Autowired
	PasswordEncoder passwordEncoder;
	@Override
	public ClinicianDTO mapFieldSet(FieldSet fieldSet) throws BindException {
		List<OrganizationDTO> orgs = new ArrayList<OrganizationDTO>();
		OrganizationDTO org = new OrganizationDTO(fieldSet.readString(6), fieldSet.readString(5));
		orgs.add(org);
		ClinicianDTO result = new ClinicianDTO(fieldSet.readString(2), fieldSet.readString(1), 
							orgs, new ArrayList<PatientSummaryDTO>());
		result.setUserName(fieldSet.readString(3));
		result.setPassword(passwordEncoder.encode(fieldSet.readString(4)));
		return result;
	}

}
