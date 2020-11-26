package ec.edu.ups.mysql.jdbc;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import ec.edu.ups.dao.CAtegoriaDAO;
import ec.edu.ups.modelo.Categoria;

public class JDBCCategoriaDAO extends JDBCGenericDAO<Categoria, Integer> implements CAtegoriaDAO{
	@Override
	public Categoria read(Integer id) {
		Categoria cat= null;
		ResultSet rs= conexion.query("Select * From Categorias When cat_id="+id);
		try {
			if(rs!=null) {
				cat= new Categoria(rs.getInt("cat_id"), rs.getString("cat_nombre"));
			}
		}catch(SQLException e) {
			System.out.println(">>>WARNING (JDBCCategoriasDAO:read): " + e.getMessage());
		}
		return cat;
	}
	
	public List<String> catEmp(int idEmp){
		List<String> lis=new ArrayList<String>();
		ResultSet rs = conexion.query("select distinct cat.cat_nombre\r\n"
				+ "from productos prod, categorias cat\r\n"
				+ "where prod.empresas_emp_id = "+idEmp);
		try {
			if(rs!=null && rs.next()) {
				lis.add(rs.getString("cat_nomnbre"));
			}
		}catch(SQLException e) {
			System.out.println(">>>WARNING (JDBCCategoriasDAO:catEmp): " + e.getMessage());
		}
		return lis;
	}

	@Override
	public void create(Categoria entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(Categoria entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Categoria entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Categoria> find() {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	
}
