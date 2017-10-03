package rest;

import javax.ws.rs.core.Response;

public interface CRUDR<T>{
	public Response get(long id);
	public Response getAll();
}
