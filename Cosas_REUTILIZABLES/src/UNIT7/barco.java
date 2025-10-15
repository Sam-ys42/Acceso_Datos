package UNIT7;
import java.util.Random;

public class barco {
	public int ID;
	public  boolean orientacion ; // TRUE = Vertical;  FLASE= horizontal
	public  int espaciosOcupados;
	public  boolean hundido = false; // false= esta en mar; true= está undido
	public  int coordenadaX;
	public int coordenadaY;
	
	
	public barco(boolean orientacion){
		this.orientacion= orientacion;
	}
	/*public  boolean getorientacion() {
		return orientacion;
	}
	
	public  int getEspacioOcupado() {
		return espaciosOcupados;
	}
	
	public  boolean getHundido() {
		return hundido;
	}
	
	public  int getcoordenadaX() {
		return coordenadaX;
	}
	public int getcoordenadaY() {
		return coordenadaY;
	}
	*/
	
	
}


