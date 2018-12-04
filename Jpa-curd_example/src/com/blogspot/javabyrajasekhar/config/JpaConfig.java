package com.blogspot.javabyrajasekhar.config;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JpaConfig {

	private static EntityManager entityManager;
	
	private JpaConfig() {
		
	}
	
	private static EntityManagerFactory createEntityManagerFactory() {
		return Persistence.createEntityManagerFactory("Jpa-curd_example");
	}
	
	public static EntityManager getInstance() {
		return createEntityManagerFactory().createEntityManager();
		
	}
}
