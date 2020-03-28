package com.doctors.athome.repos.entities.events;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.mapping.event.AbstractMongoEventListener;
import org.springframework.data.mongodb.core.mapping.event.BeforeConvertEvent;
import org.springframework.stereotype.Component;

import com.doctors.athome.repos.entities.PatientDTO;

@Component
public class PatientDTOListener extends AbstractMongoEventListener<PatientDTO> {

	@Autowired
    private MongoOperations mongoOperations;

	
	@Override
	public void onBeforeConvert(BeforeConvertEvent<PatientDTO> event) {
		
		super.onBeforeConvert(event);
		final PatientDTO source = event.getSource();
		if (source.getPreconditions() != null) {
            mongoOperations.save(source.getPreconditions());
        }
		if(source.getPatientSummary() != null) {
			mongoOperations.save(source.getPatientSummary());
		}
	}
	
}
