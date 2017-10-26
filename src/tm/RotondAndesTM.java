package tm;

import java.sql.SQLException;
import java.util.List;
import vos.*;
import dao.*;

public class RotondAndesTM extends baseTM {
	/**
	 * Metodo constructor de la clase VideoAndesMaster, esta clase modela y contiene
	 * cada una de las Transacciónes y la logica de negocios que estas conllevan.
	 * <b>post: </b> Se crea el objeto VideoAndesTM, se inicializa el path absoluto
	 * del archivo de conexion y se inicializa los atributos que se usan par la
	 * conexion a la base de datos.
	 * 
	 * @param contextPathP
	 *            - path absoluto en el servidor del contexto del deploy actual
	 */
	public RotondAndesTM(String contextPathP) {
		setConectionDataPath(contextPathP + CONNECTION_DATA_FILE_NAME_REMOTE);
		initConnectionData();
	}

	// ------------------------------------------------------------------------------
	// REGISTRO
	// ------------------------------------------------------------------------------

	public Registro login(String con, String usu) throws SQLException, RotondAndesException {
		Registro registro = null;
		updateConnection();
		try (DAORegistro dao = new DAORegistro(conn)) {
			// ------------------------
			// START
			// ------------------------
			registro = dao.get(usu, con);
			if (registro == null)
				throw new RotondAndesException("usuario o contraseña incorectos");
			conn.commit();
			// ------------------------
			// END
			// ------------------------
		} catch (SQLException e) {
			sqlException(e);
		} finally {
			closeConection();
		}
		return registro;
	}

	public Registro creaRegistro(Registro data) throws SQLException {
		updateConnection();
		try (DAORegistro dao = new DAORegistro(conn)) {
			// ------------------------
			// START
			// ------------------------
			dao.create(data);
			data = dao.get(data.getUsuario(), data.getContrasenia());
			conn.commit();
			// ------------------------
			// END
			// ------------------------
		} catch (SQLException e) {
			sqlException(e);
		} finally {
			closeConection();
		}
		return data;
	}

	public Registro updateRegistro(Registro data) throws SQLException, RotondAndesException {
		Registro registro = null;
		updateConnection();
		try (DAORegistro dao = new DAORegistro(conn)) {
			// ------------------------
			// START
			// ------------------------
			registro = dao.get(data);
			if (registro == null)
				throw new RotondAndesException("no existe el registro buscado");
			dao.update(data);
			conn.commit();
			// ------------------------
			// END
			// ------------------------
		} catch (SQLException e) {
			sqlException(e);
		} finally {
			closeConection();
		}
		return registro;
	}

	public Registro deleteRegistro(Long codigo) throws SQLException, RotondAndesException {
		Registro registro=null;
		updateConnection();
		try (DAORegistro dao = new DAORegistro(conn)) {
			// ------------------------
			// START
			// ------------------------
			registro = dao.get(codigo);
			if (registro == null)
				throw new RotondAndesException("no existe el registro buscado");
			dao.remove(registro);
			conn.commit();
			// ------------------------
			// END
			// ------------------------
		} catch (SQLException e) {
			sqlException(e);
		} finally {
			closeConection();
		}
		return registro;
	}

	// ------------------------------------------------------------------------------
	// CLIENTE
	// ------------------------------------------------------------------------------

	public void addCliente(Cliente data) throws RotondAndesException, Exception {
		updateConnection();
		try (DAOCliente daos = new DAOCliente(conn)) {
			// ------------------------
			// START
			// ------------------------
			if (daos.get(data.getCedula()) != null)
				throw new RotondAndesException("El cliente con la cedula <" + data.getCedula() + "> ya existe");
			daos.create(data);
			conn.commit();
			// ------------------------
			// END
			// ------------------------
		} catch (SQLException e) {
			sqlException(e);
		} finally {
			closeConection();
		}
	}

	public List<Cliente> getAllCliente() throws SQLException {
		List<Cliente> data = null;
		updateConnection();
		try (DAOCliente daos = new DAOCliente(conn)) {
			// ------------------------
			// START
			// ------------------------
			data = daos.getAll();
			conn.commit();
			// ------------------------
			// END
			// ------------------------
		} catch (SQLException e) {
			sqlException(e);
		} finally {
			closeConection();
		}
		return data;
	}

	public Cliente getCliente(long id) throws RotondAndesException, Exception {
		Cliente data = null;
		updateConnection();
		try (DAOCliente daos = new DAOCliente(conn)) {
			// ------------------------
			// START
			// ------------------------
			data = daos.getDetail(id);
			if (data == null)
				throw new RotondAndesException("El cliente con el codigo:<" + id + ">no existe");
			conn.commit();
			// ------------------------
			// END
			// ------------------------
		} catch (SQLException e) {
			sqlException(e);
		} finally {
			closeConection();
		}
		return data;
	}

	public void updateCliente(Cliente data) throws RotondAndesException, SQLException {
		updateConnection();
		try (DAOCliente clientes = new DAOCliente(conn)) {
			// ------------------------
			// START
			// ------------------------
			if (clientes.get(data.getCedula()) == null)
				throw new RotondAndesException("Ya existe un cliente con la cedula <" + data.getCedula() + ">");
			clientes.update(data);
			conn.commit();
			// ------------------------
			// END
			// ------------------------
		} catch (SQLException e) {
			sqlException(e);
		} finally {
			closeConection();
		}
	}

	public void deleteCliente(Cliente data) throws RotondAndesException, SQLException {
		updateConnection();
		try (DAOCliente daos = new DAOCliente(conn)) {
			// ------------------------
			// START
			// ------------------------
			if (daos.get(data.getCedula()) == null)
				throw new RotondAndesException("No existe un cliente con la cedula<" + data.getCedula() + ">");
			daos.remove(data);
			conn.commit();
			// ------------------------
			// END
			// ------------------------
		} catch (SQLException e) {
			sqlException(e);
		} finally {
			closeConection();
		}
	}
}
