package prevRest;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import rest.BaseServices;
import rest.URLS;
import tm.RotondAndesException;
import tm.RotondAndesTM;
import vos.Espacio;

@Path(URLS.ESPACIO)
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class EspacioServices extends BaseServices implements URLS{

	@GET
	@Path("{" + ESPACIOID + ": \\d+}")
	@Override
	public Response get(@PathParam(ESPACIOID)long id) {
		RotondAndesTM tm = new RotondAndesTM(getPath());
		try {
			Espacio v = tm.getEspacio(id);
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
		List<Espacio> espacio;
		try {
			espacio = tm.getAllEspacio();
		} catch (Exception e) {
			return Response.status(500).entity(doErrorMessage(e)).build();
		}
		return Response.status(200).entity(espacio).build();
	}
}
