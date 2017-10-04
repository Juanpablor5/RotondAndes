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

	public Long IdRestaurante(Long IDRegistro) {
		String sql="SELECT ID FROM RESTAURANTE,REGISTRO WHERE REGISTRO.CODIGO=RESTAURANTE.REGISTRO_ID AND REGISTRO.CODIGO="+IDRegistro;
		
		
		return IDRegistro;
		
	}
	
	@Override
	public Menu get(long id) throws SQLException, Exception {
		Menu menu = null;
		String sql = "SELECT * FROM " +TABLA+" WHERE ID =" + id;
		ResultSet rs = executeModification(sql);
		if(rs.next()) {
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

	@Override
	public void add(Menu data) throws SQLException, Exception {
		String sql = "INSERT INTO " + TABLA +" VALUES (";
		sql += data.getId() + ",'";
		sql += data.getCantidad() + ",";
		sql += data.getCostoProduccion() + ",";
		sql += data.getValorAlPublico() + ",";
		sql += data.getProductoEntrada()+",";
		sql += data.getProductoFuerte()+",";
		sql += data.getProductoBebida()+",";
		sql += data.getProductoPostre()+",";
		sql += data.getProductoAcompanamiento()+",";
		sql += data.getRestauranteID()+")";
		
		executeModification(sql);
	}

	@Override
	public void update(Menu data) throws SQLException, Exception {
		String sql = "UPDATE "+TABLA+" SET ";
		sql += "CANTIDAD=" + data.getCantidad() + ",";
		sql += "COSTODEPRODUCION=" + data.getCostoProduccion()+",";
		sql += "VALORALPUBLICO=" + data.getValorAlPublico()+",";
		sql += "PRODUCTOENTRADA_ID="+data.getProductoEntrada()+",";
		sql += "PRODUCTOPLATOFUERTE_ID="+data.getProductoFuerte()+",";
		sql += "PRODUCTOBEBIDA_ID="+data.getProductoBebida()+",";
		sql += "PRODUCTOPOSTRE_ID="+data.getProductoPostre()+",";
		sql += "PRODUCTOACOMPANAMIENTO_ID="+data.getProductoPostre()+",";
		sql += "RESTAURANTE_ID="+data.getRestauranteID();
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
