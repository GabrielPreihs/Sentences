package com.preihs.sentences.configuration;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import com.preihs.sentences.auth.RoleName;
import com.preihs.sentences.entities.Role;
import com.preihs.sentences.entities.User;
import com.preihs.sentences.repositories.RoleRepository;
import com.preihs.sentences.repositories.UserRepository;

import jakarta.transaction.Transactional;

@Component
public class SetupDataLoader implements
  ApplicationListener<ContextRefreshedEvent> {

    boolean alreadySetup = false;

    @Autowired
    private UserRepository userRepository;
 
    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;
 
    @Override
    @Transactional
    public void onApplicationEvent(ContextRefreshedEvent event) {
 
        if (alreadySetup)
            return;

        for (RoleName roleName : RoleName.values()) {
            createRoleIfNotFound(roleName);
        }

        Role adminRole = roleRepository.findByName(RoleName.ROLE_ADM);
        User user = new User();
        user.setUsername("admin");
        user.setPassword("$2a$10$aqsKDtykkO9/VsFmJP1/tuMSdR/0exuRRC2DHV7vpDH8/3I9rdpyy");
        user.setEmail("test@mail.com");
        user.setRoles(adminRole);
        userRepository.save(user);

        alreadySetup = true;
    }

    @Transactional
    Role createRoleIfNotFound(RoleName name) {
        Role role = roleRepository.findByName(name);
        if (role == null) {
            role = new Role(name);
            roleRepository.save(role);
        }
        return role;
    }
}