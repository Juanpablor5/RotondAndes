package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import vos.Categoria;

/**
 * Clase DAO que se conecta la base de datos usando JDBC para resolver los requerimientos de la aplicación
 */
public class DAOCategoria extends DAOBase implements CRUD<Categoria>{

	// -------------------------------------------------------------
	// Constantes
	// -------------------------------------------------------------
	
	/**
	 * Constante que representa la tabla categoría.
	 */
	private final static String TABLA="CATEGORIA";
	
	// -------------------------------------------------------------
	// Métodos
	// -------------------------------------------------------------

	@Override
	public Categoria get(long id) throws SQLException, Exception {
		Categoria categoria = null;
		String sql = "SELECT * FROM " +TABLA+" WHERE ID =" + id;
		ResultSet rs = executeModification(sql);
		if(rs.next()) {
			String nombre = rs.getString("NOMBRE");
			categoria = new Categoria(id, nombre);
		}
		return categoria;
	}

	@Override
	public List<Categoria> getAll() throws SQLException, Exception {
		ArrayList<Categoria> data = new ArrayList<Categoria>();

		String sql = "SELECT * FROM "+TABLA;

		ResultSet rs = executeModification(sql);

		while (rs.next()) {
			Long id = rs.getLong("ID");
			String nombre = rs.getString("NOMBRE");
			data.add( new Categoria(id, nombre));
		}
		return data;
	}

	@Override
	public void add(Categoria data) throws SQLException, Exception {
		String sql = "INSERT INTO " + TABLA +" VALUES (";
		sql += data.getId() + ",'";
		sql += data.getNombre() + "')";
		
		executeModification(sql);
	}

	@Override
	public void update(Categoria data) throws SQLException, Exception {
		String sql = "UPDATE "+TABLA+" SET ";
		sql += "NOMBRE='" + data.getNombre()+"'";
		sql += " WHERE ID = " + data.getId();
		
		executeModification(sql);
	}

	@Override
	public void delete(Categoria data) throws SQLException, Exception {
		String sql = "DELETE FROM " + TABLA;
		sql += " WHERE ID = " + data.getId();
		
		executeModification(sql);
	}	
}
