package aA_Basedatos_ejercicio;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class ej_11 {


	    private static final String URL = "jdbc:mysql://localhost:3306/navavinted";
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
	    
	    public static Scanner input = new Scanner(System.in);
	    public static void main(String[] args) {
	    	//llamar al método conectar para establecer la conexión
	    	Connection connection = conectar();
	    	int resultado =-1;
	    	do {
				menu();
				resultado = input.nextInt();
				switch (resultado) {
				case 1:
					System.out.println(listarProductosporCategoria(connection)? "": "no se han encontrado productos");
					break;
				case 2:
					System.out.println(listarProductosporTalla(connection)? "": "no se han encontrado prductos");
					break;
				case 3:
					System.out.println(nuevoProducto(connection)? "todo correcto" : "error");
					break;
				case 4 :
					System.out.println(calcularPrecioFinal(connection)? "":"ha habido un error");
					break;
				case 5:
					System.out.println(venderProducto(connection)? "" : "");
					break;
				case 6: System.out.println("adios!");
				if (connection != null) {
					try {
						connection.close();
						System.out.println("conexión cerrada");
					} catch (SQLException e) {
						e.printStackTrace();
					}
				}
		    
				break;
				
				default:
					System.out.println("valor inválido");
					break;
				}
				
			} while (resultado != 6);
	    	
	    	
	    	
	    	
	    }
	    	
	    private static boolean venderProducto(Connection connection) {
	        boolean r = false;
	        int id;
	        int stock = 0;
	        int stockVender;
	        do {
	            System.out.println("dime el ID del producto");
	            id = input.nextInt();
	            System.out.println("dime la cantidad que quieres vender, stock:  ");
	            stockVender = input.nextInt();

	            String sql = "SELECT stock from producto where id_Producto = ?";
	            try {
	                PreparedStatement pstmt = connection.prepareStatement(sql);
	                pstmt.setInt(1, id);
	                ResultSet rs = pstmt.executeQuery();
	                r = true;

	                while (rs.next()) {
	                    stock = rs.getInt("stock");
	                }

	                
	                
	            } catch (Exception e) {
	                e.printStackTrace();
	            }
	            if (stockVender > stock) {
	                System.out.println("no se pueden vender " + stockVender + ", stock total del producto: " + stock);
	            }
	        } while (stockVender > stock);

	        String sqlUpdate = "UPDATE producto set stock = stock - ? where id_Producto = ?";
	        try {
	            PreparedStatement pstmt = connection.prepareStatement(sqlUpdate);
	            pstmt.setInt(1, stockVender);
	            pstmt.setInt(2, id);
	            int filas = pstmt.executeUpdate();
	            if (filas > 0) {
	                r = true;
	            }
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	        return r;
	    }


		private static boolean calcularPrecioFinal(Connection connection) {
			// TODO Auto-generated method stub
	    	System.out.println("dime el ID del producto");
    		boolean r = false;
    		int id = input.nextInt();
    		String sql = "SELECT * from producto where id_Producto = ?";
    		try  {
    			PreparedStatement pstmt = connection.prepareStatement(sql);
    			// parámetros del 
    					pstmt.setInt(1,id );
    			ResultSet rs = pstmt.executeQuery();
    				r = true;
    			
    			//ejecutar select
    			System.out.println("datos de los productos con id talla: "+ id);
    			while (rs.next()) {
    			    
    			    Double precio = rs.getDouble("precio");    			    
    			    int descuento = rs.getInt("descuento");
    				
    				System.out.println("El precio del producto es: "+precio+"haciendo el descuento es: "+(precio-(precio*descuento)/100) );
    			}
    			
    			
    		} catch (Exception e) {
    			// TODO: handle exception
    			e.printStackTrace();
    		}
	    	
	    	
			return r;
		}

		private static boolean nuevoProducto(Connection connection) {
	        boolean r = false;
	        try {
	            // Pedimos los datos al usuario
	            System.out.println("Introduce los datos del nuevo producto:");
	            System.out.print("ID Producto: ");
	            int idProducto = input.nextInt();
	            input.nextLine(); // limpiar buffer

	            System.out.print("Nombre: ");
	            String nombre = input.nextLine();
	            System.out.print("ID Categoría: ");
	            int idCategoria = input.nextInt();
	            System.out.print("ID Talla: ");
	            int idTalla = input.nextInt();
	            System.out.print("ID Color: ");
	            int idColor = input.nextInt();
	            System.out.print("ID Material: ");
	            int idMaterial = input.nextInt();
	            System.out.print("Stock: ");
	            int stock = input.nextInt();
	            System.out.print("Precio: ");
	            double precio = input.nextDouble();
	            System.out.print("Costo: ");
	            double costo = input.nextDouble();
	            input.nextLine(); // limpiar buffer
	            System.out.print("Estado: ");
	            String estado = input.nextLine();
	            System.out.print("Descuento: ");
	            int descuento = input.nextInt();

	            
	            String sql = "INSERT INTO producto (id_Producto, nombre_Producto, id_categoria, id_Talla, id_Color, id_Material, stock, precio, costo, estado, descuento) "
	                       + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

	            PreparedStatement pstmt = connection.prepareStatement(sql);
	            pstmt.setInt(1, idProducto);
	            pstmt.setString(2, nombre);
	            pstmt.setInt(3, idCategoria);
	            pstmt.setInt(4, idTalla);
	            pstmt.setInt(5, idColor);
	            pstmt.setInt(6, idMaterial);
	            pstmt.setInt(7, stock);
	            pstmt.setDouble(8, precio);
	            pstmt.setDouble(9, costo);
	            pstmt.setString(10, estado);
	            pstmt.setInt(11, descuento);

	            int filas = pstmt.executeUpdate();
	            if (filas > 0) {
	                System.out.println(" Producto insertado correctamente.");
	                r = true;
	            } else {
	                System.out.println("No se pudo insertar el producto.");
	            }

	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	        return r;
	    }

	    
	    
	    	
	    	private static boolean listarProductosporTalla(Connection connection) {
			// TODO Auto-generated method stub
	    		System.out.println("dime el ID de la Talla");
	    		boolean r = false;
	    		int id = input.nextInt();
	    		String sql = "SELECT * from producto where id_Talla = ?";
	    		try  {
	    			PreparedStatement pstmt = connection.prepareStatement(sql);
	    			// parámetros del 
	    					pstmt.setInt(1,id );
	    			ResultSet rs = pstmt.executeQuery();
	    				r = true;
	    			
	    			//ejecutar select
	    			System.out.println("datos de los productos con id talla: "+ id);
	    			while (rs.next()) {
	    				int idProducto = rs.getInt("id_Producto");
	    			    String nombre = rs.getString("nombre_Producto");
	    			    
	    			    Double precio = rs.getDouble("precio");
	    			    String estado = rs.getString("estado");
	    			    
	    			    int descuento = rs.getInt("descuento");
	    				
	    				System.out.println(
	    				        "Producto: " + idProducto +
	    				        " | Nombre: " + nombre +
	    				        " | Precio: " + precio +
	    				        " | Estado: " + estado 
	    				    );
	    			}
	    			
	    			
	    		} catch (Exception e) {
	    			// TODO: handle exception
	    			e.printStackTrace();
	    		}
			return r; 
		}


			//cerrar la coneixion despues de usarla
	    	
private static boolean listarProductosporCategoria(Connection connection) {
			// TODO Auto-generated method stub
	System.out.println("dime el ID de la Categoria");
	boolean r = false;
	int id = input.nextInt();
	String sql = "SELECT * from producto where id_Categoria = ?";
	try  {
		PreparedStatement pstmt = connection.prepareStatement(sql);
		// parámetros del 
				pstmt.setInt(1,id );
		ResultSet rs = pstmt.executeQuery();
		r = true;
		
		//ejecutar select
		System.out.println("datos de los productos con id ategoria: "+ id);
		while (rs.next()) {
			int idProducto = rs.getInt("id_Producto");
		    String nombre = rs.getString("nombre_Producto");
		    int idCategoria = rs.getInt("id_categoria");
		    int idTalla = rs.getInt("id_Talla");
		    int idColor = rs.getInt("id_Color");
		    
		    int idMaterial = rs.getInt("id_Material");
		    int stock = rs.getInt("stock");
		    Double precio = rs.getDouble("precio");
		    Double costo = rs.getDouble("costo");
		    String estado = rs.getString("estado");
		    
		    int descuento = rs.getInt("descuento");
			
			System.out.println(
			        "Producto: " + idProducto +
			        " | Nombre: " + nombre +
			        " | Precio: " + precio +
			        " | Estado: " + estado 
			    );
		}
		
		
	} catch (Exception e) {
		// TODO: handle exception
		e.printStackTrace();
	}
			return r;
		}
//	    	
		private static void menu() {
			System.out.println("---Menú---\n"
					+ "1.-Productos por categorias\n"
					+ "2.-Productos por talla\n"
					+ "3.-Nuevo producto\n"
					+ "4.-Calcular precio fina\n"
					+ "5.-Vender un producto\n"+
					"6.-Salir");
		}


}
