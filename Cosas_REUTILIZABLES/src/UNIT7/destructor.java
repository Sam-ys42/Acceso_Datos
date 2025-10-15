package UNIT7;

public class destructor extends barco{
	public int nombre;
	public int ID= 2;
	public  int espaciosOcupados=2;
	 // TRUE = Vertical;  FLASE= horizontal
	public destructor(boolean orientacion, int a, int b, int c){
		super(orientacion);
		coordenadaX=a;
		coordenadaY =b;
		nombre= c;
	}
	
}
