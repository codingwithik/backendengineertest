package com.example.BackendEngineerTest.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.example.BackendEngineerTest.entities.Provider;

public interface ProviderRepository extends CrudRepository<Provider, Integer>{
	Optional<Provider> findByProviderId(String providerid);
}
