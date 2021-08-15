package uy.org.curso.jpa.test;


import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.validation.ConstraintViolationException;

/**
 * Integration Test para Persona
 */
public class PersonaIT {
	private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("curso_bse_test");
	private EntityManager em;
	private EntityTransaction tx;
	
	
	@Before
	public void initEntityManager() throws Exception {
		em = emf.createEntityManager();
		tx = em.getTransaction();
	}

	@After
	public void closeEntityManager() {
		if (em != null) em.close();
	}

	/**
	 * Buscarme entre las personas del insert.sql (debe existir una persona con mi documento de identidad)
	 */
	@Test
	public void buscarme() {

	}

	/**
	 * Verifica que se hayan insertado la cantidad de registros del insert.sql
	 */
	@Test
	public void getAll() {

	}

	/**
	 * Insertar una persona que no cumpla con las constraints definidas para Persona
	 */
	@Test(expected = ConstraintViolationException.class)
	public void constraintViolation() {

	}
}
