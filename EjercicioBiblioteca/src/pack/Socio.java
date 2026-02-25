package pack;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity 
@Table(name = "socio") 
public class Socio implements Serializable{
	
	@Id
	private String dni;
	private String nombre;
	private String numTelefono;
	public Socio(String dni, String nombre, String numTelefono) {
		super();
		this.dni = dni;
		this.nombre = nombre;
		this.numTelefono = numTelefono;
	}
	public Socio() {
	}
	public String getDni() {
		return dni;
	}
	public void setDni(String dni) {
		this.dni = dni;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getNumTelefono() {
		return numTelefono;
	}
	public void setNumTelefono(String numTelefono) {
		this.numTelefono = numTelefono;
	}
	@Override
	public String toString() {
		return "Socio [dni=" + dni + ", nombre=" + nombre + ", numTelefono=" + numTelefono + "]";
	}
	
	public static void actualizarTelefono(EntityManager em, String dni, String nuevoTelefono) {
		em.getTransaction().begin();
		Socio s = em.find(Socio.class, dni); 
		if (s != null) {
			s.setNumTelefono(nuevoTelefono);
			em.merge(s);
			System.out.println("Teléfono actualizado para " + dni);
			}else {
				System.out.println("No existe socio con dni " + dni);
				}
		em.getTransaction().commit();
		}
	

}
