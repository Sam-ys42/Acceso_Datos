package EJ_5_al_10;

public class Vehiculo {

	protected String matrícula;
	protected String marca;
	protected Double PrecioCompra;
	
	public Vehiculo(String matrícula, String marca, Double precioCompra) {
		super();
		this.matrícula = matrícula;
		this.marca = marca;
		PrecioCompra = precioCompra;
	}

	



	public Vehiculo() {
		// TODO Auto-generated constructor stub
	}





	public String getMarca() {
		return marca;
	}
	public String getMatrícula() {
		return matrícula;
	}
	public Double getPrecioCompra() {
		return PrecioCompra;
	}
	public void setMarca(String marca) {
		this.marca = marca;
	}
	public void setMatrícula(String matrícula) {
		this.matrícula = matrícula;
	}
public void setPrecioCompra(Double precioCompra) {
	PrecioCompra = precioCompra;
}

@Override
public String toString() {
	return "Vehiculo [matrícula=" + matrícula + ", marca=" + marca + ", PrecioCompra=" + PrecioCompra +", Precio Público= "+pvp(2)+ "]";
}





public Double pvp(int beneficio) {
	return PrecioCompra+ ((PrecioCompra*beneficio)/100);
}
}
