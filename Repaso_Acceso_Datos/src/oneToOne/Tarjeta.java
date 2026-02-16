package oneToOne;

import java.io.Serializable;
import java.sql.Date;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="tarjeta")
public class Tarjeta implements Serializable {
	
	@Id
	@Column(name="numero")
	private String nombre;
	
	@Column(name="caducidad")
	private LocalDate caducidad;
	
	@OneToOne
	@JoinColumn(name="socios_dni")
	private Socios socio;

	public Tarjeta(String nombre, LocalDate caducidad, Socios socio) {
		super();
		this.nombre = nombre;
		this.caducidad = caducidad;
		this.socio = socio;
	}

	public Tarjeta() {
		super();
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public LocalDate getCaducidad() {
		return caducidad;
	}

	public void setCaducidad(LocalDate caducidad) {
		this.caducidad = caducidad;
	}

	public Socios getSocio() {
		return socio;
	}

	public void setSocio(Socios socio) {
		this.socio = socio;
	}

	@Override
	public String toString() {
		return "Tarjeta [nombre=" + nombre + ", caducidad=" + caducidad + ", socio=" + socio + "]";
	}
	
	

}
