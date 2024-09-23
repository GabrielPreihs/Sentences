package com.preihs.sentences.entities;

import com.preihs.sentences.auth.RoleName;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "roles")
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    private RoleName name;

	public Role() {}

	public Role(Long id, RoleName name) {
		this.id = id;
		this.name = name;
	}

	public Long getId() {
		return id;
	}

	public RoleName getName() {
		return name;
	}
}
