package ec.edu.ups.mysql.jdbc;
//qweqwe
import ec.edu.ups.dao.GenericcDAO;

public abstract class JDBCGenericDAO<T, ID> implements GenericcDAO<T, ID>{
	
	protected ContextJDBC conexion = ContextJDBC.getJDBC1();

}
