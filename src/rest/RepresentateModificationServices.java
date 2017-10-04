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
import vos.Representante;

@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class RepresentateModificationServices extends BaseServices implements CRUDEst<Representante> {

	public RepresentateModificationServices(ServletContext context) {
		this.context=context;
	}

	@POST
	@Override
	public Response add(Representante data) {
		RotondAndesTM tm = new RotondAndesTM(getPath());
		try {
			integridad(data);
			tm.addRepresentante(data);
		} catch (RotondAndesException ex) {
			return Response.status(404).entity(doErrorMessage(ex)).build();
		} catch (Exception e) {
			return Response.status(500).entity(doErrorMessage(e)).build();
		}
		return Response.status(200).entity(data).build();
	}

	@PUT
	@Override
	public Response update(Representante data) {
		RotondAndesTM tm = new RotondAndesTM(getPath());
		try {
			integridad(data);
			tm.updateRepresentante(data);
		} catch (RotondAndesException ex) {
			return Response.status(404).entity(doErrorMessage(ex)).build();
		} catch (Exception e) {
			return Response.status(500).entity(doErrorMessage(e)).build();
		}
		return Response.status(200).entity(data).build();
	}

	@DELETE
	@Override
	public Response delete(Representante data) {
		RotondAndesTM tm = new RotondAndesTM(getPath());
		try {
			tm.deleteRepresentante(data);
		} catch (RotondAndesException ex) {
			return Response.status(404).entity(doErrorMessage(ex)).build();
		} catch (Exception e) {
			return Response.status(500).entity(doErrorMessage(e)).build();
		}
		return Response.status(200).entity(data).build();
	}

	@Override
	public void integridad(Representante data) throws RotondAndesException {
		if(data.getId()==null)
			throw new RotondAndesException("el representante no puede ser nulo");
		if(data.getNombre()==null)
			throw new RotondAndesException("el nombre no puede ser nulo");
		if(data.getNombre().equals(""))
			throw new RotondAndesException("el nombre no puede estar vacio");
		if(data.getTelefono()==null && data.getCorreo()==null)
			throw new RotondAndesException("tiene que ingresar almenos un telefono o correo");
		if(data.getRestauranteId()==null)
			throw new RotondAndesException ("el id del restaurane no puede ser nulo");
	}
}
