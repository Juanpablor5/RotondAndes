package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import vos.Menu;

/**
 * Clase DAO que se conecta la base de datos usando JDBC para resolver los requerimientos de la aplicación
 */
public class DAOMenu extends DAOBase{
	
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

	public Long IdRestaurante(Long IDRegistro) throws SQLException, Exception{
		String sql="SELECT ID FROM RESTAURANTE,REGISTRO WHERE REGISTRO.CODIGO=RESTAURANTE.REGISTRO_ID AND REGISTRO.CODIGO="+IDRegistro;
		System.out.println(sql);
		ResultSet rs=executeModification(sql);
		if(rs.next()) {
			return rs.getLong("ID");
		}
		return null;
	}
	
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

	public void add(Long codigo,Menu data) throws SQLException, Exception {
		Long id=IdRestaurante(codigo);
		if(id==null)throw new SQLException("no se puede obtener el codigo");
		
		String sql = "INSERT INTO " + TABLA +" VALUES (";
		sql += data.getId() + ",";
		sql += data.getCantidad() + ",";
		sql += data.getCostoProduccion() + ",";
		sql += data.getValorAlPublico() + ",";
		sql += data.getProductoEntrada()+",";
		sql += data.getProductoFuerte()+",";
		sql += data.getProductoBebida()+",";
		sql += data.getProductoPostre()+",";
		sql += data.getProductoAcompanamiento()+",";
		sql += id+")";
		System.out.println(sql);
		executeModification(sql);
	}


	public void update(Long codigo,Menu data) throws SQLException, Exception {
		Long id=IdRestaurante(codigo);
		if(id==null)throw new SQLException("no se puede obtener el codigo");
		
		if((get(data.getId()).getRestauranteID())!=id)
			throw new SQLException("no puede alterar un menu ajeno");
		
		
		String sql = "UPDATE "+TABLA+" SET ";
		sql += "CANTIDAD=" + data.getCantidad() + ",";
		sql += "COSTODEPRODUCION=" + data.getCostoProduccion()+",";
		sql += "VALORALPUBLICO=" + data.getValorAlPublico()+",";
		sql += "PRODUCTOENTRADA_ID="+data.getProductoEntrada()+",";
		sql += "PRODUCTOPLATOFUERTE_ID="+data.getProductoFuerte()+",";
		sql += "PRODUCTOBEBIDA_ID="+data.getProductoBebida()+",";
		sql += "PRODUCTOPOSTRE_ID="+data.getProductoPostre()+",";
		sql += "PRODUCTOACOMPANAMIENTO_ID="+data.getProductoPostre();
		sql += " WHERE ID = " + data.getId();
		System.out.println(sql);
		executeModification(sql);
	}

	public void delete(Long codigo,Menu data) throws SQLException, Exception {
		Long id=IdRestaurante(codigo);
		if(id==null)throw new SQLException("no se puede obtener el codigo");
		
		if(get(data.getId()).getRestauranteID()!=id)
			throw new SQLException("no puede alterar un menu ajeno");
		
		String sql = "DELETE FROM " + TABLA;
		sql += " WHERE ID = " + data.getId();
		System.out.println(sql);
		executeModification(sql);
	}
}
