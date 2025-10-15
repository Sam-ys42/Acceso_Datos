package UNIT6;

public class Ej02_TestCovid {

	boolean positivo;
	int edad;
	String nombre;
	char sexo;
	
	public void setPositivo() {
		positivo=true;
	}
	
	public void setFalso() {
		positivo=false;
	}
	
	public boolean getResultado() {
		return positivo;
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Ej02_TestCovid miTest = new Ej02_TestCovid();
		
		
		
		
		if (miTest.getResultado()) {
			System.out.println("El test ha resultado positivo.");
		}
		
	}

}
