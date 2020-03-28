package com.doctors.athome.repos.entities.events;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.mapping.event.AbstractMongoEventListener;
import org.springframework.data.mongodb.core.mapping.event.BeforeConvertEvent;
import org.springframework.stereotype.Component;

import com.doctors.athome.repos.entities.SequenceGeneratorService;
import com.doctors.athome.repos.entities.ClinicianDTO;
import com.doctors.athome.repos.entities.PatientDTO;

@Component
public class ClinicianDTOListener extends AbstractMongoEventListener<ClinicianDTO> {

	@Override
	public void onBeforeConvert(BeforeConvertEvent<ClinicianDTO> event) {
		
		super.onBeforeConvert(event);
		if(event.getSource().getClinicianID() < 1) {
			event.getSource().setClinicianID(sequenceGenerator.generateSequence(PatientDTO.SEQUENCE_NAME));
		}
	}
	private SequenceGeneratorService sequenceGenerator;
	
	@Autowired
	public ClinicianDTOListener(SequenceGeneratorService sequenceGenerator) {
		this.sequenceGenerator = sequenceGenerator;
	}
	
}
