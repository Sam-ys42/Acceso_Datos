package pack;

import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Main {

    public static void main(String[] args) {

        EntityManagerFactory emf =
            Persistence.createEntityManagerFactory("UPBiblioteca");
        EntityManager em = emf.createEntityManager();
        Scanner sc = new Scanner(System.in);

        int opcion;
        do {
            System.out.println("\n--- MENÚ  ---");
            System.out.println("1. Crear 3 libros, 3 socios y 3 préstamos");
            System.out.println("2. Actualizar teléfono de un socio ");
            System.out.println("3. Socios que han sacado un libro ");
            System.out.println("4. Total de préstamos ");
            System.out.println("0. Salir");
            System.out.print("Opción: ");
            opcion = sc.nextInt();
            sc.nextLine();

            switch (opcion) {
                case 1:
                    em.getTransaction().begin();

                    Libro l1 = new Libro("111", 3, "Dune", "Herbert");
                    Libro l2 = new Libro("222", 2, "It", "Stephen King");
                    Libro l3 = new Libro("333", 1, "1984", "Orwell");

                    Socio s1 = new Socio("A1", "Ana", "600111222");
                    Socio s2 = new Socio("B2", "Luis", "600333444");
                    Socio s3 = new Socio("C3", "Marta", "600555666");

                    em.persist(l1); em.persist(l2); em.persist(l3);
                    em.persist(s1); em.persist(s2); em.persist(s3);

                    em.persist(new Prestamo(true, s1, l1));
                    em.persist(new Prestamo(true, s2, l2));
                    em.persist(new Prestamo(true, s3, l3));

                    em.getTransaction().commit();
                    System.out.println("3 libros, 3 socios y 3 préstamos creados.");
                    break;

                case 2:
                    System.out.print("DNI del socio: ");
                    String dni = sc.nextLine();
                    System.out.print("Nuevo teléfono: ");
                    String tel = sc.nextLine();
                    Socio.actualizarTelefono(em, dni, tel);
                    break;

                case 3:
                    System.out.print("ISBN del libro: ");
                    String isbn = sc.nextLine();
                    Prestamo.mostrarSociosQueHanSacadoLibro(em, isbn);
                    break;

                case 4:
                    Prestamo.mostrarTotalPrestamos(em);
                    break;
            }

        } while (opcion != 0);

        em.close();
        emf.close();
        sc.close();
    }
}
