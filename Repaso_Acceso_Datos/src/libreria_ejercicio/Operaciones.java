package bdprestamos_nazan;

import jakarta.persistence.*;
import java.util.List;

public class Operaciones {

    private EntityManagerFactory emf;
    private EntityManager em;

    public Operaciones() {
        emf = Persistence.createEntityManagerFactory("UPPrestamos");
        em = emf.createEntityManager();
    }

    // ── SIN CONSULTAS ──────────────────────────────────────────

    // 1. Crear tres libros, tres socios y tres préstamos
    public void crearDatosPrueba() {
        em.getTransaction().begin();

        // Libros
        Libro l1 = new Libro(); l1.setIsbn("111"); l1.setTitulo("El Quijote"); l1.setAutor("Cervantes"); l1.setNumEjemplar(3);
        Libro l2 = new Libro(); l2.setIsbn("222"); l2.setTitulo("1984"); l2.setAutor("Orwell"); l2.setNumEjemplar(5);
        Libro l3 = new Libro(); l3.setIsbn("333"); l3.setTitulo("Dune"); l3.setAutor("Herbert"); l3.setNumEjemplar(2);

        em.persist(l1); em.persist(l2); em.persist(l3);

        // Socios
        Socio s1 = new Socio(); s1.setDni("11111111A"); s1.setNombre("Juan García"); s1.setNumTelefono("600111222");
        Socio s2 = new Socio(); s2.setDni("22222222B"); s2.setNombre("María López"); s2.setNumTelefono("600333444");
        Socio s3 = new Socio(); s3.setDni("33333333C"); s3.setNombre("Pedro Martínez"); s3.setNumTelefono("600555666");

        em.persist(s1); em.persist(s2); em.persist(s3);

        // Préstamos
        Prestamos p1 = new Prestamos(); p1.setPrestado(true); p1.setSocio(s1); p1.setLibro(l1);
        Prestamos p2 = new Prestamos(); p2.setPrestado(true); p2.setSocio(s2); p2.setLibro(l2);
        Prestamos p3 = new Prestamos(); p3.setPrestado(false); p3.setSocio(s3); p3.setLibro(l3);

        em.persist(p1); em.persist(p2); em.persist(p3);

        em.getTransaction().commit();
        System.out.println("✔ Datos creados correctamente.");
    }

    // 2. Actualizar teléfono de un socio por DNI
    public void actualizarTelefono(String dni, String nuevoTelefono) {
        em.getTransaction().begin();

        Socio socio = em.find(Socio.class, dni);
        if (socio != null) {
            socio.setNumTelefono(nuevoTelefono);
            System.out.println("✔ Teléfono actualizado para " + socio.getNombre());
        } else {
            System.out.println("✘ No se encontró ningún socio con DNI: " + dni);
        }

        em.getTransaction().commit();
    }

    // ── CON CONSULTAS ──────────────────────────────────────────

    // 3. Dinámica: socios que han sacado un libro por ISBN
    public void sociosPorLibro(String isbn) {
        String jpql = "SELECT p.socio FROM Prestamos p WHERE p.libro.isbn = :isbn";
        TypedQuery<Socio> query = em.createQuery(jpql, Socio.class);
        query.setParameter("isbn", isbn);

        List<Socio> socios = query.getResultList();
        if (socios.isEmpty()) {
            System.out.println("No hay socios que hayan sacado ese libro.");
        } else {
            System.out.println("Socios que han sacado el libro con ISBN " + isbn + ":");
            for (Socio s : socios) {
                System.out.println("  - " + s.getNombre() + " | DNI: " + s.getDni() + " | Tlf: " + s.getNumTelefono());
            }
        }
    }

    // 4. Estática: total de préstamos realizados
    public void totalPrestamos() {
        Query query = em.createQuery("SELECT COUNT(p) FROM Prestamos p");
        Long total = (Long) query.getSingleResult();
        System.out.println("Total de préstamos realizados: " + total);
    }

    public void cerrar() {
        em.close();
        emf.close();
    }
}