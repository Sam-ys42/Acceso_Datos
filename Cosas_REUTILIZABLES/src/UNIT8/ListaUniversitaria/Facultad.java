package UNIT8.ListaUniversitaria;
import java.util.Scanner;

public class Facultad extends EmpleadoUniversitario {
	
	private boolean titular;
	
	public void establecer_datos() {
		super.establecer_datos();
		Scanner input = new Scanner(System.in);
		
		System.out.println("Introduce si eres o no titular (1 para SI, 2 para NO)");
		if (input.nextInt()==1){
			this.titular=true;
		}else {
			this.titular=false;
		}
			
		
		

	}

	@Override
	public String toString() {
		return "Facultad: ["+super.toString()+", titular=" + titular + "]";
	}
	
	

}