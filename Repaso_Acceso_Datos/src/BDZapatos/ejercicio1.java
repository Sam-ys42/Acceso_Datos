package BDZapatos;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;



public class ejercicio1 {

	
	
	private static final String URL = "jdbc:mysql://localhost:3306/bdzapatos?allowMultiQueries=true";
  private static final String USER = "root";
  private static final String PASSWORD = "@Itowgameplay01"; 

	private static Zapatos zapatos = new Zapatos();
	
	public static Connection conectar() {
  	Connection conexion = null;
  	try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			//establecer la conexion
			conexion = DriverManager.getConnection(URL,USER,PASSWORD);
			System.out.println("conexión exitosa");
			
			
		} catch (ClassNotFoundException e) {
			System.err.println("no se encontró el edriver mySql");
			// TODO: handle exception
		}catch (SQLException e) {
			// TODO: handle ex
			e.printStackTrace();
		}
		return conexion;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		try {
			//parte 1
			Connection conexion = conectar();
			Statement s = conexion.createStatement();
			String script = new String();
			
			
				BufferedReader br = new BufferedReader(new FileReader("bdzapatos.sql"));
				String linea;
				while ((linea = br.readLine()) != null) {
					script +=linea + "\n";
				}
				s.execute(script);
				System.out.println("Script ejecutado con éxito");
			
				// parte 2
				
				ObjectMapper mimapper = new ObjectMapper();
				mimapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
				zapatos = mimapper.readValue(new File("zapatos.json"), Zapatos.class);
				System.out.println("zapatos del json leídos y guardados en el objeto zapatos correctamente");
				
				// aqui los añadimos a la tabla
				String sql = "INSERT INTO zapato (marca,modelo, tamano, color, stock, precio) "
	                    + "VALUES ( ?,?,?,?,?,?)";
				
				 for (Zapato z : zapatos.getZapatos()) {
				
				
		         PreparedStatement pstmt = conexion.prepareStatement(sql);
		         pstmt.setString(1, z.getMarca());
		         pstmt.setString(2, z.getModelo());
		         pstmt.setString(3, z.getTamano());
		         pstmt.setString(4, z.getColor());
		         pstmt.setInt(5, z.getStock());
				pstmt.setDouble(6, z.getPrecio());


		         int filas = pstmt.executeUpdate();
		         if (filas > 0) {
		             System.out.println(" zapato insertado correctamente.");
		            
		         } else {
		             System.out.println("No se pudo insertar el zapato.");
		         }
			}
				 
				
				
				
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}

}
