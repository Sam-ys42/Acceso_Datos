/*identificador, descripción, material, color, precio y cantidad en stock. Defina una clase que permita modelar dicha información. 
  Además, esta clase tendrá un método que permita mostrar por pantalla los datos de la camiseta. Crear una clase 
  ProgramaCamiseta con un método main que utilice la clase creada.*/

package UNIT6;

public class ProgramaCamiseta {

public class Camiseta{
		private  int ID;
		private  String descripcion;
		private  String material;
		private  String color;
		private  double precio;
		private  int stock;
		
		public Camiseta() {
			ID=0;
			descripcion= "Sin descripción disponible";
			material= "Desconocido";
			color="Sin resultado";
			precio= 0.0;
			stock=0;
		}
		
		// COnstructo rcon valores dados
		public   Camiseta(int id, String desc, String  ma, String c, double p, int s) {
			ID=id;
			descripcion= desc;
			material= ma;
			color=c;
			precio= p;
			stock=s;
		}
	
	public int getID() {
		return ID;
	}
	public String getdescripcion() {
		return descripcion;
	}
}
	
	public static void main(String[] args) {
		
	}

}
