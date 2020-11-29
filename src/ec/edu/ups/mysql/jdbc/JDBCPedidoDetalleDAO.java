package ec.edu.ups.mysql.jdbc;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import ec.edu.ups.dao.PedidoDetalleDAO;
import ec.edu.ups.modelo.PedidoDetalle;

public class JDBCPedidoDetalleDAO extends JDBCGenericDAO<PedidoDetalle, Integer> implements PedidoDetalleDAO{
	public List<PedidoDetalle> listPed(int id){
		List<PedidoDetalle> lis= new ArrayList<PedidoDetalle>();
		ResultSet rs = conexion.query("Select * From Pedidos_Detalle Where pedidos_cab_pedc_id="+id);
		try {
			while(rs.next()) {
				if(rs!=null) {
					lis.add(new PedidoDetalle(rs.getInt("pedD_id"), rs.getInt("pedD_cantidad"), 
							rs.getInt("pedidos_cab_pedc_id"), rs.getInt("productos_prod_id")));
				}
			}
		}catch(SQLException e) {
			System.out.println(">>>WARNING (JDBCPedidoDetalleDAO:listPed): " + e.getMessage());
		}
		return lis;
	}
	
	@Override
	public void delete(PedidoDetalle pedidoDetalle) {
		conexion.update("DELETE FROM Pedidos_Detalle WHERE pedD_id = " + pedidoDetalle.getId());
	}

	@Override
	public void create(PedidoDetalle pedidoDetalle) {
		conexion.update("Insert into Pedidos_Detalle Values("+pedidoDetalle.getId()+","+pedidoDetalle.getCantidad()+","+
						pedidoDetalle.getFKPedCabID()+","+pedidoDetalle.getFKProdID()+")");
	}
	
	public int ultimoID(){
		int id=0;
		ResultSet rs = conexion.query("select * from pedidos_detalle "
									 + "order by pedd_id desc "
									 + "limit 1;");
		try{
			if(rs != null && rs.next()) {
				id=rs.getInt("pedd_id");
			}
		}catch (SQLException e) {
			System.out.println(">>>WARNING (JDBCPedidoDetalleDAO:ultimoID): " + e.getMessage());
		}
		return id;
	}

	@Override
	public void update(PedidoDetalle pedidoDet) {
		conexion.update("Update pedidos_detalle Set pedd_cantidad="+pedidoDet.getCantidad()+
						",pedidos_cab_pedc_id="+pedidoDet.getFKPedCabID()+",productos_prod_id="+pedidoDet.getFKProdID()+
						" where pedd_id="+pedidoDet.getId());
	}

	@Override
	public PedidoDetalle read(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<PedidoDetalle> find() {
		// TODO Auto-generated method stub
		return null;
	}

}
