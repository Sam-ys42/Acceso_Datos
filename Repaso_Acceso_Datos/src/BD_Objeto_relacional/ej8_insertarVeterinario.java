package BD_Objeto_relacional;


	import java.sql.Connection;
	import java.sql.DriverManager;
	import java.sql.PreparedStatement;
	import java.sql.SQLException;
	import java.util.Scanner;

	public class ej8_insertarVeterinario {

	    public static void main(String[] args) {

	        Scanner sc = new Scanner(System.in);

	        System.out.print("Introduce DNI: ");
	        int dni = sc.nextInt();
	        sc.nextLine();
	        System.out.print("Introduce nombre: ");
	        String nombre = sc.nextLine();

	        System.out.print("Introduce número de colegiado: ");
	        int numColegiado = sc.nextInt();

	        insertarValores(dni, nombre, numColegiado);
	    }

	    public static void insertarValores(int dni, String nombre, int numColegiado) {

	        String url = "jdbc:postgresql://localhost:5432/mascotas";
	        String user = "postgres";
	        String pass = "toor";

	        String sql = "INSERT INTO veterinario (dni, nombre, \"numColegiado\") VALUES (?, ?, ?)";

	        try (Connection con = DriverManager.getConnection(url, user, pass);
	             PreparedStatement ps = con.prepareStatement(sql)) {

	            ps.setInt(1, dni);
	            ps.setString(2, nombre);
	            ps.setInt(3, numColegiado);

	            ps.executeUpdate();
	            System.out.println("Veterinario insertado .");

	        } catch (SQLException e) {
	            System.out.println("Error "+ e.getMessage());
	        
	    }
	}

}
