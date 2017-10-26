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
import vos.Espacio;

@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class EspacioModificationServices extends BaseServices{
	
	public EspacioModificationServices(ServletContext context) {
		this.context=context;
	}

	@POST
	@Override
	public Response add(Espacio data) {
		RotondAndesTM tm = new RotondAndesTM(getPath());
		try {
			integridad(data);
			tm.addEspacio(data);
		} catch (RotondAndesException ex) {
			return Response.status(404).entity(doErrorMessage(ex)).build();
		} catch (Exception e) {
			return Response.status(500).entity(doErrorMessage(e)).build();
		}
		return Response.status(200).entity(data).build();
	}

	@PUT
	@Override
	public Response update(Espacio data) {
		RotondAndesTM tm = new RotondAndesTM(getPath());
		try {
			integridad(data);
			tm.updateEspacio(data);
		} catch (RotondAndesException ex) {
			return Response.status(404).entity(doErrorMessage(ex)).build();
		} catch (Exception e) {
			return Response.status(500).entity(doErrorMessage(e)).build();
		}
		return Response.status(200).entity(data).build();
	}

	@DELETE
	@Override
	public Response delete(Espacio data) {
		RotondAndesTM tm = new RotondAndesTM(getPath());
		try {
			tm.deleteEspacio(data);
		} catch (RotondAndesException ex) {
			return Response.status(404).entity(doErrorMessage(ex)).build();
		} catch (Exception e) {
			return Response.status(500).entity(doErrorMessage(e)).build();
		}
		return Response.status(200).entity(data).build();
	}

	@Override
	public void integridad(Espacio data) throws RotondAndesException {
		if(data.getId()==null)
			throw new RotondAndesException("El id no puede ser null");
		if(data.getAcondicionamiento()==null)
			throw new RotondAndesException("El acondicionamiento no puede ser null");
		if(data.getAcondicionamiento().equals(""))
			throw new RotondAndesException("El acondicionamiento no puede ser vacio");
		if(data.getAbierto()==null)
			throw new RotondAndesException("El indicador de abierto no puede ser null");
		if(data.getAbierto() > 1)
			throw new RotondAndesException("El indicador de abierto debe ser 0 para false y 1 para true");
		if(data.getNecesidadesEspeciales()==null)
			throw new RotondAndesException("El indicador de necesidades especiales no puede ser null");
		if(data.getCapacidad() < 0)
			throw new RotondAndesException("La capacidad no puede ser negativa.");
		if(data.getNecesidadesEspeciales() > 1)
			throw new RotondAndesException("El indicador de necesidades especiales debe ser 0 para false y 1 para true");
		if(data.getCondicionesTecnicas()==null)
			throw new RotondAndesException("Las condiciones técnicas no pueden ser null");
		if(data.getCondicionesTecnicas().equals(""))
			throw new RotondAndesException("Las condiciones técnicas no puede ser vacio");
		if(data.getZonaId()==null)
			throw new RotondAndesException("El id de la zona no puede ser null");
	}
}
