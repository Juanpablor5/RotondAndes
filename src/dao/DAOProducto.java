package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import vos.Producto;

/**
 * Clase DAO que se conecta la base de datos usando JDBC para resolver los
 * requerimientos de la aplicación
 */
public class DAOProducto extends DAOBase implements CRUD<Producto> {

	// -------------------------------------------------------------
	// Constantes
	// -------------------------------------------------------------

	/**
	 * Constante que representa la tabla producto.
	 */
	private final static String TABLA = "PRODUCTO";

	// -------------------------------------------------------------
	// Métodos
	// -------------------------------------------------------------

	@Override
	public Producto get(long id) throws SQLException, Exception {
		Producto producto = null;
		String sql = "SELECT * FROM " + TABLA + " WHERE ID =" + id;
		ResultSet rs = executeModification(sql);
		if (rs.next()) {
			String nombre = rs.getString("NOMBRE");
			String descripcion = rs.getString("DESCRIPCION");
			String traduccionDesc = rs.getString("TRADUCCION");
			Integer tiempoPreparacion = rs.getInt("TIEMPOPREPARACION");
			Long categoria = rs.getLong("CATEGORIA_ID");
			producto = new Producto(id, nombre, descripcion, traduccionDesc, tiempoPreparacion,categoria);
		}
		return producto;
	}

	@Override
	public List<Producto> getAll() throws SQLException, Exception {
		ArrayList<Producto> data = new ArrayList<Producto>();

		String sql = "SELECT * FROM " + TABLA;

		ResultSet rs = executeModification(sql);

		while (rs.next()) {
			Long id = rs.getLong("ID");
			String nombre = rs.getString("NOMBRE");
			String descripcion = rs.getString("DESCRIPCION");
			String traduccionDesc = rs.getString("TRADUCCION");
			Integer tiempoPreparacion = rs.getInt("TIEMPOPREPARACION");
			Long categoria = rs.getLong("CATEGORIA_ID");
			data.add(new Producto(id, nombre, descripcion, traduccionDesc, tiempoPreparacion,categoria));
		}
		return data;
	}

	@Override
	public void add(Producto data) throws SQLException, Exception {
		String sql = "INSERT INTO " + TABLA + " VALUES (";
		sql += data.getId() + ",'";
		sql += data.getNombre() + "','";
		sql += data.getDescripcion() + "','";
		sql += data.getTraduccion() + "',";
		sql += data.getTiempoPreparacion() + ",";
		sql += data.getIdCategoria() +")";
		
		executeModification(sql);
	}

	@Override
	public void update(Producto data) throws SQLException, Exception {
		String sql = "UPDATE " + TABLA + " SET ";
		sql += "NOMBRE='" + data.getNombre() + "',";
		sql += "DESCRIPCION='" + data.getDescripcion() + "',";
		sql += "TRADUCCION='" + data.getTraduccion() + "',";
		sql += "TIEMPOPREPARACION=" + data.getTiempoPreparacion()+",";
		sql += "CATEGORIA_ID"+data.getIdCategoria();
		sql += " WHERE ID = " + data.getId();

		executeModification(sql);
	}

	@Override
	public void delete(Producto data) throws SQLException, Exception {
		String sql = "DELETE FROM " + TABLA;
		sql += " WHERE ID = " + data.getId();

		executeModification(sql);
	}
}
