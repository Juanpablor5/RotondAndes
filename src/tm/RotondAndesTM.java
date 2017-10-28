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

	public Usuario getUsuario(Long id) throws SQLException, RotondAndesException {
		Usuario usuario = null;
		updateConnection();
		try (DAOUsuario dao = new DAOUsuario(conn)) {
			// ------------------------
			// START
			// ------------------------
			usuario = dao.get(id);
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
			if (data.getPermisos() == 3 && dao.existAdmin())
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
			if (data.getPermisos() == 3 && dao.existAdmin())
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
		Usuario usuario = null;
		updateConnection();
		try (DAOUsuario dao = new DAOUsuario(conn);
				DAOCliente daoCliente = new DAOCliente(conn);
				DAORestaurante daoRestaurante = new DAORestaurante(conn)) {
			// ------------------------
			// START
			// ------------------------
			usuario = dao.get(codigo);
			if (usuario == null)
				throw new RotondAndesException("no existe el usuario buscado");
			if (usuario.getPermisos() == 1)
				daoCliente.removeAllSub(usuario);
			if (usuario.getPermisos() == 2)
				daoRestaurante.removeAllSub(usuario);
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

	public Cliente createCliente(Cliente data, Long codigo) throws SQLException, RotondAndesException {
		updateConnection();
		try (DAOCliente dao = new DAOCliente(conn); DAOUsuario daoUsuario = new DAOUsuario(conn)) {
			// ------------------------
			// START
			// ------------------------
			Usuario usuario = daoUsuario.get(codigo);
			if (usuario.getPermisos() != 1)
				throw new RotondAndesException("el nivel de permiso de la cuenta no corresponde a un cliente");
			data.setRegistro(usuario);
			dao.create(data);
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

	public Cliente updateCliente(Cliente data) throws SQLException, RotondAndesException {
		Cliente old = null;
		updateConnection();
		try (DAOCliente dao = new DAOCliente(conn)) {
			// ------------------------
			// START
			// ------------------------
			old = dao.get(data);
			if (old == null)
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
		return old;
	}

	public Cliente deleteCliente(Long cedula) throws SQLException, RotondAndesException {
		Cliente cliente = null;
		updateConnection();
		try (DAOCliente dao = new DAOCliente(conn)) {
			// ------------------------
			// START
			// ------------------------
			cliente = dao.get(cedula);
			if (cliente == null)
				throw new RotondAndesException("no existe el usuario buscado");
			dao.remove(cliente);
			conn.commit();
			// ------------------------
			// END
			// ------------------------
		} catch (SQLException e) {
			sqlException(e);
		} finally {
			closeConection();
		}
		return cliente;
	}

	// ------------------------------------------------------------------------------
	// RESTAURANTE
	// ------------------------------------------------------------------------------

	public List<Restaurante> getAllRestaurante() throws SQLException {
		List<Restaurante> data = null;
		updateConnection();
		try (DAORestaurante daos = new DAORestaurante(conn)) {
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

	public Restaurante getRestaurante(long id) throws RotondAndesException, Exception {
		Restaurante data = null;
		updateConnection();
		try (DAORestaurante daos = new DAORestaurante(conn)) {
			// ------------------------
			// START
			// ------------------------
			data = daos.getDetail(id);
			if (data == null)
				throw new RotondAndesException("El restaurante con el codigo:<" + id + ">no existe");
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

	public Restaurante createRestaurante(Restaurante data, Long codigo) throws SQLException, RotondAndesException {
		updateConnection();
		try (DAORestaurante dao = new DAORestaurante(conn); DAOUsuario daoUsuario = new DAOUsuario(conn)) {
			// ------------------------
			// START
			// ------------------------
			Usuario usuario = daoUsuario.get(codigo);
			if (usuario.getPermisos() != 2)
				throw new RotondAndesException("el nivel de permiso de la cuenta no corresponde a un restaurante");
			data.setRegistro(usuario);
			dao.create(data);
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

	public Restaurante updateRestaurante(Restaurante data) throws SQLException, RotondAndesException {
		Restaurante old = null;
		updateConnection();
		try (DAORestaurante dao = new DAORestaurante(conn)) {
			// ------------------------
			// START
			// ------------------------
			old = dao.get(data);
			if (old == null)
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
		return old;
	}

	public Restaurante deleteRestaurante(Long cedula) throws SQLException, RotondAndesException {
		Restaurante restaurante = null;
		updateConnection();
		try (DAORestaurante dao = new DAORestaurante(conn);DAORepresentante daoRepresentante=new DAORepresentante(conn)) {
			// ------------------------
			// START
			// ------------------------
			restaurante = dao.get(cedula);
			if (restaurante == null)
				throw new RotondAndesException("no existe el usuario buscado");
			daoRepresentante.removeAllSub(restaurante);
			dao.remove(restaurante);
			conn.commit();
			// ------------------------
			// END
			// ------------------------
		} catch (SQLException e) {
			sqlException(e);
		} finally {
			closeConection();
		}
		return restaurante;
	}

	// ------------------------------------------------------------------------------
	// REPRESENTANTE
	// ------------------------------------------------------------------------------

	public Representante getRepresentante(Long idRestaurante) throws RotondAndesException, SQLException {
		Representante data = null;
		updateConnection();
		try (DAORepresentante daoRepresentante = new DAORepresentante(conn)) {
			// ------------------------
			// START
			// ------------------------
			Restaurante restaurante = new Restaurante();
			restaurante.setId(idRestaurante);
			List<Representante> list = daoRepresentante.getAllSub(restaurante);
			if (list.isEmpty())
				throw new RotondAndesException("no existe un representante asociado al restaurante");
			data = list.get(0);
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

	public Representante addRepresentante(Long idRestaurante, Representante data)
			throws SQLException, RotondAndesException {
		updateConnection();
		try (DAORestaurante daoRestaurante = new DAORestaurante(conn);
				DAORepresentante dao = new DAORepresentante(conn);) {
			// ------------------------
			// START
			// ------------------------
			Restaurante restaurante = daoRestaurante.get(idRestaurante);
			if (restaurante == null)
				throw new RotondAndesException("no existe el restaurante");
			data.setRestaurante(restaurante);
			dao.create(data);
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

	public Representante updateRepresentante(Long idRestaurante, Representante data)
			throws SQLException, RotondAndesException {
		Representante old = null;
		updateConnection();
		try (DAORestaurante daoRestaurante = new DAORestaurante(conn);
				DAORepresentante dao = new DAORepresentante(conn);) {
			// ------------------------
			// START
			// ------------------------
			Restaurante restaurante = new Restaurante();
			restaurante.setId(idRestaurante);
			List<Representante> list = dao.getAllSub(restaurante);
			if (list.isEmpty())
				throw new RotondAndesException("no existe un representante asociado al restaurante");
			old = list.get(0);
			data.setId(old.getId());
			data.setRestaurante(null);
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
		return old;
	}

	public Representante deleteRepresentante(Long idRestaurante) throws RotondAndesException, SQLException {
		Representante old = null;
		updateConnection();
		try (DAORestaurante daoRestaurante = new DAORestaurante(conn);
				DAORepresentante dao = new DAORepresentante(conn);) {
			// ------------------------
			// START
			// ------------------------
			Restaurante restaurante = new Restaurante();
			restaurante.setId(idRestaurante);
			List<Representante> list = dao.getAllSub(restaurante);
			if (list.isEmpty())
				throw new RotondAndesException("no existe un representante asociado al restaurante");
			old = list.get(0);
			dao.remove(old);
			conn.commit();
			// ------------------------
			// END
			// ------------------------
		} catch (SQLException e) {
			sqlException(e);
		} finally {
			closeConection();
		}
		return old;
	}

	// ------------------------------------------------------------------------------
	// RESTAURANTE
	// ------------------------------------------------------------------------------

	public List<TipoComida> getAllTipoComida() throws SQLException {
		List<TipoComida> data = null;
		updateConnection();
		try (DAOTipoComida daos = new DAOTipoComida(conn)) {
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

	public TipoComida getTipoComida(String id) throws SQLException, RotondAndesException {
		TipoComida data = null;
		updateConnection();
		try (DAOTipoComida daos = new DAOTipoComida(conn)) {
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

	public void addTipoComida(TipoComida data) throws SQLException {
		updateConnection();
		try (DAOTipoComida dao = new DAOTipoComida(conn)) {
			// ------------------------
			// START
			// ------------------------
			dao.create(data);
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

	public TipoComida deleteTipoComida(String id) throws SQLException, RotondAndesException {
		TipoComida tipo = null;
		updateConnection();
		try (DAOTipoComida dao = new DAOTipoComida(conn); DAORestaurante daoRestaurante = new DAORestaurante(conn)) {
			// ------------------------
			// START
			// ------------------------
			tipo = dao.get(id);
			if (tipo == null)
				throw new RotondAndesException("no existe el tipo de comida buscado buscado");
			daoRestaurante.removeAllRefSub(tipo);
			dao.remove(tipo);
			conn.commit();
			// ------------------------
			// END
			// ------------------------
		} catch (SQLException e) {
			sqlException(e);
		} finally {
			closeConection();
		}
		return tipo;
	}

	public void deleteRestauranteTipoComida(Long id) throws SQLException, RotondAndesException {
		Restaurante old = new Restaurante();
		updateConnection();
		try (DAORestaurante dao = new DAORestaurante(conn)) {
			// ------------------------
			// START
			// ------------------------
			old.setId(id);
			old.setTipoComida(new TipoComida());
			dao.update(old);
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

	public TipoComida setRestauranteTipoComida(Long id, String str) throws SQLException, RotondAndesException {
		Restaurante old = new Restaurante();
		TipoComida tipoComida = null;
		updateConnection();
		try (DAORestaurante dao = new DAORestaurante(conn);DAOTipoComida daoTipoComida= new DAOTipoComida(conn)) {
			// ------------------------
			// START
			// ------------------------
			tipoComida=daoTipoComida.get(str);
			if (tipoComida == null)
				throw new RotondAndesException("no existe el usuario buscado");
			old.setId(id);
			old.setTipoComida(tipoComida);
			dao.update(old);
			conn.commit();
			// ------------------------
			// END
			// ------------------------
		} catch (SQLException e) {
			sqlException(e);
		} finally {
			closeConection();
		}
		return tipoComida;
	}
}
