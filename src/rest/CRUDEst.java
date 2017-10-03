package rest;

import javax.ws.rs.core.Response;

import tm.RotondAndesException;

public interface CRUDEst<T>{
	final static String REGISTRO="registros";
	final static String REGISTROID="registros_id";
	final static String CLIENTE="clientes";
	final static String CLIENTEID="clientes_id";
	
	public Response add(T data);
	public Response update(T data);
	public Response delete(T data);
	public void integridad(T data) throws RotondAndesException ;
}
