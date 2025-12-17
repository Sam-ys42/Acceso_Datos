package BDZapatos;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import ejercicioFInal.Persona;

public class ejercicio3 {
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
		
		 File ficheroTxt = new File("zapatos.csv");
		BufferedWriter bw = null;
		try {
			
			String sql = "SELECT * from zapato";
			Connection conexion = conectar();
			Statement st = conexion.createStatement();
			ResultSet rs = st.executeQuery(sql);
			
			
			while (rs.next()) {
				Zapato z = new Zapato(rs.getInt("ID"), rs.getString("marca"),  rs.getString("modelo"), rs.getString("tamano"), rs.getString("color"),  rs.getInt("stock"),  rs.getDouble("precio"));
				
				zapatos.anadirZapato(z);
			    
			    
				System.out.println("zapato añadido");
//		
//				
			}
			conexion.close();
			st.close();
			rs.close();
			
			//escribimos los datos obtenidos de la tabla al fichero .csv
			bw = new BufferedWriter(new FileWriter(ficheroTxt));
		
		for (Zapato z : zapatos.getZapatos()) {
			try  {
				bw.write(z.getId() + ";" + z.getMarca()+";"+z.getModelo()+";"+z.getTamano()+";"+z.getColor()+";"+z.getStock()+";"+z.getPrecio());
				System.out.println("zapato escrita en el fichero");
				bw.newLine();
				
	
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
			
		}
		bw.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

	}

}
