package rest;

import javax.servlet.ServletContext;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import tm.RotondAndesException;
import tm.RotondAndesTM;
import vos.Reserva;

@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class ReservaModificationServices extends BaseServices implements CRUDEst<Reserva>{
	public ReservaModificationServices(ServletContext context) {
		this.context=context;
	}
	
	@POST
	@Override
	public Response add(Reserva data) {
		RotondAndesTM tm = new RotondAndesTM(getPath());
		try {
			integridad(data);
			tm.addReserva(data);
		} catch (RotondAndesException ex) {
			return Response.status(404).entity(doErrorMessage(ex)).build();
		} catch (Exception e) {
			return Response.status(500).entity(doErrorMessage(e)).build();
		}
		return Response.status(200).entity(data).build();
	}

	@PUT
	@Override
	public Response update(Reserva data) {
		RotondAndesTM tm = new RotondAndesTM(getPath());
		try {
			integridad(data);
			tm.updateReserva(data);
		} catch (RotondAndesException ex) {
			return Response.status(404).entity(doErrorMessage(ex)).build();
		} catch (Exception e) {
			return Response.status(500).entity(doErrorMessage(e)).build();
		}
		return Response.status(200).entity(data).build();
	}

	@DELETE
	@Override
	public Response delete(Reserva data) {
		RotondAndesTM tm = new RotondAndesTM(getPath());
		try {
			tm.deleteReserva(data);
		} catch (RotondAndesException ex) {
			return Response.status(404).entity(doErrorMessage(ex)).build();
		} catch (Exception e) {
			return Response.status(500).entity(doErrorMessage(e)).build();
		}
		return Response.status(200).entity(data).build();
	}

	@Override
	public void integridad(Reserva data) throws RotondAndesException {
		if(data.getId()==null)
			throw new RotondAndesException("el id no puede ser nulo");
		if(data.getNombreReservante()==null)
			throw new RotondAndesException("el nombre no puede ser nulo");
		if(data.getNombreReservante().equals(""))
			throw new RotondAndesException("el nombre no puede estar vacio");
		if(data.getTelefonoReservante()==null)
			throw new RotondAndesException("el telefono no puede ser nulo");
		if(data.getTelefonoReservante()<=0)
			throw new RotondAndesException("el telefono no puede ser negativo");
		if(data.getComensales()==null)
			throw new RotondAndesException("los comensales no pueden ser nulos");
		if(data.getComensales()<=0)
			throw new RotondAndesException("el nuemro de comensales no puede ser menor que 0");
		if(data.getDuracion()==null)
			throw new RotondAndesException("la duracoin no puede ser nula");
		if(data.getDuracion()<=0)
			throw new RotondAndesException("la duracion debe ser positiva");
		if(data.getFechahora()==null)
			throw new RotondAndesException("la fecha y hora no puede ser nula");
		if(data.getZona_id()==null)
			throw new RotondAndesException("la zna no puede ser nula");
	}	
}
