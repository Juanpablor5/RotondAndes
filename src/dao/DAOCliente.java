package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import vos.Cliente;
import vos.Registro;
import vos.Video;
import vos.Cliente;

/**
 * Clase DAO que se conecta la base de datos usando JDBC para resolver los requerimientos de la aplicación
 */
public class DAOCliente extends DAOBase implements CRUD<Cliente>{
	
	// -------------------------------------------------------------
	// Constantes
	// -------------------------------------------------------------
	
	/**
	 * Constante que representa la tabla cliente.
	 */
	private final static String TABLA="CLIENTE";
	
	// -------------------------------------------------------------
	// Métodos
	// -------------------------------------------------------------
	

	@Override
	public Cliente get(long cedula) throws SQLException, Exception {
		Cliente cliente = null;
		String sql = "SELECT * FROM " +TABLA+" WHERE CEDULA =" + cedula;
		ResultSet rs = executeModification(sql);
		if(rs.next()) {
			String nombre = rs.getString("NOMBRE");
			Date fechaIngreso = rs.getDate("FECHADEINGRESO");
			cliente = new Cliente(cedula, nombre, fechaIngreso);
		}
		return cliente;
	}

	@Override
	public List<Cliente> getAll() throws SQLException, Exception {
		ArrayList<Cliente> data = new ArrayList<Cliente>();

		String sql = "SELECT * FROM "+TABLA;

		ResultSet rs = executeModification(sql);

		while (rs.next()) {
			Long cedula = rs.getLong("CEDULA");
			String nombre = rs.getString("NOMBRE");
			Date fechaIngreso = rs.getDate("FECHADEINGRESO");
			data.add( new Cliente(cedula, nombre, fechaIngreso));
		}
		return data;
	}

	@Override
	public void add(Cliente data) throws SQLException, Exception {
		String sql = "INSERT INTO " + TABLA +" VALUES (";
		sql += data.getCedula() + ",'";
		sql += data.getNombre() + "','";
		sql += data.getFechaIngreso() + "')";
		
		executeModification(sql);
	}

	@Override
	public void update(Cliente data) throws SQLException, Exception {
		String sql = "UPDATE "+TABLA+" SET ";
		sql += "NOMBRE='" + data.getNombre() + "',";
		sql += "FECHADEINGRESO='" + data.getFechaIngreso() + "'";
		sql += " WHERE CEDULA = " + data.getCedula();
		
		executeModification(sql);
	}

	@Override
	public void delete(Cliente data) throws SQLException, Exception {
		String sql = "DELETE FROM " + TABLA;
		sql += " WHERE CEDULA = " + data.getCedula();
		
		executeModification(sql);
	}	
}
