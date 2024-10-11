package com.preihs.sentences.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.preihs.sentences.entities.Role;
import com.preihs.sentences.auth.RoleName;


public interface RoleRepository extends JpaRepository<Role, Long> {
    Role findByName(RoleName name);
}
