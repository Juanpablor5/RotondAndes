package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import vos.Pedido;

public class DAOPedido extends DAOBase implements CRUD<Pedido> {

	// -------------------------------------------------------------
	// Constantes
	// -------------------------------------------------------------

	/**
	 * Constante que representa la tabla pedido.
	 */
	private final static String TABLA = "PEDIDO";

	// -------------------------------------------------------------
	// Métodos
	// -------------------------------------------------------------

	@Override
	public Pedido get(long id) throws SQLException, Exception {
		Pedido preferencias = null;
		String sql = "SELECT * FROM " + TABLA + " WHERE ID =" + id;
		ResultSet rs = executeModification(sql);
		if (rs.next()) {
			Date fecha = rs.getDate("FECHA");
			preferencias = new Pedido(id, fecha);
		}
		return preferencias;
	}

	@Override
	public List<Pedido> getAll() throws SQLException, Exception {
		ArrayList<Pedido> data = new ArrayList<Pedido>();

		String sql = "SELECT * FROM " + TABLA;

		ResultSet rs = executeModification(sql);

		while (rs.next()) {
			Long id = rs.getLong("ID");
			Date fecha = rs.getDate("FECHA");
			data.add(new Pedido(id, fecha));
		}
		return data;
	}

	@Override
	public void add(Pedido data) throws SQLException, Exception {
		String sql = "INSERT INTO " + TABLA +" VALUES (";
		sql += data.getId() + ",'";
		sql += data.getFecha() + "')";
		
		executeModification(sql);
	}

	@Override
	public void update(Pedido data) throws SQLException, Exception {
		String sql = "UPDATE "+TABLA+" SET ";
		sql += "FECHA='" + data.getFecha();
		sql += " WHERE ID = " + data.getId();
		
		executeModification(sql);
	}

	@Override
	public void delete(Pedido data) throws SQLException, Exception {
		String sql = "DELETE FROM " + TABLA;
		sql += " WHERE ID = " + data.getId();
		
		executeModification(sql);
	}

}
