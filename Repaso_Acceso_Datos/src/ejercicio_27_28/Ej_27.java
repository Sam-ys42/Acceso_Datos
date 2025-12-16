package ejercicio_27_28;

import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Unmarshaller;




public class Ej_27 {

	
	 private static final String URL = "jdbc:mysql://localhost:3306/alumnos";
//	    private static final String USER = "root";
//	    private static final String PASSWORD = "@Itowgameplay01"; 

	    
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
	
	    public static Alumnos alumnos = new Alumnos();
	public static void main(String[] args) {
		 
		// TODO Auto-generated method stub
		try {
			JAXBContext contexto = JAXBContext.newInstance(Alumnos.class);
			//2 Crear un unmarshaller  que convierte el XML en JavaBeans. 
			Unmarshaller um = contexto.createUnmarshaller(); 
			//Realizar la deserialización  llamando al método unmarshal del marshaller. 
			alumnos= (Alumnos) um.unmarshal(new File("ampliarAlumnos.xml"));
			System.out.println("se han leido los alumnos correctamente");
			
//			alumnos.getAlumnos().forEach(t -> System.out.println(t.toString()) );
			// aqui los añadimos a la tabla
			String sql = "INSERT INTO alumno (nombre, curso) "
                    + "VALUES ( ?, ?)";
System.out.println("hola?"+alumnos.getAlumnos().size());
Connection conexion = conectar();
			for (Alumno alumno : alumnos.getAlumnos()) {
				
				
		         PreparedStatement pstmt = conexion.prepareStatement(sql);
		         pstmt.setString(1, alumno.getNombre());
		         pstmt.setString(2, alumno.getCurso());

		         int filas = pstmt.executeUpdate();
		         if (filas > 0) {
		             System.out.println(" Alumno insertado correctamente.");
		            
		         } else {
		             System.out.println("No se pudo insertar el alumno.");
		         }
			}
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
	
		
		

	}

}
