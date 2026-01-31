package BD_Objeto_relacional;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class ej_15 {

	private static final String URL = "jdbc:postgresql://localhost:5432/mascotas";
	private static final String USER = "postgres";
	private static final String PASS = "toor";

	public static void main(String[] args) {

		try (Connection con = DriverManager.getConnection(URL, USER, PASS); Scanner sc = new Scanner(System.in)) {

			int opcion;

			do {
				System.out.println("\n===== MENÚ  =====");
				System.out.println("1. Listar mascotas con sus vacunas");
				System.out.println("2. Mostrar mascotas de un propietario (por DNI)");
				System.out.println("3. Mostrar perros vacunados de moquillo");
				System.out.println("4. Salir");
				opcion = sc.nextInt();
				sc.nextLine(); // limpiar buffer

				switch (opcion) {

				case 1:
					listarMascotasConVacunas(con);
					//String id = input.nextLine();
					break;

				case 2:
					System.out.print("Introduce DNI del propietario: ");
					String dni = sc.nextLine();
					mostrarMascotasPropietario(con, dni);
					break;

				case 3:
					mostrarPerrosVacunadosMoquillo(con);
					break;

				case 0:
					System.out.println("saliendo");
					break;

				default:
					System.out.println("Opción no válida");
				}

			} while (opcion != 4);

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	private static void listarMascotasConVacunas(Connection con) throws SQLException {
		String sql = "SELECT m.nombre AS mascota, v.nombrev AS vacuna FROM mascota m, UNNEST(m.vacuna) AS v";

		try (Statement st = con.createStatement(); ResultSet rs = st.executeQuery(sql)) {

			System.out.println("\n------ MASCOTAS CON VACUNAS ------");

			while (rs.next()) {
				String mascota = rs.getString("mascota");
				
				String vacuna = rs.getString("vacuna");
				
	

				System.out.println("Mascota: " + mascota  + " | Vacuna: " + vacuna);
			}
		}
	}

	private static void mostrarMascotasPropietario(Connection con, String dni)  {
		String sql = "SELECT nombre, raza FROM mascota WHERE dnipropietario = ?";

		try (PreparedStatement pst = con.prepareStatement(sql)) {
			pst.setString(1, dni);

			try (ResultSet rs = pst.executeQuery()) {
				System.out.println("\n--- MASCOTAS DEL PROPIETARIO ---");

				boolean encontrado = false;

				while (rs.next()) {
					encontrado = true;
					String nombre = rs.getString("nombre");
					String especie = rs.getString("raza");

					System.out.println("Nombre: " + nombre + " | Especie: " + especie);
				}

				if (!encontrado) {
					System.out.println("No se encontraron mascotas para ese propietario..");
				}
			}
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

	private static void mostrarPerrosVacunadosMoquillo(Connection con)  {
		String sql = "SELECT m.nombre AS perro, v.nombrev AS vacuna FROM mascota m, UNNEST(m.vacuna) AS v WHERE m.raza = 'perro' AND v.nombrev LIKE '%moquillo%'";

		try (Statement st = con.createStatement(); ResultSet rs = st.executeQuery(sql)) {

		    System.out.println("\n--- PERROS VACUNADOS DE MOQUILLO ---");

		    boolean encontrado = false;

		    while (rs.next()) {
		        encontrado = true;
		        String perro = rs.getString("perro");
		        String vacuna = rs.getString("vacuna");

		        System.out.println("Perro: " + perro + " | Vacuna: " + vacuna);
		    }

		    if (!encontrado) {
		        System.out.println("Ningún perro vacunado de moquillo");
		    }
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}

		
		
		
		
	}
}
