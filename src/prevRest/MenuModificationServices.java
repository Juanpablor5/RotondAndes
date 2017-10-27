package prevRest;

import javax.servlet.ServletContext;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import rest.BaseServices;
import rest.URLS;
import tm.RotondAndesException;
import tm.RotondAndesTM;
import vos.Menu;

@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class MenuModificationServices extends BaseServices implements URLS{
	
	public MenuModificationServices(ServletContext context) {
		this.context=context;
	}

	@POST
	public Response add(@PathParam(REGISTROID)long codigo,Menu data) {
		RotondAndesTM tm = new RotondAndesTM(getPath());
		try {
			integridad(data);
			tm.addMenu(codigo, data);
		} catch (RotondAndesException ex) {
			return Response.status(404).entity(doErrorMessage(ex)).build();
		} catch (Exception e) {
			return Response.status(500).entity(doErrorMessage(e)).build();
		}
		return Response.status(200).entity(data).build();
	}

	@PUT
	public Response update(@PathParam(REGISTROID)long codigo,Menu data) {
		RotondAndesTM tm = new RotondAndesTM(getPath());
		try {
			integridad(data);
			tm.updateMenu(codigo, data);
		} catch (RotondAndesException ex) {
			return Response.status(404).entity(doErrorMessage(ex)).build();
		} catch (Exception e) {
			return Response.status(500).entity(doErrorMessage(e)).build();
		}
		return Response.status(200).entity(data).build();
	}

	@DELETE
	public Response delete(@PathParam(REGISTROID)long codigo,Menu data) {
		RotondAndesTM tm = new RotondAndesTM(getPath());
		try {
			tm.deleteMenu(codigo, data);
		} catch (RotondAndesException ex) {
			return Response.status(404).entity(doErrorMessage(ex)).build();
		} catch (Exception e) {
			return Response.status(500).entity(doErrorMessage(e)).build();
		}
		return Response.status(200).entity(data).build();
	}

	public void integridad(Menu data) throws RotondAndesException {
		if(data.getCantidad()==null)
			throw new RotondAndesException("la cantidad de productos n puede ser nula");
		if(data.getCostoProduccion()==null)
			throw new RotondAndesException("el costo de procucion no puede ser nulo");
		if(data.getCantidad()<0) 
			throw new RotondAndesException("la cantidad no puede ser menor a 0");
		if(data.getValorAlPublico()==null)
			throw new RotondAndesException("el valor de producion no puede ser nulo");
		if(data.getId()==null)
			throw new RotondAndesException("el id no puede ser nulo");
		if(data.getValorAlPublico()<=0)
			throw  new RotondAndesException("el valor al publico debe ser positivo");
		if(data.getCostoProduccion()<=0)
			throw new RotondAndesException("el costo de producion debe ser mayor a cero");
	}
}
