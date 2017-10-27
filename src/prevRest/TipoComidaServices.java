package prevRest;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import rest.BaseServices;
import rest.URLS;
import tm.RotondAndesException;
import tm.RotondAndesTM;
import vos.TipoComida;

@Path(URLS.TIPOCOMIDA)
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class TipoComidaServices extends BaseServices implements URLS{
	
	@GET
	@Override
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
	@Path("{" + TIPOCOMIDAID + ": \\d+}")
	@Override
	public Response get(@PathParam(TIPOCOMIDAID) long id) {
		RotondAndesTM tm = new RotondAndesTM(getPath());
		try {
			TipoComida v = tm.getTipoComida(id);
			System.out.println(v);
			return Response.status(200).entity(v).build();
		} catch (RotondAndesException ex) {
			return Response.status(404).entity(doErrorMessage(ex)).build();
		} catch (Exception e) {
			return Response.status(500).entity(doErrorMessage(e)).build();
		}
	}

	@POST
	@Override
	public Response add(TipoComida data) {
		RotondAndesTM tm = new RotondAndesTM(getPath());
		try {
			integridad(data);
			tm.addTipoComida(data);
		} catch (RotondAndesException ex) {
			return Response.status(404).entity(doErrorMessage(ex)).build();
		} catch (Exception e) {
			return Response.status(500).entity(doErrorMessage(e)).build();
		}
		return Response.status(200).entity(data).build();
	}

	@PUT
	@Override
	public Response update(TipoComida data) {
		RotondAndesTM tm = new RotondAndesTM(getPath());
		try {
			integridad(data);
			tm.updateTipoComida(data);
		} catch (RotondAndesException ex) {
			return Response.status(404).entity(doErrorMessage(ex)).build();
		} catch (Exception e) {
			return Response.status(500).entity(doErrorMessage(e)).build();
		}
		return Response.status(200).entity(data).build();
	}

	@DELETE
	@Override
	public Response delete(TipoComida data) {
		RotondAndesTM tm = new RotondAndesTM(getPath());
		try {
			tm.deleteTipoComida(data);
		} catch (RotondAndesException ex) {
			return Response.status(404).entity(doErrorMessage(ex)).build();
		} catch (Exception e) {
			return Response.status(500).entity(doErrorMessage(e)).build();
		}
		return Response.status(200).entity(data).build();
	}

	@Override
	public void integridad(TipoComida data) throws RotondAndesException {
		if(data.getId()==null)
			throw new RotondAndesException("el id no puede ser nulo");
		if(data.getNombre()==null)
			throw new RotondAndesException("el nombre no piede ser nulo");
		if(data.getNombre().equals(""))
			throw new RotondAndesException("el cadena no debe ser vacia");
	}
}
