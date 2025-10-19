package ACCESO_FICHERO_ALEATORIO;

public class Producto {

	    private int codigo;
	    private String nombre;
	    private double precio;
	    private int cantidad;

	    public Producto(int codigo, String nombre, double precio, int cantidad) {
	        this.codigo = codigo;
	        this.nombre = nombre;
	        this.precio = precio;
	        this.cantidad = cantidad;
	    }

	    public int getCodigo() {
	    	return codigo;
	    	}
	    public String getNombre() {
	    	return nombre;
	    	}
	    public double getPrecio() {
	    	return precio;
	    	}
	    public int getCantidad() {
	    	return cantidad;
	    	}

	    @Override
	    public String toString() {
	        return String.format("%d %-20s %.2f %d", codigo, nombre, precio, cantidad);
	    }


}
