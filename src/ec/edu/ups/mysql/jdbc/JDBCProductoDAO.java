package ec.edu.ups.mysql.jdbc;
//qweqew
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import ec.edu.ups.dao.ProductosDao;
import ec.edu.ups.modelo.Producto;
//we
public class JDBCProductoDAO extends JDBCGenericDAO<Producto, Integer> implements ProductosDao{
	@Override
	public void create (Producto producto) {
			conexion.update("INSERT Productos Values("+producto.getId()+",'"+producto.getNombre()+"',"+
							producto.getPrecio()+",'"+producto.getDescripcion()+"',"+producto.getDirImagen()+"',"+
							producto.getFKEmpID()+","+producto.getFKCatID());
	}
	
	@Override
	public List<Producto> find() {
		List<Producto> list = new ArrayList<Producto>();
		ResultSet rs = conexion.query("Select * From Productos");
		try {
			if(rs != null && rs.next()) {
				list.add(new Producto(rs.getInt("prod_id"),rs.getString("prod_nombre"),rs.getFloat("prod_precio"),
										rs.getString("prod_descripcion"),rs.getString("prod_im"),rs.getInt("empresas_emp_id"),
										rs.getInt("categorias_cat_id")));
			}
		}catch(SQLException e) {
			System.out.println(">>>WARNING (JDBCPersonaDAO:find): " + e.getMessage());
		}
		return list;
	}
	
	

	public List<Producto> findC(Integer id) {

		List<Producto> list = new ArrayList<Producto>();
		ResultSet rs = conexion.query("Select * From Productos Where Categorias_cat_id="+id);
		try {
			if(rs != null && rs.next()) {
				list.add(new Producto(rs.getInt("prod_id"),rs.getString("prod_nombre"),rs.getFloat("prod_precio"),
										rs.getString("prod_descripcion"),rs.getString("prod_im"),rs.getInt("empresas_emp_id"),
										rs.getInt("Categorias_cat_id")));
			}
		}catch(SQLException e) {

			System.out.println(">>>WARNING (JDBCPersonaDAO:findC): " + e.getMessage());

		}
		return list;
	}
	
	

	public List<Producto> findE(Integer id) {

		List<Producto> list = new ArrayList<Producto>();
		ResultSet rs = conexion.query("Select * From Productos Where empresas_emp_id="+id);
		try {
				while (rs.next()) {
					list.add(new Producto(rs.getInt("prod_id"),rs.getString("prod_nombre"),rs.getFloat("prod_precio"),
							rs.getString("prod_descripcion"),rs.getString("prod_im"),rs.getInt("empresas_emp_id"),
							rs.getInt("categorias_cat_id")));
				}
		}catch(SQLException e) {

			System.out.println(">>>WARNING (JDBCPersonaDAO:findE): " + e.getMessage());

		}
		return list;
	}
	
	@Override
	public Producto read(Integer id) {
		Producto producto = null;
		ResultSet rs = conexion.query("Select * From Productos When Empresas_emp_id="+id);
		try {
			if(rs != null && rs.next()) {
				producto = new Producto(rs.getInt("prod_id"),rs.getString("prod_nombre"),rs.getFloat("prod_precio"),
										rs.getString("prod_descripcion"),rs.getString("prod_im"),rs.getInt("Empresas_emp_id"),
										rs.getInt("Categorias_cat_id"));
			}
		}catch(SQLException e) {
			System.out.println(">>>WARNING (JDBCPersonaDAO:read): " + e.getMessage());
		}
		return producto;
	}
	
	@Override
	public void update(Producto producto) {

		conexion.update("Update Productos Set prod_nombre='"+producto.getNombre()+
						"' , prod_precio="+producto.getPrecio()+", prod_descripcion='"+producto.getDescripcion()+
						"', prod_im='"+producto.getDirImagen()+"',Empresas_emp_id="+producto.getFKEmpID()+
						"Categorias_cat_id="+producto.getFKCatID()+" Where prod_id="+producto.getId());

	}
	
	@Override
	public void delete(Producto producto) {
		conexion.update("DELETE FROM Productos WHERE id = " + producto.getId());
	}
	
}