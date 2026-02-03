package restaurante;

import java.util.List;

public interface OrdenDAO {
	
	void insertarOrden(Orden orden);
	Orden obtenerOrdenPorID(int id);
	List<Orden> listarOrdenes();
	void actualizarOrden(Orden orden);
	void eliminarOrden(int id);

}
