package com.preihs.sentences.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.preihs.sentences.entities.User;

public interface UserRepository extends JpaRepository<User, Long>{
	Optional<User> findByUsername(String username);
}
