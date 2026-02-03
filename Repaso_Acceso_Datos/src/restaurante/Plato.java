package restaurante;

public class Plato {
	
	protected int id_plato;
	protected String nombre;
	protected double precio;
	protected String categoria;
	public Plato(int id_plato, String nombre, double precio, String categoria) {
		super();
		this.id_plato = id_plato;
		this.nombre = nombre;
		this.precio = precio;
		this.categoria = categoria;
	}
	public Plato() {
		super();
	}
	public int getId_plato() {
		return id_plato;
	}
	public void setId_plato(int id_plato) {
		this.id_plato = id_plato;
	}
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
	public String getCategoria() {
		return categoria;
	}
	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}
	@Override
	public String toString() {
		return "Plato [id_plato=" + id_plato + ", nombre=" + nombre + ", precio=" + precio + ", categoria=" + categoria
				+ "]";
	}
	
	

}
