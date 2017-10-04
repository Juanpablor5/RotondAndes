package rest;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import tm.RotondAndesException;
import tm.RotondAndesTM;
import vos.Registro;

@Path(URLS.REGISTRO)
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class RegistroServices extends BaseServices implements CRUDRest<Registro>, URLS {

	@GET
	@Override
	public Response getAll() {
		RotondAndesTM tm = new RotondAndesTM(getPath());
		List<Registro> videos;
		try {
			videos = tm.getAllResgistro();
		} catch (Exception e) {
			return Response.status(500).entity(doErrorMessage(e)).build();
		}
		return Response.status(200).entity(videos).build();
	}

	@GET
	@Path("{" + REGISTROID + ": \\d+}")
	@Override
	public Response get(@PathParam(REGISTROID) long id) {
		RotondAndesTM tm = new RotondAndesTM(getPath());
		try {
			Registro v = tm.getRegistro(id);
			System.out.println(v);
			return Response.status(200).entity(v).build();
		} catch (RotondAndesException ex) {
			return Response.status(404).entity(doErrorMessage(ex)).build();
		} catch (Exception e) {
			return Response.status(500).entity(doErrorMessage(e)).build();
		}
	}

	@POST
	@Override
	public Response add(Registro data) {
		RotondAndesTM tm = new RotondAndesTM(getPath());
		try {
			integridad(data);
			tm.addRegistro(data);
		} catch (RotondAndesException ex) {
			return Response.status(404).entity(doErrorMessage(ex)).build();
		} catch (Exception e) {
			return Response.status(500).entity(doErrorMessage(e)).build();
		}
		return Response.status(200).entity(data).build();
	}

	@PUT
	@Override
	public Response update(Registro data) {
		RotondAndesTM tm = new RotondAndesTM(getPath());
		try {
			integridad(data);
			tm.updateRegistro(data);
		} catch (RotondAndesException ex) {
			return Response.status(404).entity(doErrorMessage(ex)).build();
		} catch (Exception e) {
			return Response.status(500).entity(doErrorMessage(e)).build();
		}
		return Response.status(200).entity(data).build();
	}

	@DELETE
	@Override
	public Response delete(Registro data) {
		RotondAndesTM tm = new RotondAndesTM(getPath());
		try {
			tm.deleteRegistro(data);
		} catch (RotondAndesException ex) {
			return Response.status(404).entity(doErrorMessage(ex)).build();
		} catch (Exception e) {
			return Response.status(500).entity(doErrorMessage(e)).build();
		}
		return Response.status(200).entity(data).build();
	}

	@Path("{" + REGISTROID + ": \\d+}/" + CLIENTE)
	public ClienteModificationServices getCliente(@PathParam(REGISTROID) Long id) {

		RotondAndesTM tm = new RotondAndesTM(getPath());
		try {
			if (tm.getRegistro(id).getPermisos() != 3)
				throw new RotondAndesException("no tiene los permisos necesarios");

			return new ClienteModificationServices(context);
		} catch (RotondAndesException ex) {
			throw new WebApplicationException(Response.status(404).entity(doErrorMessage(ex)).build());
		} catch (Exception e) {
			throw new WebApplicationException(Response.status(500).entity(doErrorMessage(e)).build());
		}
	}
	
	@Path("{" + REGISTROID + ": \\d+}/" + ZONA)
	public ZonaModificationServices getZona(@PathParam(REGISTROID) Long id) {
		RotondAndesTM tm = new RotondAndesTM(getPath());
		try {
			if (tm.getRegistro(id).getPermisos() != 3)
				throw new RotondAndesException("no tiene los permisos necesarios");

			return new ZonaModificationServices(context);
		} catch (RotondAndesException ex) {
			throw new WebApplicationException(Response.status(404).entity(doErrorMessage(ex)).build());
		} catch (Exception e) {
			throw new WebApplicationException(Response.status(500).entity(doErrorMessage(e)).build());
		}
	}
	
	@Path("{" + REGISTROID + ": \\d+}/" + RESTAURANTE)
	public RestauranteModificationServices getRestaurante(@PathParam(REGISTROID) Long id) {
		RotondAndesTM tm = new RotondAndesTM(getPath());
		try {
			if (tm.getRegistro(id).getPermisos() != 3)
				throw new RotondAndesException("No tiene los permisos necesarios");

			return new RestauranteModificationServices(context);
		} catch (RotondAndesException ex) {
			throw new WebApplicationException(Response.status(404).entity(doErrorMessage(ex)).build());
		} catch (Exception e) {
			throw new WebApplicationException(Response.status(500).entity(doErrorMessage(e)).build());
		}
	}
	
	@Path("{" + REGISTROID + ": \\d+}/" + RESERVA)
	public ReservaModificationServices getReservas(@PathParam(REGISTROID) Long id) {
		RotondAndesTM tm = new RotondAndesTM(getPath());
		try {
			if (tm.getRegistro(id).getPermisos() != 3)
				throw new RotondAndesException("No tiene los permisos necesarios");

			return new ReservaModificationServices(context);
		} catch (RotondAndesException ex) {
			throw new WebApplicationException(Response.status(404).entity(doErrorMessage(ex)).build());
		} catch (Exception e) {
			throw new WebApplicationException(Response.status(500).entity(doErrorMessage(e)).build());
		}
	}
	
	@Path("{" + REGISTROID + ": \\d+}/" + ESPACIO)
	public EspacioModificationServices getEspacio(@PathParam(REGISTROID) Long id) {
		RotondAndesTM tm = new RotondAndesTM(getPath());
		try {
			if (tm.getRegistro(id).getPermisos() != 3)
				throw new RotondAndesException("No tiene los permisos necesarios");

			return new EspacioModificationServices(context);
		} catch (RotondAndesException ex) {
			throw new WebApplicationException(Response.status(404).entity(doErrorMessage(ex)).build());
		} catch (Exception e) {
			throw new WebApplicationException(Response.status(500).entity(doErrorMessage(e)).build());
		}
	}
	
	@Path("{" + REGISTROID + ": \\d+}/" + REPRESENTANTE)
	public RepresentateModificationServices getRepresentante(@PathParam(REGISTROID) Long id) {
		RotondAndesTM tm = new RotondAndesTM(getPath());
		try {
			if (tm.getRegistro(id).getPermisos() != 3)
				throw new RotondAndesException("No tiene los permisos necesarios");

			return new RepresentateModificationServices(context);
		} catch (RotondAndesException ex) {
			throw new WebApplicationException(Response.status(404).entity(doErrorMessage(ex)).build());
		} catch (Exception e) {
			throw new WebApplicationException(Response.status(500).entity(doErrorMessage(e)).build());
		}
	}

	@Override
	public void integridad(Registro data) throws RotondAndesException {
		if (data.getCodigo() == null)
			throw new RotondAndesException("el codigo no puede ser null");
		if (data.getUsuario() == null)
			throw new RotondAndesException("el usuario no puede ser null");
		if (data.getContrasena() == null)
			throw new RotondAndesException("la contrasenia no piede ser null");
		if (data.getPermisos() == null)
			throw new RotondAndesException("el permiso no puede se null");
		if (data.getUsuario().equals(""))
			throw new RotondAndesException("no puede agregar un usuario vacio");
		if (data.getUsuario().contains(" "))
			throw new RotondAndesException("un usuario no puede tener espacios");
		if (data.getUsuario().length() > 100)
			throw new RotondAndesException("la cadena ususrio supera el limite permitido de caracteres");
		if (data.getContrasena().equals(""))
			throw new RotondAndesException("no puede agregar un usuario vacio");
		if (data.getContrasena().length() > 100)
			throw new RotondAndesException("la cadena ususrio supera el limite permitido de caracteres");
		if (data.getPermisos() <= 0 || data.getPermisos() > 3)
			throw new RotondAndesException("el permiso no es valido");
	}
}
