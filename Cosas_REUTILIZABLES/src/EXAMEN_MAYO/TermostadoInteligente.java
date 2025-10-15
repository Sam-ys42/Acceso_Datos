package EXAMEN_MAYO;

public class TermostadoInteligente extends DispositivoInteligente {
protected double temperaturaObjetivo;
	public TermostadoInteligente(String id, String ubicacion, boolean encendido, double temperaturaObjetivo) {
		super(id, ubicacion, encendido);
		this.temperaturaObjetivo= temperaturaObjetivo;
		// TODO Auto-generated constructor stub
	}
	
	public String mostrarInfo() {
		return "Termostato - "+ super.mostrarInfo()+ " | temperatura Obejtivo: "+ temperaturaObjetivo +  "Cº";
	}

}
