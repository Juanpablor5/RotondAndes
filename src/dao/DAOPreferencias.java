package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import vos.Preferencias;

/**
 * Clase DAO que se conecta la base de datos usando JDBC para resolver los requerimientos de la aplicación
 */
public class DAOPreferencias extends DAOBase implements CRUD<Preferencias>{
	
	// -------------------------------------------------------------
	// Constantes
	// -------------------------------------------------------------
	
	/**
	 * Constante que representa la tabla preferencias.
	 */
	private final static String TABLA="PREFERENCIAS";

	// -------------------------------------------------------------
	// Métodos
	// -------------------------------------------------------------
	
	@Override
	public Preferencias get(long id) throws SQLException, Exception {
		Preferencias preferencias = null;
		String sql = "SELECT * FROM " +TABLA+" WHERE ID =" + id;
		ResultSet rs = executeModification(sql);
		if(rs.next()) {
			Double precioMenor = rs.getDouble("PRECIOMENOR");
			Double precioMayor = rs.getDouble("PRECIOMAYOR");
			preferencias = new Preferencias(id, precioMenor, precioMayor);
		}
		return preferencias;
	}

	@Override
	public List<Preferencias> getAll() throws SQLException, Exception {
		ArrayList<Preferencias> data = new ArrayList<Preferencias>();

		String sql = "SELECT * FROM "+TABLA;

		ResultSet rs = executeModification(sql);

		while (rs.next()) {
			Long id = rs.getLong("ID");
			Double precioMenor = rs.getDouble("PRECIOMENOR");
			Double precioMayor = rs.getDouble("PRECIOMAYOR");
			data.add( new Preferencias(id, precioMenor, precioMayor));
		}
		return data;
	}

	@Override
	public void add(Preferencias data) throws SQLException, Exception {
		String sql = "INSERT INTO " + TABLA +" VALUES (";
		sql += data.getId() + ",";
		sql += data.getPrecioMenor() + ",";
		sql += data.getPrecioMayor() + ")";
		
		executeModification(sql);
	}

	@Override
	public void update(Preferencias data) throws SQLException, Exception {
		String sql = "UPDATE "+TABLA+" SET ";
		sql += "PRECIOMENOR=" + data.getPrecioMenor() + ",";
		sql += "PRECIOMAYOR=" + data.getPrecioMayor();
		sql += " WHERE ID = " + data.getId();
		
		executeModification(sql);
	}

	@Override
	public void delete(Preferencias data) throws SQLException, Exception {
		String sql = "DELETE FROM " + TABLA;
		sql += " WHERE ID = " + data.getId();
		
		executeModification(sql);
	}
}
