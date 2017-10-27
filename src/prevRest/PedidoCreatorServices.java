package prevRest;

import javax.servlet.ServletContext;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import rest.BaseServices;
import rest.URLS;
import tm.RotondAndesException;
import tm.RotondAndesTM;
import vos.Pedido;
import vos.PedidoDetail;

@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class PedidoCreatorServices extends BaseServices implements URLS{
	
	public PedidoCreatorServices(ServletContext context) {
		this.context=context;
	}
	
	@POST
	public Response add(@PathParam(REGISTROID)long id, PedidoDetail data) {
		RotondAndesTM tm = new RotondAndesTM(getPath());
		try {
			integridad(data);
			tm.addPedidoCliente(id, data);
		} catch (RotondAndesException ex) {
			return Response.status(404).entity(doErrorMessage(ex)).build();
		} catch (Exception e) {
			return Response.status(500).entity(doErrorMessage(e)).build();
		}
		return Response.status(200).entity(data).build();
	}
	
	public void integridad(Pedido data) throws RotondAndesException {
		if(data.getId()==null)
			throw new RotondAndesException("El id del ingrediente no puede ser null");
		if(data.getFechahora()==null)
			throw new RotondAndesException("La fecha del pedido no puede ser null");
		if(data.getFechahora().equals(""))
			throw new RotondAndesException("La fecha del pedido no puede ser  vacio");
	}
}
