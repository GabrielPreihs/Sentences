package com.preihs.sentences.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Service;

import com.preihs.sentences.entities.User;
import com.preihs.sentences.repositories.UserRepository;
import com.preihs.sentences.services.exceptions.ResourceNotFoundException;

@Service
public class UserService {
	@Autowired
	private UserRepository userRepository;

	@Autowired
	private MessageSource messageSource;
	
	public User findByUsername(String username) {
		return userRepository.findByUsername(username)
				.orElseThrow(() -> new ResourceNotFoundException(messageSource.getMessage("exception.user.NOT_FOUND", null, null)));
	}
	
}
