package UNIT7;
import java.util.Scanner;
public class A5_Ejer_ahorcado {

	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);
		System.out.println("PIM PIM PIM... JUEGO DEL AHORCADO\n introduzca una palabra: ");
		String palabra=input.nextLine();
		String malos= "Palabras descartadas:  "; 
		System.out.println("\n\n\n\n\n\n");
		String respuesta;
		int contador=9;
		boolean acierto, hasGanado=false;
		StringBuffer cadena = new StringBuffer ("");

		for (int i = 0; i < palabra.length(); i++) {
			cadena.append(" _");
		}
		System.out.println(cadena +"\n introduzca una letra, solo puede fallar "+ contador+ " veces");
		System.out.println(malos);
		do{
			hasGanado= true;
			
			acierto=false;
			respuesta = input.nextLine();
			
			for (int i = 0; i < palabra.length(); i++) {
				if (palabra.charAt(i) == respuesta.charAt(0)) {
					cadena.delete((i*2)+1, (i*2)+2);
					cadena.insert(i*2+1,  respuesta.charAt(0));
					
					acierto = true;
					char letra = respuesta.charAt(0);

				}
			}
			if (acierto != true) {
				System.out.println("ERROR             no es esa palabra...");
				System.out.println("solo puede fallar "+ --contador+" veces");
				
				boolean hayLetra= false;
				for(int i=20; i< malos.length(); i++) {
						if(malos.charAt(i)== respuesta.charAt(0)) { // hay algo
								hayLetra= true;	
						}
				}
				if(hayLetra==false) {
						malos += respuesta.charAt(0)+ ", ";
				}
	
		}
			System.out.println(malos + "\n"+ cadena);
			
			for (int i = 0; i < cadena.length(); i++) {
				if (cadena.charAt(i)== '_') {
					hasGanado= false; // todavia no ha ganado....
				}
			}
			if(hasGanado== true) {
				contador= 0;
				
			}
			
		}while(contador>0 );
		if (hasGanado== true) System.out.println("HAS GANADO ");
		else {
			System.out.println("HAS PERDIDO");
		}
		System.out.println("--------------------FIN DEL JUEGO-------------------- \n"+ palabra);
			
		}
}
