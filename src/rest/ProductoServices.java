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
import vos.Producto;

@Path(URLS.PRODUCTO)
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class ProductoServices extends BaseServices implements CRUDR<Producto>,URLS{
	
	@GET
	@Path("{" + PRODUCTOID + ": \\d+}")
	@Override
	public Response get(@PathParam(PRODUCTOID)long id) {
		RotondAndesTM tm = new RotondAndesTM(getPath());
		try {
			Producto v = tm.getProducto(id);
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
		List<Producto> espacio;
		try {
			espacio = tm.getAllProducto();
		} catch (Exception e) {
			return Response.status(500).entity(doErrorMessage(e)).build();
		}
		return Response.status(200).entity(espacio).build();
	}
	
	@GET
	@Path("{" + PRODUCTOID + ": \\d+}/" + INGREDIENTE)
	public ProductoIngredienteServices getIngredientes(@PathParam(PRODUCTOID) Long id) {
		RotondAndesTM tm = new RotondAndesTM(getPath());
		try {
			tm.getProducto(id);
			return new ProductoIngredienteServices(context);
		} catch (Exception e) {
			throw new WebApplicationException(Response.status(500).entity(doErrorMessage(e)).build());
		}
	}
}
