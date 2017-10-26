package rest;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import tm.RotondAndesException;
import tm.RotondAndesTM;
import vos.Reserva;

@Path(URLS.RESERVA)
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class ReservaServices  extends BaseServices implements URLS{
	@GET
	@Path("{" + RESERVAID + ": \\d+}")
	@Override
	public Response get(@PathParam(RESERVAID)long id) {
		RotondAndesTM tm = new RotondAndesTM(getPath());
		try {
			Reserva v = tm.getReserva(id);
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
		List<Reserva> data;
		try {
			data = tm.getAllReserva();
		} catch (Exception e) {
			return Response.status(500).entity(doErrorMessage(e)).build();
		}
		return Response.status(200).entity(data).build();
	}
	
	@Path("{" + RESERVAID + ": \\d+}/" + MENU)
	public ReservaMenuServices getEspacio(@PathParam(RESERVAID) Long id) {
		RotondAndesTM tm = new RotondAndesTM(getPath());
		try {
			tm.getReserva(id);
			return new ReservaMenuServices(context);
		} catch (Exception e) {
			throw new WebApplicationException(Response.status(500).entity(doErrorMessage(e)).build());
		}
	}
}
