package oneToMany;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "Persona")
public class Persona {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String nombre;
	@OneToMany(mappedBy = "persona")
	private List<Factura> facturas;
	public Persona(int id, String nombre, List<Factura> facturas) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.facturas = facturas;
	}
	
	public Persona() {
		super();
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public List<Factura> getFacturas() {
		return facturas;
	}
	public void setFacturas(List<Factura> facturas) {
		this.facturas = facturas;
	}
	@Override
	public String toString() {
		return "Persona [id=" + id + ", nombre=" + nombre + ", facturas=" + facturas + "]";
	}
	
	
	
	
	

}
