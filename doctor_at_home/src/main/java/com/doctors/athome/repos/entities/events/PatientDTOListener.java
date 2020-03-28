package com.doctors.athome.repos.entities.events;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.mapping.event.AbstractMongoEventListener;
import org.springframework.data.mongodb.core.mapping.event.BeforeConvertEvent;
import org.springframework.stereotype.Component;

import com.doctors.athome.repos.entities.SequenceGeneratorService;
import com.doctors.athome.repos.entities.PatientDTO;

@Component
public class PatientDTOListener extends AbstractMongoEventListener<PatientDTO> {

	@Override
	public void onBeforeConvert(BeforeConvertEvent<PatientDTO> event) {
		
		super.onBeforeConvert(event);
		if(event.getSource().getPatientID() < 1) {
			event.getSource().setPatientID(sequenceGenerator.generateSequence(PatientDTO.SEQUENCE_NAME));
		}
	}
	private SequenceGeneratorService sequenceGenerator;
	
	@Autowired
	public PatientDTOListener(SequenceGeneratorService sequenceGenerator) {
		this.sequenceGenerator = sequenceGenerator;
	}
	
}
