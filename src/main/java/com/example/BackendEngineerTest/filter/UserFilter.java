package com.example.BackendEngineerTest.filter;

import org.springframework.data.jpa.domain.Specification;

import com.example.BackendEngineerTest.entities.User;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

public class UserFilter implements Specification<User> {
	
/**
	 * 
	 */
private static final long serialVersionUID = 1L;
private User filter;
	
	public UserFilter(User filter) {
		super();
		this.filter = filter;
	}

	public Predicate toPredicate(Root<User> root, CriteriaQuery<?> cq,
			CriteriaBuilder cb) {
		
		Predicate user = cb.disjunction();

		if (filter.getName() != null) {
			user.getExpressions().add(cb.equal(root.get("name"), filter.getName()));
		}
		
		if (filter.getAge() != null && filter.getTimestamp() != null) {
			user.getExpressions().add(cb.and(
						cb.equal(root.get("age"), filter.getAge()),
						cb.equal(root.get("timestamp"), filter.getTimestamp())
						
					));
		}
		
		
		return user;
		
	}
}
