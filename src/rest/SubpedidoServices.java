package rest;

import java.util.List;

import javax.servlet.ServletContext;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import tm.RotondAndesException;
import tm.RotondAndesTM;
import vos.Menu;

@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class SubpedidoServices extends BaseServices implements URLS {
	public SubpedidoServices(ServletContext context) {
		this.context=context;
	}

	@GET
	@Path("{" + MENUID + ": \\d+}")
	public Response get(@PathParam(PRODUCTOID) long idPedido, @PathParam(MENUID) long id) {
		RotondAndesTM tm = new RotondAndesTM(getPath());
		try {
			Menu v = tm.getPedidoMenu(idPedido, id);
			return Response.status(200).entity(v).build();
		} catch (RotondAndesException ex) {
			return Response.status(404).entity(doErrorMessage(ex)).build();
		} catch (Exception e) {
			return Response.status(500).entity(doErrorMessage(e)).build();
		}
	}

	@GET
	public Response getAll(@PathParam(PRODUCTOID) long idPedido) {
		RotondAndesTM tm = new RotondAndesTM(getPath());
		List<Menu> data;
		try {
			data = tm.getAllPedidoMenu(idPedido);
		} catch (Exception e) {
			return Response.status(500).entity(doErrorMessage(e)).build();
		}
		return Response.status(200).entity(data).build();
	}
}