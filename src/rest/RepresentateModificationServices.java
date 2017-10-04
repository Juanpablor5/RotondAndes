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
import vos.Espacio;
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
	public void integridad(Espacio data) throws RotondAndesException {
	}
}
