package BD_Objeto_relacional;

	import java.sql.Connection;
	import java.sql.DriverManager;
	import java.sql.PreparedStatement;
	import java.sql.SQLException;
	import java.util.Scanner;

	public class ej10_insertarPropietarioComp {

	    public static void main(String[] args) {

	        Scanner sc = new Scanner(System.in);

	        System.out.print("Introduce DNI: ");
	        int dni = sc.nextInt();
	        sc.nextLine();
	        System.out.print("Introduce nombre: ");
	        String nombre = sc.nextLine();

	        System.out.print("Introduce calle: ");
	        String calle = sc.nextLine();

	        System.out.print("Introduce número: ");
	        int numero = sc.nextInt();
	        sc.nextLine();

	        System.out.print("Introduce ciudad: ");
	        String ciudad = sc.nextLine();

	        System.out.print("Introduce código postal: ");
	        int cp = sc.nextInt();
	        // lo he metido en una funcion
	        insertarPropietario(dni, nombre, calle, numero, ciudad, cp);
	    }

	    public static void insertarPropietario(int dni, String nombre, String calle, int numero, String poblacion, int cp) {

	        String url = "jdbc:postgresql://localhost:5432/mascotas";
	        String user = "postgres";
	        String pass = "toor";

	        
	        
	        String sql = "INSERT INTO propietario (dni, nombre, direccion) " +
	                     "VALUES (?, ?, ROW(?, ?, ?, ?))";

	        try (Connection con = DriverManager.getConnection(url, user, pass);
	             PreparedStatement ps = con.prepareStatement(sql)) {

	            ps.setInt(1, dni);
	            ps.setString(2, nombre);
	            ps.setString(3, calle);
	            ps.setInt(4, numero);
	            ps.setString(5, poblacion);
	            ps.setInt(6, cp);

	            ps.executeUpdate();
	            System.out.println("Propietario insertado correctamente.");

	        } catch (SQLException e) {
	      e.getMessage();
	        }
	    
	}

}
