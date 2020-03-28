package com.doctors.athome.repos.entities.events;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.mapping.event.AbstractMongoEventListener;
import org.springframework.data.mongodb.core.mapping.event.BeforeConvertEvent;
import org.springframework.stereotype.Component;

import com.doctors.athome.repos.entities.ClinicianDTO;

@Component
public class ClinicianDTOListener extends AbstractMongoEventListener<ClinicianDTO> {

	
	@Autowired
    private MongoOperations mongoOperations;

	
	@Override
	public void onBeforeConvert(BeforeConvertEvent<ClinicianDTO> event) {
		
		super.onBeforeConvert(event);
		final ClinicianDTO source = event.getSource();
		if (source.getPatients() != null) {
            mongoOperations.save(source.getPatients());
        }
	}
	
	
}
