package EJ_5_al_10;

import java.util.HashSet;
import java.util.LinkedHashSet;

public class Ejercicio31 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
			HashSet<String> nombres = new HashSet<String>();
			LinkedHashSet<String> a = new LinkedHashSet<String>();
			for (int i = 5; i >=0; i--) {
				nombres.add("Pepe"+i);
				a.add("Pepe"+i);
			}
			
			for (String string : nombres) {
				
				System.out.println(string);
			}
			System.out.println("____________________");
			
			for (String string : a) {
				System.out.println(string);
			}
	}

}
