package ejercicioCRUD;

import java.util.List;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class Main {

    // Creamos la factoria 
    static EntityManagerFactory emf = Persistence.createEntityManagerFactory("Productos");
    static EntityManager em = emf.createEntityManager();

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        int opcion;

        do {
            System.out.println("\n--- CRUD PRODUCTOS ---");
            System.out.println("1. Insertar producto");
            System.out.println("2. Listar productos");
            System.out.println("3. Buscar producto");
            System.out.println("4. Actualizar producto");
            System.out.println("5. Eliminar producto");
            System.out.println("6. Salir");
            System.out.print("Opción: ");
            opcion = input.nextInt();
            input.nextLine();

            switch (opcion) {
                case 1:
                    insertar(input);
                    break;

                case 2:
                    listar();
                    break;

                case 3:
                    buscar(input);
                    break;

                case 4:
                    actualizar(input);
                    break;

                case 5:
                    eliminar(input);
                    break;
            }

        } while (opcion != 6);

        input.close();
        em.close();
        emf.close();
    }

    private static void insertar(Scanner input) {
        try {
            System.out.print("Nombre: ");
            String nombre = input.nextLine();
            System.out.print("Precio: ");
            double precio = input.nextDouble();

            em.getTransaction().begin();  

            Producto p = new Producto(nombre, precio);
            em.persist(p);

            em.getTransaction().commit();
            System.out.println("Producto guardado con éxito.");

        } catch (Exception e) {
            e.printStackTrace();
            em.getTransaction().rollback();  
        }
    }

    private static void listar() {
        try {
            List<Producto> lista =
                    em.createQuery("SELECT p FROM Producto p", Producto.class).getResultList();

            for (Producto producto : lista) {
                System.out.println(producto);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void buscar(Scanner input) {
        System.out.print("ID: ");
        int id = input.nextInt();

        Producto p = em.find(Producto.class, id);

        System.out.println(p != null ? p : "Producto no encontrado");
    }

    private static void actualizar(Scanner input) {
        System.out.print("id: ");
        int id = input.nextInt();
        input.nextLine();

        System.out.print("Nuevo nombre: ");
        String nombre = input.nextLine();
        System.out.print("Nuevo precio: ");
        double precio = input.nextDouble();

        try {
            em.getTransaction().begin();   

            Producto p = em.find(Producto.class, id);
            if (p != null) {
                p.setNombre(nombre);
                p.setPrecio(precio);
                em.merge(p);
                System.out.println("Producto actualizado.");
            } else {
                System.out.println("Producto no encontrado.");
            }

            em.getTransaction().commit();

        } catch (Exception e) {
            e.printStackTrace();
            em.getTransaction().rollback();
        }
    }

    private static void eliminar(Scanner input) {
        System.out.print("ID: ");
        int id = input.nextInt();

        try {
            em.getTransaction().begin();   

            Producto p = em.find(Producto.class, id);
            if (p != null) {
                em.remove(p);
                System.out.println("Producto eliminado.");
            } else {
                System.out.println("Producto no encontrado.");
            }

            em.getTransaction().commit();

        } catch (Exception e) {
            e.printStackTrace();
            em.getTransaction().rollback();
        }
    }
}
