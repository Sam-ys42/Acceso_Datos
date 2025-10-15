package mis_cosas_APARTE;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Collections;

class Producto {
    private String nombre;
    private double precio;
    private int cantidadEnStock;

    public Producto(String nombre, double precio, int cantidadEnStock) {
        this.nombre = nombre;
        this.precio = precio;
        this.cantidadEnStock = cantidadEnStock;
    }

    // Getters y Setters
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public int getCantidadEnStock() {
        return cantidadEnStock;
    }

    public void setCantidadEnStock(int cantidadEnStock) {
        this.cantidadEnStock = cantidadEnStock;
    }

    @Override
    public String toString() {
        return "Producto [nombre=" + nombre + ", precio=" + precio + ", cantidadEnStock=" + cantidadEnStock + "]";
    }

    // Compara productos por nombre
    @Override
    public boolean equals(Object obj) {
        if (obj == null || getClass() != obj.getClass()) return false;
        Producto other = (Producto) obj;
        return this.nombre.equals(other.nombre);
    }
}
//------------------------------------------------------------------
public class GestionInventario {

    static ArrayList<Producto> inventario = new ArrayList<>();
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        boolean continuar = true;

        while (continuar) {
            System.out.println("\n--- Menú de Inventario ---");
            System.out.println("1. Añadir producto");
            System.out.println("2. Eliminar producto");
            System.out.println("3. Buscar producto");
            System.out.println("4. Mostrar inventario");
            System.out.println("5. Ordenar inventario por precio");
            System.out.println("6. Actualizar cantidad");
            System.out.println("0. Salir");
            System.out.print("Elija una opción: ");
            int opcion = scanner.nextInt();
            scanner.nextLine(); // Consumir el salto de línea

            switch (opcion) {
                case 1:
                    añadirProducto();
                    break;
                case 2:
                    eliminarProducto();
                    break;
                case 3:
                    buscarProducto();
                    break;
                case 4:
                    mostrarInventario();
                    break;
                case 5:
                    ordenarInventarioPorPrecio();
                    break;
                case 6:
                    actualizarCantidad();
                    break;
                case 0:
                    continuar = false;
                    break;
                default:
                    System.out.println("Opción no válida.");
                    break;
            }
        }

        System.out.println("¡Gracias por usar el sistema de inventario!");
    }
    
    //-------------------------------------------------------------------

    public static void añadirProducto() {
        System.out.print("Introduzca el nombre del producto: ");
        String nombre = scanner.nextLine();
        System.out.print("Introduzca el precio del producto: ");
        double precio = scanner.nextDouble();
        System.out.print("Introduzca la cantidad en stock: ");
        int cantidad = scanner.nextInt();
        scanner.nextLine(); // Consumir el salto de línea

        Producto nuevoProducto = new Producto(nombre, precio, cantidad);
        if (!inventario.contains(nuevoProducto)) {
            inventario.add(nuevoProducto);
            System.out.println("Producto añadido exitosamente.");
        } else {
            System.out.println("¡El producto ya existe en el inventario!");
        }
    }

    public static void eliminarProducto() {
        System.out.print("Introduzca el nombre del producto a eliminar: ");
        String nombre = scanner.nextLine();
        Producto producto = buscarProductoPorNombre(nombre);
        if (producto != null) {
            inventario.remove(producto);
            System.out.println("Producto eliminado.");
        } else {
            System.out.println("El producto no se encuentra en el inventario.");
        }
    }

    public static void buscarProducto() {
        System.out.print("Introduzca el nombre del producto a buscar: ");
        String nombre = scanner.nextLine();
        Producto producto = buscarProductoPorNombre(nombre);
        if (producto != null) {
            System.out.println(producto);
        } else {
            System.out.println("Producto no encontrado.");
        }
    }

    public static Producto buscarProductoPorNombre(String nombre) {
        for (Producto producto : inventario) {
            if (producto.getNombre().equalsIgnoreCase(nombre)) {
                return producto;
            }
        }
        return null;
    }

    public static void mostrarInventario() {
        if (inventario.isEmpty()) {
            System.out.println("El inventario está vacío.");
        } else {
            for (Producto producto : inventario) {
                System.out.println(producto);
            }
        }
    }

    public static void ordenarInventarioPorPrecio() {
        Collections.sort(inventario, (p1, p2) -> Double.compare(p1.getPrecio(), p2.getPrecio()));
        System.out.println("Inventario ordenado por precio.");
    }

    public static void actualizarCantidad() {
        System.out.print("Introduzca el nombre del producto a actualizar cantidad: ");
        String nombre = scanner.nextLine();
        Producto producto = buscarProductoPorNombre(nombre);
        if (producto != null) {
            System.out.print("Introduzca la nueva cantidad en stock: ");
            int cantidad = scanner.nextInt();
            producto.setCantidadEnStock(cantidad);
            System.out.println("Cantidad actualizada.");
        } else {
            System.out.println("Producto no encontrado.");
        }
    }
}
