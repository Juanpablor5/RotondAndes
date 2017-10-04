package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import vos.Reserva;

/**
 * Clase DAO que se conecta la base de datos usando JDBC para resolver los requerimientos de la aplicación
 */
public class DAOReserva extends DAOBase implements CRUD<Reserva>{
	
	// -------------------------------------------------------------
	// Constantes
	// -------------------------------------------------------------
	
	/**
	 * Constante que representa la tabla reserva.
	 */
	private final static String TABLA="RESERVA";
	
	// -------------------------------------------------------------
	// Métodos
	// -------------------------------------------------------------

	@Override
	public Reserva get(long id) throws SQLException, Exception {
		Reserva reserva = null;
		String sql = "SELECT * FROM " +TABLA+" WHERE ID =" + id;
		ResultSet rs = executeModification(sql);
		if(rs.next()) {
			Date fechaHora = rs.getDate("FECHAHORA");
			Integer duracion = rs.getInt("DURACION");
			Integer comensales = rs.getInt("COMENSALES");
			String nombreReservante = rs.getString("NOMBRERESERVANTE");
			Integer telefonoReservante = rs.getInt("TELEFONORESERVANTE");
			Integer zonaid=rs.getInt("ZONA_ID");
			reserva = new Reserva(id, fechaHora, duracion, comensales, nombreReservante, telefonoReservante,zonaid);
		}
		return reserva;
	}

	@Override
	public List<Reserva> getAll() throws SQLException, Exception {
		ArrayList<Reserva> data = new ArrayList<Reserva>();

		String sql = "SELECT * FROM "+TABLA;

		ResultSet rs = executeModification(sql);

		while (rs.next()) {
			Long id = rs.getLong("ID");
			Date fechaHora = rs.getDate("FECHAHORA");
			Integer duracion = rs.getInt("DURACION");
			Integer comensales = rs.getInt("COMENSALES");
			String nombreReservante = rs.getString("NOMBRERESERVANTE");
			Integer telefonoReservante = rs.getInt("TELEFONORESERVANTE");
			Integer zonaid=rs.getInt("ZONA_ID");
			data.add( new Reserva(id, fechaHora, duracion, comensales, nombreReservante, telefonoReservante,zonaid));
		}
		return data;
	}

	@Override
	public void add(Reserva data) throws SQLException, Exception {
		String sql = "INSERT INTO " + TABLA +" VALUES (";
		sql += data.getId() + ",'";
		sql += data.getFechahora() + "',";
		sql += data.getDuracion() + ",";
		sql += data.getComensales() + ",'";
		sql += data.getNombreReservante() + "',";
		sql += data.getTelefonoReservante() + ",";
		sql += data.getZona_id()+ ")";
		
		executeModification(sql);
	}

	@Override
	public void update(Reserva data) throws SQLException, Exception {
		String sql = "UPDATE "+TABLA+" SET ";
		sql += "FECHAHORA='" + data.getFechahora() + "',";
		sql += "DURACION=" + data.getDuracion()+",";
		sql += "COMENSALES=" + data.getComensales()+",";
		sql += "NOMBRERESERVANTE='" + data.getNombreReservante() + "',";
		sql += "TELEFONORESERVANTE=" + data.getTelefonoReservante()+",";
		sql += "ZONA_ID"+ data.getZona_id();
		sql += " WHERE ID = " + data.getId();
		
		executeModification(sql);
	}

	@Override
	public void delete(Reserva data) throws SQLException, Exception {
		String sql = "DELETE FROM " + TABLA;
		sql += " WHERE ID = " + data.getId();
		
		executeModification(sql);
	}

}
