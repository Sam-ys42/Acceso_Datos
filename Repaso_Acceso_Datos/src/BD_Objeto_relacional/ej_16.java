package BD_Objeto_relacional;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.CallableStatement;
import java.sql.SQLException;
import java.sql.Types;
import java.sql.Date;
import java.util.Scanner;

public class ej_16 {

    private static final String URL = "jdbc:postgresql://localhost:5432/mascotas";
    private static final String USER = "postgres";
    private static final String PASS = "toor";

    public static void main(String[] args) {

        try (Connection con = DriverManager.getConnection(URL, USER, PASS);
             Scanner input = new Scanner(System.in)) {

            int opcion;

            do {
                System.out.println("===== MENU =====");
                System.out.println("1. Mostrar número total de mascotas");
                System.out.println("2. Poner vacuna a una mascota por ID ");
                System.out.println("3. Salir");

                opcion = input.nextInt();
                input.nextLine();

                switch (opcion) {

                    case 1:
                        mostrarTotalMascotas(con);
                        break;

                    case 2:
                        System.out.print("ID de la mascota: ");
                        int id = input.nextInt();
                        input.nextLine();

                        System.out.print("Nombre de la vacuna: ");
                        String nombreVac = input.nextLine();
                        
                        System.out.println("Numero de colegiado: ");
                        int numCol = input.nextInt();
                        input.nextLine();

                        System.out.print("Fecha (YYYY-MM-DD): ");
                        String fechaStr = input.next();
                        Date fecha = Date.valueOf(fechaStr);

                        ponerVacuna(con, id, nombreVac, numCol, fecha);
                        break;

                    case 3:
                        System.out.println("Saliendo...");
                        break;

                    default:
                        System.out.println("Opción no válida");
                }

            } while (opcion != 3);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static void mostrarTotalMascotas(Connection con)  {
        String sql = "{? = call total_mascotas()}";

        try (CallableStatement cs = con.prepareCall(sql)) {

            cs.registerOutParameter(1, Types.INTEGER);
            cs.execute();

            int total = cs.getInt(1);
            System.out.println("Total de mascotas registradas: " + total);
        }catch (Exception e) {
			// TODO: handle exception
        	e.printStackTrace();
		}
    }

    private static void ponerVacuna(Connection con, int id, String nombreVac, int numCol, Date fecha) {
        String sql = " CALL poner_vacuna(?, ?, ?, ?) ";

        System.out.println(fecha);
        try (CallableStatement cs = con.prepareCall(sql)) {

            cs.setInt(1, id);
            cs.setInt(2, numCol);
            cs.setString(3, nombreVac);
            cs.setDate(4, fecha);

            cs.execute();
            System.out.println("Vacuna añadida correctamente.");
        }catch (Exception e) {
			// TODO: handle exception
        	e.printStackTrace();
		}
    }
}


