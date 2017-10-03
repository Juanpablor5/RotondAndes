package dao;

import java.sql.SQLException;

import vos.Registro;

public class DAORegistro extends DAOBase implements CRUD<Registro>{
	private final static String TABLA="REGISTRO";
	
	/**
	 * metodo que agrega un registro a la base de datos
	 * @param data los datos a agregar
	 * * @throws SQLException - Cualquier error que la base de datos arroje. No pudo agregar el video a la base de datos
	 * @throws Exception - Cualquier error que no corresponda a la base de datos
	 */
	public void add(Registro data) throws SQLException, Exception {
		String sql = "INSERT INTO "+TABLA+" VALUES (";
		sql += data.getCodigo() + ",'";
		sql += data.getUsuario() + "',";
		sql += data.getContrasena() + "',";
		sql += data.getPermisos() + ")";
		
		executeModification(sql);
	}
	
	
}
