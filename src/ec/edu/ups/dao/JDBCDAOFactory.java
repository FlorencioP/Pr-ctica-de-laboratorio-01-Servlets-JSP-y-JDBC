package ec.edu.ups.dao;
import java.util.List;

import ec.edu.ups.modelo.Categoria;
import ec.edu.ups.modelo.PedidoCabecera;
import ec.edu.ups.modelo.PedidoDetalle;
import ec.edu.ups.modelo.Usuario;
import ec.edu.ups.mysql.jdbc.JDBCCategoriaDAO;
import ec.edu.ups.mysql.jdbc.JDBCPedidoCabeceraDAO;
import ec.edu.ups.mysql.jdbc.JDBCPedidoDetalleDAO;
//qweqwew
import ec.edu.ups.mysql.jdbc.JDBCProductoDAO;
import ec.edu.ups.mysql.jdbc.JDBCUsuarioDAO;

public class JDBCDAOFactory extends DAOFactory{
		
	@Override
	public ProductosDao getProductosDao() {
		return new JDBCProductoDAO();
	}

	@Override
	public UsuariosDAO getUsuariosDAO() {
		// TODO Auto-generated method stub
		return new JDBCUsuarioDAO();
	}

	@Override
	public CAtegoriaDAO getcCAtegoriaDAO() {
		// TODO Auto-generated method stub
		return new JDBCCategoriaDAO() ;
	}

	@Override
	public PedidoCabeceraDAO getpeCabeceraDAO() {
		// TODO Auto-generated method stub
		return new JDBCPedidoCabeceraDAO();
	}

	@Override
	public PedidoDetalleDAO getpeDetalleDAO() {
		// TODO Auto-generated method stub
		return new JDBCPedidoDetalleDAO();
	}
	
}
