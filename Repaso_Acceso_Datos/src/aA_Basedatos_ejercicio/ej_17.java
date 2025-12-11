package aA_Basedatos_ejercicio;

import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class ej_17 {

	
    private static final String URL = "jdbc:mysql://localhost:3306/navavinted";
//    private static final String USER = "root";
//    private static final String PASSWORD = "@Itowgameplay01"; 

    
    public static Connection conectar() {
    	Connection conexion = null;
    	try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			//establecer la conexion
			conexion = DriverManager.getConnection(URL);
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
			// Abrir fichero CSV
			BufferedReader bf = new BufferedReader(
					new FileReader("navaVinted.csv"));

			// Variable para lectura
			String linea;

			//variables para obtener los valores de los objetos en la linea
			int id;
			String nombre;
			int idCategoria;
			int idTalla;
			int idColor;
			int idMaterial;
			int stock;
			double precio;
			double costo;
			String estado;
			int descuento;
			// Bucle para leer
			while ((linea = bf.readLine()) != null) {

				String[] textoSeparado = linea.split(";");

				
				id = Integer.parseInt(textoSeparado[0]);
				nombre = textoSeparado[1];
				
				idCategoria = Integer.parseInt(textoSeparado[2]);
				idTalla = Integer.parseInt(textoSeparado[3]);
				idColor = Integer.parseInt(textoSeparado[4]);
				idMaterial =  Integer.parseInt(textoSeparado[5]);
				
				stock = Integer.parseInt(textoSeparado[6]);
				
				precio = Double.parseDouble(textoSeparado[7]);
				costo =  Double.parseDouble(textoSeparado[8]);
				
				estado = textoSeparado[9];
				
				descuento =  Integer.parseInt(textoSeparado[10]);
				

				System.out.println(anadirProductoaBD(id, nombre, idCategoria, idTalla, idColor,idMaterial, stock, precio, costo, estado, descuento)? "producto añadido" : "error");

			}

			
			


		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


	private static boolean anadirProductoaBD(int id, String nombre, int idCategoria, int idTalla, int idColor,int idMaterial,
			int stock, double precio, double costo, String estado, int descuento) {
		// TODO Auto-generated method stub
		boolean r = false;
		
		String sql = "INSERT into PRODUCTO (id_Producto, nombre_Producto, id_categoria, id_Talla, id_Color, id_Material, stock, precio, costo, estado, descuento) values (?,?,?,?,?,?,?,?,?,?,?)";
		
		try  (Connection connection = conectar();){
			PreparedStatement pstmt = connection.prepareStatement(sql);
			// parámetros del
					pstmt.setInt(1,id );
					pstmt.setString(2,nombre );
					
					pstmt.setInt(3,idCategoria );
					pstmt.setInt(4,idTalla );
					pstmt.setInt(5,idColor );
					pstmt.setInt(6,idMaterial );
					
					pstmt.setInt(7,stock );
					
					pstmt.setDouble(8,precio );
					pstmt.setDouble(9,costo );
					
					pstmt.setString(10,estado );
					
					pstmt.setDouble(11,descuento );
					
			//ResultSet rs = pstmt.executeQuery();
					int filasInsertadas = pstmt.executeUpdate();
					if (filasInsertadas>0) {
						r = true;
					}
				
			
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		
		return r;
	}

}
