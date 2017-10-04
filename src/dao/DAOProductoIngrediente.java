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
public class DAOProductoIngrediente extends DAOBase{
	
	// -------------------------------------------------------------
	// Constantes
	// -------------------------------------------------------------

	/**
	 * Constante que representa la tabla producto-ingrediente.
	 */
	private final static String TABLA = "PRODUCTOINGREDIENTE";
	
	/**
	 * Constante que representa la tabla ingrediente.
	 */
	private final static String TABLA2 = "INGREDIENTE";
	
	// -------------------------------------------------------------
	// Métodos
	// -------------------------------------------------------------

	public List<Ingrediente> getAll(long idProducto) throws SQLException, Exception {
		ArrayList<Ingrediente> data = new ArrayList<>();

		String sql = "SELECT B.* FROM " + TABLA + " A, " + TABLA2 + " B WHERE A.INGREDIENTE_ID = B.ID ";
		sql += "AND A.PRODUCTO_ID=" + idProducto;

		System.out.println(sql);
		ResultSet rs = executeModification(sql);

		while (rs.next()) {
			Long id = rs.getLong("ID");
			String nombre = rs.getString("NOMBRE");
			String descripcion = rs.getString("DESCRIPCION");
			String traduccionDesc = rs.getString("TRADUCCION");
			data.add(new Ingrediente(id, nombre, descripcion, traduccionDesc));
		}
		return data;
	}

	public Ingrediente get(long idProducto, long id) throws SQLException, Exception {
		Ingrediente ingrediente = null;
		String sql = "SELECT B.* FROM " + TABLA + " A, " + TABLA2 + " B WHERE A.INGREDIENTE_ID = B.ID ";
		sql += "AND A.PRODUCTO_ID=" + idProducto + " AND B.ID=" + id;

		System.out.println(sql);
		ResultSet rs = executeModification(sql);
		if (rs.next()) {
			String nombre = rs.getString("NOMBRE");
			String descripcion = rs.getString("DESCRIPCION");
			String traduccionDesc = rs.getString("TRADUCCION");
			ingrediente = new Ingrediente(id, nombre, descripcion, traduccionDesc);
		}
		return ingrediente;
	}

	public void add(long idProducto, long id) throws SQLException, Exception {
		String sql = "INSERT INTO " + TABLA;
		sql += " VALUES (" + idProducto + "," + id + ")";

		System.out.println(sql);
		executeModification(sql);
	}

	public void delete(long idProducto, long id) throws SQLException, Exception {
		String sql = "DELETE FROM " + TABLA;
		sql += " WHERE PRODUCTO_ID=" + idProducto + " AND INGREDIENTE_ID=" + id;

		System.out.println(sql);
		executeModification(sql);
	}
}
