package dao;

import java.sql.SQLException;
import java.util.List;

public interface CRUD<T> {
	public T get(long id)throws SQLException, Exception;
	public List<T> getAll()throws SQLException, Exception;
	public void add(T t)throws SQLException, Exception;
	public void update(T t)throws SQLException, Exception;
	public void delete(T t)throws SQLException, Exception;
}
