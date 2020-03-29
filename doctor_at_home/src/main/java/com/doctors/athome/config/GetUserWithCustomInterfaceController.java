package com.doctors.athome.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class GetUserWithCustomInterfaceController {

	@Autowired
	private AuthenticationFacade authenticationFacade;
	
	@RequestMapping(value = "/username", method = RequestMethod.GET)
    @ResponseBody
	public String currentUserNameSimple() {
		Authentication authentication = authenticationFacade.getAuthentication();
		return authentication.getName();
	}
	

}
