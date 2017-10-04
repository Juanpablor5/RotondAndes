package tm;

import java.io.File;
import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;
import java.util.Properties;

import dao.DAOProducto;
import dao.DAOProductoIngrediente;
import dao.DAOIngrediente;
import dao.DAOMenu;
import dao.DAOPreferencias;
import dao.DAOPedido;
import dao.DAOZona;
import dao.DAOCliente;
import dao.DAOEspacio;
import dao.DAORegistro;
import dao.DAORepresentante;
import dao.DAOReserva;
import dao.DAOReservaMenu;
import dao.DAORestaurante;
import dao.DAOTipoComida;
import vos.Pedido;
import vos.Preferencias;
import vos.Cliente;
import vos.Espacio;
import vos.Ingrediente;
import vos.Menu;
import vos.Producto;
import vos.ProductoDetail;
import vos.Registro;
import vos.Representante;
import vos.Reserva;
import vos.Restaurante;
import vos.TipoComida;
import vos.Zona;

public class RotondAndesTM {
	/**
	 * Atributo estatico que contiene el path relativo del archivo que tiene los
	 * datos de la conexion
	 */
	private static final String CONNECTION_DATA_FILE_NAME_REMOTE = "/conexion.properties";

	/**
	 * Atributo estatico que contiene el path absoluto del archivo que tiene los
	 * datos de la conexion
	 */
	private String connectionDataPath;

	/**
	 * Atributo que guarda el usuario que se va a usar para conectarse a la base
	 * de datos.
	 */
	private String user;

	/**
	 * Atributo que guarda la clave que se va a usar para conectarse a la base
	 * de datos.
	 */
	private String password;

	/**
	 * Atributo que guarda el URL que se va a usar para conectarse a la base de
	 * datos.
	 */
	private String url;

	/**
	 * Atributo que guarda el driver que se va a usar para conectarse a la base
	 * de datos.
	 */
	private String driver;

	/**
	 * conexion a la base de datos
	 */
	private Connection conn;

	/**
	 * Metodo constructor de la clase VideoAndesMaster, esta clase modela y
	 * contiene cada una de las Transacciónes y la logica de negocios que estas
	 * conllevan. <b>post: </b> Se crea el objeto VideoAndesTM, se inicializa el
	 * path absoluto del archivo de conexion y se inicializa los atributos que
	 * se usan par la conexion a la base de datos.
	 * 
	 * @param contextPathP
	 *            - path absoluto en el servidor del contexto del deploy actual
	 */
	public RotondAndesTM(String contextPathP) {
		connectionDataPath = contextPathP + CONNECTION_DATA_FILE_NAME_REMOTE;
		initConnectionData();
	}

	/**
	 * Metodo que inicializa los atributos que se usan para la conexion a la
	 * base de datos. <b>post: </b> Se han inicializado los atributos que se
	 * usan par la conexion a la base de datos.
	 */
	private void initConnectionData() {
		try {
			File arch = new File(this.connectionDataPath);
			Properties prop = new Properties();
			FileInputStream in = new FileInputStream(arch);
			prop.load(in);
			in.close();
			this.url = prop.getProperty("url");
			this.user = prop.getProperty("usuario");
			this.password = prop.getProperty("clave");
			this.driver = prop.getProperty("driver");
			Class.forName(driver);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Metodo que retorna la conexion a la base de datos
	 * 
	 * @return Connection - la conexion a la base de datos
	 * @throws SQLException
	 *             - Cualquier error que se genere durante la conexion a la base
	 *             de datos
	 */
	private Connection darConexion() throws SQLException {
		System.out.println("Connecting to: " + url + " With user: " + user);
		return DriverManager.getConnection(url, user, password);
	}

	////////////////////////////////////////
	/////// Transacciones////////////////////
	////////////////////////////////////////

	public List<Registro> getAllResgistro() throws SQLException, Exception {
		List<Registro> data;
		DAORegistro daos = new DAORegistro();
		try {
			////// Transacción
			this.conn = darConexion();
			daos.setConn(conn);
			data = daos.getAll();
		} catch (SQLException e) {
			System.err.println("SQLException:" + e.getMessage());
			e.printStackTrace();
			throw e;
		} catch (Exception e) {
			System.err.println("GeneralException:" + e.getMessage());
			e.printStackTrace();
			throw e;
		} finally {
			try {
				daos.cerrarRecursos();
				if (this.conn != null)
					this.conn.close();
			} catch (SQLException exception) {
				System.err.println("SQLException closing resources:" + exception.getMessage());
				exception.printStackTrace();
				throw exception;
			}
		}
		return data;
	}

	public Registro getRegistro(long id) throws RotondAndesException, Exception {
		Registro data;
		DAORegistro daos = new DAORegistro();
		try {
			////// Transacción
			this.conn = darConexion();
			daos.setConn(conn);
			data = daos.get(id);
			if (data == null)
				throw new RotondAndesException("El registro con el codigo:<" + id + ">no existe");
		} catch (SQLException e) {
			System.err.println("SQLException:" + e.getMessage());
			e.printStackTrace();
			throw e;
		} catch (Exception e) {
			System.err.println("GeneralException:" + e.getMessage());
			e.printStackTrace();
			throw e;
		} finally {
			try {
				daos.cerrarRecursos();
				if (this.conn != null)
					this.conn.close();
			} catch (SQLException exception) {
				System.err.println("SQLException closing resources:" + exception.getMessage());
				exception.printStackTrace();
				throw exception;
			}
		}
		return data;
	}

	public void addRegistro(Registro data) throws RotondAndesException, Exception {
		DAORegistro daos = new DAORegistro();
		try {
			////// Transacción
			this.conn = darConexion();
			daos.setConn(conn);
			if (daos.get(data.getCodigo()) != null)
				throw new RotondAndesException("El registro con el codigo <" + data.getCodigo() + "> ya existe");
			daos.add(data);
			conn.commit();

		} catch (SQLException e) {
			System.err.println("SQLException:" + e.getMessage());
			e.printStackTrace();
			throw e;
		} catch (Exception e) {
			System.err.println("GeneralException:" + e.getMessage());
			e.printStackTrace();
			throw e;
		} finally {
			try {
				daos.cerrarRecursos();
				if (this.conn != null)
					this.conn.close();
			} catch (SQLException exception) {
				System.err.println("SQLException closing resources:" + exception.getMessage());
				exception.printStackTrace();
				throw exception;
			}
		}
	}

	public void updateRegistro(Registro data) throws RotondAndesException, Exception {
		DAORegistro daos = new DAORegistro();
		try {
			////// Transacción
			this.conn = darConexion();
			daos.setConn(conn);
			if (daos.get(data.getCodigo()) == null)
				throw new RotondAndesException("Ya existe un regstro con el codigo <" + data.getCodigo() + ">");
			daos.update(data);

		} catch (SQLException e) {
			System.err.println("SQLException:" + e.getMessage());
			e.printStackTrace();
			throw e;
		} catch (Exception e) {
			System.err.println("GeneralException:" + e.getMessage());
			e.printStackTrace();
			throw e;
		} finally {
			try {
				daos.cerrarRecursos();
				if (this.conn != null)
					this.conn.close();
			} catch (SQLException exception) {
				System.err.println("SQLException closing resources:" + exception.getMessage());
				exception.printStackTrace();
				throw exception;
			}
		}
	}

	public void deleteRegistro(Registro data) throws RotondAndesException, Exception {
		DAORegistro daos = new DAORegistro();
		try {
			////// Transacción
			this.conn = darConexion();
			daos.setConn(conn);
			if (daos.get(data.getCodigo()) == null)
				throw new RotondAndesException("No existe un registro con codigo:<" + data.getCodigo() + ">");
			daos.delete(data);

		} catch (SQLException e) {
			System.err.println("SQLException:" + e.getMessage());
			e.printStackTrace();
			throw e;
		} catch (Exception e) {
			System.err.println("GeneralException:" + e.getMessage());
			e.printStackTrace();
			throw e;
		} finally {
			try {
				daos.cerrarRecursos();
				if (this.conn != null)
					this.conn.close();
			} catch (SQLException exception) {
				System.err.println("SQLException closing resources:" + exception.getMessage());
				exception.printStackTrace();
				throw exception;
			}
		}
	}

	public List<Cliente> getAllCliente() throws SQLException, Exception {
		List<Cliente> data;
		DAOCliente daos = new DAOCliente();
		try {
			////// Transacción
			this.conn = darConexion();
			daos.setConn(conn);
			data = daos.getAll();
		} catch (SQLException e) {
			System.err.println("SQLException:" + e.getMessage());
			e.printStackTrace();
			throw e;
		} catch (Exception e) {
			System.err.println("GeneralException:" + e.getMessage());
			e.printStackTrace();
			throw e;
		} finally {
			try {
				daos.cerrarRecursos();
				if (this.conn != null)
					this.conn.close();
			} catch (SQLException exception) {
				System.err.println("SQLException closing resources:" + exception.getMessage());
				exception.printStackTrace();
				throw exception;
			}
		}
		return data;
	}

	public Cliente getCliente(long id) throws RotondAndesException, Exception {
		Cliente data;
		DAOCliente daos = new DAOCliente();
		try {
			////// Transacción
			this.conn = darConexion();
			daos.setConn(conn);
			data = daos.get(id);
			if (data == null)
				throw new RotondAndesException("El cliente con el codigo:<" + id + ">no existe");
		} catch (SQLException e) {
			System.err.println("SQLException:" + e.getMessage());
			e.printStackTrace();
			throw e;
		} catch (Exception e) {
			System.err.println("GeneralException:" + e.getMessage());
			e.printStackTrace();
			throw e;
		} finally {
			try {
				daos.cerrarRecursos();
				if (this.conn != null)
					this.conn.close();
			} catch (SQLException exception) {
				System.err.println("SQLException closing resources:" + exception.getMessage());
				exception.printStackTrace();
				throw exception;
			}
		}
		return data;
	}

	public void addCliente(Cliente data) throws RotondAndesException, Exception {
		DAOCliente daos = new DAOCliente();
		try {
			////// Transacción
			this.conn = darConexion();
			daos.setConn(conn);
			if (daos.get(data.getCedula()) != null)
				throw new RotondAndesException("El cliente con la cedula <" + data.getCedula() + "> ya existe");
			daos.add(data);
			conn.commit();

		} catch (SQLException e) {
			System.err.println("SQLException:" + e.getMessage());
			e.printStackTrace();
			throw e;
		} catch (Exception e) {
			System.err.println("GeneralException:" + e.getMessage());
			e.printStackTrace();
			throw e;
		} finally {
			try {
				daos.cerrarRecursos();
				if (this.conn != null)
					this.conn.close();
			} catch (SQLException exception) {
				System.err.println("SQLException closing resources:" + exception.getMessage());
				exception.printStackTrace();
				throw exception;
			}
		}
	}

	public void updateCliente(Cliente data) throws RotondAndesException, Exception {
		DAOCliente daos = new DAOCliente();
		try {
			////// Transacción
			this.conn = darConexion();
			daos.setConn(conn);
			if (daos.get(data.getCedula()) == null)
				throw new RotondAndesException("Ya existe un cliente con la cedula <" + data.getCedula() + ">");
			daos.update(data);

		} catch (SQLException e) {
			System.err.println("SQLException:" + e.getMessage());
			e.printStackTrace();
			throw e;
		} catch (Exception e) {
			System.err.println("GeneralException:" + e.getMessage());
			e.printStackTrace();
			throw e;
		} finally {
			try {
				daos.cerrarRecursos();
				if (this.conn != null)
					this.conn.close();
			} catch (SQLException exception) {
				System.err.println("SQLException closing resources:" + exception.getMessage());
				exception.printStackTrace();
				throw exception;
			}
		}
	}

	public void deleteCliente(Cliente data) throws RotondAndesException, Exception {
		DAOCliente daos = new DAOCliente();
		try {
			////// Transacción
			this.conn = darConexion();
			daos.setConn(conn);
			if (daos.get(data.getCedula()) == null)
				throw new RotondAndesException("No existe un cliente con la cedula<" + data.getCedula() + ">");
			daos.delete(data);

		} catch (SQLException e) {
			System.err.println("SQLException:" + e.getMessage());
			e.printStackTrace();
			throw e;
		} catch (Exception e) {
			System.err.println("GeneralException:" + e.getMessage());
			e.printStackTrace();
			throw e;
		} finally {
			try {
				daos.cerrarRecursos();
				if (this.conn != null)
					this.conn.close();
			} catch (SQLException exception) {
				System.err.println("SQLException closing resources:" + exception.getMessage());
				exception.printStackTrace();
				throw exception;
			}
		}
	}

	public List<Restaurante> getAllRestaurante() throws SQLException, Exception {
		List<Restaurante> data;
		DAORestaurante daos = new DAORestaurante();
		try {
			////// Transacción
			this.conn = darConexion();
			daos.setConn(conn);
			data = daos.getAll();
		} catch (SQLException e) {
			System.err.println("SQLException:" + e.getMessage());
			e.printStackTrace();
			throw e;
		} catch (Exception e) {
			System.err.println("GeneralException:" + e.getMessage());
			e.printStackTrace();
			throw e;
		} finally {
			try {
				daos.cerrarRecursos();
				if (this.conn != null)
					this.conn.close();
			} catch (SQLException exception) {
				System.err.println("SQLException closing resources:" + exception.getMessage());
				exception.printStackTrace();
				throw exception;
			}
		}
		return data;
	}

	public Restaurante getRestaurante(long id) throws RotondAndesException, Exception {
		Restaurante data;
		DAORestaurante daos = new DAORestaurante();
		try {
			////// Transacción
			this.conn = darConexion();
			daos.setConn(conn);
			data = daos.get(id);
			if (data == null)
				throw new RotondAndesException("El restaurante con el id:<" + id + ">no existe");
		} catch (SQLException e) {
			System.err.println("SQLException:" + e.getMessage());
			e.printStackTrace();
			throw e;
		} catch (Exception e) {
			System.err.println("GeneralException:" + e.getMessage());
			e.printStackTrace();
			throw e;
		} finally {
			try {
				daos.cerrarRecursos();
				if (this.conn != null)
					this.conn.close();
			} catch (SQLException exception) {
				System.err.println("SQLException closing resources:" + exception.getMessage());
				exception.printStackTrace();
				throw exception;
			}
		}
		return data;
	}

	public void addRestaurante(Restaurante data) throws RotondAndesException, Exception {
		DAORestaurante daos = new DAORestaurante();
		try {
			////// Transacción
			this.conn = darConexion();
			daos.setConn(conn);
			if (daos.get(data.getId()) != null)
				throw new RotondAndesException("El restaurante con el id <" + data.getId() + "> ya existe");
			daos.add(data);
			conn.commit();

		} catch (SQLException e) {
			System.err.println("SQLException:" + e.getMessage());
			e.printStackTrace();
			throw e;
		} catch (Exception e) {
			System.err.println("GeneralException:" + e.getMessage());
			e.printStackTrace();
			throw e;
		} finally {
			try {
				daos.cerrarRecursos();
				if (this.conn != null)
					this.conn.close();
			} catch (SQLException exception) {
				System.err.println("SQLException closing resources:" + exception.getMessage());
				exception.printStackTrace();
				throw exception;
			}
		}
	}

	public void updateRestaurante(Restaurante data) throws RotondAndesException, Exception {
		DAORestaurante daos = new DAORestaurante();
		try {
			////// Transacción
			this.conn = darConexion();
			daos.setConn(conn);
			if (daos.get(data.getId()) == null)
				throw new RotondAndesException("Ya existe un restaurante con el <" + data.getId() + ">");
			daos.update(data);

		} catch (SQLException e) {
			System.err.println("SQLException:" + e.getMessage());
			e.printStackTrace();
			throw e;
		} catch (Exception e) {
			System.err.println("GeneralException:" + e.getMessage());
			e.printStackTrace();
			throw e;
		} finally {
			try {
				daos.cerrarRecursos();
				if (this.conn != null)
					this.conn.close();
			} catch (SQLException exception) {
				System.err.println("SQLException closing resources:" + exception.getMessage());
				exception.printStackTrace();
				throw exception;
			}
		}
	}

	public void deleteRestaurante(Restaurante data) throws RotondAndesException, Exception {
		DAORestaurante daos = new DAORestaurante();
		try {
			////// Transacción
			this.conn = darConexion();
			daos.setConn(conn);
			if (daos.get(data.getId()) == null)
				throw new RotondAndesException("No existe un restaurante con el id<" + data.getId() + ">");
			daos.delete(data);

		} catch (SQLException e) {
			System.err.println("SQLException:" + e.getMessage());
			e.printStackTrace();
			throw e;
		} catch (Exception e) {
			System.err.println("GeneralException:" + e.getMessage());
			e.printStackTrace();
			throw e;
		} finally {
			try {
				daos.cerrarRecursos();
				if (this.conn != null)
					this.conn.close();
			} catch (SQLException exception) {
				System.err.println("SQLException closing resources:" + exception.getMessage());
				exception.printStackTrace();
				throw exception;
			}
		}
	}

	public List<Producto> getAllProducto() throws SQLException, Exception {
		List<Producto> data;
		DAOProducto daos = new DAOProducto();
		try {
			////// Transacción
			this.conn = darConexion();
			daos.setConn(conn);
			data = daos.getAll();
		} catch (SQLException e) {
			System.err.println("SQLException:" + e.getMessage());
			e.printStackTrace();
			throw e;
		} catch (Exception e) {
			System.err.println("GeneralException:" + e.getMessage());
			e.printStackTrace();
			throw e;
		} finally {
			try {
				daos.cerrarRecursos();
				if (this.conn != null)
					this.conn.close();
			} catch (SQLException exception) {
				System.err.println("SQLException closing resources:" + exception.getMessage());
				exception.printStackTrace();
				throw exception;
			}
		}
		return data;
	}

	public Producto getProducto(long id) throws RotondAndesException, Exception {
		Producto data;
		DAOProducto daos = new DAOProducto();
		try {
			////// Transacción
			this.conn = darConexion();
			daos.setConn(conn);
			data = daos.get(id);
			if (data == null)
				throw new RotondAndesException("El producto con el id:<" + id + ">no existe");
		} catch (SQLException e) {
			System.err.println("SQLException:" + e.getMessage());
			e.printStackTrace();
			throw e;
		} catch (Exception e) {
			System.err.println("GeneralException:" + e.getMessage());
			e.printStackTrace();
			throw e;
		} finally {
			try {
				daos.cerrarRecursos();
				if (this.conn != null)
					this.conn.close();
			} catch (SQLException exception) {
				System.err.println("SQLException closing resources:" + exception.getMessage());
				exception.printStackTrace();
				throw exception;
			}
		}
		return data;
	}

	public void addProducto(Producto data) throws RotondAndesException, Exception {
		DAOProducto daos = new DAOProducto();
		try {
			////// Transacción
			this.conn = darConexion();
			daos.setConn(conn);
			if (daos.get(data.getId()) != null)
				throw new RotondAndesException("El producto con el id <" + data.getId() + "> ya existe");
			daos.add(data);
			conn.commit();

		} catch (SQLException e) {
			System.err.println("SQLException:" + e.getMessage());
			e.printStackTrace();
			throw e;
		} catch (Exception e) {
			System.err.println("GeneralException:" + e.getMessage());
			e.printStackTrace();
			throw e;
		} finally {
			try {
				daos.cerrarRecursos();
				if (this.conn != null)
					this.conn.close();
			} catch (SQLException exception) {
				System.err.println("SQLException closing resources:" + exception.getMessage());
				exception.printStackTrace();
				throw exception;
			}
		}
	}

	public void updateProducto(Producto data) throws RotondAndesException, Exception {
		DAOProducto daos = new DAOProducto();
		try {
			////// Transacción
			this.conn = darConexion();
			daos.setConn(conn);
			if (daos.get(data.getId()) == null)
				throw new RotondAndesException("Ya existe un producto con el <" + data.getId() + ">");
			daos.update(data);

		} catch (SQLException e) {
			System.err.println("SQLException:" + e.getMessage());
			e.printStackTrace();
			throw e;
		} catch (Exception e) {
			System.err.println("GeneralException:" + e.getMessage());
			e.printStackTrace();
			throw e;
		} finally {
			try {
				daos.cerrarRecursos();
				if (this.conn != null)
					this.conn.close();
			} catch (SQLException exception) {
				System.err.println("SQLException closing resources:" + exception.getMessage());
				exception.printStackTrace();
				throw exception;
			}
		}
	}

	public void deleteProducto(Producto data) throws RotondAndesException, Exception {
		DAOProducto daos = new DAOProducto();
		try {
			////// Transacción
			this.conn = darConexion();
			daos.setConn(conn);
			if (daos.get(data.getId()) == null)
				throw new RotondAndesException("No existe un producto con el id<" + data.getId() + ">");
			daos.delete(data);

		} catch (SQLException e) {
			System.err.println("SQLException:" + e.getMessage());
			e.printStackTrace();
			throw e;
		} catch (Exception e) {
			System.err.println("GeneralException:" + e.getMessage());
			e.printStackTrace();
			throw e;
		} finally {
			try {
				daos.cerrarRecursos();
				if (this.conn != null)
					this.conn.close();
			} catch (SQLException exception) {
				System.err.println("SQLException closing resources:" + exception.getMessage());
				exception.printStackTrace();
				throw exception;
			}
		}
	}

	public List<Ingrediente> getAllIngrediente() throws SQLException, Exception {
		List<Ingrediente> data;
		DAOIngrediente daos = new DAOIngrediente();
		try {
			////// Transacción
			this.conn = darConexion();
			daos.setConn(conn);
			data = daos.getAll();
		} catch (SQLException e) {
			System.err.println("SQLException:" + e.getMessage());
			e.printStackTrace();
			throw e;
		} catch (Exception e) {
			System.err.println("GeneralException:" + e.getMessage());
			e.printStackTrace();
			throw e;
		} finally {
			try {
				daos.cerrarRecursos();
				if (this.conn != null)
					this.conn.close();
			} catch (SQLException exception) {
				System.err.println("SQLException closing resources:" + exception.getMessage());
				exception.printStackTrace();
				throw exception;
			}
		}
		return data;
	}

	public Ingrediente getIngrediente(long id) throws RotondAndesException, Exception {
		Ingrediente data;
		DAOIngrediente daos = new DAOIngrediente();
		try {
			////// Transacción
			this.conn = darConexion();
			daos.setConn(conn);
			data = daos.get(id);
			if (data == null)
				throw new RotondAndesException("El ingrediente con el id:<" + id + ">no existe");
		} catch (SQLException e) {
			System.err.println("SQLException:" + e.getMessage());
			e.printStackTrace();
			throw e;
		} catch (Exception e) {
			System.err.println("GeneralException:" + e.getMessage());
			e.printStackTrace();
			throw e;
		} finally {
			try {
				daos.cerrarRecursos();
				if (this.conn != null)
					this.conn.close();
			} catch (SQLException exception) {
				System.err.println("SQLException closing resources:" + exception.getMessage());
				exception.printStackTrace();
				throw exception;
			}
		}
		return data;
	}

	public void addIngrediente(Ingrediente data) throws RotondAndesException, Exception {
		DAOIngrediente daos = new DAOIngrediente();
		try {
			////// Transacción
			this.conn = darConexion();
			daos.setConn(conn);
			if (daos.get(data.getId()) != null)
				throw new RotondAndesException("El ingrediente con el id <" + data.getId() + "> ya existe");
			daos.add(data);
			conn.commit();

		} catch (SQLException e) {
			System.err.println("SQLException:" + e.getMessage());
			e.printStackTrace();
			throw e;
		} catch (Exception e) {
			System.err.println("GeneralException:" + e.getMessage());
			e.printStackTrace();
			throw e;
		} finally {
			try {
				daos.cerrarRecursos();
				if (this.conn != null)
					this.conn.close();
			} catch (SQLException exception) {
				System.err.println("SQLException closing resources:" + exception.getMessage());
				exception.printStackTrace();
				throw exception;
			}
		}
	}

	public void updateIngrediente(Ingrediente data) throws RotondAndesException, Exception {
		DAOIngrediente daos = new DAOIngrediente();
		try {
			////// Transacción
			this.conn = darConexion();
			daos.setConn(conn);
			if (daos.get(data.getId()) == null)
				throw new RotondAndesException("Ya existe un ingrediente con el <" + data.getId() + ">");
			daos.update(data);

		} catch (SQLException e) {
			System.err.println("SQLException:" + e.getMessage());
			e.printStackTrace();
			throw e;
		} catch (Exception e) {
			System.err.println("GeneralException:" + e.getMessage());
			e.printStackTrace();
			throw e;
		} finally {
			try {
				daos.cerrarRecursos();
				if (this.conn != null)
					this.conn.close();
			} catch (SQLException exception) {
				System.err.println("SQLException closing resources:" + exception.getMessage());
				exception.printStackTrace();
				throw exception;
			}
		}
	}

	public void deleteIngrediente(Ingrediente data) throws RotondAndesException, Exception {
		DAOIngrediente daos = new DAOIngrediente();
		try {
			////// Transacción
			this.conn = darConexion();
			daos.setConn(conn);
			if (daos.get(data.getId()) == null)
				throw new RotondAndesException("No existe un ingrediente con el id<" + data.getId() + ">");
			daos.delete(data);

		} catch (SQLException e) {
			System.err.println("SQLException:" + e.getMessage());
			e.printStackTrace();
			throw e;
		} catch (Exception e) {
			System.err.println("GeneralException:" + e.getMessage());
			e.printStackTrace();
			throw e;
		} finally {
			try {
				daos.cerrarRecursos();
				if (this.conn != null)
					this.conn.close();
			} catch (SQLException exception) {
				System.err.println("SQLException closing resources:" + exception.getMessage());
				exception.printStackTrace();
				throw exception;
			}
		}
	}

	public List<Menu> getAllMenu() throws SQLException, Exception {
		List<Menu> data;
		DAOMenu daos = new DAOMenu();
		try {
			////// Transacción
			this.conn = darConexion();
			daos.setConn(conn);
			data = daos.getAll();
		} catch (SQLException e) {
			System.err.println("SQLException:" + e.getMessage());
			e.printStackTrace();
			throw e;
		} catch (Exception e) {
			System.err.println("GeneralException:" + e.getMessage());
			e.printStackTrace();
			throw e;
		} finally {
			try {
				daos.cerrarRecursos();
				if (this.conn != null)
					this.conn.close();
			} catch (SQLException exception) {
				System.err.println("SQLException closing resources:" + exception.getMessage());
				exception.printStackTrace();
				throw exception;
			}
		}
		return data;
	}

	public Menu getMenu(long id) throws RotondAndesException, Exception {
		Menu data;
		DAOMenu daos = new DAOMenu();
		try {
			////// Transacción
			this.conn = darConexion();
			daos.setConn(conn);
			data = daos.get(id);
			if (data == null)
				throw new RotondAndesException("El menu con el id:<" + id + ">no existe");
		} catch (SQLException e) {
			System.err.println("SQLException:" + e.getMessage());
			e.printStackTrace();
			throw e;
		} catch (Exception e) {
			System.err.println("GeneralException:" + e.getMessage());
			e.printStackTrace();
			throw e;
		} finally {
			try {
				daos.cerrarRecursos();
				if (this.conn != null)
					this.conn.close();
			} catch (SQLException exception) {
				System.err.println("SQLException closing resources:" + exception.getMessage());
				exception.printStackTrace();
				throw exception;
			}
		}
		return data;
	}

	public void addMenu(Menu data) throws RotondAndesException, Exception {
		DAOMenu daos = new DAOMenu();
		try {
			////// Transacción
			this.conn = darConexion();
			daos.setConn(conn);
			if (daos.get(data.getId()) != null)
				throw new RotondAndesException("El menu con el id <" + data.getId() + "> ya existe");
			daos.add(data);
			conn.commit();

		} catch (SQLException e) {
			System.err.println("SQLException:" + e.getMessage());
			e.printStackTrace();
			throw e;
		} catch (Exception e) {
			System.err.println("GeneralException:" + e.getMessage());
			e.printStackTrace();
			throw e;
		} finally {
			try {
				daos.cerrarRecursos();
				if (this.conn != null)
					this.conn.close();
			} catch (SQLException exception) {
				System.err.println("SQLException closing resources:" + exception.getMessage());
				exception.printStackTrace();
				throw exception;
			}
		}
	}

	public void updateMenu(Menu data) throws RotondAndesException, Exception {
		DAOMenu daos = new DAOMenu();
		try {
			////// Transacción
			this.conn = darConexion();
			daos.setConn(conn);
			if (daos.get(data.getId()) == null)
				throw new RotondAndesException("Ya existe un menu con el <" + data.getId() + ">");
			daos.update(data);

		} catch (SQLException e) {
			System.err.println("SQLException:" + e.getMessage());
			e.printStackTrace();
			throw e;
		} catch (Exception e) {
			System.err.println("GeneralException:" + e.getMessage());
			e.printStackTrace();
			throw e;
		} finally {
			try {
				daos.cerrarRecursos();
				if (this.conn != null)
					this.conn.close();
			} catch (SQLException exception) {
				System.err.println("SQLException closing resources:" + exception.getMessage());
				exception.printStackTrace();
				throw exception;
			}
		}
	}

	public void deleteMenu(Menu data) throws RotondAndesException, Exception {
		DAOMenu daos = new DAOMenu();
		try {
			////// Transacción
			this.conn = darConexion();
			daos.setConn(conn);
			if (daos.get(data.getId()) == null)
				throw new RotondAndesException("No existe un menu con el id<" + data.getId() + ">");
			daos.delete(data);

		} catch (SQLException e) {
			System.err.println("SQLException:" + e.getMessage());
			e.printStackTrace();
			throw e;
		} catch (Exception e) {
			System.err.println("GeneralException:" + e.getMessage());
			e.printStackTrace();
			throw e;
		} finally {
			try {
				daos.cerrarRecursos();
				if (this.conn != null)
					this.conn.close();
			} catch (SQLException exception) {
				System.err.println("SQLException closing resources:" + exception.getMessage());
				exception.printStackTrace();
				throw exception;
			}
		}
	}

	public List<Zona> getAllZona() throws SQLException, Exception {
		List<Zona> data;
		DAOZona daos = new DAOZona();
		try {
			////// Transacción
			this.conn = darConexion();
			daos.setConn(conn);
			data = daos.getAll();
		} catch (SQLException e) {
			System.err.println("SQLException:" + e.getMessage());
			e.printStackTrace();
			throw e;
		} catch (Exception e) {
			System.err.println("GeneralException:" + e.getMessage());
			e.printStackTrace();
			throw e;
		} finally {
			try {
				daos.cerrarRecursos();
				if (this.conn != null)
					this.conn.close();
			} catch (SQLException exception) {
				System.err.println("SQLException closing resources:" + exception.getMessage());
				exception.printStackTrace();
				throw exception;
			}
		}
		return data;
	}

	public Zona getZona(long id) throws RotondAndesException, Exception {
		Zona data;
		DAOZona daos = new DAOZona();
		try {
			////// Transacción
			this.conn = darConexion();
			daos.setConn(conn);
			data = daos.get(id);
			if (data == null)
				throw new RotondAndesException("La zona con el id:<" + id + ">no existe");
		} catch (SQLException e) {
			System.err.println("SQLException:" + e.getMessage());
			e.printStackTrace();
			throw e;
		} catch (Exception e) {
			System.err.println("GeneralException:" + e.getMessage());
			e.printStackTrace();
			throw e;
		} finally {
			try {
				daos.cerrarRecursos();
				if (this.conn != null)
					this.conn.close();
			} catch (SQLException exception) {
				System.err.println("SQLException closing resources:" + exception.getMessage());
				exception.printStackTrace();
				throw exception;
			}
		}
		return data;
	}

	public void addZona(Zona data) throws RotondAndesException, Exception {
		DAOZona daos = new DAOZona();
		try {
			////// Transacción
			this.conn = darConexion();
			daos.setConn(conn);
			if (daos.get(data.getId()) != null)
				throw new RotondAndesException("La zona con el id <" + data.getId() + "> ya existe");
			daos.add(data);
			conn.commit();

		} catch (SQLException e) {
			System.err.println("SQLException:" + e.getMessage());
			e.printStackTrace();
			throw e;
		} catch (Exception e) {
			System.err.println("GeneralException:" + e.getMessage());
			e.printStackTrace();
			throw e;
		} finally {
			try {
				daos.cerrarRecursos();
				if (this.conn != null)
					this.conn.close();
			} catch (SQLException exception) {
				System.err.println("SQLException closing resources:" + exception.getMessage());
				exception.printStackTrace();
				throw exception;
			}
		}
	}

	public void updateZona(Zona data) throws RotondAndesException, Exception {
		DAOZona daos = new DAOZona();
		try {
			////// Transacción
			this.conn = darConexion();
			daos.setConn(conn);
			if (daos.get(data.getId()) == null)
				throw new RotondAndesException("Ya existe una zona con el <" + data.getId() + ">");
			daos.update(data);

		} catch (SQLException e) {
			System.err.println("SQLException:" + e.getMessage());
			e.printStackTrace();
			throw e;
		} catch (Exception e) {
			System.err.println("GeneralException:" + e.getMessage());
			e.printStackTrace();
			throw e;
		} finally {
			try {
				daos.cerrarRecursos();
				if (this.conn != null)
					this.conn.close();
			} catch (SQLException exception) {
				System.err.println("SQLException closing resources:" + exception.getMessage());
				exception.printStackTrace();
				throw exception;
			}
		}
	}

	public void deleteZona(Zona data) throws RotondAndesException, Exception {
		DAOZona daos = new DAOZona();
		try {
			////// Transacción
			this.conn = darConexion();
			daos.setConn(conn);
			if (daos.get(data.getId()) == null)
				throw new RotondAndesException("No existe una zona con el id<" + data.getId() + ">");
			daos.delete(data);

		} catch (SQLException e) {
			System.err.println("SQLException:" + e.getMessage());
			e.printStackTrace();
			throw e;
		} catch (Exception e) {
			System.err.println("GeneralException:" + e.getMessage());
			e.printStackTrace();
			throw e;
		} finally {
			try {
				daos.cerrarRecursos();
				if (this.conn != null)
					this.conn.close();
			} catch (SQLException exception) {
				System.err.println("SQLException closing resources:" + exception.getMessage());
				exception.printStackTrace();
				throw exception;
			}
		}
	}

	public List<Preferencias> getAllPreferencias() throws SQLException, Exception {
		List<Preferencias> data;
		DAOPreferencias daos = new DAOPreferencias();
		try {
			////// Transacción
			this.conn = darConexion();
			daos.setConn(conn);
			data = daos.getAll();
		} catch (SQLException e) {
			System.err.println("SQLException:" + e.getMessage());
			e.printStackTrace();
			throw e;
		} catch (Exception e) {
			System.err.println("GeneralException:" + e.getMessage());
			e.printStackTrace();
			throw e;
		} finally {
			try {
				daos.cerrarRecursos();
				if (this.conn != null)
					this.conn.close();
			} catch (SQLException exception) {
				System.err.println("SQLException closing resources:" + exception.getMessage());
				exception.printStackTrace();
				throw exception;
			}
		}
		return data;
	}

	public Preferencias getPreferencias(long id) throws RotondAndesException, Exception {
		Preferencias data;
		DAOPreferencias daos = new DAOPreferencias();
		try {
			////// Transacción
			this.conn = darConexion();
			daos.setConn(conn);
			data = daos.get(id);
			if (data == null)
				throw new RotondAndesException("La preferencia con el id:<" + id + ">no existe");
		} catch (SQLException e) {
			System.err.println("SQLException:" + e.getMessage());
			e.printStackTrace();
			throw e;
		} catch (Exception e) {
			System.err.println("GeneralException:" + e.getMessage());
			e.printStackTrace();
			throw e;
		} finally {
			try {
				daos.cerrarRecursos();
				if (this.conn != null)
					this.conn.close();
			} catch (SQLException exception) {
				System.err.println("SQLException closing resources:" + exception.getMessage());
				exception.printStackTrace();
				throw exception;
			}
		}
		return data;
	}

	
	public void addPreferencias(Preferencias data) throws RotondAndesException, Exception {
		DAOPreferencias daos = new DAOPreferencias();
		try {
			////// Transacción
			this.conn = darConexion();
			daos.setConn(conn);
			if (daos.get(data.getId()) != null)
				throw new RotondAndesException("La preferencia con el id <" + data.getId() + "> ya existe");
			daos.add(data);
			conn.commit();

		} catch (SQLException e) {
			System.err.println("SQLException:" + e.getMessage());
			e.printStackTrace();
			throw e;
		} catch (Exception e) {
			System.err.println("GeneralException:" + e.getMessage());
			e.printStackTrace();
			throw e;
		} finally {
			try {
				daos.cerrarRecursos();
				if (this.conn != null)
					this.conn.close();
			} catch (SQLException exception) {
				System.err.println("SQLException closing resources:" + exception.getMessage());
				exception.printStackTrace();
				throw exception;
			}
		}
	}

	public void updatePreferencias(Preferencias data) throws RotondAndesException, Exception {
		DAOPreferencias daos = new DAOPreferencias();
		try {
			////// Transacción
			this.conn = darConexion();
			daos.setConn(conn);
			if (daos.get(data.getId()) == null)
				throw new RotondAndesException("Ya existe una preferencia con el <" + data.getId() + ">");
			daos.update(data);

		} catch (SQLException e) {
			System.err.println("SQLException:" + e.getMessage());
			e.printStackTrace();
			throw e;
		} catch (Exception e) {
			System.err.println("GeneralException:" + e.getMessage());
			e.printStackTrace();
			throw e;
		} finally {
			try {
				daos.cerrarRecursos();
				if (this.conn != null)
					this.conn.close();
			} catch (SQLException exception) {
				System.err.println("SQLException closing resources:" + exception.getMessage());
				exception.printStackTrace();
				throw exception;
			}
		}
	}

	public void deletePreferencias(Preferencias data) throws RotondAndesException, Exception {
		DAOPreferencias daos = new DAOPreferencias();
		try {
			////// Transacción
			this.conn = darConexion();
			daos.setConn(conn);
			if (daos.get(data.getId()) == null)
				throw new RotondAndesException("No existe una preferencia con el id<" + data.getId() + ">");
			daos.delete(data);

		} catch (SQLException e) {
			System.err.println("SQLException:" + e.getMessage());
			e.printStackTrace();
			throw e;
		} catch (Exception e) {
			System.err.println("GeneralException:" + e.getMessage());
			e.printStackTrace();
			throw e;
		} finally {
			try {
				daos.cerrarRecursos();
				if (this.conn != null)
					this.conn.close();
			} catch (SQLException exception) {
				System.err.println("SQLException closing resources:" + exception.getMessage());
				exception.printStackTrace();
				throw exception;
			}
		}
	}

	public List<TipoComida> getAllTipoComida() throws SQLException, Exception {
		List<TipoComida> data;
		DAOTipoComida daos = new DAOTipoComida();
		try {
			////// Transacción
			this.conn = darConexion();
			daos.setConn(conn);
			data = daos.getAll();
		} catch (SQLException e) {
			System.err.println("SQLException:" + e.getMessage());
			e.printStackTrace();
			throw e;
		} catch (Exception e) {
			System.err.println("GeneralException:" + e.getMessage());
			e.printStackTrace();
			throw e;
		} finally {
			try {
				daos.cerrarRecursos();
				if (this.conn != null)
					this.conn.close();
			} catch (SQLException exception) {
				System.err.println("SQLException closing resources:" + exception.getMessage());
				exception.printStackTrace();
				throw exception;
			}
		}
		return data;
	}

	public TipoComida getTipoComida(long id) throws RotondAndesException, Exception {
		TipoComida data;
		DAOTipoComida daos = new DAOTipoComida();
		try {
			////// Transacción
			this.conn = darConexion();
			daos.setConn(conn);
			data = daos.get(id);
			if (data == null)
				throw new RotondAndesException("El pedido con el id:<" + id + ">no existe");
		} catch (SQLException e) {
			System.err.println("SQLException:" + e.getMessage());
			e.printStackTrace();
			throw e;
		} catch (Exception e) {
			System.err.println("GeneralException:" + e.getMessage());
			e.printStackTrace();
			throw e;
		} finally {
			try {
				daos.cerrarRecursos();
				if (this.conn != null)
					this.conn.close();
			} catch (SQLException exception) {
				System.err.println("SQLException closing resources:" + exception.getMessage());
				exception.printStackTrace();
				throw exception;
			}
		}
		return data;
	}

	public void addTipoComida(TipoComida data) throws RotondAndesException, Exception {
		DAOTipoComida daos = new DAOTipoComida();
		try {
			////// Transacción
			this.conn = darConexion();
			daos.setConn(conn);
			if (daos.get(data.getId()) != null)
				throw new RotondAndesException("El pedido con el id <" + data.getId() + "> ya existe");
			daos.add(data);
			conn.commit();

		} catch (SQLException e) {
			System.err.println("SQLException:" + e.getMessage());
			e.printStackTrace();
			throw e;
		} catch (Exception e) {
			System.err.println("GeneralException:" + e.getMessage());
			e.printStackTrace();
			throw e;
		} finally {
			try {
				daos.cerrarRecursos();
				if (this.conn != null)
					this.conn.close();
			} catch (SQLException exception) {
				System.err.println("SQLException closing resources:" + exception.getMessage());
				exception.printStackTrace();
				throw exception;
			}
		}
	}

	public void updateTipoComida(TipoComida data) throws RotondAndesException, Exception {
		DAOTipoComida daos = new DAOTipoComida();
		try {
			////// Transacción
			this.conn = darConexion();
			daos.setConn(conn);
			if (daos.get(data.getId()) == null)
				throw new RotondAndesException("Ya existe un pedido con el <" + data.getId() + ">");
			daos.update(data);

		} catch (SQLException e) {
			System.err.println("SQLException:" + e.getMessage());
			e.printStackTrace();
			throw e;
		} catch (Exception e) {
			System.err.println("GeneralException:" + e.getMessage());
			e.printStackTrace();
			throw e;
		} finally {
			try {
				daos.cerrarRecursos();
				if (this.conn != null)
					this.conn.close();
			} catch (SQLException exception) {
				System.err.println("SQLException closing resources:" + exception.getMessage());
				exception.printStackTrace();
				throw exception;
			}
		}
	}

	public void deleteTipoComida(TipoComida data) throws RotondAndesException, Exception {
		DAOTipoComida daos = new DAOTipoComida();
		try {
			////// Transacción
			this.conn = darConexion();
			daos.setConn(conn);
			if (daos.get(data.getId()) == null)
				throw new RotondAndesException("No existe un pedido con el id<" + data.getId() + ">");
			daos.delete(data);

		} catch (SQLException e) {
			System.err.println("SQLException:" + e.getMessage());
			e.printStackTrace();
			throw e;
		} catch (Exception e) {
			System.err.println("GeneralException:" + e.getMessage());
			e.printStackTrace();
			throw e;
		} finally {
			try {
				daos.cerrarRecursos();
				if (this.conn != null)
					this.conn.close();
			} catch (SQLException exception) {
				System.err.println("SQLException closing resources:" + exception.getMessage());
				exception.printStackTrace();
				throw exception;
			}
		}
	}
	
	public List<Pedido> getAllPedido() throws SQLException, Exception {
		List<Pedido> data;
		DAOPedido daos = new DAOPedido();
		try {
			////// Transacción
			this.conn = darConexion();
			daos.setConn(conn);
			data = daos.getAll();
		} catch (SQLException e) {
			System.err.println("SQLException:" + e.getMessage());
			e.printStackTrace();
			throw e;
		} catch (Exception e) {
			System.err.println("GeneralException:" + e.getMessage());
			e.printStackTrace();
			throw e;
		} finally {
			try {
				daos.cerrarRecursos();
				if (this.conn != null)
					this.conn.close();
			} catch (SQLException exception) {
				System.err.println("SQLException closing resources:" + exception.getMessage());
				exception.printStackTrace();
				throw exception;
			}
		}
		return data;
	}

	public Pedido getPedido(long id) throws RotondAndesException, Exception {
		Pedido data;
		DAOPedido daos = new DAOPedido();
		try {
			////// Transacción
			this.conn = darConexion();
			daos.setConn(conn);
			data = daos.get(id);
			if (data == null)
				throw new RotondAndesException("El pedido con el id:<" + id + ">no existe");
		} catch (SQLException e) {
			System.err.println("SQLException:" + e.getMessage());
			e.printStackTrace();
			throw e;
		} catch (Exception e) {
			System.err.println("GeneralException:" + e.getMessage());
			e.printStackTrace();
			throw e;
		} finally {
			try {
				daos.cerrarRecursos();
				if (this.conn != null)
					this.conn.close();
			} catch (SQLException exception) {
				System.err.println("SQLException closing resources:" + exception.getMessage());
				exception.printStackTrace();
				throw exception;
			}
		}
		return data;
	}

	public void addPedido(Pedido data) throws RotondAndesException, Exception {
		DAOPedido daos = new DAOPedido();
		try {
			////// Transacción
			this.conn = darConexion();
			daos.setConn(conn);
			if (daos.get(data.getId()) != null)
				throw new RotondAndesException("El pedido con el id <" + data.getId() + "> ya existe");
			daos.add(data);
			conn.commit();

		} catch (SQLException e) {
			System.err.println("SQLException:" + e.getMessage());
			e.printStackTrace();
			throw e;
		} catch (Exception e) {
			System.err.println("GeneralException:" + e.getMessage());
			e.printStackTrace();
			throw e;
		} finally {
			try {
				daos.cerrarRecursos();
				if (this.conn != null)
					this.conn.close();
			} catch (SQLException exception) {
				System.err.println("SQLException closing resources:" + exception.getMessage());
				exception.printStackTrace();
				throw exception;
			}
		}
	}

	public void updatePedido(Pedido data) throws RotondAndesException, Exception {
		DAOPedido daos = new DAOPedido();
		try {
			////// Transacción
			this.conn = darConexion();
			daos.setConn(conn);
			if (daos.get(data.getId()) == null)
				throw new RotondAndesException("Ya existe un pedido con el <" + data.getId() + ">");
			daos.update(data);

		} catch (SQLException e) {
			System.err.println("SQLException:" + e.getMessage());
			e.printStackTrace();
			throw e;
		} catch (Exception e) {
			System.err.println("GeneralException:" + e.getMessage());
			e.printStackTrace();
			throw e;
		} finally {
			try {
				daos.cerrarRecursos();
				if (this.conn != null)
					this.conn.close();
			} catch (SQLException exception) {
				System.err.println("SQLException closing resources:" + exception.getMessage());
				exception.printStackTrace();
				throw exception;
			}
		}
	}

	public void deletePedido(Pedido data) throws RotondAndesException, Exception {
		DAOPedido daos = new DAOPedido();
		try {
			////// Transacción
			this.conn = darConexion();
			daos.setConn(conn);
			if (daos.get(data.getId()) == null)
				throw new RotondAndesException("No existe un pedido con el id<" + data.getId() + ">");
			daos.delete(data);

		} catch (SQLException e) {
			System.err.println("SQLException:" + e.getMessage());
			e.printStackTrace();
			throw e;
		} catch (Exception e) {
			System.err.println("GeneralException:" + e.getMessage());
			e.printStackTrace();
			throw e;
		} finally {
			try {
				daos.cerrarRecursos();
				if (this.conn != null)
					this.conn.close();
			} catch (SQLException exception) {
				System.err.println("SQLException closing resources:" + exception.getMessage());
				exception.printStackTrace();
				throw exception;
			}
		}
	}
	
	public List<Reserva> getAllReserva() throws SQLException, Exception {
		List<Reserva> data;
		DAOReserva daos = new DAOReserva();
		try {
			////// Transacción
			this.conn = darConexion();
			daos.setConn(conn);
			data = daos.getAll();
		} catch (SQLException e) {
			System.err.println("SQLException:" + e.getMessage());
			e.printStackTrace();
			throw e;
		} catch (Exception e) {
			System.err.println("GeneralException:" + e.getMessage());
			e.printStackTrace();
			throw e;
		} finally {
			try {
				daos.cerrarRecursos();
				if (this.conn != null)
					this.conn.close();
			} catch (SQLException exception) {
				System.err.println("SQLException closing resources:" + exception.getMessage());
				exception.printStackTrace();
				throw exception;
			}
		}
		return data;
	}

	public Reserva getReserva(long id) throws RotondAndesException, Exception {
		Reserva data;
		DAOReserva daos = new DAOReserva();
		try {
			////// Transacción
			this.conn = darConexion();
			daos.setConn(conn);
			data = daos.get(id);
			if (data == null)
				throw new RotondAndesException("La reserva con el id:<" + id + ">no existe");
		} catch (SQLException e) {
			System.err.println("SQLException:" + e.getMessage());
			e.printStackTrace();
			throw e;
		} catch (Exception e) {
			System.err.println("GeneralException:" + e.getMessage());
			e.printStackTrace();
			throw e;
		} finally {
			try {
				daos.cerrarRecursos();
				if (this.conn != null)
					this.conn.close();
			} catch (SQLException exception) {
				System.err.println("SQLException closing resources:" + exception.getMessage());
				exception.printStackTrace();
				throw exception;
			}
		}
		return data;
	}

	public void addReserva(Reserva data) throws RotondAndesException, Exception {
		DAOReserva daos = new DAOReserva();
		try {
			////// Transacción
			this.conn = darConexion();
			daos.setConn(conn);
			if (daos.get(data.getId()) != null)
				throw new RotondAndesException("La reserva con el id <" + data.getId() + "> ya existe");
			daos.add(data);
			conn.commit();

		} catch (SQLException e) {
			System.err.println("SQLException:" + e.getMessage());
			e.printStackTrace();
			throw e;
		} catch (Exception e) {
			System.err.println("GeneralException:" + e.getMessage());
			e.printStackTrace();
			throw e;
		} finally {
			try {
				daos.cerrarRecursos();
				if (this.conn != null)
					this.conn.close();
			} catch (SQLException exception) {
				System.err.println("SQLException closing resources:" + exception.getMessage());
				exception.printStackTrace();
				throw exception;
			}
		}
	}

	public void updateReserva(Reserva data) throws RotondAndesException, Exception {
		DAOReserva daos = new DAOReserva();
		try {
			////// Transacción
			this.conn = darConexion();
			daos.setConn(conn);
			if (daos.get(data.getId()) == null)
				throw new RotondAndesException("Ya existe una reserva con el <" + data.getId() + ">");
			daos.update(data);

		} catch (SQLException e) {
			System.err.println("SQLException:" + e.getMessage());
			e.printStackTrace();
			throw e;
		} catch (Exception e) {
			System.err.println("GeneralException:" + e.getMessage());
			e.printStackTrace();
			throw e;
		} finally {
			try {
				daos.cerrarRecursos();
				if (this.conn != null)
					this.conn.close();
			} catch (SQLException exception) {
				System.err.println("SQLException closing resources:" + exception.getMessage());
				exception.printStackTrace();
				throw exception;
			}
		}
	}

	public void deleteReserva(Reserva data) throws RotondAndesException, Exception {
		DAOReserva daos = new DAOReserva();
		try {
			////// Transacción
			this.conn = darConexion();
			daos.setConn(conn);
			if (daos.get(data.getId()) == null)
				throw new RotondAndesException("No existe una reserva con el id<" + data.getId() + ">");
			daos.delete(data);

		} catch (SQLException e) {
			System.err.println("SQLException:" + e.getMessage());
			e.printStackTrace();
			throw e;
		} catch (Exception e) {
			System.err.println("GeneralException:" + e.getMessage());
			e.printStackTrace();
			throw e;
		} finally {
			try {
				daos.cerrarRecursos();
				if (this.conn != null)
					this.conn.close();
			} catch (SQLException exception) {
				System.err.println("SQLException closing resources:" + exception.getMessage());
				exception.printStackTrace();
				throw exception;
			}
		}
	}
	
	public List<Representante> getAllRepresentate() throws SQLException, Exception {
		List<Representante> data;
		DAORepresentante daos = new DAORepresentante();
		try {
			////// Transacción
			this.conn = darConexion();
			daos.setConn(conn);
			data = daos.getAll();
		} catch (SQLException e) {
			System.err.println("SQLException:" + e.getMessage());
			e.printStackTrace();
			throw e;
		} catch (Exception e) {
			System.err.println("GeneralException:" + e.getMessage());
			e.printStackTrace();
			throw e;
		} finally {
			try {
				daos.cerrarRecursos();
				if (this.conn != null)
					this.conn.close();
			} catch (SQLException exception) {
				System.err.println("SQLException closing resources:" + exception.getMessage());
				exception.printStackTrace();
				throw exception;
			}
		}
		return data;
	}

	public Representante getRepresentante(long id) throws RotondAndesException, Exception {
		Representante data;
		DAORepresentante daos = new DAORepresentante();
		try {
			////// Transacción
			this.conn = darConexion();
			daos.setConn(conn);
			data = daos.get(id);
			if (data == null)
				throw new RotondAndesException("El espacio con el id:<" + id + ">no existe");
		} catch (SQLException e) {
			System.err.println("SQLException:" + e.getMessage());
			e.printStackTrace();
			throw e;
		} catch (Exception e) {
			System.err.println("GeneralException:" + e.getMessage());
			e.printStackTrace();
			throw e;
		} finally {
			try {
				daos.cerrarRecursos();
				if (this.conn != null)
					this.conn.close();
			} catch (SQLException exception) {
				System.err.println("SQLException closing resources:" + exception.getMessage());
				exception.printStackTrace();
				throw exception;
			}
		}
		return data;
	}

	public void addRepresentante(Representante data) throws RotondAndesException, Exception {
		DAORepresentante daos = new DAORepresentante();
		try {
			////// Transacción
			this.conn = darConexion();
			daos.setConn(conn);
			if (daos.get(data.getId()) != null)
				throw new RotondAndesException("El espacio con el id <" + data.getId() + "> ya existe");
			daos.add(data);
			conn.commit();

		} catch (SQLException e) {
			System.err.println("SQLException:" + e.getMessage());
			e.printStackTrace();
			throw e;
		} catch (Exception e) {
			System.err.println("GeneralException:" + e.getMessage());
			e.printStackTrace();
			throw e;
		} finally {
			try {
				daos.cerrarRecursos();
				if (this.conn != null)
					this.conn.close();
			} catch (SQLException exception) {
				System.err.println("SQLException closing resources:" + exception.getMessage());
				exception.printStackTrace();
				throw exception;
			}
		}
	}

	public void updateRepresentante(Representante data) throws RotondAndesException, Exception {
		DAORepresentante daos = new DAORepresentante();
		try {
			////// Transacción
			this.conn = darConexion();
			daos.setConn(conn);
			if (daos.get(data.getId()) == null)
				throw new RotondAndesException("Ya existe un espacio con el <" + data.getId() + ">");
			daos.update(data);

		} catch (SQLException e) {
			System.err.println("SQLException:" + e.getMessage());
			e.printStackTrace();
			throw e;
		} catch (Exception e) {
			System.err.println("GeneralException:" + e.getMessage());
			e.printStackTrace();
			throw e;
		} finally {
			try {
				daos.cerrarRecursos();
				if (this.conn != null)
					this.conn.close();
			} catch (SQLException exception) {
				System.err.println("SQLException closing resources:" + exception.getMessage());
				exception.printStackTrace();
				throw exception;
			}
		}
	}

	public void deleteRepresentante(Representante data) throws RotondAndesException, Exception {
		DAORepresentante daos = new DAORepresentante();
		try {
			////// Transacción
			this.conn = darConexion();
			daos.setConn(conn);
			if (daos.get(data.getId()) == null)
				throw new RotondAndesException("No existe un espacio con el id<" + data.getId() + ">");
			daos.delete(data);

		} catch (SQLException e) {
			System.err.println("SQLException:" + e.getMessage());
			e.printStackTrace();
			throw e;
		} catch (Exception e) {
			System.err.println("GeneralException:" + e.getMessage());
			e.printStackTrace();
			throw e;
		} finally {
			try {
				daos.cerrarRecursos();
				if (this.conn != null)
					this.conn.close();
			} catch (SQLException exception) {
				System.err.println("SQLException closing resources:" + exception.getMessage());
				exception.printStackTrace();
				throw exception;
			}
		}
	}
	
	public List<Espacio> getAllEspacio() throws SQLException, Exception {
		List<Espacio> data;
		DAOEspacio daos = new DAOEspacio();
		try {
			////// Transacción
			this.conn = darConexion();
			daos.setConn(conn);
			data = daos.getAll();
		} catch (SQLException e) {
			System.err.println("SQLException:" + e.getMessage());
			e.printStackTrace();
			throw e;
		} catch (Exception e) {
			System.err.println("GeneralException:" + e.getMessage());
			e.printStackTrace();
			throw e;
		} finally {
			try {
				daos.cerrarRecursos();
				if (this.conn != null)
					this.conn.close();
			} catch (SQLException exception) {
				System.err.println("SQLException closing resources:" + exception.getMessage());
				exception.printStackTrace();
				throw exception;
			}
		}
		return data;
	}

	public Espacio getEspacio(long id) throws RotondAndesException, Exception {
		Espacio data;
		DAOEspacio daos = new DAOEspacio();
		try {
			////// Transacción
			this.conn = darConexion();
			daos.setConn(conn);
			data = daos.get(id);
			if (data == null)
				throw new RotondAndesException("El espacio con el id:<" + id + ">no existe");
		} catch (SQLException e) {
			System.err.println("SQLException:" + e.getMessage());
			e.printStackTrace();
			throw e;
		} catch (Exception e) {
			System.err.println("GeneralException:" + e.getMessage());
			e.printStackTrace();
			throw e;
		} finally {
			try {
				daos.cerrarRecursos();
				if (this.conn != null)
					this.conn.close();
			} catch (SQLException exception) {
				System.err.println("SQLException closing resources:" + exception.getMessage());
				exception.printStackTrace();
				throw exception;
			}
		}
		return data;
	}

	public void addEspacio(Espacio data) throws RotondAndesException, Exception {
		DAOEspacio daos = new DAOEspacio();
		try {
			////// Transacción
			this.conn = darConexion();
			daos.setConn(conn);
			if (daos.get(data.getId()) != null)
				throw new RotondAndesException("El espacio con el id <" + data.getId() + "> ya existe");
			daos.add(data);
			conn.commit();

		} catch (SQLException e) {
			System.err.println("SQLException:" + e.getMessage());
			e.printStackTrace();
			throw e;
		} catch (Exception e) {
			System.err.println("GeneralException:" + e.getMessage());
			e.printStackTrace();
			throw e;
		} finally {
			try {
				daos.cerrarRecursos();
				if (this.conn != null)
					this.conn.close();
			} catch (SQLException exception) {
				System.err.println("SQLException closing resources:" + exception.getMessage());
				exception.printStackTrace();
				throw exception;
			}
		}
	}

	public void updateEspacio(Espacio data) throws RotondAndesException, Exception {
		DAOEspacio daos = new DAOEspacio();
		try {
			////// Transacción
			this.conn = darConexion();
			daos.setConn(conn);
			if (daos.get(data.getId()) == null)
				throw new RotondAndesException("Ya existe un espacio con el <" + data.getId() + ">");
			daos.update(data);

		} catch (SQLException e) {
			System.err.println("SQLException:" + e.getMessage());
			e.printStackTrace();
			throw e;
		} catch (Exception e) {
			System.err.println("GeneralException:" + e.getMessage());
			e.printStackTrace();
			throw e;
		} finally {
			try {
				daos.cerrarRecursos();
				if (this.conn != null)
					this.conn.close();
			} catch (SQLException exception) {
				System.err.println("SQLException closing resources:" + exception.getMessage());
				exception.printStackTrace();
				throw exception;
			}
		}
	}

	public void deleteEspacio(Espacio data) throws RotondAndesException, Exception {
		DAOEspacio daos = new DAOEspacio();
		try {
			////// Transacción
			this.conn = darConexion();
			daos.setConn(conn);
			if (daos.get(data.getId()) == null)
				throw new RotondAndesException("No existe un espacio con el id<" + data.getId() + ">");
			daos.delete(data);

		} catch (SQLException e) {
			System.err.println("SQLException:" + e.getMessage());
			e.printStackTrace();
			throw e;
		} catch (Exception e) {
			System.err.println("GeneralException:" + e.getMessage());
			e.printStackTrace();
			throw e;
		} finally {
			try {
				daos.cerrarRecursos();
				if (this.conn != null)
					this.conn.close();
			} catch (SQLException exception) {
				System.err.println("SQLException closing resources:" + exception.getMessage());
				exception.printStackTrace();
				throw exception;
			}
		}
	}

	public Menu getReservaMenu(long idReserva, long id)  throws RotondAndesException, Exception {
		Menu data;
		DAOReservaMenu daos = new DAOReservaMenu();
		try {
			////// Transacción
			this.conn = darConexion();
			daos.setConn(conn);
			data = daos.get(idReserva,id);
			if (data == null)
				throw new RotondAndesException("El espacio con el id:<" + id + ">no existe");
		} catch (SQLException e) {
			System.err.println("SQLException:" + e.getMessage());
			e.printStackTrace();
			throw e;
		} catch (Exception e) {
			System.err.println("GeneralException:" + e.getMessage());
			e.printStackTrace();
			throw e;
		} finally {
			try {
				daos.cerrarRecursos();
				if (this.conn != null)
					this.conn.close();
			} catch (SQLException exception) {
				System.err.println("SQLException closing resources:" + exception.getMessage());
				exception.printStackTrace();
				throw exception;
			}
		}
		return data;
	}

	public List<Menu> getAllReservaMenu(long idReserva) throws SQLException,Exception {
		List<Menu> data;
		DAOReservaMenu daos = new DAOReservaMenu();
		try {
			////// Transacción
			this.conn = darConexion();
			daos.setConn(conn);
			data = daos.getAll(idReserva);
		} catch (SQLException e) {
			System.err.println("SQLException:" + e.getMessage());
			e.printStackTrace();
			throw e;
		} catch (Exception e) {
			System.err.println("GeneralException:" + e.getMessage());
			e.printStackTrace();
			throw e;
		} finally {
			try {
				daos.cerrarRecursos();
				if (this.conn != null)
					this.conn.close();
			} catch (SQLException exception) {
				System.err.println("SQLException closing resources:" + exception.getMessage());
				exception.printStackTrace();
				throw exception;
			}
		}
		return data;
	}
	
	public Menu addReservaMenu(long idReserva, long id) throws RotondAndesException, Exception {
		DAOReservaMenu daos = new DAOReservaMenu();
		DAOMenu daosHijo=new DAOMenu();
		Menu data=null;
		try {
			////// Transacción
			this.conn = darConexion();
			daos.setConn(conn);
			daos.add(idReserva, id);
			conn.commit();
			daosHijo.setConn(conn);
			data=daosHijo.get(id);
			conn.commit();

		} catch (SQLException e) {
			System.err.println("SQLException:" + e.getMessage());
			e.printStackTrace();
			throw e;
		} catch (Exception e) {
			System.err.println("GeneralException:" + e.getMessage());
			e.printStackTrace();
			throw e;
		} finally {
			try {
				daos.cerrarRecursos();
				if (this.conn != null)
					this.conn.close();
			} catch (SQLException exception) {
				System.err.println("SQLException closing resources:" + exception.getMessage());
				exception.printStackTrace();
				throw exception;
			}
		}
		return data;
	}

	public Menu deleteReservaMenu(long idReserva, long id) throws RotondAndesException, Exception {
		DAOReservaMenu daos = new DAOReservaMenu();
		DAOMenu daosHijo=new DAOMenu();
		Menu data=null;
		try {
			////// Transacción
			this.conn = darConexion();
			daos.setConn(conn);
			daos.delete(idReserva, id);
			daosHijo.setConn(conn);
			data=daosHijo.get(id);
			conn.commit();

		} catch (SQLException e) {
			System.err.println("SQLException:" + e.getMessage());
			e.printStackTrace();
			throw e;
		} catch (Exception e) {
			System.err.println("GeneralException:" + e.getMessage());
			e.printStackTrace();
			throw e;
		} finally {
			try {
				daos.cerrarRecursos();
				if (this.conn != null)
					this.conn.close();
			} catch (SQLException exception) {
				System.err.println("SQLException closing resources:" + exception.getMessage());
				exception.printStackTrace();
				throw exception;
			}
		}
		return data;
	}
	
	public Ingrediente getProductoIngredienteu(long idProducto, long id)  throws RotondAndesException, Exception {
		Ingrediente data;
		DAOProductoIngrediente daos = new DAOProductoIngrediente();
		try {
			////// Transacción
			this.conn = darConexion();
			daos.setConn(conn);
			data = daos.get(idProducto,id);
			if (data == null)
				throw new RotondAndesException("El espacio con el id:<" + id + ">no existe");
		} catch (SQLException e) {
			System.err.println("SQLException:" + e.getMessage());
			e.printStackTrace();
			throw e;
		} catch (Exception e) {
			System.err.println("GeneralException:" + e.getMessage());
			e.printStackTrace();
			throw e;
		} finally {
			try {
				daos.cerrarRecursos();
				if (this.conn != null)
					this.conn.close();
			} catch (SQLException exception) {
				System.err.println("SQLException closing resources:" + exception.getMessage());
				exception.printStackTrace();
				throw exception;
			}
		}
		return data;
	}

	public List<Ingrediente> getAllProductoIngrediente(long idProducto) throws SQLException,Exception {
		List<Ingrediente> data;
		DAOProductoIngrediente daos = new DAOProductoIngrediente();
		try {
			////// Transacción
			this.conn = darConexion();
			daos.setConn(conn);
			data = daos.getAll(idProducto);
		} catch (SQLException e) {
			System.err.println("SQLException:" + e.getMessage());
			e.printStackTrace();
			throw e;
		} catch (Exception e) {
			System.err.println("GeneralException:" + e.getMessage());
			e.printStackTrace();
			throw e;
		} finally {
			try {
				daos.cerrarRecursos();
				if (this.conn != null)
					this.conn.close();
			} catch (SQLException exception) {
				System.err.println("SQLException closing resources:" + exception.getMessage());
				exception.printStackTrace();
				throw exception;
			}
		}
		return data;
	}
	
	public Ingrediente addProductoIngrediente(long idProducto, long id) throws RotondAndesException, Exception {
		DAOProductoIngrediente daos = new DAOProductoIngrediente();
		DAOIngrediente daosHijo=new DAOIngrediente();
		Ingrediente data=null;
		try {
			////// Transacción
			this.conn = darConexion();
			daos.setConn(conn);
			daos.add(idProducto, id);
			conn.commit();
			daosHijo.setConn(conn);
			data=daosHijo.get(id);
			conn.commit();

		} catch (SQLException e) {
			System.err.println("SQLException:" + e.getMessage());
			e.printStackTrace();
			throw e;
		} catch (Exception e) {
			System.err.println("GeneralException:" + e.getMessage());
			e.printStackTrace();
			throw e;
		} finally {
			try {
				daos.cerrarRecursos();
				if (this.conn != null)
					this.conn.close();
			} catch (SQLException exception) {
				System.err.println("SQLException closing resources:" + exception.getMessage());
				exception.printStackTrace();
				throw exception;
			}
		}
		return data;
	}

	public Ingrediente deleteProductoIngrediente(long idProducto, long id) throws RotondAndesException, Exception {
		DAOProductoIngrediente daos = new DAOProductoIngrediente();
		DAOIngrediente daosHijo=new DAOIngrediente();
		Ingrediente data=null;
		try {
			////// Transacción
			this.conn = darConexion();
			daos.setConn(conn);
			daos.delete(idProducto, id);
			daosHijo.setConn(conn);
			data=daosHijo.get(id);
			conn.commit();

		} catch (SQLException e) {
			System.err.println("SQLException:" + e.getMessage());
			e.printStackTrace();
			throw e;
		} catch (Exception e) {
			System.err.println("GeneralException:" + e.getMessage());
			e.printStackTrace();
			throw e;
		} finally {
			try {
				daos.cerrarRecursos();
				if (this.conn != null)
					this.conn.close();
			} catch (SQLException exception) {
				System.err.println("SQLException closing resources:" + exception.getMessage());
				exception.printStackTrace();
				throw exception;
			}
		}
		return data;
	}

	public void addProductoCliente(ProductoDetail data) throws SQLException ,Exception{
		DAOProducto daos = new DAOProducto();
		DAOProductoIngrediente daosHijos= new DAOProductoIngrediente();
		try {
			////// Transacción
			this.conn = darConexion();
			daos.setConn(conn);
			if (daos.get(data.getId()) != null)
				throw new RotondAndesException("El producto con el id <" + data.getId() + "> ya existe");
			daos.add(data);
			conn.commit();
			daosHijos.setConn(conn);
			for(Long idIngrediente :data.getIngredientes())
				daosHijos.add(data.getId(), idIngrediente);
			conn.commit();

		} catch (SQLException e) {
			System.err.println("SQLException:" + e.getMessage());
			e.printStackTrace();
			throw e;
		} catch (Exception e) {
			System.err.println("GeneralException:" + e.getMessage());
			e.printStackTrace();
			throw e;
		} finally {
			try {
				daos.cerrarRecursos();
				if (this.conn != null)
					this.conn.close();
			} catch (SQLException exception) {
				System.err.println("SQLException closing resources:" + exception.getMessage());
				exception.printStackTrace();
				throw exception;
			}
		}
	}
}
