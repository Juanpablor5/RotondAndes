package rest;

import javax.servlet.ServletContext;
import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import tm.RotondAndesException;
import tm.RotondAndesTM;
import vos.Restaurante;

@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class RestauranteModificationServices extends BaseServices implements CRUDEst<Restaurante>{

	public RestauranteModificationServices(ServletContext context) {
		this.context=context;
	}
	
	@Override
	public Response add(Restaurante data) {
		RotondAndesTM tm = new RotondAndesTM(getPath());
		try {
			integridad(data);
			tm.addRestaurante(data);
		} catch (RotondAndesException ex) {
			return Response.status(404).entity(doErrorMessage(ex)).build();
		} catch (Exception e) {
			return Response.status(500).entity(doErrorMessage(e)).build();
		}
		return Response.status(200).entity(data).build();
	}

	@Override
	public Response update(Restaurante data) {
		RotondAndesTM tm = new RotondAndesTM(getPath());
		try {
			integridad(data);
			tm.updateRestaurante(data);
		} catch (RotondAndesException ex) {
			return Response.status(404).entity(doErrorMessage(ex)).build();
		} catch (Exception e) {
			return Response.status(500).entity(doErrorMessage(e)).build();
		}
		return Response.status(200).entity(data).build();
	}

	@Override
	public Response delete(Restaurante data) {
		RotondAndesTM tm = new RotondAndesTM(getPath());
		try {
			tm.deleteRestaurante(data);
		} catch (RotondAndesException ex) {
			return Response.status(404).entity(doErrorMessage(ex)).build();
		} catch (Exception e) {
			return Response.status(500).entity(doErrorMessage(e)).build();
		}
		return Response.status(200).entity(data).build();
	}

	@Override
	public void integridad(Restaurante data) throws RotondAndesException {
		if(data.getRegristroId()==null)
			throw new RotondAndesException("El id del restaurante");
		if(data.getId()==null)
			throw new RotondAndesException("El id no puede ser null");
		if(data.getNombre()==null)
			throw new RotondAndesException("El nombre no puede ser null");
		if(data.getId()<=0)
			throw new RotondAndesException("La cedula no puede ser negativa ni cero");
		if(data.getNombre().equals(""))
			throw new RotondAndesException("El nombre no puedo ser vacio");
	}	
}
