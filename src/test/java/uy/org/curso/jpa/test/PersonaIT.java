package uy.org.curso.jpa.test;


import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

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
	
	@Test
	public void buscarme() {

	}

	@Test
	public void contraintViolation() {

	}
}
