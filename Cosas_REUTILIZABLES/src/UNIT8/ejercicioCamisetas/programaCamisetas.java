/*Crea una clase Camiseta para la compañía Camisetas Augusta. Los campos incluyen un número de pedido, tamaño, 
 * color y precio. Cree métodos establecidos para el número de pedido, el tamaño y el color y obtenga métodos para los cuatro campos.
 *  El precio está determinado por el tamaño: 22.99€ para XXL o XXXL, y  9.99€ para todos los demás tamaños. Cree una subclase llamada 
 *  Personalizada que descienda de Camiseta e incluya un campo para contener el eslogan solicitado para la camisa e incluya métodos
 *   get y set en este campo. Escriba una aplicación que cree dos objetos de cada clase y demuestre que todos los métodos funcionan 
 *   correctamente. Guarde los archivos como Camiseta.java, Personalizada.java y ProgramaCamisetas.java*/

package UNIT8.ejercicioCamisetas;

public class programaCamisetas {

	public static void main(String[] args) {
		Camiseta cam1 = new Camiseta();
		Camiseta cam2 = new Camiseta();
		 int i =0;
		cam1.setColor("azul");
		cam1.setNumeroPedido(1);
		cam1.setTamaño("XXL");
		
		cam2.setColor("rojo");
		cam2.setNumeroPedido(2);
		cam2.setTamaño("S");
		
		System.out.println(cam1.toString() + "\n"+  cam2.toString());
		
		Personalizadas cam3 = new Personalizadas();
		Personalizadas cam4 = new Personalizadas();
		
		cam3.setColor("amarillo");
		cam3.setNumeroPedido(3);
		cam3.setTamaño("M");
		cam3.setSlogan("Pepi");
		
		cam4.setColor("verde");
		cam4.setNumeroPedido(4);
		cam4.setTamaño("xxxl");
		cam4.setSlogan("pony salvaje");
		System.out.println();
		System.out.println(cam3.toString() + "\n"+  cam4.toString());
		
	}

}
