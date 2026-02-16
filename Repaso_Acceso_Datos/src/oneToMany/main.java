package oneToMany;

import java.util.Date;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class main {

    public static void main(String[] args) {

        // Creamos la factoría
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("oneToMany");
        System.out.println("Factoría creada");

        EntityManager em = emf.createEntityManager();
        System.out.println("Entidad creada");

        try {
            EntityTransaction tx = em.getTransaction();
            tx.begin();

            // Creamos una persona
            Persona p = new Persona();
            p.setNombre("Samira");
            em.persist(p);

            // Creamos varias facturas asociadas a esa persona
            Factura f1 = new Factura(new Date(), "Compra libros", 45.90, p);
            Factura f2 = new Factura(new Date(), "Cuota gimnasio", 29.99, p);

            em.persist(f1);
            em.persist(f2);

            tx.commit();
            System.out.println("Persona y facturas guardadas con éxito.");

        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Error, revirtiendo cambios.");
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
        } 
    }
}
