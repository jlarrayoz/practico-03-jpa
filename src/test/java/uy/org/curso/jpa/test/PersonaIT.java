package uy.org.curso.jpa.test;


import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import uy.org.curso.jpa.Persona;

import javax.persistence.*;
import javax.validation.ConstraintViolationException;
import java.util.Date;
import java.util.List;

import static junit.framework.TestCase.assertEquals;

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
		Persona persona = em.createNamedQuery("findMe", Persona.class).getSingleResult();
		assertEquals("1234567-8", persona.getNroDocumento());
	}

	/**
	 * Verifica que se hayan insertado la cantidad de registros del insert.sql
	 */
	@Test
	public void getAll() {
		List<Persona> personas = em.createNamedQuery("findAll", Persona.class).getResultList();
		assertEquals(3L, personas.size());
	}

	/**
	 * Insertar una persona que no cumpla con las constraints definidas para Persona
	 */
	@Test(expected = ConstraintViolationException.class)
	public void contraintViolation() {
		Persona p = new Persona(null, null, "6785231-5", new Date());
		tx.begin();
		em.persist(p);
	}
}
