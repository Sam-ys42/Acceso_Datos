package EJ_5_al_10;

import java.util.ArrayList;

public class Ejercicio30 {
public static void main(String[] args) {
	ArrayList<String> nombres= new ArrayList<String>();
	nombres.add("Pepe");
	nombres.add("Aitana");
	nombres.add("Fabio");
	nombres.add("Enrique");
	nombres.add("Pepe");
	
	for (String string : nombres) {
		System.out.println(string);
	}
	
}
}
