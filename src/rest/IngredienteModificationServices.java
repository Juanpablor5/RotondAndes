package rest;

import javax.servlet.ServletContext;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import tm.RotondAndesException;
import tm.RotondAndesTM;
import vos.Ingrediente;

@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class IngredienteModificationServices extends BaseServices{
	
	public IngredienteModificationServices(ServletContext context) {
		this.context=context;
	}

	@POST
	@Override
	public Response add(Ingrediente data) {
		RotondAndesTM tm = new RotondAndesTM(getPath());
		try {
			integridad(data);
			tm.addIngrediente(data);
		} catch (RotondAndesException ex) {
			return Response.status(404).entity(doErrorMessage(ex)).build();
		} catch (Exception e) {
			return Response.status(500).entity(doErrorMessage(e)).build();
		}
		return Response.status(200).entity(data).build();
	}

	@PUT
	@Override
	public Response update(Ingrediente data) {
		RotondAndesTM tm = new RotondAndesTM(getPath());
		try {
			integridad(data);
			tm.updateIngrediente(data);
		} catch (RotondAndesException ex) {
			return Response.status(404).entity(doErrorMessage(ex)).build();
		} catch (Exception e) {
			return Response.status(500).entity(doErrorMessage(e)).build();
		}
		return Response.status(200).entity(data).build();
	}

	@DELETE
	@Override
	public Response delete(Ingrediente data) {
		RotondAndesTM tm = new RotondAndesTM(getPath());
		try {
			tm.deleteIngrediente(data);
		} catch (RotondAndesException ex) {
			return Response.status(404).entity(doErrorMessage(ex)).build();
		} catch (Exception e) {
			return Response.status(500).entity(doErrorMessage(e)).build();
		}
		return Response.status(200).entity(data).build();
	}

	@Override
	public void integridad(Ingrediente data) throws RotondAndesException {
		if(data.getId()==null)
			throw new RotondAndesException("El id del ingrediente no puede ser null");
		if(data.getNombre()==null)
			throw new RotondAndesException("El nombre del ingrediente no puede ser null");
		if(data.getNombre().equals(""))
			throw new RotondAndesException("El nombre del ingrediente no puede ser  vacio");
		if(data.getDescripcion()==null)
			throw new RotondAndesException("La descripción no puede ser null");
		if(data.getDescripcion().equals(""))
			throw new RotondAndesException("La descripción no puede estar vacia");
		if(data.getTraduccion()==null)
			throw new RotondAndesException("La traducción no puede ser null");
		if(data.getTraduccion().equals(""))
			throw new RotondAndesException("La traducción no puede ser  vacio");
	}
}
