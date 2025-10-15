package UNIT7;
import java.util.Random;
import java.util.Scanner;


public class undir_la_Flota_GAME {
	public static Random random = new Random();
	public static final int ALTO = 10; //es 10
	public static final int LARGO = 10; // es 10
	
 public static String tableroJUGADOR[][]= new String [ALTO][LARGO];
 public static int tableroVIRTUAL[][]= new int [ALTO][LARGO];
 public static String arriba[]=  {"A","B","C", "D","E","F","G","H","I","J"};
 public static String izquierda[]= {"0","1","2","3","4","5","6","7","8","9" };

 
 
	public static void main(String[] args) {
		
		
		submarino submarinito1 = new submarino(random.nextBoolean(),random.nextInt(ALTO),random.nextInt(LARGO));
		submarino submarinito2 = new submarino(random.nextBoolean(),random.nextInt(ALTO),random.nextInt(LARGO)); // 	PRIMERO, Nº FILA, SEGUNDO Nº COLUMNA
		destructor terreneitor1 = new destructor(random.nextBoolean(),random.nextInt(ALTO),random.nextInt(LARGO),8);
		destructor terreneitor2 = new destructor(random.nextBoolean(),random.nextInt(ALTO),random.nextInt(LARGO),3);
		crucero crucerito = new crucero(random.nextBoolean(), random.nextInt(ALTO), random.nextInt(LARGO), 5);
		
		limpiarTablero();
		System.out.println();
		//mostrarTablero();
		
		
		colocarDestructor(terreneitor1.coordenadaX, terreneitor1.coordenadaY, terreneitor1.ID, terreneitor1.orientacion, 8);
		colocarDestructor(terreneitor2.coordenadaX, terreneitor2.coordenadaY, terreneitor2.ID, terreneitor2.orientacion, 3);
		
		colocarCrucero(crucerito.coordenadaX, crucerito.coordenadaY,crucerito.ID,crucerito.orientacion, 5);
		
		pintarSubTablero(submarinito1.coordenadaX,submarinito1.coordenadaY);
		pintarSubTablero(submarinito2.coordenadaX,submarinito2.coordenadaY);
		
		
		mostrarTablero();
		mostrarTableroVirtual();
		
		System.out.println(terreneitor1.coordenadaX+ "   "+ terreneitor1.coordenadaY+ " "+ terreneitor1.orientacion);
		System.out.println(terreneitor2.coordenadaX+ "   "+ terreneitor2.coordenadaY+" "+terreneitor2.orientacion);
		/*
		
		*/
		
	}
	
	public static void colocarCrucero(int a, int b, int id, boolean orientacion, int numero){

		if(tableroVIRTUAL[a][b]>0) {
			do {
				crucero crucerito = new crucero(random.nextBoolean(), random.nextInt(ALTO), random.nextInt(LARGO),5);
			}while(tableroVIRTUAL[a][b]>0);
		}else {
			tableroVIRTUAL[a][b]=3;
			colocarcolas(a,b,id, orientacion, numero);
			
		}
		
	}
	
	
	
	public static void colocarDestructor(int a, int b, int id, boolean orientacion, int numero){

		if(tableroVIRTUAL[a][b]>0) {
			if(numero==3) {
				do {
					destructor terreneitor2 = new destructor(random.nextBoolean(),random.nextInt(ALTO),random.nextInt(LARGO),3);
				}while(tableroVIRTUAL[a][b]>0);
			}
			else if(numero==8) {
				do {
					destructor terreneitor1 = new destructor(random.nextBoolean(),random.nextInt(ALTO),random.nextInt(LARGO),8);
				}while(tableroVIRTUAL[a][b]>0);
			}
			
		}else {
			tableroVIRTUAL[a][b]=2;
			colocarcolas(a,b,id, orientacion, numero);
			
		}
		
	}
	public static void colocarcolas(int a, int b, int id, boolean orientacion, int numero) {
		int total1=0, totak2=0;
		if(orientacion == true) { // TRUE= VERTICAL
																//por ahora solo se colocan, tengo que ponerle las excepciones para que no haya errores
			for (int i = 0; i < id; i++) { 		// ERROR POR LENGTH 
				if((a+1)>=(tableroVIRTUAL.length-1)&&id==3) {
					do {
					crucero crucerito = new crucero(random.nextBoolean(), random.nextInt(ALTO), random.nextInt(LARGO),5);
					colocarCrucero(crucerito.coordenadaX, crucerito.coordenadaY,crucerito.ID,crucerito.orientacion, 5);}
					while(tableroVIRTUAL[a][b]>0);
					
					if((a+1)>=(tableroVIRTUAL.length-1)&&id==2) {
						if(numero==3) {
							do {
								destructor terreneitor2 = new destructor(random.nextBoolean(),random.nextInt(ALTO),random.nextInt(LARGO),3);
								colocarDestructor(terreneitor2.coordenadaX, terreneitor2.coordenadaY, terreneitor2.ID, terreneitor2.orientacion,3);}
							while(tableroVIRTUAL[a][b]>0);}
						if(numero==8) {
							do {
								destructor terreneitor1= new destructor(random.nextBoolean(),random.nextInt(ALTO),random.nextInt(LARGO),8);
								colocarDestructor(terreneitor1.coordenadaX, terreneitor1.coordenadaY, terreneitor1.ID, terreneitor1.orientacion,8);}
							while(tableroVIRTUAL[a][b]>0);}
						
						}
						
				}else {
				tableroVIRTUAL[a+i][b]=id;}
			}
		}else if(orientacion==false) {
			for (int i = 0; i < id; i++) {
				if((b+1)>=(tableroVIRTUAL.length-1)&& id==3) {
					do {
					crucero crucerito = new crucero(random.nextBoolean(), random.nextInt(ALTO), random.nextInt(LARGO),5);
					colocarCrucero(crucerito.coordenadaX, crucerito.coordenadaY,crucerito.ID,crucerito.orientacion,5);}
					while(tableroVIRTUAL[a][b]>0);
				}
					if((b+1)>=(tableroVIRTUAL.length-1)&&id==2) {
						if(numero==3) {
							do {
								destructor terreneitor2 = new destructor(random.nextBoolean(),random.nextInt(ALTO),random.nextInt(LARGO),3);
								colocarDestructor(terreneitor2.coordenadaX, terreneitor2.coordenadaY, terreneitor2.ID, terreneitor2.orientacion,3);}
							while(tableroVIRTUAL[a][b]>0);}
						if(numero==8) {
							do {
								destructor terreneitor1= new destructor(random.nextBoolean(),random.nextInt(ALTO),random.nextInt(LARGO),8);
								colocarDestructor(terreneitor1.coordenadaX, terreneitor1.coordenadaY, terreneitor1.ID, terreneitor1.orientacion,8);}
							while(tableroVIRTUAL[a][b]>0);}
						}
				else {
				tableroVIRTUAL[a][b+i]=id;}
			}
		}
	}
	 public static void mostrarTableroVirtual() {
		
		 for  (int i=0; i<ALTO; i++) {
				for (int j=0; j<LARGO; j++) {
					System.out.print(tableroVIRTUAL[i][j]+ "   "  );
				}
				System.out.println();
			}
		 System.out.println();
	 }
	
	
	
	 public static void mostrarTablero() {
		 System.out.print("\t");
		 for(int i=0; i<LARGO; i++) {
			 System.out.print(arriba[i]+ "   ");
		 }
		 System.out.println();
		
		 for  (int i=0; i<ALTO; i++) {
			System.out.print( izquierda[i]+"\t");
				for (int j=0; j<LARGO; j++) {
					System.out.print(tableroJUGADOR[i][j]+ "   "  );
				}
				System.out.println();
			}
		 System.out.println();
	 }
	public static void limpiarTablero() {
		for  (int i=0; i<ALTO; i++) {
			for (int j=0; j<LARGO; j++) {
				tableroJUGADOR[i][j]= "X";
			}
		}
		System.out.println();
	}
	
	public static void limpiarTableroVirtual() {
		for  (int i=0; i<ALTO; i++) {
			for (int j=0; j<LARGO; j++) {
				tableroVIRTUAL[i][j]= 0;
			}
		}
		System.out.println();
	}

	public static void pintarSubTablero( int a, int b) {

		if(tableroVIRTUAL[a][b]>0) {
			do {
				submarino submarinito2 = new submarino(random.nextBoolean(),random.nextInt(ALTO),random.nextInt(LARGO));
			}while(tableroVIRTUAL[a][b]>0);
		}else {
			tableroVIRTUAL[a][b]=1;
		}
	}





}
