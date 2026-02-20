package pack;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity 
@Table(name = "prestamo") 
public class Prestamo {
	
	private int idPrestamo;
	private boolean prestamo;
	private String socioDni; // dni de socio
	private String libroisbn; // isbn de libro
	
	
	public Prestamo(int idPrestamo, boolean prestamo, String socioDni, String libroisbn) {
		super();
		this.idPrestamo = idPrestamo;
		this.prestamo = prestamo;
		this.socioDni = socioDni;
		this.libroisbn = libroisbn;
	}
	
	
	public Prestamo() {
	}


	public int getIdPrestamo() {
		return idPrestamo;
	}
	public void setIdPrestamo(int idPrestamo) {
		this.idPrestamo = idPrestamo;
	}
	public boolean isPrestamo() {
		return prestamo;
	}
	public void setPrestamo(boolean prestamo) {
		this.prestamo = prestamo;
	}
	public String getSocioDni() {
		return socioDni;
	}
	public void setSocioDni(String socioDni) {
		this.socioDni = socioDni;
	}
	public String getLibroisbn() {
		return libroisbn;
	}
	public void setLibroisbn(String libroisbn) {
		this.libroisbn = libroisbn;
	}
	@Override
	public String toString() {
		return "Prestamo [idPrestamo=" + idPrestamo + ", prestamo=" + prestamo + ", socioDni=" + socioDni + ", libroisbn="
				+ libroisbn + "]";
	}
	
	

}
