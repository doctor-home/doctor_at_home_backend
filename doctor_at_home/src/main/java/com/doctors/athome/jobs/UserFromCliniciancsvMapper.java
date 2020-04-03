package com.doctors.athome.jobs;

import java.util.ArrayList;

import org.springframework.batch.item.file.mapping.FieldSetMapper;
import org.springframework.batch.item.file.transform.FieldSet;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.validation.BindException;

import com.doctors.athome.repos.entities.UserDTO;

public class UserFromCliniciancsvMapper implements FieldSetMapper<UserDTO>{

	@Override
	public UserDTO mapFieldSet(FieldSet fieldSet) throws BindException {
		UserDTO user = new UserDTO(fieldSet.readString(2),fieldSet.readString(3),
				new BCryptPasswordEncoder().encode(fieldSet.readString(4)),
				new ArrayList<String>() {
					private static final long serialVersionUID = 1L;
					{
						add("user");
					}
				});
		return user;
	}

}
