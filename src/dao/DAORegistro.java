package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import vos.Registro;

/**
 * Clase DAO que se conecta la base de datos usando JDBC para resolver los requerimientos de la aplicación
 */
public class DAORegistro extends DAOBase implements CRUD<Registro>{
	
	// -------------------------------------------------------------
	// Constantes
	// -------------------------------------------------------------
	
	/**
	 * Constante que representa la tabla registro.
	 */
	private final static String TABLA="REGISTRO";
	

	@Override
	public List<Registro> getAll() throws SQLException, Exception {
		ArrayList<Registro> data = new ArrayList<>();

		String sql = "SELECT * FROM "+TABLA;

		ResultSet rs = executeModification(sql);

		while (rs.next()) {
			String usuario = rs.getString("USUARIO");
			Long codigo = rs.getLong("CODIGO");
			String contrasenia =rs.getString("CONTRASENIA");
			Integer permisos= rs.getInt("PERMISOS");
			data.add( new Registro(codigo, usuario, contrasenia,permisos));
		}
		return data;
	}
	
	@Override
	public Registro get(long id) throws SQLException, Exception {
		Registro data = null;
		String sql = "SELECT * FROM "+TABLA+" WHERE CODIGO =" + id;
		
		ResultSet rs =executeModification(sql);
		if(rs.next()) {
			String usuario = rs.getString("USUARIO");
			Long codigo = rs.getLong("CODIGO");
			String contrasenia =rs.getString("CONTRASENIA");
			Integer permisos= rs.getInt("PERMISOS");
			data = new Registro(codigo, usuario, contrasenia,permisos);
		}
		return data;
	}

	@Override
	public void update(Registro data) throws SQLException, Exception {
		String sql = "UPDATE "+TABLA+" SET ";
		sql += "USUARIO='" + data.getUsuario() + "',";
		sql += "CONTRASENIA='" + data.getContrasena()+"',";
		sql += "PERMISOS=" + data.getPermisos();
		sql += "WHERE CODIGO = " + data.getCodigo();
		
		executeModification(sql);
	}


	@Override
	public void delete(Registro data) throws SQLException, Exception {
		String sql = "DELETE FROM "+TABLA;
		sql += " WHERE CODIGO = " + data.getCodigo();
		
		executeModification(sql);
	}
	

	@Override
	public void add(Registro data) throws SQLException, Exception {
		String sql = "INSERT INTO "+TABLA+" VALUES (";
		sql += data.getCodigo() + ",'";
		sql += data.getUsuario() + "','";
		sql += data.getContrasena() + "',";
		sql += data.getPermisos() + ")";
		
		executeModification(sql);
	}
}
