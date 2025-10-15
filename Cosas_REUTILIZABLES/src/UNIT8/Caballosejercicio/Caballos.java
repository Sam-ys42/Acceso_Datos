package UNIT8.Caballosejercicio;
import java.util.Date;
import java.util.Scanner;
public class Caballos {
	
	private String nombre, color;
	private Date fechaNacimiento;
	
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public Date getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(Date fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	public static void main(String[] args) {
		 Scanner input = new Scanner(System.in);
		 Caballos Perdigon = new Caballos();
		 CarrerasCaballo velocito = new CarrerasCaballo();

	}

	

}