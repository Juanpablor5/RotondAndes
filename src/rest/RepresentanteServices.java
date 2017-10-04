package rest;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import tm.RotondAndesException;
import tm.RotondAndesTM;
import vos.Representante;

@Path(URLS.REPRESENTANTE)
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class RepresentanteServices extends BaseServices implements CRUDR<Representante>,URLS{
	@GET
	@Path("{" + REPRESENTANTEID + ": \\d+}")
	@Override
	public Response get(@PathParam(REPRESENTANTEID)long id) {
		RotondAndesTM tm = new RotondAndesTM(getPath());
		try {
			Representante v = tm.getRepresentante(id);
			return Response.status(200).entity(v).build();
		} catch (RotondAndesException ex) {
			return Response.status(404).entity(doErrorMessage(ex)).build();
		} catch (Exception e) {
			return Response.status(500).entity(doErrorMessage(e)).build();
		}
	}

	@GET
	@Override
	public Response getAll() {
		RotondAndesTM tm = new RotondAndesTM(getPath());
		List<Representante> data;
		try {
			data = tm.getAllRepresentate();
		} catch (Exception e) {
			return Response.status(500).entity(doErrorMessage(e)).build();
		}
		return Response.status(200).entity(data).build();
	}
}
