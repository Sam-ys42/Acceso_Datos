package BD_Objeto_relacional;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class ej12_InsertarMascotaArray {

    public static void insertarMascota() {
        try {
            Connection conn = DriverManager.getConnection(
                "jdbc:postgresql://localhost:5432/mascotas", "postgres", "toor");

            Scanner input = new Scanner(System.in);

            System.out.print("Ingrese el ID de la mascota: ");
            int id = Integer.parseInt(input.nextLine());

            System.out.print("Ingrese el nombre: ");
            String nombre = input.nextLine();

            System.out.print("Ingrese la raza: ");
            String raza = input.nextLine();

            System.out.print("Ingrese el DNI del propietario: ");
            String dnipropietario = input.nextLine();

            System.out.print("¿Cuántas vacunas tiene?: ");
            int numVacunas = Integer.parseInt(input.nextLine());

            String[] vacunas = new String[numVacunas];

            for (int i = 0; i < numVacunas; i++) {
                System.out.println("Vacuna " + (i + 1) + ":");

                System.out.print("  Nombre de la vacuna: ");
                String nombrev = input.nextLine();

                System.out.print("  Número de colegiado: ");
                int numcolegiado = Integer.parseInt(input.nextLine()); // con esto evitamos que el programa se coma el salto de linea

                System.out.print("  Fecha (YYYY-MM-DD): ");
                String fecha = input.nextLine();

                vacunas[i] = "('"  +nombrev+ "'," + numcolegiado+ ",'" + fecha +"')";
            }

            String sql = "INSERT INTO mascota (id, nombre, raza, dnipropietario, vacuna) VALUES (?, ?, ?, ?, ?::vacuna[])";

            try (PreparedStatement pst = conn.prepareStatement(sql)) {
                pst.setInt(1, id);
                pst.setString(2, nombre);
                pst.setString(3, raza);
                pst.setString(4, dnipropietario);
                pst.setArray(5, conn.createArrayOf("vacuna", vacunas));

                int filas = pst.executeUpdate();
                if (filas > 0) {
                    System.out.println("Mascota insertada correctamente.");
                } 
                
                
            }

        } catch (SQLException e) {
        	e.printStackTrace();
        }
    }

    
    public static void main(String[] args) {
        insertarMascota();
    }
}
