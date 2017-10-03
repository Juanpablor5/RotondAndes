package tm;

import java.io.File;
import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;
import java.util.Properties;

import dao.DAOCliente;
import dao.DAORegistro;
import vos.Cliente;
import vos.Registro;


public class RotondAndesTM {
	/**
	 * Atributo estatico que contiene el path relativo del archivo que tiene los datos de la conexion
	 */
	private static final String CONNECTION_DATA_FILE_NAME_REMOTE = "/conexion.properties";

	/**
	 * Atributo estatico que contiene el path absoluto del archivo que tiene los datos de la conexion
	 */
	private  String connectionDataPath;

	/**
	 * Atributo que guarda el usuario que se va a usar para conectarse a la base de datos.
	 */
	private String user;

	/**
	 * Atributo que guarda la clave que se va a usar para conectarse a la base de datos.
	 */
	private String password;

	/**
	 * Atributo que guarda el URL que se va a usar para conectarse a la base de datos.
	 */
	private String url;

	/**
	 * Atributo que guarda el driver que se va a usar para conectarse a la base de datos.
	 */
	private String driver;
	
	/**
	 * conexion a la base de datos
	 */
	private Connection conn;


	/**
	 * Metodo constructor de la clase VideoAndesMaster, esta clase modela y contiene cada una de las 
	 * transacciones y la logica de negocios que estas conllevan.
	 * <b>post: </b> Se crea el objeto VideoAndesTM, se inicializa el path absoluto del archivo de conexion y se
	 * inicializa los atributos que se usan par la conexion a la base de datos.
	 * @param contextPathP - path absoluto en el servidor del contexto del deploy actual
	 */
	public RotondAndesTM(String contextPathP) {
		connectionDataPath = contextPathP + CONNECTION_DATA_FILE_NAME_REMOTE;
		initConnectionData();
	}

	/**
	 * Metodo que  inicializa los atributos que se usan para la conexion a la base de datos.
	 * <b>post: </b> Se han inicializado los atributos que se usan par la conexion a la base de datos.
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
	 * Metodo que  retorna la conexion a la base de datos
	 * @return Connection - la conexion a la base de datos
	 * @throws SQLException - Cualquier error que se genere durante la conexion a la base de datos
	 */
	private Connection darConexion() throws SQLException {
		System.out.println("Connecting to: " + url + " With user: " + user);
		return DriverManager.getConnection(url, user, password);
	}

	////////////////////////////////////////
	///////Transacciones////////////////////
	////////////////////////////////////////
	
	public List<Registro> getAllResgistro() throws SQLException, Exception{
		List<Registro> data;
		DAORegistro daos = new DAORegistro();
		try 
		{
			//////transaccion
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
				if(this.conn!=null)
					this.conn.close();
			} catch (SQLException exception) {
				System.err.println("SQLException closing resources:" + exception.getMessage());
				exception.printStackTrace();
				throw exception;
			}
		}
		return data;
	}
	
	public Registro getRegistro(long id) throws RotondAndesException, Exception{
		Registro data;
		DAORegistro daos = new DAORegistro();
		try 
		{
			//////transaccion
			this.conn = darConexion();
			daos.setConn(conn);
			data = daos.get(id);
			if(data==null)
				throw new RotondAndesException("el registro con el codigo:<"+id+">no existe");
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
				if(this.conn!=null)
					this.conn.close();
			} catch (SQLException exception) {
				System.err.println("SQLException closing resources:" + exception.getMessage());
				exception.printStackTrace();
				throw exception;
			}
		}
		return data;
	}
	
	public List<Cliente> getAllCliente() throws SQLException, Exception{
		List<Cliente> data;
		DAOCliente daos = new DAOCliente();
		try 
		{
			//////transaccion
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
				if(this.conn!=null)
					this.conn.close();
			} catch (SQLException exception) {
				System.err.println("SQLException closing resources:" + exception.getMessage());
				exception.printStackTrace();
				throw exception;
			}
		}
		return data;
	}

	public Cliente getCliente(long id) throws RotondAndesException, Exception{
		Cliente data;
		DAOCliente daos = new DAOCliente();
		try 
		{
			//////transaccion
			this.conn = darConexion();
			daos.setConn(conn);
			data = daos.get(id);
			if(data==null)
				throw new RotondAndesException("el registro con el codigo:<"+id+">no existe");
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
				if(this.conn!=null)
					this.conn.close();
			} catch (SQLException exception) {
				System.err.println("SQLException closing resources:" + exception.getMessage());
				exception.printStackTrace();
				throw exception;
			}
		}
		return data;
	}

	public void addRegistro(Registro data) throws RotondAndesException, Exception{
		DAORegistro daos = new DAORegistro();
		try 
		{
			//////transaccion
			this.conn = darConexion();
			daos.setConn(conn);
			if(daos.get(data.getCodigo())!=null)
				throw new RotondAndesException("el registro con el codigo <"+data.getCodigo()+"> ya existe");
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
				if(this.conn!=null)
					this.conn.close();
			} catch (SQLException exception) {
				System.err.println("SQLException closing resources:" + exception.getMessage());
				exception.printStackTrace();
				throw exception;
			}
		}
	}

	public void updateRegistro(Registro data) throws RotondAndesException, Exception{
		DAORegistro daos = new DAORegistro();
		try 
		{
			//////transaccion
			this.conn = darConexion();
			daos.setConn(conn);
			if(daos.get(data.getCodigo())==null)
				throw new RotondAndesException("ya existe un regstro con el codigo <"+data.getCodigo()+">");
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
				if(this.conn!=null)
					this.conn.close();
			} catch (SQLException exception) {
				System.err.println("SQLException closing resources:" + exception.getMessage());
				exception.printStackTrace();
				throw exception;
			}
		}
	}

	public void deleteRegistro(Registro data) throws RotondAndesException, Exception{
		DAORegistro daos = new DAORegistro();
		try 
		{
			//////transaccion
			this.conn = darConexion();
			daos.setConn(conn);
			if(daos.get(data.getCodigo())==null)
				throw new RotondAndesException("no existes un registro con codigo:<"+data.getCodigo()+">");
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
				if(this.conn!=null)
					this.conn.close();
			} catch (SQLException exception) {
				System.err.println("SQLException closing resources:" + exception.getMessage());
				exception.printStackTrace();
				throw exception;
			}
		}
	}

	public void addCliente(Cliente data) throws RotondAndesException, Exception{
		DAOCliente daos = new DAOCliente();
		try 
		{
			//////transaccion
			this.conn = darConexion();
			daos.setConn(conn);
			if(daos.get(data.getCedula())!=null)
				throw new RotondAndesException("el cliente con la cedula <"+data.getCedula()+"> ya existe");
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
				if(this.conn!=null)
					this.conn.close();
			} catch (SQLException exception) {
				System.err.println("SQLException closing resources:" + exception.getMessage());
				exception.printStackTrace();
				throw exception;
			}
		}
	}

	public void updateCliente(Cliente data) throws RotondAndesException, Exception{
		DAOCliente daos = new DAOCliente();
		try 
		{
			//////transaccion
			this.conn = darConexion();
			daos.setConn(conn);
			if(daos.get(data.getCedula())==null)
				throw new RotondAndesException("ya existe un cliente con la cedula <"+data.getCedula()+">");
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
				if(this.conn!=null)
					this.conn.close();
			} catch (SQLException exception) {
				System.err.println("SQLException closing resources:" + exception.getMessage());
				exception.printStackTrace();
				throw exception;
			}
		}
	}

	public void deleteCliente(Cliente data) throws RotondAndesException, Exception{
		DAOCliente daos = new DAOCliente();
		try 
		{
			//////transaccion
			this.conn = darConexion();
			daos.setConn(conn);
			if(daos.get(data.getCedula())==null)
				throw new RotondAndesException("no existe un cliente con la cedula<"+data.getCedula()+">");
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
				if(this.conn!=null)
					this.conn.close();
			} catch (SQLException exception) {
				System.err.println("SQLException closing resources:" + exception.getMessage());
				exception.printStackTrace();
				throw exception;
			}
		}
	}
}
