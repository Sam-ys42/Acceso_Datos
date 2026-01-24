package BD_Objeto_relacional;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class ej_13 {

    private static final String URL = "jdbc:postgresql://localhost:5432/mascotas";
    private static final String USER = "postgres";
    private static final String PASS = "toor";

    public static void main(String[] args) {
        try (Connection conn = DriverManager.getConnection(URL, USER, PASS);
             Scanner input = new Scanner(System.in)) {

            int answ = 0;

            do {
                System.out.println("1. Alta");
                System.out.println("2. Modificar");
                System.out.println("3. Baja");
                System.out.println("4. Aplicar vacuna");
                System.out.println("5. Salir");
                answ = input.nextInt();
                input.nextLine();

                int answ2 = 0;
                do {
                    

                    answ2 = menu(answ, input);

                    switch (answ) {
                        case 1:
                            darAlta(answ2, input);
                            break;

                        case 2:
                            modificar(answ2, input);
                            break;

                        case 3:
                            baja(answ2, input);
                            break;

                        case 4:
                            aplicarVacuna(input);
                            break;
                        case 5:
                        	answ2 = 5;
                    }
                } while (answ2 != 5);

            } while (answ != 5);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void aplicarVacuna(Scanner input) {
        try (Connection conn = DriverManager.getConnection(URL, USER, PASS)) {

            System.out.println("ID mascota a vacunar:");
            int id = input.nextInt();
            input.nextLine();

            System.out.println("Nombre vacuna:");
            String nombreV = input.nextLine();
            System.out.println("Numero de colegiado del veterinario:");
            int numCol = input.nextInt();
            input.nextLine();
            System.out.println("Fecha vacuna (YYYY-MM-DD):");
            String fecha = input.nextLine();

            String vacunaTexto = "(" + nombreV + "," + numCol + "," + fecha + ")";

            String sql = "UPDATE mascota SET vacuna = array_append(vacuna, ?::vacuna) WHERE id=?";
            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setString(1, vacunaTexto);
            ps.setInt(2, id);

            int filas = ps.executeUpdate();
            if (filas > 0) {
                System.out.println("Vacuna añadida correctamente");
            } else {
                System.out.println("No se ha podido añadir la vacuna");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static void baja(int answ2, Scanner input) {
        try (Connection conn = DriverManager.getConnection(URL, USER, PASS)) {

            switch (answ2) {

                case 1: // Mascota
                    System.out.println("ID mascota a eliminar: ");
                    int id = input.nextInt();
                    input.nextLine();

                    String sqlMasc = "DELETE FROM mascota WHERE id=?";
                    PreparedStatement psM = conn.prepareStatement(sqlMasc);
                    psM.setInt(1, id);

                    int filasM = psM.executeUpdate();
                    if (filasM > 0) {
                        System.out.println("Mascota eliminada");
                    } else {
                        System.out.println("No se ha podido eliminar la mascota");
                    }
                    break;

                case 2: // Propietario
                    System.out.println("DNI propietario a eliminar:");
                    int dni = input.nextInt();
                    input.nextLine();

                    String sqlProp = "DELETE FROM propietario WHERE dni=?";
                    PreparedStatement psP = conn.prepareStatement(sqlProp);
                    psP.setInt(1, dni);

                    int filasP = psP.executeUpdate();
                    if (filasP > 0) {
                        System.out.println("Propietario eliminado");
                    } else {
                        System.out.println("No se ha podido eliminar el propietario ");
                    }
                    break;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static void modificar(int answ2, Scanner input) {
        try (Connection conn = DriverManager.getConnection(URL, USER, PASS)) {

            switch (answ2) {

                case 1: // Propietario
                    System.out.println("DNI del propietario a modificar:");
                    int dniP = input.nextInt();
                    input.nextLine();

                    System.out.println("Nuevo nombre:");
                    String nombre = input.nextLine();
                    System.out.println("Nueva calle:");
                    String calle = input.nextLine();
                    System.out.println("Nuevo número:");
                    int numero = input.nextInt();
                    input.nextLine();
                    System.out.println("Nueva población:");
                    String poblacion = input.nextLine();
                    System.out.println("Nuevo CP:");
                    int cp = input.nextInt();
                    input.nextLine();

                    String sqlProp = "UPDATE propietario SET nombre=?, direccion=ROW(?, ?, ?, ?)::direccion WHERE dni=?";
                    PreparedStatement ps = conn.prepareStatement(sqlProp);
                    ps.setString(1, nombre);
                    ps.setString(2, calle);
                    ps.setInt(3, numero);
                    ps.setString(4, poblacion);
                    ps.setInt(5, cp);
                    ps.setInt(6, dniP);

                    int filas = ps.executeUpdate();
                    if (filas > 0) {
                        System.out.println("Propietario modificado");
                    } else {
                        System.out.println("No se ha podido modificar el propietario");
                    }
                    break;

                case 2: // Mascota
                    System.out.println("ID mascota a modificar:");
                    int id = input.nextInt();
                    input.nextLine();

                    System.out.println("Nuevo nombre:");
                    String nombreM = input.nextLine();
                    System.out.println("Nueva raza:");
                    String raza = input.nextLine();

                    String sqlMasc = "UPDATE mascota SET nombre=?, raza=? WHERE id=?";
                    PreparedStatement psM = conn.prepareStatement(sqlMasc);
                    psM.setString(1, nombreM);
                    psM.setString(2, raza);
                    psM.setInt(3, id);

                    int filasM2 = psM.executeUpdate();
                    if (filasM2 > 0) {
                        System.out.println("Mascota modificada");
                    } else {
                        System.out.println("No se ha podido modificar la mascota");
                    }
                    break;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static void darAlta(int answ2, Scanner input) {
        try (Connection conn = DriverManager.getConnection(URL, USER, PASS)) {

            switch (answ2) {

                case 1: // Veterinario
                    System.out.println("DNI:");
                    int dni = input.nextInt();
                    input.nextLine();
                    System.out.println("Nombre:");
                    String nombre = input.nextLine();
                    System.out.println("Num colegiado:");
                    int numCol = input.nextInt();
                    input.nextLine();

                    String sqlVet = "INSERT INTO public.veterinario(dni, nombre, \"numColegiado\") VALUES (?, ?, ?)";
                    PreparedStatement psVet = conn.prepareStatement(sqlVet);
                    psVet.setInt(1, dni);
                    psVet.setString(2, nombre);
                    psVet.setInt(3, numCol);

                    int filasInsertadas = psVet.executeUpdate();
                    if (filasInsertadas > 0) {
                        System.out.println("Veterinario dado de alta.");
                    } else {
                        System.out.println("error, no se ha podido insertar al veterinario");
                    }
                    break;

                case 2: // Mascota
                    System.out.println("ID:");
                    int id = input.nextInt();
                    input.nextLine();
                    System.out.println("Nombre:");
                    String nombreM = input.nextLine();
                    System.out.println("Raza:");
                    String raza = input.nextLine();
                    System.out.println("DNI propietario:");
                    int dniProp = input.nextInt();
                    input.nextLine();

                    System.out.println("Nombre vacuna:");
                    String nombreVac = input.nextLine();
                    System.out.println("Num colegiado veterinario:");
                    int numColVac = input.nextInt();
                    input.nextLine();
                    System.out.println("Fecha vacuna (YYYY-MM-DD):");
                    String fechaVac = input.nextLine();

                    String arrayVacunas = "'{\"(" + nombreVac + "," + numColVac + "," + fechaVac + ")\"}'";

                    String sqlMasc = "INSERT INTO public.mascota(id, nombre, raza, dnipropietario, vacuna) VALUES (?, ?, ?, ?, " + arrayVacunas + ")";

                    PreparedStatement psMasc = conn.prepareStatement(sqlMasc);
                    psMasc.setInt(1, id);
                    psMasc.setString(2, nombreM);
                    psMasc.setString(3, raza);
                    psMasc.setInt(4, dniProp);

                    psMasc.executeUpdate();
                    System.out.println("Mascota dada de alta.");
                    break;

                case 3: // Propietario
                    System.out.println("DNI:");
                    int dniP = input.nextInt();
                    input.nextLine();
                    System.out.println("Nombre:");
                    String nombreP = input.nextLine();

                    System.out.println("Calle:");
                    String calle = input.nextLine();
                    System.out.println("Número:");
                    int numero = input.nextInt();
                    input.nextLine();
                    System.out.println("Población:");
                    String poblacion = input.nextLine();
                    System.out.println("CP:");
                    int cp = input.nextInt();
                    input.nextLine();

                    String sqlProp = "INSERT INTO public.propietario(dni, nombre, direccion)VALUES (?, ?, ROW(?, ?, ?, ?)::direccion)";
                    PreparedStatement psProp = conn.prepareStatement(sqlProp);
                    psProp.setInt(1, dniP);
                    psProp.setString(2, nombreP);
                    psProp.setString(3, calle);
                    psProp.setInt(4, numero);
                    psProp.setString(5, poblacion);
                    psProp.setInt(6, cp);

                    int filasInsertadas2 = psProp.executeUpdate();
                    if (filasInsertadas2 > 0) {
                        System.out.println("Propietario dado de alta.");
                    } else {
                        System.out.println("error, no se ha podido insertar al propietario");
                    }
                    break;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static int menu(int answ, Scanner input) {
        int resultado = 0;
        System.out.println("submenú");
        switch (answ) {

            case 1:
                System.out.println("1- Veterinario");
                System.out.println("2.-Mascota");
                System.out.println("3.-propietario");
                System.out.println("4.-atrás");
                resultado = input.nextInt();
                input.nextLine();
                resultado = resultado == 4 ? 5 : resultado;
                break;

            case 2:
                System.out.println("1.- Propietario");
                System.out.println("2.- Mascota");
                System.out.println("3.-atrás");
                resultado = input.nextInt();
                input.nextLine();
                resultado = resultado == 3 ? 5 : resultado;
                break;

            case 3:
                System.out.println("1.- Mascota");
                System.out.println("2.- Propietario");
                System.out.println("3.-atrás");
                resultado = input.nextInt();
                input.nextLine();
                resultado = resultado == 3 ? 5 : resultado;
                break;
                
            case 4:
            	resultado= 5;
        }
        return resultado;
    }

}
