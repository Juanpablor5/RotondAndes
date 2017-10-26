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
		// USUARIO
		// ------------------------------------------------------------------------------

		public Usuario login(String con, String usu) throws SQLException, RotondAndesException {
			Usuario usuario = null;
			updateConnection();
			try (DAOUsuario dao = new DAOUsuario(conn)) {
				// ------------------------
				// START
				// ------------------------
				usuario = dao.get(usu, con);
				if (usuario == null)
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
			return usuario;
		}

		public Usuario creaUsuario(Usuario data) throws SQLException, RotondAndesException {
			updateConnection();
			try (DAOUsuario dao = new DAOUsuario(conn)) {
				// ------------------------
				// START
				// ------------------------
				if(data.getPermisos()==3 && dao.existAdmin())
					throw new RotondAndesException("ya existe un administrador");
				dao.create(data);
				data = dao.get(data.getNickName(), data.getContrasenia());
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

		public Usuario updateUsuario(Usuario data) throws SQLException, RotondAndesException {
			Usuario usuario = null;
			updateConnection();
			try (DAOUsuario dao = new DAOUsuario(conn)) {
				// ------------------------
				// START
				// ------------------------
				if(data.getPermisos()==3  && dao.existAdmin())
					throw new RotondAndesException("ya existe un administrador");
				usuario = dao.get(data);
				if (usuario == null)
					throw new RotondAndesException("no existe el usuario buscado");
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
			return usuario;
		}

		public Usuario deleteUsuario(Long codigo) throws SQLException, RotondAndesException {
			Usuario usuario=null;
			updateConnection();
			try (DAOUsuario dao = new DAOUsuario(conn)) {
				// ------------------------
				// START
				// ------------------------
				usuario = dao.get(codigo);
				if (usuario == null)
					throw new RotondAndesException("no existe el usuario buscado");
				dao.remove(usuario);
				conn.commit();
				// ------------------------
				// END
				// ------------------------
			} catch (SQLException e) {
				sqlException(e);
			} finally {
				closeConection();
			}
			return usuario;
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
