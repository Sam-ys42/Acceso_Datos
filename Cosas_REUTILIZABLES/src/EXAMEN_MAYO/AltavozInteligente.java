package EXAMEN_MAYO;

public class AltavozInteligente extends DispositivoInteligente{
protected int volumen;
protected boolean reproduciendoMusica;
	public AltavozInteligente(String id, String ubicacion, boolean encendido, int volumen, boolean musica) {
		super(id, ubicacion, encendido);
		this.volumen= volumen;
		this.reproduciendoMusica= musica;
		// TODO Auto-generated constructor stub
	}
	
	public String mostrarInfo() {
		String aux = "";
		 if(encendido == true) {
			 aux = "sí";
		 }else {
			 aux= "no";
		 }
		return "Altavoz - "+ super.mostrarInfo()+ " | volumen: "+ volumen+ "¿Reproduciendo música?: "+ aux; 
	}

}
