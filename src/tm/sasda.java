package tm;

import java.sql.SQLException;
import java.util.List;

import dao.DAOCambiar;
import vos.Cambiar;

public class sasda {
	
	public List<Cambiar> getAllCambiar() throws SQLException, Exception {
		List<Cambiar> data;
		DAOCambiar daos = new DAOCambiar();
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

	public Cambiar getCambiar(long id) throws RotondAndesException, Exception {
		Cambiar data;
		DAOCambiar daos = new DAOCambiar();
		try {
			////// Transacción
			this.conn = darConexion();
			daos.setConn(conn);
			data = daos.get(id);
			if (data == null)
				throw new RotondAndesException("El cambiar con el id:<" + id + ">no existe");
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

	public void addCambiar(Cambiar data) throws RotondAndesException, Exception {
		DAOCambiar daos = new DAOCambiar();
		try {
			////// Transacción
			this.conn = darConexion();
			daos.setConn(conn);
			if (daos.get(data.getId()) != null)
				throw new RotondAndesException("El cambiar con el id <" + data.getId() + "> ya existe");
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

	public void updateCambiar(Cambiar data) throws RotondAndesException, Exception {
		DAOCambiar daos = new DAOCambiar();
		try {
			////// Transacción
			this.conn = darConexion();
			daos.setConn(conn);
			if (daos.get(data.getId()) == null)
				throw new RotondAndesException("Ya existe un cambiar con el <" + data.getId() + ">");
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

	public void deleteCambiar(Cambiar data) throws RotondAndesException, Exception {
		DAOCambiar daos = new DAOCambiar();
		try {
			////// Transacción
			this.conn = darConexion();
			daos.setConn(conn);
			if (daos.get(data.getId()) == null)
				throw new RotondAndesException("No existe un cambiar con el id<" + data.getId() + ">");
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

}
