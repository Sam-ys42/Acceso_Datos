package aA_BaseDatos_ejercicios;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

public class ej_11 {


	    private static final String URL = "jdbc:mysql://localhost:3306/navavinted";
	    private static final String USER = "root";
	    private static final String PASSWORD = ""; 

	    public static void main(String[] args) {
	    	try {
				Class.forName("com.mysql.cj.jdbc.Driver");
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD)) {
	            System.out.println("Conexión exitosa a la base de datos 'navavinted'");
	            Scanner sc = new Scanner(System.in);
	            int opcion;

	            do {
	                System.out.println("\n--- MENÚ NAVAVINTED ---");
	                System.out.println("1. Productos por categoría");
	                System.out.println("2. Productos por talla");
	                System.out.println("3. Nuevo producto");
	                System.out.println("4. Calcular precio final");
	                System.out.println("5. Vender un producto");
	                System.out.println("0. Salir");
	                System.out.print("Elige opción: ");
	                opcion = sc.nextInt();
	                sc.nextLine(); // limpiar buffer

	                switch (opcion) {
	                    case 1:
	                        productosPorCategoria(conn, sc);
	                        break;
	                    case 2:
	                        productosPorTalla(conn, sc);
	                        break;
	                    case 3:
	                        nuevoProducto(conn, sc);
	                        break;
	                    case 4:
	                        calcularPrecioFinal(conn, sc);
	                        break;
	                    case 5:
	                        venderProducto(conn, sc);
	                        break;
	                    case 0:
	                        System.out.println("Saliendo...");
	                        break;
	                    default:
	                        System.out.println("Opción no válida");
	                }
	            } while (opcion != 0);

	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	    }

	    // 1. Productos por categoría
	    private static void productosPorCategoria(Connection conn, Scanner sc)  {
	        System.out.print("Introduce ID de categoría: ");
	        int idCat = sc.nextInt();
	        String sql = "SELECT c.nombre_categoria, p.id_producto, p.nombre_producto, p.estado, p.precio " +
	                     "FROM producto p JOIN categoria c ON p.id_categoria=c.id_categoria WHERE p.id_categoria=?";
	        try (PreparedStatement ps = conn.prepareStatement(sql)) {
	            ps.setInt(1, idCat);
	            ResultSet rs = ps.executeQuery();
	            while (rs.next()) {
	                System.out.println(rs.getString("nombre_categoria") + " | " +
	                                   rs.getInt("id_producto") + " | " +
	                                   rs.getString("nombre_producto") + " | " +
	                                   rs.getString("estado") + " | " +
	                                   rs.getBigDecimal("precio"));
	            }
	        }catch (Exception e) {
				// TODO: handle exception
			}
	    }

	    // 2. Productos por talla
	    private static void productosPorTalla(Connection conn, Scanner sc) {
	        System.out.print("Introduce ID de talla: ");
	        int idTalla = sc.nextInt();
	        String sql = "SELECT nombre_producto, estado, precio FROM producto WHERE id_talla=?";
	        try (PreparedStatement ps = conn.prepareStatement(sql)) {
	            ps.setInt(1, idTalla);
	            ResultSet rs = ps.executeQuery();
	            while (rs.next()) {
	                System.out.println(rs.getString("nombre_producto") + " | " +
	                                   rs.getString("estado") + " | " +
	                                   rs.getBigDecimal("precio"));
	            }
	        }catch (Exception e) {
				// TODO: handle exception
			}
	    }

	    // 3. Nuevo producto
	    private static void nuevoProducto(Connection conn, Scanner sc)  {
	        System.out.print("Nombre producto: ");
	        String nombre = sc.nextLine();
	        System.out.print("ID categoría: ");
	        int idCat = sc.nextInt();
	        System.out.print("ID talla: ");
	        int idTalla = sc.nextInt();
	        System.out.print("ID color: ");
	        int idColor = sc.nextInt();
	        System.out.print("ID material: ");
	        int idMat = sc.nextInt();
	        System.out.print("Stock: ");
	        int stock = sc.nextInt();
	        System.out.print("Precio: ");
	        double precio = sc.nextDouble();
	        System.out.print("Costo: ");
	        double costo = sc.nextDouble();
	        sc.nextLine();
	        System.out.print("Estado: ");
	        String estado = sc.nextLine();
	        System.out.print("Descuento: ");
	        int descuento = sc.nextInt();

	        String sql = "INSERT INTO producto(nombre_producto, id_categoria, id_talla, id_color, id_material, stock, precio, costo, estado, descuento) " +
	                     "VALUES (?,?,?,?,?,?,?,?,?,?)";
	        try (PreparedStatement ps = conn.prepareStatement(sql)) {
	            ps.setString(1, nombre);
	            ps.setInt(2, idCat);
	            ps.setInt(3, idTalla);
	            ps.setInt(4, idColor);
	            ps.setInt(5, idMat);
	            ps.setInt(6, stock);
	            ps.setDouble(7, precio);
	            ps.setDouble(8, costo);
	            ps.setString(9, estado);
	            ps.setInt(10, descuento);
	            ps.executeUpdate();
	            System.out.println("Producto insertado correctamente.");
	        }catch (Exception e) {
				// TODO: handle exception
			}
	    }

	    // 4. Calcular precio final
	    private static void calcularPrecioFinal(Connection conn, Scanner sc)  {
	        System.out.print("Introduce ID de producto: ");
	        int idProd = sc.nextInt();
	        String sql = "SELECT precio, descuento FROM producto WHERE id_producto=?";
	        try (PreparedStatement ps = conn.prepareStatement(sql)) {
	            ps.setInt(1, idProd);
	            ResultSet rs = ps.executeQuery();
	            if (rs.next()) {
	                double precio = rs.getDouble("precio");
	                int descuento = rs.getInt("descuento");
	                double precioFinal = precio - (precio * descuento) / 100.0;
	                System.out.println("Precio final: " + precioFinal);
	            } else {
	                System.out.println("Producto no encontrado.");
	            }
	        }catch (Exception e) {
				// TODO: handle exception
			}
	    }

	    // 5. Vender producto
	    private static void venderProducto(Connection conn, Scanner sc)  {
	        System.out.print("Introduce ID de producto: ");
	        int idProd = sc.nextInt();
	        System.out.print("Cantidad a vender: ");
	        int cantidad = sc.nextInt();

	        String sql = "UPDATE producto SET stock = stock - ? WHERE id_producto=?";
	        try (PreparedStatement ps = conn.prepareStatement(sql)) {
	            ps.setInt(1, cantidad);
	            ps.setInt(2, idProd);
	            int filas = ps.executeUpdate();
	            if (filas > 0) {
	                System.out.println("Venta realizada. Stock actualizado.");
	            } else {
	                System.out.println("Producto no encontrado.");
	            }
	        }
	        catch (Exception e) {
				// TODO: handle exception
			}
	    }
}
