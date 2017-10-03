package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import vos.Menu;

/**
 * Clase DAO que se conecta la base de datos usando JDBC para resolver los requerimientos de la aplicación
 */
public class DAOMenu extends DAOBase implements CRUD<Menu>{
	
	// -------------------------------------------------------------
	// Constantes
	// -------------------------------------------------------------
	
	/**
	 * Constante que representa la tabla menu.
	 */
	private final static String TABLA="MENU";

	// -------------------------------------------------------------
	// Métodos
	// -------------------------------------------------------------

	@Override
	public Menu get(long id) throws SQLException, Exception {
		Menu menu = null;
		String sql = "SELECT * FROM " +TABLA+" WHERE ID =" + id;
		ResultSet rs = executeModification(sql);
		if(rs.next()) {
			Integer cantidad = rs.getInt("CANTIDAD");
			Double costoProduccion = rs.getDouble("COSTODEPRODUCION");
			Double valorPublico = rs.getDouble("VALORALPUBLICO");
			menu = new Menu(id, cantidad, costoProduccion, valorPublico);
		}
		return menu;
	}

	@Override
	public List<Menu> getAll() throws SQLException, Exception {
		ArrayList<Menu> data = new ArrayList<Menu>();

		String sql = "SELECT * FROM "+TABLA;

		ResultSet rs = executeModification(sql);

		while (rs.next()) {
			Long id = rs.getLong("ID");
			Integer cantidad = rs.getInt("CANTIDAD");
			Double costoProduccion = rs.getDouble("COSTODEPRODUCION");
			Double valorPublico = rs.getDouble("VALORALPUBLICO");
			data.add( new Menu(id, cantidad, costoProduccion, valorPublico));
		}
		return data;
	}

	@Override
	public void add(Menu data) throws SQLException, Exception {
		String sql = "INSERT INTO " + TABLA +" VALUES (";
		sql += data.getId() + ",'";
		sql += data.getCantidad() + ",";
		sql += data.getCostoProduccion() + ",";
		sql += data.getValorAlPublico() + ")";
		
		executeModification(sql);
	}

	@Override
	public void update(Menu data) throws SQLException, Exception {
		String sql = "UPDATE "+TABLA+" SET ";
		sql += "CANTIDAD=" + data.getCantidad() + ",";
		sql += "COSTODEPRODUCION=" + data.getCostoProduccion()+",";
		sql += "VALORALPUBLICO=" + data.getValorAlPublico();
		sql += " WHERE ID = " + data.getId();
		
		executeModification(sql);
	}

	@Override
	public void delete(Menu data) throws SQLException, Exception {
		String sql = "DELETE FROM " + TABLA;
		sql += " WHERE ID = " + data.getId();
		
		executeModification(sql);
	}

}
