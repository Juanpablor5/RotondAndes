package dao;

import java.sql.Connection;
import em.GenericDao;
import vos.Producto;

public class DAOProducto extends GenericDao<Producto> {

	public DAOProducto(Connection conn) {
		super(Producto.class, conn);
	}
}
