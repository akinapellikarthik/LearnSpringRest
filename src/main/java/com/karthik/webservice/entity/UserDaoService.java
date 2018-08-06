package com.karthik.webservice.entity;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

@Repository
@Transactional
public class UserDaoService {

	@PersistenceContext
	private EntityManager entityManager;
	
	public long saveUser(User u) {
		entityManager.persist(u);
		return u.getUserId();
	}
}

