package rest;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import tm.RotondAndesException;
import tm.RotondAndesTM;
import vos.Pedido;

@Path(URLS.PEDIDO)
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class PedidoServices extends BaseServices implements URLS{

	@POST
	public Response add(Pedido data) {
		RotondAndesTM tm = new RotondAndesTM(getPath());
		try {
			integridad(data);
			tm.addPedido(data);
		} catch (RotondAndesException ex) {
			return Response.status(404).entity(doErrorMessage(ex)).build();
		} catch (Exception e) {
			return Response.status(500).entity(doErrorMessage(e)).build();
		}
		return Response.status(200).entity(data).build();
	}
	
	@Path("{" + PRODUCTOID + ": \\d+}/" + INGREDIENTE)
	public SubpedidoServices getIngredientes(@PathParam(PRODUCTOID) Long id) {
		RotondAndesTM tm = new RotondAndesTM(getPath());
		try {
			tm.getProducto(id);
			return new SubpedidoServices(context);
		} catch (Exception e) {
			throw new WebApplicationException(Response.status(500).entity(doErrorMessage(e)).build());
		}
	}
	
	public void integridad(Pedido data) throws RotondAndesException {
		if(data.getId()==null)
			throw new RotondAndesException("El id no puede ser null");
		if(data.getFechahora()==null)
			throw new RotondAndesException("La fecha no puede ser null");
		if(data.getFechahora().equals(""))
			throw new RotondAndesException("La fecha no puede estar vacio");
		if(data.getClienteCedula()!=null)
			throw new RotondAndesException("Para registrar un pedido debe registrarlo como cliente.");
	}
}
