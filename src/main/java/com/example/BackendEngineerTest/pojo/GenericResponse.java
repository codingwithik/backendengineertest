package com.example.BackendEngineerTest.pojo;

import java.util.List;

import com.example.BackendEngineerTest.entities.User;

import lombok.Data;

@Data
public class GenericResponse {
	
	private String providerId;
	private List<User> data;
	
	public GenericResponse(String providerId) {
		super();
		this.providerId = providerId;
	}
	
	public GenericResponse(String providerId, List<User> data) {
		super();
		this.providerId = providerId;
		this.data = data;
	}

}
