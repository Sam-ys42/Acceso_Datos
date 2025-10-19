package ACCESO_FICHERO_ALEATORIO;
import java.io.IOException;
import java.io.RandomAccessFile;

public class EJERCICIO32 {



	    static final int TAM_NOMBRE = 20; // 20 caracteres máximo
	    static final int TAM_REGISTRO = 4 + (2 * TAM_NOMBRE) + 8 + 4; // int + nombre(20char*2) + double + int = 56 bytes

	    public static void main(String[] args) {
	        String fichero = "productos.dat";

	        // Crear tres productos
	        Producto p1 = new Producto(1, "Leche", 1.50, 100);
	        Producto p2 = new Producto(2, "Pan", 8.75, 200);
	        Producto p3 = new Producto(3, "Zumo", 15.30, 50);

	        try (RandomAccessFile raf = new RandomAccessFile(fichero, "rw")) {
	            // Escribir los tres productos en el fichero
	            escribirProducto(raf, p1);
	            escribirProducto(raf, p2);
	            escribirProducto(raf, p3);

	            // Leer el producto 2 (posición 1)
	            int numRegistro = 1; // Producto número 2
	            raf.seek(numRegistro * TAM_REGISTRO); // desplazamiento al segundo registro

	            Producto p = LeerProducto(raf);
	            System.out.println("Producto: " + p.getCodigo() +
	                    " Nombre: " + p.getNombre().trim() +
	                    " Precio: " + p.getPrecio() +
	                    " Cantidad en stock: " + p.getCantidad());

	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	    }

	    // Método para escribir un producto en el fichero binario
	    public static void escribirProducto(RandomAccessFile raf, Producto p) throws IOException {
	        raf.writeInt(p.getCodigo());

	        StringBuffer buffer = new StringBuffer(p.getNombre());
	        buffer.setLength(TAM_NOMBRE); // ajusta longitud a 20 caracteres
	        raf.writeChars(buffer.toString());

	        raf.writeDouble(p.getPrecio());
	        raf.writeInt(p.getCantidad());
	    }

	    // Método para leer un producto desde la posición actual del fichero
	    public static Producto LeerProducto(RandomAccessFile raf) throws IOException {
	        int codigo = raf.readInt();

	        char[] nombreChars = new char[TAM_NOMBRE];
	        for (int i = 0; i < TAM_NOMBRE; i++) {
	            nombreChars[i] = raf.readChar();
	        }
	        String nombre = new String(nombreChars);

	        double precio = raf.readDouble();
	        int cantidad = raf.readInt();

	        return new Producto(codigo, nombre, precio, cantidad);
	    }
}
