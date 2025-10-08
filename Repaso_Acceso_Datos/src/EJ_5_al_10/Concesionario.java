package EJ_5_al_10;

public class Concesionario{

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Vehiculo coche1 = new Vehiculo("ERI 456", "Renault", 23000.56);
		Vehiculo moto1 = new Vehiculo();
		 moto1.setMarca("Yamaha");
		 moto1.setMatrícula("RUT 456");
		 moto1.setPrecioCompra(45600.73);
		
		 System.out.println(moto1.toString());
		 System.out.println(coche1.toString());

	}

}
