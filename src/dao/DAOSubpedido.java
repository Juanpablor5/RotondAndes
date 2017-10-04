package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import vos.Menu;
/**
 * Clase DAO que se conecta la base de datos usando JDBC para resolver los
 * requerimientos de la aplicación
 */
public class DAOSubpedido extends DAOBase {

	// -------------------------------------------------------------
	// Constantes
	// -------------------------------------------------------------

	/**
	 * Constante que representa la tabla subpedido.
	 */
	private final static String TABLA = "SUBPEDIDO";

	/**
	 * Constante que representa la tabla menu.
	 */
	private final static String TABLA2 = "MENU";

	// -------------------------------------------------------------
	// Métodos
	// -------------------------------------------------------------

	public List<Menu> getAll(long idPedido) throws SQLException, Exception {
		ArrayList<Menu> data = new ArrayList<>();

		String sql = "SELECT B.* FROM " + TABLA + " A, " + TABLA2 + " B WHERE A.MENU_ID = B.ID ";
		sql += "AND A.PEDIDO_ID=" + idPedido;

		System.out.println(sql);
		ResultSet rs = executeModification(sql);

		while (rs.next()) {
			Long id = rs.getLong("ID");
			Integer cantidad = rs.getInt("CANTIDAD");
			Double costoProduccion = rs.getDouble("COSTODEPRODUCCION");
			Double valorAlPublico = rs.getDouble("VALORALPUBLICO");
			Long productoEntradaId = rs.getLong("ID");
			Long productoPlatoFuerteId = rs.getLong("ID");
			Long productoBebidaId = rs.getLong("ID");
			Long productoPostreId = rs.getLong("ID");
			Long productoAcompanamientoId = rs.getLong("ID");
			Long restauranteId = rs.getLong("ID");
			data.add(new Menu(id, cantidad, costoProduccion, valorAlPublico, productoEntradaId,
					productoPlatoFuerteId, productoBebidaId, productoPostreId, productoAcompanamientoId,
					restauranteId));
		}
		return data;
	}
	
	public Menu get(long idPedido, long id) throws SQLException, Exception {
		Menu ingrediente = null;
		String sql = "SELECT B.* FROM " + TABLA + " A, " + TABLA2 + " B WHERE A.MENU_ID = B.ID ";
		sql += "AND A.PEDIDO_ID=" + idPedido + " AND B.ID=" + id;

		System.out.println(sql);
		ResultSet rs = executeModification(sql);
		if (rs.next()) {
			Integer cantidad = rs.getInt("CANTIDAD");
			Double costoProduccion = rs.getDouble("COSTODEPRODUCCION");
			Double valorAlPublico = rs.getDouble("VALORALPUBLICO");
			Long productoEntradaId = rs.getLong("ID");
			Long productoPlatoFuerteId = rs.getLong("ID");
			Long productoBebidaId = rs.getLong("ID");
			Long productoPostreId = rs.getLong("ID");
			Long productoAcompanamientoId = rs.getLong("ID");
			Long restauranteId = rs.getLong("ID");
			ingrediente = new Menu(id, cantidad, costoProduccion, valorAlPublico, productoEntradaId,
					productoPlatoFuerteId, productoBebidaId, productoPostreId, productoAcompanamientoId,
					restauranteId);
		}
		return ingrediente;
	}
	
	public void add(long idPedido, long id) throws SQLException, Exception {
		String sql = "INSERT INTO " + TABLA;
		sql += " VALUES (" + idPedido + "," + id + ")";

		System.out.println(sql);
		executeModification(sql);
	}

	public void delete(long idPedido, long id) throws SQLException, Exception {
		String sql = "DELETE FROM " + TABLA;
		sql += " WHERE PEDIDO_ID=" + idPedido + " AND MENU_ID=" + id;

		System.out.println(sql);
		executeModification(sql);
	}
}
