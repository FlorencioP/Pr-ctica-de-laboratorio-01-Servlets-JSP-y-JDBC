package ec.edu.ups.mysql.jdbc;

import ec.edu.ups.dao.ProductosDao;
import ec.edu.ups.modelo.Producto;

public class JDBCProductoDAO extends JDBCGenericDAO<Producto, Integer> implements ProductosDao{
	@Override
	public void create (Producto producto) {
			conexion.update("");
	}
}
