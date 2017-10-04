package rest;

import java.util.List;

import javax.servlet.ServletContext;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import tm.RotondAndesException;
import tm.RotondAndesTM;
import vos.Pedido;

@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class PedidoModificationServices extends BaseServices implements CRUDR<Pedido>,URLS{

	@GET
	@Path("{" + PEDIDOID + ": \\d+}")
	@Override
	public Response get(long id) {
		RotondAndesTM tm = new RotondAndesTM(getPath());
		try {
			Pedido v = tm.getPedido(id);
			return Response.status(200).entity(v).build();
		} catch (RotondAndesException ex) {
			return Response.status(404).entity(doErrorMessage(ex)).build();
		} catch (Exception e) {
			return Response.status(500).entity(doErrorMessage(e)).build();
		}
	}

	@Override
	public Response getAll() {
		RotondAndesTM tm = new RotondAndesTM(getPath());
		List<Pedido> zona;
		try {
			zona = tm.getAllPedido();
		} catch (Exception e) {
			return Response.status(500).entity(doErrorMessage(e)).build();
		}
		return Response.status(200).entity(zona).build();
	}
	
	public PedidoModificationServices(ServletContext context) {
		this.context=context;
	}

	public Response update(Pedido data) {
		RotondAndesTM tm = new RotondAndesTM(getPath());
		try {
			integridad(data);
			tm.updatePedido(data);
		} catch (RotondAndesException ex) {
			return Response.status(404).entity(doErrorMessage(ex)).build();
		} catch (Exception e) {
			return Response.status(500).entity(doErrorMessage(e)).build();
		}
		return Response.status(200).entity(data).build();
	}

	public Response delete(Pedido data) {
		RotondAndesTM tm = new RotondAndesTM(getPath());
		try {
			tm.deletePedido(data);
		} catch (RotondAndesException ex) {
			return Response.status(404).entity(doErrorMessage(ex)).build();
		} catch (Exception e) {
			return Response.status(500).entity(doErrorMessage(e)).build();
		}
		return Response.status(200).entity(data).build();
	}
	
	public void integridad(Pedido data) throws RotondAndesException {
		if(data.getId()==null)
			throw new RotondAndesException("El id no puede ser null");
		if(data.getFechahora()==null)
			throw new RotondAndesException("La fecha no puede ser null");
		if(data.getFechahora().equals(""))
			throw new RotondAndesException("La fecha no puede estar vacio");
	}	
}
