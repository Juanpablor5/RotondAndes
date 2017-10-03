package rest;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import tm.RotondAndesException;
import tm.RotondAndesTM;
import vos.Cliente;

@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class ClienteModificationServices extends BaseServices implements CRUDEst<Cliente> {
	@POST
	@Override
	public Response add(Cliente data) {
		RotondAndesTM tm = new RotondAndesTM(getPath());
		try {
			integridad(data);
			tm.addCliente(data);
		} catch (RotondAndesException ex) {
			return Response.status(404).entity(doErrorMessage(ex)).build();
		} catch (Exception e) {
			return Response.status(500).entity(doErrorMessage(e)).build();
		}
		return Response.status(200).entity(data).build();
	}

	@PUT
	@Override
	public Response update(Cliente data) {
		RotondAndesTM tm = new RotondAndesTM(getPath());
		try {
			integridad(data);
			tm.updateCliente(data);
		} catch (RotondAndesException ex) {
			return Response.status(404).entity(doErrorMessage(ex)).build();
		} catch (Exception e) {
			return Response.status(500).entity(doErrorMessage(e)).build();
		}
		return Response.status(200).entity(data).build();
	}

	@DELETE
	@Override
	public Response delete(Cliente data) {
		RotondAndesTM tm = new RotondAndesTM(getPath());
		try {
			tm.deleteCliente(data);
		} catch (RotondAndesException ex) {
			return Response.status(404).entity(doErrorMessage(ex)).build();
		} catch (Exception e) {
			return Response.status(500).entity(doErrorMessage(e)).build();
		}
		return Response.status(200).entity(data).build();
	}

	@Override
	public void integridad(Cliente data) throws RotondAndesException {
		if(data.getCedula()==null)
			throw new RotondAndesException("la cedua no puede ser null");
		if(data.getNombre()==null)
			throw new RotondAndesException("el nombre no puede ser null");
		if(data.getCedula()<=0)
			throw new RotondAndesException("la cedula no puede ser negativa ni cero");
		if(data.getNombre().equals(""))
			throw new RotondAndesException("el nombre no puedo ser vacio");
	}

}
