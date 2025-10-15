package EXAMEN_MAYO;

public class BombillaInteligente extends DispositivoInteligente{
protected int brillo; // de 0 a 100
	public BombillaInteligente(String id, String ubicacion, boolean encendido, int brillo) {
		super(id, ubicacion, encendido);
		this.brillo= brillo;
		// TODO Auto-generated constructor stub
	}
	public String mostrarInfo() {
		return "Bombilla - "+ super.mostrarInfo()+ "| brillo: "+brillo + " %";
	}

}
