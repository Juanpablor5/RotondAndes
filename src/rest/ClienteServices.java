package rest;

import java.util.List;

import javax.servlet.ServletContext;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import tm.RotondAndesException;
import tm.RotondAndesTM;
import vos.Cliente;

@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class ClienteServices extends BaseServices implements URLS {

	public ClienteServices(ServletContext context) {
		this.context = context;
	}

	@GET
	public Response getAll() {
		RotondAndesTM tm = new RotondAndesTM(getPath());
		List<Cliente> data;
		try {
			data = tm.getAllCliente();
		} catch (Exception e) {
			return Response.status(500).entity(doErrorMessage(e)).build();
		}
		return Response.status(200).entity(data).build();
	}

	@GET
	@Path("{" + CLIENTEID + ": \\d+}")
	public Response get(@PathParam(CLIENTEID) long cedula) {
		RotondAndesTM tm = new RotondAndesTM(getPath());
		try {
			Cliente v = tm.getCliente(cedula);
			return Response.status(200).entity(v).build();
		} catch (RotondAndesException ex) {
			return Response.status(404).entity(doErrorMessage(ex)).build();
		} catch (Exception e) {
			return Response.status(500).entity(doErrorMessage(e)).build();
		}
	}

	@POST
	@Path("{" + USUARIOID + "}")
	public Response add(@PathParam(USUARIOID)Long codigo, Cliente data) {
		RotondAndesTM tm = new RotondAndesTM(getPath());
		try {
			data = tm.createCliente(data,codigo);
		} catch (Exception e) {
			return Response.status(500).entity(doErrorMessage(e)).build();
		}
		return Response.status(200).entity(data).build();
	}

	@PUT
	@Path("{" + CLIENTEID + "}")
	public Response update(@PathParam(CLIENTEID) Long cedula, Cliente data) {
		data.setCedula(cedula);
		RotondAndesTM tm = new RotondAndesTM(getPath());
		try {
			data = tm.updateCliente(data);
		} catch (RotondAndesException ex) {
			return Response.status(404).entity(doErrorMessage(ex)).build();
		} catch (Exception e) {
			return Response.status(500).entity(doErrorMessage(e)).build();
		}
		return Response.status(200).entity(data).build();
	}

	@DELETE
	@Path("{" + CLIENTEID + "}")
	public Response delete(@PathParam(CLIENTEID) Long cedula) {
		Cliente data;
		RotondAndesTM tm = new RotondAndesTM(getPath());
		try {
			data = tm.deleteCliente(cedula);
		} catch (RotondAndesException ex) {
			return Response.status(404).entity(doErrorMessage(ex)).build();
		} catch (Exception e) {
			return Response.status(500).entity(doErrorMessage(e)).build();
		}
		return Response.status(200).entity(data).build();
	}

}
