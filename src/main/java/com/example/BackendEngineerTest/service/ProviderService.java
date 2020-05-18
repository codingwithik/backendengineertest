package com.example.BackendEngineerTest.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.BackendEngineerTest.entities.Provider;
import com.example.BackendEngineerTest.repository.ProviderRepository;

@Service
public class ProviderService {
	
	private ProviderRepository providerRepository;

	public ProviderService(ProviderRepository providerRepository) {
		this.providerRepository = providerRepository;
	}

	public Optional<Provider> findById(Integer id) {
		return providerRepository.findById(id);
	}

	
	public Optional<Provider> findByProviderId(String providerid) {
		return providerRepository.findByProviderId(providerid);
	}


	public List<Provider> findAll() {
		return (List<Provider>) providerRepository.findAll();
	}

	
	public void deleteById(Integer id) {
		providerRepository.deleteById(id);
	}

	public void delete(Provider provider) {
		providerRepository.delete(provider);
	}

	public Provider save(Provider provider) {
		return providerRepository.save(provider);
	}

	public void saveAll(List<Provider> providers) {
		providerRepository.saveAll(providers);
	}

	public boolean existsById(Integer id) {
		return providerRepository.existsById(id);
	}

	public long count() {
		return providerRepository.count();
	}

	public void deleteAll(List<Provider> providers) {
		providerRepository.deleteAll(providers);
	}

	public void deleteAll() {
		providerRepository.deleteAll();
	}

}
