package ejercicioFinal_NavaVinted;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlTransient;
import javax.xml.bind.annotation.XmlType;

import com.fasterxml.jackson.annotation.JsonIgnore;

@XmlType(propOrder = { "nombre","talla","color","precio","estado" })
public class Producto implements Serializable {

	private int id, stock, descuento;
	private String nombre, talla, color, estado;
	private double precio, coste;

	public Producto(int id, int stock, int descuento, String nombre, String talla, String color, String estado,
			double precio, double coste) {
		super();
		this.id = id;
		this.stock = stock;
		this.descuento = descuento;
		this.nombre = nombre;
		this.talla = talla;
		this.color = color;
		this.estado = estado;
		this.precio = precio;
		this.coste = coste;
	}

	public Producto() {
		super();
	}

	@XmlTransient
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@JsonIgnore
	@XmlTransient
	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}

	@JsonIgnore
	@XmlTransient
	public int getDescuento() {
		return descuento;
	}

	public void setDescuento(int descuento) {
		this.descuento = descuento;
	}

	@JsonIgnore
	@XmlElement(name = "nombre")
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	@JsonIgnore
	@XmlElement(name = "talla")
	public String getTalla() {
		return talla;
	}

	public void setTalla(String talla) {
		this.talla = talla;
	}

	@JsonIgnore
	@XmlElement(name = "color")
	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	@JsonIgnore
	@XmlElement(name = "estado")
	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	@XmlElement(name = "precio")
	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	@JsonIgnore
	@XmlTransient
	public double getCoste() {
		return coste;
	}

	public void setCoste(double coste) {
		this.coste = coste;
	}

	@Override
	public String toString() {
		return "Producto [id=" + id + ", stock=" + stock + ", descuento=" + descuento + ", nombre=" + nombre
				+ ", talla=" + talla + ", color=" + color + ", estado=" + estado + ", precio=" + precio + ", coste="
				+ coste + "]";
	}

}
