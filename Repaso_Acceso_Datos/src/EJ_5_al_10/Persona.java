package EJ_5_al_10;

public class Persona {
	protected String nombre;
	protected  String apellidos;
	protected String dni;
	protected int edad;
	protected boolean estadoCivil;
	public Persona(String nombre, String apellidos, String dni, int edad, boolean estadoCivil) {
		super();
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.dni = dni;
		this.edad = edad;
		this.estadoCivil = estadoCivil;
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
	public String getDni() {
		return dni;
	}
	public void setDni(String dni) {
		this.dni = dni;
	}
	public int getEdad() {
		return edad;
	}
	public void setEdad(int edad) {
		this.edad = edad;
	}
	public boolean isEstadoCivil() {
		return estadoCivil;
	}
	public void setEstadoCivil(boolean estadoCivil) {
		this.estadoCivil = estadoCivil;
	}
	@Override
	public String toString() {
		return "Persona [nombre=" + nombre + ", apellidos=" + apellidos + ", dni=" + dni + ", edad=" + edad
				+ ", estadoCivil=" + estadoCivil + "]";
	}
	
	
	
	
	
	
	
	
	
}
