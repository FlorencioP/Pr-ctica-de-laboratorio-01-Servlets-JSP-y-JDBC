package ec.edu.ups.dao;

public class DAOFactory {
	protected DAOFactory factory = new JDBCDAOFactory();
	
	public static DAOFactory getFactory() {
		return factory;
	}
	
	public abstract void createTables();
	
	public abstract ProductosDao getProductosDao();
	
}
