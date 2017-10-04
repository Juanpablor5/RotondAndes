package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import vos.Restaurante;

/**
 * Clase DAO que se conecta la base de datos usando JDBC para resolver los requerimientos de la aplicación
 */
public class DAORestaurante extends DAOBase implements CRUD<Restaurante>{
	
	// -------------------------------------------------------------
	// Constantes
	// -------------------------------------------------------------
	
	/**
	 * Constante que representa la tabla restaurante.
	 */
	private final static String TABLA="RESTAURANTE";
	
	// -------------------------------------------------------------
	// Métodos
	// -------------------------------------------------------------

	@Override
	public Restaurante get(long id) throws SQLException, Exception {
		Restaurante restaurante = null;
		String sql = "SELECT * FROM " +TABLA+" WHERE ID =" + id;
		ResultSet rs = executeModification(sql);
		if(rs.next()) {
			String nombre = rs.getString("NOMBRE");
			String paginaweb = rs.getString("PAGINAWEB");
			Integer tipoComida= rs.getInt("TIPOCOMIDA_ID");
			Integer registroId= rs.getInt("REGISTRO_ID");
			Integer zona= rs.getInt("ZONA_ID");
			restaurante = new Restaurante(id, nombre, paginaweb, tipoComida, registroId, zona);
		}
		return restaurante;
	}

	@Override
	public List<Restaurante> getAll() throws SQLException, Exception {
		ArrayList<Restaurante> data = new ArrayList<Restaurante>();

		String sql = "SELECT * FROM "+TABLA;

		ResultSet rs = executeModification(sql);

		while (rs.next()) {
			Long id = rs.getLong("ID");
			String nombre = rs.getString("NOMBRE");
			String paginaweb = rs.getString("PAGINAWEB");
			Integer tipoComida= rs.getInt("TIPOCOMIDA_ID");
			Integer registroId= rs.getInt("REGISTRO_ID");
			Integer zona= rs.getInt("ZONA_ID");
			data.add( new Restaurante(id, nombre, paginaweb, tipoComida, registroId, zona));
		}
		return data;
	}

	@Override
	public void add(Restaurante data) throws SQLException, Exception {
		String sql = "INSERT INTO " + TABLA +" VALUES (";
		
		sql += data.getId() + ",'";
		sql += data.getNombre() + "','";
		sql += data.getPaginaWeb() + "',";
		sql += data.getTipoComidaId() + ",";
		sql += data.getRegristroId() + ",";
		sql += data.getZonaId() + ")";
		
		executeModification(sql);
	}

	@Override
	public void update(Restaurante data) throws SQLException, Exception {
		String sql = "UPDATE "+TABLA+" SET ";
		
		sql += "NOMBRE='" + data.getNombre() + "',";
		sql += "PAGINAWEB='" + data.getPaginaWeb()+"',";
		sql += "TIPOCOMIDA_ID=" + data.getTipoComidaId()+",";
		sql += "REGISTRO_ID=" + data.getRegristroId()+",";
		sql += "ZONA_ID=" + data.getZonaId();
		sql += " WHERE ID = " + data.getId();
		
		executeModification(sql);
	}

	@Override
	public void delete(Restaurante data) throws SQLException, Exception {
		String sql = "DELETE FROM " + TABLA;
		sql += " WHERE ID = " + data.getId();
		
		executeModification(sql);
	}

}
