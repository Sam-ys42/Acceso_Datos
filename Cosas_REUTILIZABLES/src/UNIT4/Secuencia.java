package UNIT4;

public class Secuencia {
						// se escribe una clase Secuencia que muestra una secuencia comenzando con los números 1 y 1. Los números sucesivos en la 
						//secuencia son la suma de los dos números anteriores. Por ejemplo:1 1 2 3 5 8 13. Siga estos pasos para crear la clase:
	public static void mostrarFrecuencia() {
		int a=0, b=1, aux=0, i=0;
		System.out.print(b+ " ");
		while(aux<55) {
			aux= a+b;
			a=b;
			b=aux;
			System.out.print(aux+ " ");
			
		
		}
	}
	public static void main(String[] args) {
		mostrarFrecuencia();

	}

}
