package ejercicio_27_28;

import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;


public class ej28 {

	private static final String URL = "jdbc:mysql://localhost:3306/alumnos";
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
	
	private static Alumnos alumnos = new Alumnos();
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String sql = "SELECT * from alumno";
		try  {
			Connection connection = conectar();
			PreparedStatement pstmt = connection.prepareStatement(sql);
			
			ResultSet rs = pstmt.executeQuery();
			
			
			//ejecutar select
		
			while (rs.next()) {
			    String nombre = rs.getString("nombre");
			    String curso = rs.getString("curso");
			
				System.out.println(
				        " | Nombre: " + nombre +
				        " | Curso: " + curso 
				    );
				Alumno a = new Alumno(); // si no se hace así, explota
				a.setNombre(nombre);
				a.setCurso(curso);
				alumnos.anadirAlumno(a);
			}
			//1 crear contexto
			JAXBContext jaxbContext = JAXBContext.newInstance(Alumnos.class); 
			Marshaller marshaller = jaxbContext.createMarshaller();
			
				// Configuración opcional para formato legible 
			marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE); 
 				
			
 				//2 Convertir objeto a XML y meter en fichero xml 
 			marshaller.marshal(alumnos, new File("totalAlumno.xml")); 
 			marshaller.marshal(alumnos, System.out);
			
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}

	}

}
