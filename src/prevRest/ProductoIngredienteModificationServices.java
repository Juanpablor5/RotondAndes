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
import vos.Ingrediente;

@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class ProductoIngredienteModificationServices extends BaseServices implements URLS {
	public ProductoIngredienteModificationServices(ServletContext context) {
		this.context=context;
	}
	
	@POST
	@Path("{" + INGREDIENTEID + ": \\d+}")
	public Response add(@PathParam(PRODUCTOID)long idProducto,@PathParam(INGREDIENTEID)long id) {
		System.out.println("asdas");
		RotondAndesTM tm = new RotondAndesTM(getPath());
		Ingrediente data=null;
		try {
			data=tm.addProductoIngrediente(idProducto, id);
		} catch (RotondAndesException ex) {
			return Response.status(404).entity(doErrorMessage(ex)).build();
		} catch (Exception e) {
			return Response.status(500).entity(doErrorMessage(e)).build();
		}
		return Response.status(200).entity(data).build();
	}

	@DELETE
	@Path("{" + INGREDIENTEID + ": \\d+}")
	public Response delete(@PathParam(PRODUCTOID)long idProducto,@PathParam(INGREDIENTEID)long id) {
		RotondAndesTM tm = new RotondAndesTM(getPath());
		Ingrediente data=null;
		try {
			data=tm.deleteProductoIngrediente(idProducto, id);
		} catch (RotondAndesException ex) {
			return Response.status(404).entity(doErrorMessage(ex)).build();
		} catch (Exception e) {
			return Response.status(500).entity(doErrorMessage(e)).build();
		}
		return Response.status(200).entity(data).build();
	}
}
