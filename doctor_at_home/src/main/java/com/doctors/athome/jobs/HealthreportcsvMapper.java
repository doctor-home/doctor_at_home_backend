package com.doctors.athome.jobs;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.springframework.batch.item.file.mapping.FieldSetMapper;
import org.springframework.batch.item.file.transform.FieldSet;
import org.springframework.validation.BindException;

import com.doctors.athome.repos.entities.HealthReportDTO;


public class HealthreportcsvMapper implements FieldSetMapper<HealthReportDTO>{

	@Override
	public HealthReportDTO mapFieldSet(FieldSet fieldSet) throws BindException {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
		HealthReportDTO result = new HealthReportDTO(null, LocalDateTime.parse(fieldSet.readString(2), formatter), 
												fieldSet.readString(1),
												fieldSet.readInt(3),
												fieldSet.readBigDecimal(4).floatValue(),
												fieldSet.readBigDecimal(5).floatValue(),
												fieldSet.readInt(6),
												fieldSet.readInt(7));
		return result;
	}

}
