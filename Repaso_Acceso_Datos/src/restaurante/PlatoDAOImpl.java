package restaurante;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.List;

public class PlatoDAOImpl implements PlatoDAO{
public static String sql = null;

  String bbdd ;


	public PlatoDAOImpl(String bbdd) {
	super();
	this.bbdd = bbdd;
}

	@Override
	public void insertarPlato(Plato plato) {
		// TODO Auto-generated method stub
		sql = "INSERT INTO plato (nombre, precio, categoria) VALUES (?,?,?)";
		
		try(Connection con = ConexionBD.getConnection(bbdd)) {
			PreparedStatement ps = con.prepareStatement(sql);
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
	}

	@Override
	public Plato obtenerPlatoPorID(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Plato> listarPlatos() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void actualizarPlato(Plato plato) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void eliminarPlato(int id) {
		// TODO Auto-generated method stub
		sql = "DELETE FROM plato WHERE id_plato = ?";
		
		try (Connection con = ConexionBD.getConnection(bbdd)){
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, id);
			ps.executeUpdate();
				
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
	}

}
