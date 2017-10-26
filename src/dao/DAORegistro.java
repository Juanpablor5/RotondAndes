package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import em.GenericDao;
import vos.Registro;

public class DAORegistro extends GenericDao<Registro>{
	
	public DAORegistro(Connection conn) {
		super(Registro.class, conn);
	}

	public Registro get(String usuario,String contrasenia) throws SQLException {
		Registro data = null;
		String sql = "SELECT * FROM "+TABLA+" WHERE USUARIO='" + usuario +"' AND CONTRASENIA='"+contrasenia+"'";
		ResultSet rs =executeModification(sql);
		
		if(rs.next()) {
			Long codigo = rs.getLong("CODIGO");
			Integer permisos= rs.getInt("PERMISOS");
			data = new Registro(codigo,usuario, contrasenia,permisos);
		}
		return data;
	}
}
