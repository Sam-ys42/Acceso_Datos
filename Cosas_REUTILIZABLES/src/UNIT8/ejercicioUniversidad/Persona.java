package UNIT8.ejercicioUniversidad;

import UNIT3.rectángulo;

public  class Persona {
	protected   String  nombre;
	protected String apellido;
	protected String direccion;
    protected int codigoPostal;
    protected int telefono;
    
    public  void setNombre(String nombre) {
    	this.nombre = nombre;
    }
    public void setApellido(String apellido) {
    	this.apellido = apellido;
    }
    public void setDireccion(String direccion) {
    	this.direccion= direccion;
    	}
    public void setCodigoPostal(int codigoPostal) {
    	this.codigoPostal= codigoPostal;
    }
    public void setTelefono(int telefono) {
    	this.telefono= telefono;
    }
    public String getNombre() {
    	return nombre;
    }
    public String getApellido() {
		return apellido;
	}
    public String getDireccion() {
    	return direccion;
	}
    public int getCodigopostal() {
		return codigoPostal;
	}
    public int getTelefono() {
		return telefono;
	}
    public  void mostrarInformacion() {
    	
    };
    
    
    
    
    
    
    
    
    
    
    
}
