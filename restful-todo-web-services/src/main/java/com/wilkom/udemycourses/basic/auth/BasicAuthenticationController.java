package com.wilkom.udemycourses.basic.auth;

import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BasicAuthenticationController {

	@Autowired
	private MessageSource messageSource;

	// GET
	// URI - /hello-world
	@GetMapping("/basicauth")
	public AuthenticationBean helloWorld() {
		return new AuthenticationBean("You are authenticated !");
	}


}
