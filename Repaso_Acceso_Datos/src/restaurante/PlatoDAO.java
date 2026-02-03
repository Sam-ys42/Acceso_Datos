package restaurante;

import java.util.List;

public interface PlatoDAO {
	
	void insertarPlato(Plato plato);
   Plato obtenerPlatoPorID(int id);
   List<Plato> listarPlatos();
   void actualizarPlato(Plato plato);
   void eliminarPlato(int id);
}
