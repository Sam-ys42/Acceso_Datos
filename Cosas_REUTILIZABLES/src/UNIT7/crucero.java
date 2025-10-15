package UNIT7;
public class crucero extends barco{
	public int nombre;

	public int ID=3;
	public int espaciosOcupados=3;
	
	public crucero(boolean orientacion, int a, int b, int c) {
		super(orientacion);
		coordenadaX=a;
		coordenadaY =b;
		nombre= c;
	}
}
