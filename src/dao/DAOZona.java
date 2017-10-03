package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import vos.Zona;

/**
 * Clase DAO que se conecta la base de datos usando JDBC para resolver los requerimientos de la aplicación
 */
public class DAOZona extends DAOBase implements CRUD<Zona>{

	// -------------------------------------------------------------
	// Constantes
	// -------------------------------------------------------------
	
	/**
	 * Constante que representa la tabla zona.
	 */
	private final static String TABLA="ZONA";
	
	// -------------------------------------------------------------
	// Métodos
	// -------------------------------------------------------------
	
	@Override
	public Zona get(long id) throws SQLException, Exception {
		Zona zona = null;
		String sql = "SELECT * FROM " +TABLA+" WHERE ID =" + id;
		ResultSet rs = executeModification(sql);
		if(rs.next()) {
			String nombre = rs.getString("NOMBRE");
			zona = new Zona(id, nombre);
		}
		return zona;
	}

	@Override
	public List<Zona> getAll() throws SQLException, Exception {
		ArrayList<Zona> data = new ArrayList<Zona>();

		String sql = "SELECT * FROM "+TABLA;

		ResultSet rs = executeModification(sql);

		while (rs.next()) {
			Long id = rs.getLong("ID");
			String nombre = rs.getString("NOMBRE");
			data.add( new Zona(id, nombre));
		}
		return data;
	}

	@Override
	public void add(Zona data) throws SQLException, Exception {
		String sql = "INSERT INTO " + TABLA +" VALUES (";
		sql += data.getId() + ",'";
		sql += data.getNombre() + "')";
		
		executeModification(sql);
	}

	@Override
	public void update(Zona data) throws SQLException, Exception {
		String sql = "UPDATE "+TABLA+" SET ";
		sql += "NOMBRE='" + data.getNombre() + "'";
		sql += " WHERE ID = " + data.getId();
		
		executeModification(sql);
	}

	@Override
	public void delete(Zona data) throws SQLException, Exception {
		String sql = "DELETE FROM " + TABLA;
		sql += " WHERE ID = " + data.getId();
		
		executeModification(sql);
	}

}
