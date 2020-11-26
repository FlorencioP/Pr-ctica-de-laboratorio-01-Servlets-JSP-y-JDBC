package ec.edu.ups.mysql.jdbc;

import java.sql.ResultSet;
import java.sql.SQLException;

import java.util.ArrayList;
import java.util.List;

import ec.edu.ups.dao.UsuariosDAO;
import ec.edu.ups.modelo.Producto;

import ec.edu.ups.modelo.Usuario;

public class JDBCUsuarioDAO extends JDBCGenericDAO<Usuario, Integer> implements UsuariosDAO{

	public Usuario validarU(String correo, String password) {
		Usuario us=null;
		System.out.println("correo: "+correo);
		System.out.println("pasword: "+password);
		ResultSet rs = conexion.query("Select *  From Usuarios Where us_correo='"+correo+"' AND us_password='"+password+"'");
		try {
			while(rs.next()){
				if(rs != null) {
					us=new Usuario(rs.getInt("us_id"), rs.getString("us_nombre"), rs.getString("us_apellido"), 
							rs.getString("us_correo"), rs.getString("us_password"), rs.getString("us_rol").charAt(0), 
							rs.getInt("empresas_emp_id"));
				}
			}
		}catch(SQLException e) {
			System.out.println(">>>WARNING (JDBCUsuarioDAO:validarU): " + e.getMessage());
		}
		return us;
	}
	

	public List<Usuario> findU() {
		List<Usuario> list=new ArrayList<Usuario>();
		ResultSet rs = conexion.query("Select * From Usuarios");
		try {
			if(rs != null) {
				list.add(new Usuario(rs.getInt("us_id"), rs.getString("us_nombre"), rs.getString("us_apellido"), 
						rs.getString("us_correo"), rs.getString("us_password"), rs.getString("us_rol").charAt(0), 
						rs.getInt("Empresas_emp_id")));
			}
		}catch(SQLException e) {
			System.out.println(">>>WARNING (JDBCUsuarioDAO:findU): " + e.getMessage());
		}
		return list;
	}
	
	@Override
	public void update(Usuario usuario) {
		conexion.update("Update Usuarios Set us_id="+usuario.getId()+",us_nombre='"+usuario.getNombre()+
						"' , us_apellido="+usuario.getApellido()+", us_correo='"+usuario.getCorreo()+
						"', us_password='"+usuario.getPassword()+"',us_rol="+usuario.getRol()+
						"Empresas_emp_id="+usuario.getFKEmpID());
	}
	
	@Override
	public void delete(Usuario usuario) {
		conexion.update("DELETE FROM Usuarios WHERE id = " + usuario.getId());
	}


	@Override
	public void create(Usuario entity) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public Usuario read(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public List<Usuario> find() {
		// TODO Auto-generated method stub
		return null;
	}
	

	
}
