package oneToMany;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
@Table(name = "Factura")
public class Factura {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private Date fecha;
	private String concepto;
	private Double importe;
	@ManyToOne
	@JoinColumn(name = "persona_nombre")
	private Persona persona;
	
	
	public Factura(int id, Date fecha, String concepto, Double importe, Persona persona) {
		super();
		this.id = id;
		this.fecha = fecha;
		this.concepto = concepto;
		this.importe = importe;
		this.persona = persona;
	}
	
	public Factura(Date fecha, String concepto, Double importe, Persona persona) {
		super();
		this.fecha = fecha;
		this.concepto = concepto;
		this.importe = importe;
		this.persona = persona;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Date getFecha() {
		return fecha;
	}
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	public String getConcepto() {
		return concepto;
	}
	public void setConcepto(String concepto) {
		this.concepto = concepto;
	}
	public Double getImporte() {
		return importe;
	}
	public void setImporte(Double importe) {
		this.importe = importe;
	}
	
	public Factura() {
		super();
	}
	@Override
	public String toString() {
		return "Factura [id=" + id + ", fecha=" + fecha + ", concepto=" + concepto + ", importe=" + importe
				+ ", persona=" + persona + "]";
	}
	
	
	
}
