package com.blogspot.javabyrajasekhar.Controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import com.blogspot.javabyrajasekhar.config.JpaConfig;
import com.blogspot.javabyrajasekhar.entity.Employee;

public class App {

	public static void main(String[] args) {

		EntityManager entityManager = JpaConfig.getInstance();

		Employee employee = new Employee();
		employee.setName("vamsi");
		employee.setSalary(2300d);

		save(entityManager, employee);

		getByEmployeeId(entityManager,101);
		updateEmployee(entityManager,"anil",101);
		deleteEmployeeById(entityManager,101);
		getAllEmployees(entityManager);

		entityManager.close();
	}

	private static void updateEmployee(EntityManager entityManager,String name,Integer id) {
		// updating employee record

		Employee updateemployee = entityManager.find(Employee.class, id);
		entityManager.getTransaction().begin();

		if (updateemployee != null) {
			updateemployee.setName(name);
			entityManager.persist(updateemployee);
		} else {
			System.out.println("employee is not avalibale");
		}

		entityManager.getTransaction().commit();
	}

	private static void deleteEmployeeById(EntityManager entityManager,Integer id) {
		entityManager.getTransaction().begin();

		Employee e4 = entityManager.find(Employee.class, id);
		if (e4 != null) {
			// entityManager.remove(e4);
		} else {
			System.out.println("employee not avaliable");
		}
		entityManager.getTransaction().commit();
	}

	private static void getAllEmployees(EntityManager entityManager) {
		String query = "select e from Employee e";
		// get all employees
		TypedQuery<Employee> typedQuery = entityManager.createQuery(query, Employee.class);
		List<Employee> emplist = typedQuery.getResultList();
		for (Employee e3 : emplist) {
			System.out.println(e3);
		}
	}

	private static void getByEmployeeId(EntityManager entityManager,Integer id) {
		// get employee by id
		Employee e2 = entityManager.find(Employee.class, id);
		System.out.println(e2);
	}

	private static void save(EntityManager entityManager, Employee employee) {
		// persisting employee object
		entityManager.getTransaction().begin();
		entityManager.persist(employee);
		entityManager.getTransaction().commit();
	}

}
