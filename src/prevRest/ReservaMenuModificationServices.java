package prevRest;

import javax.servlet.ServletContext;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.POST;
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
public class ReservaMenuModificationServices extends BaseServices implements URLS {
	public ReservaMenuModificationServices(ServletContext context) {
		this.context=context;
	}
	
	@POST
	@Path("{" + MENUID + ": \\d+}")
	public Response add(@PathParam(RESERVAID)long idReserva,@PathParam(MENUID)long id) {
		RotondAndesTM tm = new RotondAndesTM(getPath());
		Menu data=null;
		try {
			data=tm.addReservaMenu(idReserva, id);
		} catch (RotondAndesException ex) {
			return Response.status(404).entity(doErrorMessage(ex)).build();
		} catch (Exception e) {
			return Response.status(500).entity(doErrorMessage(e)).build();
		}
		return Response.status(200).entity(data).build();
	}

	@DELETE
	@Path("{" + MENUID + ": \\d+}")
	public Response delete(@PathParam(RESERVAID)long idReserva,@PathParam(MENUID)long id) {
		RotondAndesTM tm = new RotondAndesTM(getPath());
		Menu data=null;
		try {
			data=tm.deleteReservaMenu(idReserva, id);
		} catch (RotondAndesException ex) {
			return Response.status(404).entity(doErrorMessage(ex)).build();
		} catch (Exception e) {
			return Response.status(500).entity(doErrorMessage(e)).build();
		}
		return Response.status(200).entity(data).build();
	}
}
