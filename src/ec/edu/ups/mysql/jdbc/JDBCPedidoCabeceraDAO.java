package ec.edu.ups.mysql.jdbc;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import ec.edu.ups.dao.PedidoCabeceraDAO;
import ec.edu.ups.modelo.PedidoCabecera;
import ec.edu.ups.modelo.Producto;

public class JDBCPedidoCabeceraDAO extends JDBCGenericDAO<PedidoCabecera, Integer> implements PedidoCabeceraDAO {
	
	@Override
	public PedidoCabecera read(Integer id) {
		
		PedidoCabecera pedCab =null;
		
		ResultSet rs = conexion.query("Select * from Pedidos_Cabecera where pedC_id = " + id+ "and pedc_estado != 'E'");
		
		try {
			if (rs != null) {
				pedCab = new PedidoCabecera(rs.getInt("pedC_id"), rs.getInt("Usuarios_us_id"), rs.getInt("Empresas_emp_id"),  
						rs.getString("pedc_estado").charAt(0));
			}
		} catch (SQLException e) {
			System.out.println(">>>WARNING (JDBCPedidoCabeceraDAO:read): " + e.getMessage());
		}
		
		return  pedCab;
	}
	
	public void modEst(char est, int id) {
		conexion.update("Update pedidos_cabecera set pedc_estado= '"+est+"' where pedC_id= "+id+ " and pedc_estado != 'E'");
	}

	@Override
	public void create(PedidoCabecera pedidoCab) {
		conexion.update("INSERT INTO pedidos_cabecera (pedc_id, usuarios_us_id, empresas_emp_id, pedc_estado) values"+
						"("+pedidoCab.getId()+","+pedidoCab.getFk_usu_id()+","+pedidoCab.getFk_emp_id()+",'"+pedidoCab.getEstado()+"')");
	}
	
	public int ultimoID(){
		int id=0;
		ResultSet rs = conexion.query("select * from pedidos_cabecera "
									 + "order by pedc_id desc "
									 + "limit 1;");
		try{
			if(rs != null && rs.next()) {
				id=rs.getInt("pedc_id");
			}
		}catch (SQLException e) {
			System.out.println(">>>WARNING (JDBCPedidoCabeceraDAO:ultimoID): " + e.getMessage());
		}
		return id;
	}
	
	public List<PedidoCabecera> findU(int id) {
		List<PedidoCabecera> list = new ArrayList<PedidoCabecera>();
		ResultSet rs = conexion.query("Select * from pedidos_cabecera where usuarios_us_id="+id);
		try {
			while(rs.next()) {
				if(rs != null) {
					list.add(new PedidoCabecera(rs.getInt("pedc_id"),rs.getInt("usuarios_us_id"), rs.getInt("empresas_emp_id"),
								(rs.getString("pedc_estado")).charAt(0)));
				}
			}
		}catch (SQLException e) {
			System.out.println(">>>WARNING (JDBCPedidoCabeceraDAO:findU): " + e.getMessage());
		}
		return list;
	}

	@Override
	public void update(PedidoCabecera entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(PedidoCabecera entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<PedidoCabecera> find() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<PedidoCabecera> findPedidos(int idUsu) {
		
		List<PedidoCabecera> list = new ArrayList<PedidoCabecera>();
		ResultSet rs = conexion.query("select * from pedidos_cabecera where usuarios_us_id = "+idUsu+";");
		try {
			while (rs.next()) {
				list.add(new PedidoCabecera(rs.getInt("pedc_id"), rs.getInt("usuarios_us_id"), rs.getInt("empresas_emp_id"), rs.getString("pedc_estado").charAt(0)));
				
				
			}
		}catch(SQLException e) {
			System.out.println(">>>WARNING (JDBCPersonaDAO:find): " + e.getMessage());
		}
		return list;
	}
	
}
