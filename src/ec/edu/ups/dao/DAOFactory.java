package ec.edu.ups.dao;
//qweqwe
public abstract class DAOFactory {
	
	protected static DAOFactory factory = new JDBCDAOFactory();

	public static DAOFactory getFactory() {
		return factory;
	}
	
	public abstract ProductosDao getProductosDao();
	
}
