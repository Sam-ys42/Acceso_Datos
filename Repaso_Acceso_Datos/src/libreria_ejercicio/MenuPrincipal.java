package bdprestamos_nazan;

import java.util.Scanner;

public class MenuPrincipal {

    public static void main(String[] args) {
        Operaciones op = new Operaciones();
        Scanner sc = new Scanner(System.in);
        int opcion;

        do {
            System.out.println("\n══════════════════════════════");
            System.out.println("       MENÚ DE OPERACIONES    ");
            System.out.println("══════════════════════════════");
            System.out.println("1. Crear libros, socios y préstamos");
            System.out.println("2. Actualizar teléfono de un socio");
            System.out.println("3. Ver socios que han sacado un libro");
            System.out.println("4. Ver total de préstamos");
            System.out.println("0. Salir");
            System.out.print("Elige una opción: ");
            opcion = sc.nextInt();
            sc.nextLine();

            switch (opcion) {
                case 1:
                    op.crearDatosPrueba();
                    break;
                case 2:
                    System.out.print("Introduce el DNI del socio: ");
                    String dni = sc.nextLine();
                    System.out.print("Introduce el nuevo teléfono: ");
                    String telefono = sc.nextLine();
                    op.actualizarTelefono(dni, telefono);
                    break;
                case 3:
                    System.out.print("Introduce el ISBN del libro: ");
                    String isbn = sc.nextLine();
                    op.sociosPorLibro(isbn);
                    break;
                case 4:
                    op.totalPrestamos();
                    break;
                case 0:
                    System.out.println("Saliendo...");
                    break;
                default:
                    System.out.println("Opción no válida.");
            }

        } while (opcion != 0);

        op.cerrar();
        sc.close();
    }
}