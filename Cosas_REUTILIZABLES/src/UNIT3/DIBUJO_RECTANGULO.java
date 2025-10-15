package UNIT3;

public class DIBUJO_RECTANGULO {

	public static void main(String[] args) {
		int altura=3, anchura = 10, contadorColu = 0, contadorFIlas=0;
		while (contadorFIlas < altura) {
			contadorColu =0;
			while (contadorColu < anchura) {
				System.out.print("o");
				contadorColu ++;
			}
			System.out.println();
			contadorFIlas ++;
		}
	}

}
