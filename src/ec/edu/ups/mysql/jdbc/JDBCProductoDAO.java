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
			conexion.update(" INSERT INTO productos (prod_id, prod_nombre, prod_precio, prod_descripcion, prod_im, empresas_emp_id, categorias_cat_id, prod_estado) values ('"+producto.getId()+"','"+producto.getNombre()+"','"+
							producto.getPrecio()+"','"+producto.getDescripcion()+"','"+producto.getDirImagen()+"','"+
							producto.getFKEmpID()+"','"+producto.getFKCatID()+"','A');");
	}
	
	@Override
	public List<Producto> find() {
		List<Producto> list = new ArrayList<Producto>();
		ResultSet rs = conexion.query("Select * From Productos where prod_estado = 'A'");
		try {
			if(rs != null && rs.next()) {
				list.add(new Producto(rs.getInt("prod_id"),rs.getString("prod_nombre"),rs.getFloat("prod_precio"),
										rs.getString("prod_descripcion"),rs.getString("prod_im"),rs.getInt("empresas_emp_id"),
										rs.getInt("categorias_cat_id"),(rs.getString("prod_estado")).charAt(0)));
			}
		}catch(SQLException e) {
			System.out.println(">>>WARNING (JDBCProductoDAO:find): " + e.getMessage());
		}
		return list;
	}
	
	
	public Integer findID(String nombre) {

		Integer id=0;
		ResultSet rs = conexion.query("Select prod_id From Productos Where prod_nombre='"+nombre+"'");
		try {
			if(rs != null && rs.next()) {
				id=rs.getInt("prod_id");
			}
		}catch(SQLException e) {

			System.out.println(">>>WARNING (JDBCProductoDAO:findID): " + e.getMessage());

		}
		return id;
	}
	
	

	public List<Producto> findC(Integer id, Integer emp) {

		List<Producto> list = new ArrayList<Producto>();
		ResultSet rs = conexion.query("Select * From Productos Where Categorias_cat_id="+id+ " And prod_estado = 'A' and empresas_emp_id="+emp);
		try {
			while (rs.next()) {
				list.add(new Producto(rs.getInt("prod_id"),rs.getString("prod_nombre"),rs.getFloat("prod_precio"),
										rs.getString("prod_descripcion"),rs.getString("prod_im"),rs.getInt("empresas_emp_id"),
										rs.getInt("Categorias_cat_id"),(rs.getString("prod_estado")).charAt(0)));
			}
		}catch(SQLException e) {

			System.out.println(">>>WARNING (JDBCProductoDAO:findC): " + e.getMessage());

		}
		return list;
	}
	
	

	public List<Producto> findE(Integer id) {

		List<Producto> list = new ArrayList<Producto>();
		ResultSet rs = conexion.query("Select * From Productos Where empresas_emp_id="+id+ " And prod_estado = 'A'");
		try {
				while (rs.next()) {
					list.add(new Producto(rs.getInt("prod_id"),rs.getString("prod_nombre"),rs.getFloat("prod_precio"),
							rs.getString("prod_descripcion"),rs.getString("prod_im"),rs.getInt("empresas_emp_id"),
							rs.getInt("categorias_cat_id"),(rs.getString("prod_estado")).charAt(0)));
				}
		}catch(SQLException e) {

			System.out.println(">>>WARNING (JDBCProductoDAO:findE): " + e.getMessage());

		}
		return list;
	}
	
	
	
	
	
	@Override
	public Producto read(Integer id) {
		Producto producto = null;
		ResultSet rs = conexion.query("Select * From Productos Where prod_id= "+id);
		//System.out.println(rs);
		try {
			while (rs.next() && rs.getString("prod_estado").charAt(0)=='A') {
				producto = new Producto(rs.getInt("prod_id"),rs.getString("prod_nombre"),rs.getFloat("prod_precio"),
										rs.getString("prod_descripcion"),rs.getString("prod_im"),rs.getInt("empresas_emp_id"),
										rs.getInt("categorias_cat_id"),(rs.getString("prod_estado")).charAt(0));
				
				System.out.println(producto);
			
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
						"', prod_im='"+producto.getDirImagen()+"',empresas_emp_id="+producto.getFKEmpID()+
						", categorias_cat_id="+producto.getFKCatID()+" Where prod_id="+producto.getId()+";");

	}
	
	@Override
	public void delete(Producto producto) {
		
		conexion.update( " UPDATE productos set prod_estado = 'E' WHERE prod_id = " + producto.getId());
	}

	
	
	public int buscarUltId() {
		
		ResultSet valor = conexion.query("Select MAX(prod_id) from productos;");
		int numero = 0 ;
		try {
			if (valor.next()) {
				numero = valor.getInt("MAX(prod_id)");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("Problema con buscarUltId");
			e.printStackTrace();
		}
		System.out.println("Numero ID : " + (numero +1));
		return numero + 1;
	}

	@Override
	public List<Producto> findCnomb(int cat, int idEmp, String tex) {
		
		List<Producto> list = new ArrayList<Producto>();
		ResultSet rs = conexion.query("Select * From Productos Where Categorias_cat_id="+cat+ " And prod_estado = 'A' and empresas_emp_id="+idEmp+" and prod_nombre rlike '"+tex+"'");
		try {
			while (rs.next()) {
				list.add(new Producto(rs.getInt("prod_id"),rs.getString("prod_nombre"),rs.getFloat("prod_precio"),
										rs.getString("prod_descripcion"),rs.getString("prod_im"),rs.getInt("empresas_emp_id"),
										rs.getInt("Categorias_cat_id"),(rs.getString("prod_estado")).charAt(0)));
			}
		}catch(SQLException e) {

			System.out.println(">>>WARNING (JDBCPersonaDAO:findC): " + e.getMessage());

		}
		return list;
		
	}
	
	
	
	//public Producto buscarPRO(int id) {
		
		//ResultSet rs = conexion.query("select * from productos where prod_id = "+id+";");
		//Producto este = null;
		
		//try {
		//	if (rs.next()) {
	//			este = new Producto(rs.getInt("prod_id"),rs.getString("prod_nombre"),rs.getFloat("prod_precio"),
	//					rs.getString("prod_descripcion"),rs.getString("prod_im"),rs.getInt("Empresas_emp_id"),
	//					rs.getInt("Categorias_cat_id"));
	//		}
	//	} catch (SQLException e) {
	//		// TODO Auto-generated catch block
	//		System.out.println("Problema con buscaPRO");
	//		e.printStackTrace();
	//	}
		
		
	//	return este;
	//}
	
	
}
