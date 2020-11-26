package ec.edu.ups.mysql.jdbc;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import ec.edu.ups.dao.PedidoCabeceraDAO;
import ec.edu.ups.modelo.PedidoCabecera;

public class JDBCPedidoCabeceraDAO extends JDBCGenericDAO<PedidoCabecera, Integer> implements PedidoCabeceraDAO {
	
	@Override
	public PedidoCabecera read(Integer id) {
		
		PedidoCabecera pedCab =null;
		
		ResultSet rs = conexion.query("Select * from Pedidos_Cabecera when pedC_id =" + id);
		
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
		conexion.update("Update Productos_Cabecera Set pedc_estado="+est+"where pedC_id="+id);
	}

	@Override
	public void create(PedidoCabecera entity) {
		// TODO Auto-generated method stub
		
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
	
	
	
	
}
