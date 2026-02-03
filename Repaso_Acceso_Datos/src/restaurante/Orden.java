package restaurante;

import java.sql.Date;

public class Orden {

	protected int id_orden;
	protected Date fecha;
	protected double total;
	protected String estado;
	public Orden(int id_orden, Date fecha, double total, String estado) {
		super();
		this.id_orden = id_orden;
		this.fecha = fecha;
		this.total = total;
		this.estado = estado;
	}
	public Orden() {
		super();
	}
	public int getId_orden() {
		return id_orden;
	}
	public void setId_orden(int id_orden) {
		this.id_orden = id_orden;
	}
	public Date getFecha() {
		return fecha;
	}
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	public double getTotal() {
		return total;
	}
	public void setTotal(double total) {
		this.total = total;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	@Override
	public String toString() {
		return "Orden [id_orden=" + id_orden + ", fecha=" + fecha + ", total=" + total + ", estado=" + estado + "]";
	}
	
	
}
