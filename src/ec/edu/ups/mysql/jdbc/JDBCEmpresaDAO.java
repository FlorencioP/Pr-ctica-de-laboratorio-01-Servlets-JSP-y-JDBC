package ec.edu.ups.mysql.jdbc;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import ec.edu.ups.dao.EmpresaDAO;
import ec.edu.ups.modelo.Empresa;

public abstract class JDBCEmpresaDAO extends JDBCGenericDAO<Empresa, Integer> implements EmpresaDAO{
	@Override
	public Empresa read(Integer id) {
		Empresa emp=null;
		ResultSet rs = conexion.query("Select * From Empresas When emp_id="+id);
		try{
			if(rs != null) {
				emp = new Empresa(rs.getInt("emp_id"),rs.getString("emp_noombre"));
			}
		}catch(SQLException e) {
			System.out.println(">>>WARNING (JDBCEmpresaDAO:read): " + e.getMessage());
		}
		return emp;
	}
	
}
