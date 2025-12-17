package BDZapatos;

import java.awt.im.InputContext;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import ejercicio_27_28.Alumno;

public class ejercicio2 {

	private static final String URL = "jdbc:mysql://localhost:3306/bdzapatos?allowMultiQueries=true";
	private static final String USER = "root";
	private static final String PASSWORD = "@Itowgameplay01";

	private static Zapatos zapatos = new Zapatos();

	public static Connection conectar() {
		Connection conexion = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			// establecer la conexion
			conexion = DriverManager.getConnection(URL, USER, PASSWORD);
			System.out.println("conexión exitosa");

		} catch (ClassNotFoundException e) {
			System.err.println("no se encontró el edriver mySql");
			// TODO: handle exception
		} catch (SQLException e) {
			// TODO: handle ex
			e.printStackTrace();
		}
		return conexion;
	}

	private static Scanner input = new Scanner(System.in);

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int respueta = 0;
		do {
			menu();
			respueta = input.nextInt();
			
			switch (respueta) {
			case 1:
				
				mostrarZapatosstockmenor();
				break;
			case 2:
				
				aumentarPrecio();

				break;
			case 3:
				anadirCampoDescripción();

				break;
			case 4:
				String color = "rojo";
				String tamano = "70";
				mostrarZapatosColorYTamano(color, tamano);

				break;
			case 5:
				mostrarTotalZapatos();
				

				break;
			case 6:
				System.out.println("Saliendo");
				break;

			default:
				System.out.println("respuesta inválida");
				break;
			}
		} while (respueta != 6);

	}

	private static void mostrarTotalZapatos() {
		// TODO Auto-generated method stub
		int r=0;
		try {
			String sql =  " {? =  call contarZapatosDOS()}";
			Connection conexion = conectar();
			CallableStatement cs = conexion.prepareCall(sql);
			cs.registerOutParameter(1, java.sql.Types.INTEGER);
			cs.execute();
			
			 r = cs.getInt(1);
			 System.out.println("en total, hay "+ r+" pares de zapatos : )");
		
		} catch (Exception e) {
			 e.printStackTrace();
		}
		
	}

	private static void mostrarZapatosColorYTamano(String color, String tamano) {
		// TODO Auto-generated method stub
		try {
			String sql = "SELECT * FROM  zapato where color = ? and tamano < ?";
			Connection conexion = conectar();
			
			PreparedStatement pstmt = conexion.prepareStatement(sql);
	        pstmt.setString(1, color);
	        pstmt.setString(2,tamano);
	        
	        ResultSet rs = pstmt.executeQuery();
	        while (rs.next()) {
	        	Zapato z = new Zapato();
	        	z.setId(rs.getInt("ID"));
	        	z.setColor(rs.getString("color"));
	        	z.setMarca(rs.getString("marca"));
	        	z.setModelo(rs.getString("modelo"));
	        	z.setPrecio(rs.getDouble("precio"));
	        	z.setStock(rs.getInt("stock"));
	        	z.setTamano(rs.getString("tamano"));
	        	System.out.println(z);
	        }
			
	        conexion.close();
			pstmt.close();
			rs.close();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
	}

	private static void anadirCampoDescripción() {
		// TODO Auto-generated method stub
		
		
		try {
			String sql ="ALTER TABLE zapato ADD COLUMN descripcion VARCHAR(50)";
			Connection connection = conectar();
			Statement stmt = connection.createStatement();
			int campo = stmt.executeUpdate(sql);
			if (campo == 0) {
				System.out.println("se ha añadido descripción");
			}
//			boolean r = stmt.execute(sql);
//			System.out.println(r);
//			if(r) { 																														////duda
//				System.out.println("se ha añadido descripción");
//			}else {
//				System.out.println("error, descipción ya existe");
//			}
			connection.close();
			stmt.close();
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("ya hay una columna descripción");
		}
		
	}

	private static void aumentarPrecio() {
		// TODO Auto-generated method stub
		try {
			String sql = "UPDATE zapato set precio = precio + 2.0 where marca like '%Nike%'";
			
				Connection connection = conectar();
				Statement pstmt = connection.createStatement();
				
				
				int resultado = pstmt.executeUpdate(sql);
				System.out.println("se han modificado "+ resultado + " columnas");
	
				connection.close();
				pstmt.close();
				
		} catch (Exception e) {
			// TODO: handle exceptio
			e.printStackTrace();
		}
		
	}

	private static void mostrarZapatosstockmenor() {
//		 TODO Auto-generated method stub
		try {
			String sql = "SELECT * from zapato where stock < 5";
			
			Connection connection = conectar();
			Statement pstmt = connection.createStatement();
			
			ResultSet rs = pstmt.executeQuery(sql);
				
				
				
				
				//ejecutar select
			
				while (rs.next()) {
					int id = rs.getInt("ID");
				    String marca = rs.getString("marca");
				    String modelo = rs.getString("modelo");
				    String tamano = rs.getString("tamano");
				    String color = rs.getString("color");
				    int stock = rs.getInt("stock");
				    Double precio = rs.getDouble("precio");
				    
				    
					System.out.println(
					        " | id: " + id +
					        " | marca: " + marca + 
					        " | modelo: " + modelo + 
					        " | tamaño: " + tamano + 
					        " | color: " + color + 
					        " | stock: " + stock + 
					        " | precio: " + precio 
					    );
//			
//					
				}
				connection.close();
				pstmt.close();
				rs.close();
		} catch (Exception e) {
			// TODO: handle exceptio
			e.printStackTrace();
		}
		
	}

	private static void menu() {
		System.out.println("***Bienvenido a la base de datos***\n" + "1.- Mostrar zapatos con stock < 5\n"
				+ "2.- Aumentar precio a 2€ a todas las Nike\n" + "3.- Añadir a la tabla campo descripción\n"
				+ "4.- Mostrar zapatos rojos y talla < 20\n" + "5.- Total zapatos\n" + "6.-Salir");
	}

}
