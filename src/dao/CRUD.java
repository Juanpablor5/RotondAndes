package dao;

import java.sql.SQLException;
import java.util.List;

public interface CRUD<T> {

	/**
	 * M�todo que retorna un atributo de tipo T que se busca en la base de datos
	 * con el identificador que le llega por par�metro.
	 * 
	 * @param id
	 *            - Id del atributo solicitado.
	 * @return id
	 * @throws SQLException
	 *             Cualquier error que la base de datos arroje.
	 * @throws Exception
	 *             Cualquier error que no corresponda a la base de datos.
	 */
	public T get(long id) throws SQLException, Exception;

	/**
	 * Retorna una lista con todos los datos de la tabla.
	 * 
	 * @return List con todos los datos de la tabla.
	 * @throws SQLException
	 *             Cualquier error que la base de datos arroje.
	 * @throws Exception
	 *             Cualquier error que no corresponda a la base de datos.
	 */
	public List<T> getAll() throws SQLException, Exception;

	/**
	 * M�todo que agrega los datos que le entran por par�metro a la base de
	 * datos.
	 * 
	 * @param data
	 *            - El dato a agregar. data != null
	 * @throws SQLException
	 *             Cualquier error que la base de datos arroje.
	 * @throws Exception
	 *             Cualquier error que no corresponda a la base de datos.
	 */
	public void add(T data) throws SQLException, Exception;

	/**
	 * M�todo que actualiza la tabla con el dato que entra como par�metro en la
	 * base de datos.
	 * 
	 * @param data
	 *            - Datos a ingresar en la tabla.
	 * @throws SQLException
	 *             Cualquier error que la base de datos arroje.
	 * @throws Exception
	 *             Cualquier error que no corresponda a la base de datos.
	 */
	public void update(T data) throws SQLException, Exception;

	/**
	 * M�todo que elimina el video que entra como par�metro en la base de datos.
	 * 
	 * @param data
	 *            - Datos a eliminar de la tabla.
	 * @throws SQLException
	 *             Cualquier error que la base de datos arroje.
	 * @throws Exception
	 *             Cualquier error que no corresponda a la base de datos.
	 */
	public void delete(T data) throws SQLException, Exception;
}
