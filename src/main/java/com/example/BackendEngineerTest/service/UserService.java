package com.example.BackendEngineerTest.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.BackendEngineerTest.entities.User;
import com.example.BackendEngineerTest.repository.UserRepository;

@Service
public class UserService {
	
	private UserRepository userRepository;

	public UserService(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	public Optional<User> findById(Integer id) {
		return userRepository.findById(id);
	}


	public List<User> findAll() {
		return (List<User>) userRepository.findAll();
	}

	
	public void deleteById(Integer id) {
		userRepository.deleteById(id);
	}

	public void delete(User user) {
		userRepository.delete(user);
	}

	public User save(User user) {
		return userRepository.save(user);
	}

	public void saveAll(List<User> users) {
		userRepository.saveAll(users);
	}

	public boolean existsById(Integer id) {
		return userRepository.existsById(id);
	}

	public long count() {
		return userRepository.count();
	}

	public void deleteAll(List<User> users) {
		userRepository.deleteAll(users);
	}

	public void deleteAll() {
		userRepository.deleteAll();
	}

}
