package uy.org.curso.jpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.Date;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        System.out.println("01 - Crear una instancia de persona");
        Persona persona = new Persona(99L, "Prueba Main", "8888888-8", new Date());

        System.out.println("02 - Obtener Factory y pedirle el EntityManager");
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("curso_bse");
        EntityManager em = emf.createEntityManager();

        System.out.println("03 - Iniciar transaccion y persistir la persona");
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        em.persist(persona);

        System.out.println("04 - Hacer commit de la transaccion");
        tx.commit();

        System.out.println("05 - Obtener lista de persona desde la BD");
        List<Persona> personas = em.createNamedQuery("findAll", Persona.class).getResultList();
        for (Persona p : personas) {
            System.out.println(p);
        }

        System.out.println("06 - Cerrar la factory y el EntityManager");
        em.close();
        emf.close();
    }
}
