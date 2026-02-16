package oneToOne;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="socios")
public class Socios implements Serializable {
	
	@Id
	@Column(name="dni")
	private String dni;
	
	@Column(name="nombre")
	private String nombre;
	
	@Column(name="apellidos")
	private String apellidos;
	
	@OneToOne(mappedBy = "socio")
	private Tarjeta tarjeta;

	public Socios(String dni, String nombre, String apellidos) {
		super();
		this.dni = dni;
		this.nombre = nombre;
		this.apellidos = apellidos;
	}

	public Socios() {
		super();
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

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public Tarjeta getTarjeta() {
		return tarjeta;
	}

	public void setTarjeta(Tarjeta tarjeta) {
		this.tarjeta = tarjeta;
	}

	@Override
	public String toString() {
		return "Socios [dni=" + dni + ", nombre=" + nombre + ", apellidos=" + apellidos + ", tarjeta=" + tarjeta + "]";
	}
	
	
	

}
