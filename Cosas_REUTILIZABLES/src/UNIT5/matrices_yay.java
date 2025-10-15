package UNIT5;

public class matrices_yay {

	public static void main(String[] args) {
		
		int matriz[][]= {{0,0,0},{1,1,1},{2,2,2},{3,3,3}};
		for(int i=0; i<4; i++) {
			escribir.E("El contenido de la fila " + i+ " es: ");
			for(int j=0; j<3; j++) {
				escribir.E("matriz["+i+"] ["+j+"] ="+ matriz[i][j]);
			}
		}
	}

}
