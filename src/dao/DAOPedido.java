package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
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
			String fechaHora = rs.getString("FECHAHORA");
			Integer cedulaCliente = rs.getInt("CLIENTE_ID");
			preferencias = new Pedido(id, fechaHora, cedulaCliente);
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
			String fechaHora = rs.getString("FECHAHORA");
			Integer cedulaCliente = rs.getInt("CLIENTE_ID");
			data.add(new Pedido(id, fechaHora, cedulaCliente));
		}
		return data;
	}

	@Override
	public void add(Pedido data) throws SQLException, Exception {
		String sql = "INSERT INTO " + TABLA +" VALUES (";
		sql += data.getId() + ",'";
		sql += data.getFechahora() + "',";
		sql += data.getClienteCedula() + ")";
		
		executeModification(sql);
	}

	@Override
	public void update(Pedido data) throws SQLException, Exception {
		String sql = "UPDATE "+TABLA+" SET ";
		sql += "FECHA='" + data.getFechahora() + ",";
		sql += "CLIENTE_ID=" + data.getClienteCedula();
		sql += " WHERE ID " + data.getId();
		
		executeModification(sql);
	}

	@Override
	public void delete(Pedido data) throws SQLException, Exception {
		String sql = "DELETE FROM " + TABLA;
		sql += " WHERE ID = " + data.getId();
		
		executeModification(sql);
	}

}
