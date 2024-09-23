package com.preihs.sentences.auth;

import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthenticationController {
	private AuthenticationService authService;

	public AuthenticationController(AuthenticationService authService) {
		this.authService = authService;
	}
	
	@PostMapping(path = "authenticate")
	public String authenticate(Authentication authentication) {
		return authService.authenticate(authentication);
	}
}
