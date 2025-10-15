package EXAMEN_MAYO;

public class DispositivoInteligente {
	protected String id;
	protected String ubicacion;
	protected boolean encendido;
	
	 public DispositivoInteligente(String id, String ubicacion, boolean encendido) {
		this.id=id;
		this.ubicacion=ubicacion;
		this.encendido= encendido;
	}
	 public void EncenderDispositivo() {
		 this.encendido= true;
	 }
	 public void ApagarDispositivo() {
		 this.encendido= false;
	 }
	 public String mostrarInfo() {
		 String aux = "";
		 if(encendido == true) {
			 aux = "sí";
		 }else {
			 aux= "no";
		 }
		 return "ID: "+id+ " | "+" Ubicación: "+ ubicacion+ " | "+"¿Encendido? : "+ aux;
	 }
	 
}
