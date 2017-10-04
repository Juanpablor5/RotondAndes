package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import vos.Ingrediente;

/**
 * Clase DAO que se conecta la base de datos usando JDBC para resolver los
 * requerimientos de la aplicación
 */
public class DAOIngrediente extends DAOBase implements CRUD<Ingrediente> {

	// -------------------------------------------------------------
	// Constantes
	// -------------------------------------------------------------

	/**
	 * Constante que representa la tabla ingrediente.
	 */
	private final static String TABLA = "INGREDIENTE";

	// -------------------------------------------------------------
	// Métodos
	// -------------------------------------------------------------

	@Override
	public Ingrediente get(long id) throws SQLException, Exception {
		Ingrediente ingrediente = null;
		String sql = "SELECT * FROM " + TABLA + " WHERE ID =" + id;
		ResultSet rs = executeModification(sql);
		if (rs.next()) {
			String nombre = rs.getString("NOMBRE");
			String descripcion = rs.getString("DESCRIPCION");
			String traduccionDesc = rs.getString("TRADUCCION");
			ingrediente = new Ingrediente(id, nombre, descripcion, traduccionDesc);
		}
		return ingrediente;
	}

	@Override
	public List<Ingrediente> getAll() throws SQLException, Exception {
		ArrayList<Ingrediente> data = new ArrayList<Ingrediente>();

		String sql = "SELECT * FROM "+TABLA;

		ResultSet rs = executeModification(sql);

		while (rs.next()) {
			Long id = rs.getLong("ID");
			String nombre = rs.getString("NOMBRE");
			String descripcion = rs.getString("DESCRIPCION");
			String traduccionDesc = rs.getString("TRADUCCION");
			data.add( new Ingrediente(id, nombre, descripcion, traduccionDesc));
		}
		return data;
	}

	@Override
	public void add(Ingrediente data) throws SQLException, Exception {
		String sql = "INSERT INTO " + TABLA +" VALUES (";
		sql += data.getId() + ",'";
		sql += data.getNombre() + "','";
		sql += data.getDescripcion() + "','";
		sql += data.getTraduccion() + "')";
		executeModification(sql);
	}

	@Override
	public void update(Ingrediente data) throws SQLException, Exception {
		String sql = "UPDATE "+TABLA+" SET ";
		sql += "NOMBRE='" + data.getNombre() + "',";
		sql += "DESCRIPCION='" + data.getDescripcion()+"',";
		sql += "TRADUCCION='" + data.getTraduccion() + "'";
		sql += " WHERE ID = " + data.getId();
		
		executeModification(sql);
	}

	@Override
	public void delete(Ingrediente data) throws SQLException, Exception {
		String sql = "DELETE FROM " + TABLA;
		sql += " WHERE ID = " + data.getId();
		
		executeModification(sql);
	}

}
