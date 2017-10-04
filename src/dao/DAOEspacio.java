package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import oracle.sql.ZONEIDMAP;
import vos.Espacio;

/**
 * Clase DAO que se conecta la base de datos usando JDBC para resolver los
 * requerimientos de la aplicación
 */
public class DAOEspacio extends DAOBase implements CRUD<Espacio> {

	// -------------------------------------------------------------
	// Constantes
	// -------------------------------------------------------------

	/**
	 * Constante que representa la tabla espacio.
	 */
	private final static String TABLA = "ESPACIO";

	// -------------------------------------------------------------
	// Métodos
	// -------------------------------------------------------------

	@Override
	public Espacio get(long id) throws SQLException, Exception {
		Espacio espacio = null;
		String sql = "SELECT * FROM " + TABLA + " WHERE ID =" + id;
		ResultSet rs = executeModification(sql);
		if (rs.next()) {
			String acondicionamiento = rs.getString("ACONDICIONAMIENTO");
			Integer abierto = rs.getInt("ABIERTO");
			Integer capacidad = rs.getInt("CAPACIDAD");
			Integer necesidadesEspeciales = rs.getInt("NECESIDADESESPECIALES");
			String condicionesTecnicas = rs.getString("CONDICIONESTECNICAS");
			Integer zonaId = rs.getInt("ZONA_ID");
			espacio = new Espacio(id, acondicionamiento, abierto, capacidad, necesidadesEspeciales, condicionesTecnicas,
					zonaId);
		}
		return espacio;
	}

	@Override
	public List<Espacio> getAll() throws SQLException, Exception {
		ArrayList<Espacio> data = new ArrayList<Espacio>();

		String sql = "SELECT * FROM " + TABLA;

		ResultSet rs = executeModification(sql);

		while (rs.next()) {
			Long id = rs.getLong("ID");
			String acondicionamiento = rs.getString("ACONDICIONAMIENTO");
			Integer abierto = rs.getInt("ABIERTO");
			Integer capacidad = rs.getInt("CAPACIDAD");
			Integer necesidadesEspeciales = rs.getInt("NECESIDADESESPECIALES");
			String condicionesTecnicas = rs.getString("CONDICIONESTECNICAS");
			Integer zonaId = rs.getInt("ZONA_ID");
			data.add(new Espacio(id, acondicionamiento, abierto, capacidad, necesidadesEspeciales, condicionesTecnicas,
					zonaId));
		}
		return data;
	}

	@Override
	public void add(Espacio data) throws SQLException, Exception {
		String sql = "INSERT INTO " + TABLA + " VALUES (";
		sql += data.getId() + ",'";
		sql += data.getAcondicionamiento() + "',";
		sql += data.getAbierto() + ",";
		sql += data.getCapacidad() + ",";
		sql += data.getNecesidadesEspeciales() + ",'";
		sql += data.getCondicionesTecnicas() + "',";
		sql += data.getZonaId() + ")";

		executeModification(sql);
	}

	@Override
	public void update(Espacio data) throws SQLException, Exception {
		String sql = "UPDATE " + TABLA + " SET ";
		sql += "ACONDICIONAMIENTO='" + data.getAcondicionamiento() + "',";
		sql += "ABIERTO=" + data.getAbierto() + ",";
		sql += "CAPACIDAD=" + data.getCapacidad() + ",";
		sql += "NECESIDADESESPECIALES=" + data.getNecesidadesEspeciales() + ",";
		sql += "CONDICIONESTECNICAS='" + data.getCondicionesTecnicas() + "'";
		sql += "ZONA_ID=" + data.getZonaId();
		sql += " WHERE ID = " + data.getId();

		executeModification(sql);
	}

	@Override
	public void delete(Espacio data) throws SQLException, Exception {
		String sql = "DELETE FROM " + TABLA;
		sql += " WHERE ID = " + data.getId();

		executeModification(sql);
	}

}
