package com.blogspot.javabyrajasekhar.Controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import com.blogspot.javabyrajasekhar.entity.Employee;

public class App {

	public static void main(String[] args) {

		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("Jpa-curd_example");
		EntityManager entityManager = entityManagerFactory.createEntityManager();

		Employee employee = new Employee();
		employee.setName("vamsi");
		employee.setSalary(2300d);

		// persisting employee object
		entityManager.getTransaction().begin();
		// entityManager.persist(employee);
		entityManager.getTransaction().commit();

		// get employee by id
		// Employee e2 = entityManager.find(Employee.class, 101);
		// System.out.println(e2);

		String query = "select e from Employee e";
		// get all employees
		TypedQuery<Employee> typedQuery = entityManager.createQuery(query, Employee.class);
		List<Employee> emplist = typedQuery.getResultList();
		for (Employee e3 : emplist) {
			System.out.println(e3);
		}

		entityManager.getTransaction().begin();

		Employee e4 = entityManager.find(Employee.class, 1);
		if (e4 != null) {
			//entityManager.remove(e4);
		} else {
			System.out.println("employee not avaliable");
		}
		entityManager.getTransaction().commit();

		// updating employee record

		Employee updateemployee = entityManager.find(Employee.class, 101);
		entityManager.getTransaction().begin();

		if (updateemployee != null) {
			updateemployee.setName("rajasekhar");
			entityManager.persist(updateemployee);
		} else {
			System.out.println("employee is not avalibale");
		}

		entityManager.getTransaction().commit();

		entityManager.close();
		entityManagerFactory.close();
	}

}
