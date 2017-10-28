package rest;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import tm.RotondAndesException;
import tm.RotondAndesTM;
import vos.TipoComida;

@Path(URLS.TIPOCOMIDA)
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class TipoComidaServices extends BaseServices implements URLS{
	
	@GET
	public Response getAll() {
		RotondAndesTM tm = new RotondAndesTM(getPath());
		List<TipoComida> videos;
		try {
			videos = tm.getAllTipoComida();
		} catch (Exception e) {
			return Response.status(500).entity(doErrorMessage(e)).build();
		}
		return Response.status(200).entity(videos).build();
	}

	@GET
	@Path("{" + TIPOCOMIDAID + "}")
	public Response get(@PathParam(TIPOCOMIDAID) String id) {
		RotondAndesTM tm = new RotondAndesTM(getPath());
		try {
			TipoComida v = tm.getTipoComida(id);
			return Response.status(200).entity(v).build();
		} catch (RotondAndesException ex) {
			return Response.status(404).entity(doErrorMessage(ex)).build();
		} catch (Exception e) {
			return Response.status(500).entity(doErrorMessage(e)).build();
		}
	}

	@POST
	public Response add(TipoComida data) {
		RotondAndesTM tm = new RotondAndesTM(getPath());
		try {
			tm.addTipoComida(data);
		} catch (Exception e) {
			return Response.status(500).entity(doErrorMessage(e)).build();
		}
		return Response.status(200).entity(data).build();
	}

	@DELETE
	@Path("{" + TIPOCOMIDAID + "}")
	public Response delete(@PathParam(TIPOCOMIDAID) String id) {
		TipoComida tipoComida;
		RotondAndesTM tm = new RotondAndesTM(getPath());
		try {
			tipoComida=tm.deleteTipoComida(id);
		} catch (RotondAndesException ex) {
			return Response.status(404).entity(doErrorMessage(ex)).build();
		} catch (Exception e) {
			return Response.status(500).entity(doErrorMessage(e)).build();
		}
		return Response.status(200).entity(tipoComida).build();
	}
}
