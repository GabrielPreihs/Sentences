package com.preihs.sentences.auth;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

import com.preihs.sentences.entities.User;
import com.preihs.sentences.services.UserService;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
	private final UserService userService;

	public UserDetailsServiceImpl(UserService userService) {
		this.userService = userService;
	}

	@Override
	public UserDetails loadUserByUsername(String username) {
		User user = userService.findByUsername(username);
		return new UserAuthenticated(user);
	}

}
