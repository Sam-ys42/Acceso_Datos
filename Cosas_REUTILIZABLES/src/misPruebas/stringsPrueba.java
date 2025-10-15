package misPruebas;

public class stringsPrueba {
private static final int I = 7;
	public static void main(String[] args) {
		int value=0;
		String s="";
		for (int i=0; i<4; i++) {
			for(int j=0; j<I; j++) {
				if(j<I-1) {
					s +="1";
					//value += Integer.parseInt(s);
				
			}
			}
		}
		System.out.println(s+ value);
		String a = "555555555";
		int b = Integer.parseInt(a);
		int c = b+5;
		System.out.println(c);
		String e= "si";
		String gaga = "SI";
		if(e.equalsIgnoreCase(gaga)) {
			System.out.println("hoLA");
		}
	}

}
