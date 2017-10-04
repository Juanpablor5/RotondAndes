package rest;

import javax.servlet.ServletContext;
import javax.ws.rs.POST;
import javax.ws.rs.core.Response;

import tm.RotondAndesException;
import tm.RotondAndesTM;
import vos.Producto;

public class ProductoCreatorServices extends BaseServices{
	public ProductoCreatorServices(ServletContext context) {
		this.context=context;
	}
	
	@POST
	public Response add(Producto data) {
		RotondAndesTM tm = new RotondAndesTM(getPath());
		try {
			integridad(data);
			tm.addProducto(data);
		} catch (RotondAndesException ex) {
			return Response.status(404).entity(doErrorMessage(ex)).build();
		} catch (Exception e) {
			return Response.status(500).entity(doErrorMessage(e)).build();
		}
		return Response.status(200).entity(data).build();
	}
	
	public void integridad(Producto data) throws RotondAndesException {
		if(data.getId()==null)
			throw new RotondAndesException("El id no puede ser null");
		if(data.getDescripcion()==null)
			throw new RotondAndesException("la descripcion no puede ser nula");
		if(data.getDescripcion().equals(""))
			throw new RotondAndesException("la descripcion no puede ser vacia");
		if(data.getTiempoPreparacion()==null)
			throw new RotondAndesException("el tiempode preparacion no puede ser nulo");
		if(data.getTiempoPreparacion()<=0)
			throw new RotondAndesException("el tiempo de preparacion debe ser mayor a 0");
		if(data.getNombre()==null)
			throw new RotondAndesException("el nombre no puede ser nulo");
		if(data.getNombre().equals(""))
			throw new RotondAndesException("el nombre no puede estar vacio");
		if(data.getTraduccion()==null)
			throw new RotondAndesException("la traducion no pude ser nula");
		if(data.getTraduccion().equals(""))
			throw new RotondAndesException("la traducion no puede estar vacia");
	}
}
