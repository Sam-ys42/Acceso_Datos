package Tareas_Evaluables;
import java.util.Scanner; // importo la librería Scanner para meter valores;
public class prueba_Array_Samira_delaCruz_Menacho {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.print("¿Cuántas temperaturas quiere ingresar? : "); // preguntamos el valor de n
		int n= input.nextInt();
		int dias[]= new int[n]; // le damos el tamaño del aray según nos lo especifica el usuario
		System.out.println("A continuación, indica las "+ n + " temperaturas: ");
		for(int i=0; i<n; i++) {
			dias[i]= input.nextInt(); // Aquí rellenamos las n casillas del array 
		}
		for(int i=0; i<n; i++) {
			int b=0, s=i; // Aquí declaro las variables int que voy a usar, en este caso b será el contador de días, y s, será la variable que usaré para moverme por el array
			do { 					/*aquí lo que hago es sumarle 1 a la variable s, para que dias[i] y dias[s] NO sean iguales, 
										despues le sumo por defecto al contador un 1, ya que con el condicional if  que tenemos, en el caso que no encuentra ningún mayor a ese número, se cambiará de inmediato a un 0*/
				s+=1;
				b++;
				if(s>=dias.length) { // aquí si no ve a lo largo del array algún número mayor, cambia la variable b por el valor 0, y rompe el bucle do-while
					b=0;
					break;
				}
			}while(dias[i]>=dias[s]); // en este apartado me he decantado por el bucle do-while, en la condicional le digo que se repita el bucle, hasta que dias[i] sea mayor o igual a dias[s], en ese caso, volverá al bucle for con int i
			System.out.print(b+",   ");
		}  // Cómo no se ha especificado que el programa se repita hasta que el usuario lo pida, solo se ejecutará 1 vez. FIN.
	}
}