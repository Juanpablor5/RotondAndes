package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import vos.Menu;

public class DAOReservaMenu extends DAOBase {
	private final static String TABLA = "MENURESERVA";
	private final static String TABLA2 = "MENU";

	public List<Menu> getAll(long idReserva) throws SQLException, Exception {
		ArrayList<Menu> data = new ArrayList<Menu>();

		String sql = "SELECT B.* FROM " + TABLA + " A, " + TABLA2 + " B WHERE A.MENU_ID = B.ID ";
		sql += "AND A.RESERVA_ID=" + idReserva;

		System.out.println(sql);
		ResultSet rs = executeModification(sql);

		while (rs.next()) {
			Long id = rs.getLong("ID");
			Integer cantidad = rs.getInt("CANTIDAD");
			Double costoProduccion = rs.getDouble("COSTODEPRODUCION");
			Double valorPublico = rs.getDouble("VALORALPUBLICO");
			Long entrada=rs.getLong("PRODUCTOENTRADA_ID");
			Long fuerte=rs.getLong("PRODUCTOPLATOFUERTE_ID");
			Long bebida=rs.getLong("PRODUCTOBEBIDA_ID");
			Long postre=rs.getLong("PRODUCTOPOSTRE_ID");
			Long acompanamiento=rs.getLong("PRODUCTOACOMPANAMIENTO_ID");
			Long restaurante=rs.getLong("RESTAURANTE_ID");
			data.add(new Menu(id, cantidad, costoProduccion, valorPublico, entrada, fuerte, bebida, postre, acompanamiento, restaurante));
		}
		return data;
	}

	public Menu get(long idReserva, long id) throws SQLException, Exception {
		Menu menu = null;
		String sql = "SELECT B.* FROM " + TABLA + " A, " + TABLA2 + " B WHERE A.MENU_ID = B.ID ";
		sql += "AND A.RESERVA_ID=" + idReserva + " AND B.ID=" + id;

		System.out.println(sql);
		ResultSet rs = executeModification(sql);
		if (rs.next()) {
			Integer cantidad = rs.getInt("CANTIDAD");
			Double costoProduccion = rs.getDouble("COSTODEPRODUCION");
			Double valorPublico = rs.getDouble("VALORALPUBLICO");
			Long entrada=rs.getLong("PRODUCTOENTRADA_ID");
			Long fuerte=rs.getLong("PRODUCTOPLATOFUERTE_ID");
			Long bebida=rs.getLong("PRODUCTOBEBIDA_ID");
			Long postre=rs.getLong("PRODUCTOPOSTRE_ID");
			Long acompanamiento=rs.getLong("PRODUCTOACOMPANAMIENTO_ID");
			Long restaurante=rs.getLong("RESTAURANTE_ID");
			menu = new Menu(id, cantidad, costoProduccion, valorPublico, entrada, fuerte, bebida, postre, acompanamiento, restaurante);
		}
		return menu;
	}

	public void add(long idReserva, long id) throws SQLException, Exception {
		String sql = "INSERT INTO " + TABLA;
		sql += " VALUES (" + id + "," + idReserva + ")";

		System.out.println(sql);
		executeModification(sql);
	}

	public void delete(long idReserva, long id) throws SQLException, Exception {
		String sql = "DELETE FROM " + TABLA;
		sql += " WHERE MENU_ID=" + id + " AND RESERVA_ID=" + idReserva;

		System.out.println(sql);
		executeModification(sql);
	}
}
