package dao;

import java.sql.SQLException;
import java.util.List;

import vos.Registro;

public class DAORegistro extends DAOBase implements CRUD<Registro>{
	private final static String TABLA="REGISTRO";
	

	@Override
	public Registro get(long id) throws SQLException, Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Registro> getAll() throws SQLException, Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void update(Registro data) throws SQLException, Exception {
		String sql = "UPDATE "+TABLA+" SET ";
		sql += "USUARIO='" + data.getUsuario() + "',";
		sql += "CONTRASENIA=" + data.getContrasena()+",";
		sql += "PERMISOS=" + data.getPermisos();
		sql += " WHERE CODIGO = " + data.getCodigo();
		
		executeModification(sql);
	}


	@Override
	public void delete(Registro data) throws SQLException, Exception {
		String sql = "DELETE FROM VIDEO";
		sql += " WHERE CODIGO = " + data.getCodigo();
		
		executeModification(sql);
	}
	

	@Override
	public void add(Registro data) throws SQLException, Exception {
		String sql = "INSERT INTO "+TABLA+" VALUES (";
		sql += data.getCodigo() + ",'";
		sql += data.getUsuario() + "',";
		sql += data.getContrasena() + "',";
		sql += data.getPermisos() + ")";
		
		executeModification(sql);
	}
}
