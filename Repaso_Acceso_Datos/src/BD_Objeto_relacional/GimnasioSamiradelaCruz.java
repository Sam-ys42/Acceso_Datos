package BD_Objeto_relacional;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Types;
import java.util.Scanner;

public class GimnasioSamiradelaCruz {

	public static Scanner input = new Scanner(System.in);

	private static final String URL = "jdbc:postgresql://localhost:5432/bdgym_Samira";
	private static final String USER = "postgres";
	private static final String PASS = "toor";

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			// Cargamos el driver
			Class.forName("org.postgresql.Driver");
			// Abrimos conexión
			Connection c = DriverManager.getConnection(URL, USER, PASS);

			int answ = 0;
			int answ2 = 0;
			do {
				menu();
				answ = Integer.parseInt(input.nextLine());

				switch (answ) {
				case 1:
					System.out.println("1.-Agregar cliente \n2.-Agregar entrenador \n");
					System.out.println("Introduzca uno de los valores: ");

					answ2 = Integer.parseInt(input.nextLine());
					PreparedStatement pstmt;
					int filasInsertadas;

					String sql;
					switch (answ2) {
					case 1:
						sql = "INSERT INTO cliente (dni, nombre, apellido, numerocliente, rutinas) VALUES (?, ?, ?, ?, ARRAY[ (?) ])";
						pstmt = c.prepareStatement(sql);

						System.out.println("Introduce el DNI: ");
						pstmt.setString(1, input.nextLine());
						System.out.println("Introduce el nombre: ");
						pstmt.setString(2, input.nextLine());
						System.out.println("Introduce el apellido: ");
						pstmt.setString(3, input.nextLine());
						System.out.println("Introduce el numero de cliente: ");
						pstmt.setInt(4, Integer.parseInt(input.nextLine()));
						System.out.println("Introduce la rutina: ");
						pstmt.setString(5, input.nextLine());

						// Ejecutar la consulta
						filasInsertadas = pstmt.executeUpdate();
						if (filasInsertadas > 0) {
							System.out.println("Se han insertado los datos");
						} else {
							System.out.println("No se insertaron datos.");
						}

						break;
					case 2:
						sql = "INSERT INTO entrenador (dni, nombre, apellido, especialidad, salario) VALUES (?, ?, ?, ?,ROW(?, ?)::salario)";
						pstmt = c.prepareStatement(sql);

						System.out.println("Introduce el DNI: ");
						pstmt.setString(1, input.nextLine());
						System.out.println("Introduce el nombre: ");
						pstmt.setString(2, input.nextLine());
						System.out.println("Introduce el apellido: ");
						pstmt.setString(3, input.nextLine());
						System.out.println("Introduce la especialidad: ");
						pstmt.setString(4, input.nextLine());
						System.out.println("Introduce la cuota base: ");
						pstmt.setInt(5, Integer.parseInt(input.nextLine()));
						System.out.println("Introduce la comisión: ");
						pstmt.setDouble(6, Double.parseDouble(input.nextLine()));

						// Ejecutar la consulta
						filasInsertadas = pstmt.executeUpdate();
						if (filasInsertadas > 0) {
							System.out.println("Se han incertado los datos");
						} else {
							System.out.println("No se insertaron datos.");
						}

						break;

					default:
						System.out.println("opcion inválida.");
						break;

					}
					break;
				case 2:
					// json y csv

					break;
				case 3:

					System.out.println(
							"1.-Registrar una nueva rutina para cliente \n2.-Total de rutinas de un cliente \n");
					System.out.println("Introduzca uno de los valores: ");

					answ2 = Integer.parseInt(input.nextLine());
					PreparedStatement psmt3;
					int filasActualizadas3;
					String sqlUpdate;

					switch (answ2) {
					case 1:
						sqlUpdate = "UPDATE cliente SET rutinas = array_append(rutinas, ?) WHERE dni = ?";
						psmt3 = c.prepareStatement(sqlUpdate);
						System.out.println("Introudce el dni del cliente:");
						psmt3.setString(2, input.nextLine());
						System.out.println("Introduce la nueva rutina: ");
						psmt3.setString(1, input.nextLine());

						filasActualizadas3 = psmt3.executeUpdate();
						if (filasActualizadas3 > 0) {
							System.out.println("Rutina agregada");
						}
						break;
					case 2:
						sql = "{? = call totalrutina(?)}";
						try (CallableStatement stmt = c.prepareCall(sql)) {

							// Registrar el tipo de retorno de la función (en este caso, INTEGER)
							stmt.registerOutParameter(1, Types.INTEGER);

							System.out.println("Introduce el dni del cliente: ");
							stmt.setString(2, input.nextLine()); // Pasar el dni
							stmt.execute();

							int resultado = stmt.getInt(1);
							System.out.println("Número de rutinas: " + resultado);
						} catch (SQLException e) {
							e.printStackTrace();
						}

						break;

					default:
						System.out.println("Opcion noválida.");
						break;
					}break;

				case 4:

					System.out.println("1.-Calcular salario entrenador \n2.-Aumentar un 2% la cuota base \n");
					System.out.println("Introduzca uno de los valores: ");

					answ2 = Integer.parseInt(input.nextLine());
					PreparedStatement psmt4;
					int filasActualizadas4;
					String sqlSalario;

					switch (answ2) {
					case 1:
						sqlSalario = "SELECT (salario).cuota_base + (salario).comision AS salario from entrenador where dni = ?";
						psmt4 = c.prepareStatement(sqlSalario);
						System.out.println("Introduce el dni del entrenador: ");
						psmt4.setString(1, input.nextLine());
						ResultSet rs = psmt4.executeQuery();

						while (rs.next()) {
							System.out.println("El salario del entrenador es: " + rs.getDouble("salario"));
						}

						break;
					case 2:
						String sqlCuota = "CALL aumentar_cuota()";

						try (Statement stmt = c.createStatement()) {
							stmt.execute(sqlCuota);
							System.out.println("Cuota actualizada.");
						} catch (SQLException e) {
							System.err.println("Error al ejecutar aumentarCuota: " + e.getMessage());
							e.printStackTrace();
						}
					}
					break;

				case 5:
					System.out.println("Saliendo..");
				
				}

			} while (answ != 5);

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}

	}

	public static void menu() {
		System.out.println("=== MENU ===");
		System.out
				.println("1)Alta \n 2)Cargar datos\n 3)Gestión de rutinas clientes\n 4)Gestión de salarios\n 5) Salir");

	}

}
