package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import vos.Representante;

/**
 * Clase DAO que se conecta la base de datos usando JDBC para resolver los
 * requerimientos de la aplicación
 */
public class DAORepresentante extends DAOBase implements CRUD<Representante> {

	// -------------------------------------------------------------
	// Constantes
	// -------------------------------------------------------------

	/**
	 * Constante que representa la tabla representante.
	 */
	private final static String TABLA = "REPRESENTANTE";

	// -------------------------------------------------------------
	// Métodos
	// -------------------------------------------------------------

	@Override
	public Representante get(long id) throws SQLException, Exception {
		Representante representante = null;
		String sql = "SELECT * FROM " + TABLA + " WHERE ID =" + id;
		ResultSet rs = executeModification(sql);
		if (rs.next()) {
			String nombre = rs.getString("NOMBRE");
			Integer telefono = rs.getInt("TELEFONO");
			String correo = rs.getString("CORREO");
			Long restauranteid=rs.getLong("RESTAURANTE_ID");
			representante = new Representante(id, nombre, telefono, correo,restauranteid);
		}
		return representante;
	}

	@Override
	public List<Representante> getAll() throws SQLException, Exception {
		ArrayList<Representante> data = new ArrayList<Representante>();

		String sql = "SELECT * FROM " + TABLA;

		ResultSet rs = executeModification(sql);

		while (rs.next()) {
			Long id = rs.getLong("ID");
			String nombre = rs.getString("NOMBRE");
			Integer telefono = rs.getInt("TELEFONO");
			String correo = rs.getString("CORREO");
			Long restauranteid=rs.getLong("RESTAURANTE_ID");
			data.add(new Representante(id, nombre, telefono, correo,restauranteid));
		}
		return data;
	}

	@Override
	public void add(Representante data) throws SQLException, Exception {
		String sql = "INSERT INTO " + TABLA + " VALUES (";
		sql += data.getId() + ",'";
		sql += data.getNombre() + "',";
		sql += data.getTelefono() + ",'";
		sql += data.getCorreo() + "',";
		sql += data.getRestauranteId() + ")";

		executeModification(sql);
	}

	@Override
	public void update(Representante data) throws SQLException, Exception {
		String sql = "UPDATE " + TABLA + " SET ";
		sql += "NOMBRE='" + data.getNombre() + "',";
		sql += "TELEFONO='" + data.getTelefono() + "',";
		sql += "CORREO='" + data.getCorreo()+"',";
		sql += "RESTAURANTE_ID="+ data.getRestauranteId();
		sql += " WHERE ID = " + data.getId();

		executeModification(sql);
	}

	@Override
	public void delete(Representante data) throws SQLException, Exception {
		String sql = "DELETE FROM " + TABLA;
		sql += " WHERE ID = " + data.getId();

		executeModification(sql);
	}
}
