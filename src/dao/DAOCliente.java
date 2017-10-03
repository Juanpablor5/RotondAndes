package dao;

import java.sql.SQLException;
import java.util.List;

import vos.Cliente;

/**
 * Clase DAO que se conecta la base de datos usando JDBC para resolver los requerimientos de la aplicación
 */
public class DAOCliente extends DAOBase implements CRUD{
	
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
	public Object get(long id) throws SQLException, Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List getAll() throws SQLException, Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void add(Object t) throws SQLException, Exception {
		String sql = "INSERT INTO CLIENTE VALUES (";
		sql += cliente.getCedula() + ",'";
		sql += cliente.getNombre() + "',";
		sql += cliente.getFechaIngreso() + ")";
		
		executeModification(sql);
	}

	@Override
	public void update(Object t) throws SQLException, Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Object t) throws SQLException, Exception {
		// TODO Auto-generated method stub
		
	}
}
