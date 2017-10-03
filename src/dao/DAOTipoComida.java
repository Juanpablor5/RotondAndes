package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import vos.TipoComida;

/**
 * Clase DAO que se conecta la base de datos usando JDBC para resolver los requerimientos de la aplicación
 */
public class DAOTipoComida extends DAOBase implements CRUD<TipoComida>{

	// -------------------------------------------------------------
	// Constantes
	// -------------------------------------------------------------
	
	/**
	 * Constante que representa la tabla tipo comida.
	 */
	private final static String TABLA="TIPOCOMIDA";
	
	// -------------------------------------------------------------
	// Métodos
	// -------------------------------------------------------------

	@Override
	public TipoComida get(long id) throws SQLException, Exception {
		TipoComida tipoComida = null;
		String sql = "SELECT * FROM " +TABLA+" WHERE ID =" + id;
		ResultSet rs = executeModification(sql);
		if(rs.next()) {
			String nombre = rs.getString("NOMBRE");
			tipoComida = new TipoComida(id, nombre);
		}
		return tipoComida;
	}

	@Override
	public List<TipoComida> getAll() throws SQLException, Exception {
		ArrayList<TipoComida> data = new ArrayList<TipoComida>();

		String sql = "SELECT * FROM "+TABLA;

		ResultSet rs = executeModification(sql);

		while (rs.next()) {
			Long id = rs.getLong("ID");
			String nombre = rs.getString("NOMBRE");
			data.add( new TipoComida(id, nombre));
		}
		return data;
	}

	@Override
	public void add(TipoComida data) throws SQLException, Exception {
		String sql = "INSERT INTO " + TABLA +" VALUES (";
		sql += data.getId() + ",'";
		sql += data.getNombre() + "')";
		
		executeModification(sql);
	}

	@Override
	public void update(TipoComida data) throws SQLException, Exception {
		String sql = "UPDATE "+TABLA+" SET ";
		sql += "NOMBRE='" + data.getNombre() + "'";
		sql += " WHERE ID = " + data.getId();
		
		executeModification(sql);
	}

	@Override
	public void delete(TipoComida data) throws SQLException, Exception {
		String sql = "DELETE FROM " + TABLA;
		sql += " WHERE ID = " + data.getId();
		
		executeModification(sql);
	}
}
