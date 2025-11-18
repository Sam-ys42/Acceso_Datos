package ejercicioFinal_NavaVinted;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="productos")
public class Productos implements Serializable {
	
	protected List<Producto> productos = new ArrayList<>();

	public Productos(List<Producto> productos) {
		super();
		this.productos = productos;
	}

	public Productos() {
		super();
	}

	
	@XmlElement(name="producto")
	public List<Producto> getProductos() {
		return productos;
	}

	public void setProductos(List<Producto> productos) {
		this.productos = productos;
	}

	@Override
	public String toString() {
		return "Productos [productos=" + productos + "]";
	}
	
	public void mostrarProductos() {
		
		for (Producto p : productos) {
			System.out.println(p);
		}
	}
	
	public void annadirProducto(Producto p) {
		
		productos.add(p);
	}

}
