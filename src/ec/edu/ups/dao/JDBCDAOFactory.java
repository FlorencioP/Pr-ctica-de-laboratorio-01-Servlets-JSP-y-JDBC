package ec.edu.ups.dao;

import ec.edu.ups.mysql.jdbc.JDBCProductoDAO;

public class JDBCDAOFactory extends DAOFactory{
		
	@Override
	public ProductosDao getProductosDao() {
		return new JDBCProductoDAO();
	}
	
}
