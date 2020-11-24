package ec.edu.ups.dao;

public class JDBCDAOFactory extends DAOFactory{
	
	@Override 
	public void createTables() {
		this.getProductosDao().createTable();
	}
	
	public void getEmpresaDAO() {
		return new JDc;
	}
	
}
