package ejercicio46;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonPropertyOrder({"nombre", "tipo", "origen", "ingredientes"})
public class Receta {
	private String nombre;
	private String  tipo;
	private Origen origen;
	private List<Ingrediente> ingredientes;
	
	
	public Receta(String nombre, String tipo, Origen origen, List<Ingrediente> ingredientes) {
		super();
		this.nombre = nombre;
		this.tipo = tipo;
		this.origen = origen;
		this.ingredientes = ingredientes;
	}

	public Receta() {
	
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public Origen getOrigen() {
		return origen;
	}

	public void setOrigen(Origen origen) {
		this.origen = origen;
	}

	public List<Ingrediente> getIngredientes() {
		return ingredientes;
	}

	public void setIngredientes(List<Ingrediente> ingredientes) {
		this.ingredientes = ingredientes;
	}
	
	public String mostrarIngredientes(String resultado) {
		
		for (Ingrediente ingredientes2 : ingredientes) {
			resultado += ingredientes2;
		}
		return resultado;
		
	}

	@Override
	public String toString() {
		return " Nombre: " + nombre + "\n Tipo: " + tipo + "\n Origen:" + origen + "\n Ingredientes: " + mostrarIngredientes("")
				;
	}
	
	

}
