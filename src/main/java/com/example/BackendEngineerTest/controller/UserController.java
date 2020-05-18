package com.example.BackendEngineerTest.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.BackendEngineerTest.entities.Provider;
import com.example.BackendEngineerTest.entities.User;
import com.example.BackendEngineerTest.exception.NotFoundException;
import com.example.BackendEngineerTest.filter.UserFilter;
import com.example.BackendEngineerTest.pojo.GenericResponse;
import com.example.BackendEngineerTest.pojo.SpecificationRequest;
import com.example.BackendEngineerTest.repository.UserRepository;
import com.example.BackendEngineerTest.service.ProviderService;

@RestController
@RequestMapping(path = "api")
public class UserController {
	
	@Autowired
	private ProviderService providerService;
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	MessageSource messageSource;
	
	@PostMapping("/v1/specification")
	public GenericResponse createSpecification(@RequestBody SpecificationRequest request) {
		
		Provider provider = new Provider();
		
		provider.setProviderId(request.getProviderId());
		provider.setUsers(request.getFields());
		
		provider = providerService.save(provider);
		
		return new GenericResponse(request.getProviderId(), request.getFields());
		
	}
	
	@GetMapping("/v1/filter/{providerId}")
	public List<User> filter(@PathVariable String providerId, @RequestParam(value = "name", required = false) String name, 
			@RequestParam(value = "age", required = false) String age,  
			@RequestParam(value = "timestamp", required = false) String timestamp) {
		
		String[] params = new String[] {providerId , "Provider" };
		
		 providerService.findByProviderId(providerId).orElseThrow(() -> new NotFoundException(
				messageSource.getMessage("not.found", params, LocaleContextHolder.getLocale())));
		 
		 User filter = new User();
		 filter.setName(name);
		 filter.setAge(age);
		 filter.setTimestamp(timestamp);
		 
		 Specification<User> spec = new UserFilter(filter);

		 List<User> result = userRepository.findAll(spec);
		 
		return result; 
		
	}
}
