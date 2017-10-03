package rest;

import javax.ws.rs.core.Response;

import tm.RotondAndesException;

public interface CRUDRest<T>{
	final static String REGISTRO="registros";
	final static String REGISTROID="registros_id";
	
	public Response get(long id);
	public Response getAll();
	public Response add(T data);
	public Response update(T data);
	public Response delete(T data);
	public void integridad(T data) throws RotondAndesException ;
}
