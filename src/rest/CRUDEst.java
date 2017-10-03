package rest;

import javax.ws.rs.core.Response;

import tm.RotondAndesException;

public interface CRUDEst<T>{
	public Response add(T data);
	public Response update(T data);
	public Response delete(T data);
	public void integridad(T data) throws RotondAndesException ;
}
