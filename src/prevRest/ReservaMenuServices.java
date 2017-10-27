package prevRest;



import java.util.List;

import javax.servlet.ServletContext;
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
import vos.Menu;

@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class ReservaMenuServices extends BaseServices implements URLS{
	public ReservaMenuServices(ServletContext context) {
		this.context=context;
	}

	@GET
	@Path("{" + MENUID + ": \\d+}")
	public Response get(@PathParam(RESERVAID)long idReserva,@PathParam(MENUID)long id) {
		RotondAndesTM tm = new RotondAndesTM(getPath());
		try {
			Menu v = tm.getReservaMenu(idReserva,id);
			return Response.status(200).entity(v).build();
		} catch (RotondAndesException ex) {
			return Response.status(404).entity(doErrorMessage(ex)).build();
		} catch (Exception e) {
			return Response.status(500).entity(doErrorMessage(e)).build();
		}
	}
	
	@GET
	public Response getAll(@PathParam(RESERVAID)long idReserva) {
		RotondAndesTM tm = new RotondAndesTM(getPath());
		List<Menu> data;
		try {
			data = tm.getAllReservaMenu(idReserva);
		} catch (Exception e) {
			return Response.status(500).entity(doErrorMessage(e)).build();
		}
		return Response.status(200).entity(data).build();
	}
}
