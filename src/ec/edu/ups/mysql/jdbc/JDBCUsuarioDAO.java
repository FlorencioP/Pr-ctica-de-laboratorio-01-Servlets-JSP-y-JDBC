package ec.edu.ups.mysql.jdbc;

import java.sql.ResultSet;
import java.sql.SQLException;

import ec.edu.ups.dao.UsuariosDAO;
import ec.edu.ups.modelo.Usuario;

public abstract class JDBCUsuarioDAO extends JDBCGenericDAO<Usuario, Integer> implements UsuariosDAO{

	public Usuario validarU(String correo, String password) {
		Usuario us=null;
		ResultSet rs = conexion.query("Select *  From Usuarios Where us_correo='"+correo+"' AND us_password='"+
					   					password+"'");
		try {
			if(rs != null) {
				us=new Usuario(rs.getInt("us_id"), rs.getString("us_nombre"), rs.getString("us_apellido"), 
								rs.getString("us_correo"), rs.getString("us_password"), rs.getString("us_rol").charAt(0), 
								rs.getInt("Empresas_emp_id"));
			}
		}catch(SQLException e) {
			System.out.println(">>>WARNING (JDBCUsuarioDAO:validarU): " + e.getMessage());
		}
		return us;
	}
	
	
	
}
