package aA_Basedatos_ejercicio;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class ej_21 {

	private static final String URL = "jdbc:mysql://localhost:3306/alumnos";
//  private static final String USER = "root";
//  private static final String PASSWORD = "@Itowgameplay01"; 
	
	
	public static Connection conectar() {
    	Connection conexion = null;
    	try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			//establecer la conexion
			conexion = DriverManager.getConnection(URL);
//			System.out.println("conexión exitosa");
			
			
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
		Scanner input = new Scanner(System.in);
		System.out.println("Introduzca un id para comprobar si el alumno existe: ");
		int idAlumno = input.nextInt();input.nextLine();
		chequearAlumno(idAlumno);
		System.out.println("ahora vamos a añadir un alumno a la base de datos, rellene sus campos");
		System.out.println("dime el nombre: ");
		String nombre = input.nextLine();
		
		System.out.println("Dime el curso 1DAM, 2DAM, 1DAW, 2DAW");
		String curso  = input.nextLine();
		
		insertarAlumnos(nombre, curso);
		
		System.out.println("total de alumnos: "+ contarAlumnos());
	}



	private static int contarAlumnos() {
		int r=0;
		try {
			String sql =  " {? =  call contarAlumnos()}";
			Connection conexion = conectar();
			CallableStatement cs = conexion.prepareCall(sql);
			cs.registerOutParameter(1, java.sql.Types.INTEGER);
			cs.execute();
			
			 r = cs.getInt(1);
		
		} catch (Exception e) {
			 e.printStackTrace();
		}
		return r;
	}



	private static void insertarAlumnos(String nombre, String curso) {
		// TODO Auto-generated method stub
		try {
			String sql =  " call insertarAlumno(?,?)";
			Connection conexion = conectar();
			CallableStatement cs = conexion.prepareCall(sql);
			cs.setString(1, nombre);
			cs.setString(2, curso);
			
			
			cs.execute(); // con esto ejecutamos el procedimiento
			System.out.println("alumno agregado con exito");
			
		} catch (Exception e) {
			 e.printStackTrace();
		}
		
	}



	private static void chequearAlumno(int id) {
		try {
			String sql =  " {? =  call chequearAlumno(?)}";
			Connection conexion = conectar();
			CallableStatement cs = conexion.prepareCall(sql);
			cs.registerOutParameter(1, java.sql.Types.BOOLEAN);
			cs.setInt(2, id);
			cs.execute();
			
			boolean resultado = cs.getBoolean(1);
			System.out.println("¿Existe el alumno? : "+ resultado);
			
		} catch (Exception e) {
			 e.printStackTrace();
		}
	}

}
