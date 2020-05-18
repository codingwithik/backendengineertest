package com.example.BackendEngineerTest.pojo;

import java.util.List;

import com.example.BackendEngineerTest.entities.User;

import lombok.Data;

public @Data class SpecificationRequest {
	
	private String providerId;
	private List<User> fields;
}
