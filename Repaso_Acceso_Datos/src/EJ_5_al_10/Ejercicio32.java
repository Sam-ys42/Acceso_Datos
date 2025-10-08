package EJ_5_al_10;

import java.util.LinkedHashSet;

public class Ejercicio32 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LinkedHashSet<String> a = new LinkedHashSet<String>();
		
		for (int i = 5; i >=0; i--) {
		
			a.add("Pepe"+i);
		}
		
		for (String string : a) {
			System.out.println(string);
		}
	}

}
