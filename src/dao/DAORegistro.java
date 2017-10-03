package dao;

import vos.Registro;

public class DAORegistro extends DAOBase{
	private final static String TABLA="REGISTRO";
	
	public void add(Registro registro) {
		String sql = "INSERT INTO VIDEO VALUES (";
		sql += video.getId() + ",'";
		sql += video.getName() + "',";
		sql += video.getDuration() + ")";
		
		executeModification(sql);
	}
}
