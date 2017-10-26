package rest;

import javax.servlet.ServletContext;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import tm.RotondAndesException;
import tm.RotondAndesTM;
import vos.Restaurante;

@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class RestauranteModificationServices extends BaseServices implements URLS{

	public RestauranteModificationServices(ServletContext context) {
		this.context=context;
	}
	
	@POST
	@Path("{" + USUARIOID + "}")
	public Response add(@PathParam(USUARIOID)Long codigo,Restaurante data) {
		RotondAndesTM tm = new RotondAndesTM(getPath());
		try {
			tm.createRestaurante(data, codigo);
		} catch (RotondAndesException ex) {
			return Response.status(404).entity(doErrorMessage(ex)).build();
		} catch (Exception e) {
			return Response.status(500).entity(doErrorMessage(e)).build();
		}
		return Response.status(200).entity(data).build();
	}

	@PUT
	@Path("{"+RESTAURANTEID+"}")
	public Response update(@PathParam(RESTAURANTEID)Long id,Restaurante data) {
		data.setId(id);
		RotondAndesTM tm = new RotondAndesTM(getPath());
		try {
			data = tm.updateRestaurante(data);
		} catch (RotondAndesException ex) {
			return Response.status(404).entity(doErrorMessage(ex)).build();
		} catch (Exception e) {
			return Response.status(500).entity(doErrorMessage(e)).build();
		}
		return Response.status(200).entity(data).build();
	}

	@DELETE
	@Path("{"+RESTAURANTEID+"}")
	public Response delete(@PathParam(RESTAURANTEID)Long id) {
		Restaurante restaurante;
		RotondAndesTM tm = new RotondAndesTM(getPath());
		try {
			restaurante = tm.deleteRestaurante(id);
		} catch (RotondAndesException ex) {
			return Response.status(404).entity(doErrorMessage(ex)).build();
		} catch (Exception e) {
			return Response.status(500).entity(doErrorMessage(e)).build();
		}
		return Response.status(200).entity(restaurante).build();
	}
}
