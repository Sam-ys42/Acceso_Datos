package BDZapatos;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;


@JsonIgnoreProperties(ignoreUnknown = true)
@JsonPropertyOrder({"marca", "modelo", "tamano", "color","stock","precio"})

public class Zapato implements Serializable {
	
	@JsonIgnore
	private int id;
	private String marca;
	private String modelo;
	private String tamano;
	private String color;
	private int stock;
	private double precio;
	public Zapato(int id, String marca, String modelo, String tamano, String color, int stock, double precio) {
		super();
		this.id = id;
		this.marca = marca;
		this.modelo = modelo;
		this.tamano = tamano;
		this.color = color;
		this.stock = stock;
		this.precio = precio;
	}
	public Zapato() {
		
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getMarca() {
		return marca;
	}
	public void setMarca(String marca) {
		this.marca = marca;
	}
	public String getModelo() {
		return modelo;
	}
	public void setModelo(String modelo) {
		this.modelo = modelo;
	}
	public String getTamano() {
		return tamano;
	}
	public void setTamano(String tamano) {
		this.tamano = tamano;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public int getStock() {
		return stock;
	}
	public void setStock(int stock) {
		this.stock = stock;
	}
	public double getPrecio() {
		return precio;
	}
	public void setPrecio(double precio) {
		this.precio = precio;
	}
	@Override
	public String toString() {
		return "Zapato [id=" + id + ", marca=" + marca + ", modelo=" + modelo + ", tamano=" + tamano + ", color="
				+ color + ", stock=" + stock + ", precio=" + precio + "]";
	}
	
	
	

}
