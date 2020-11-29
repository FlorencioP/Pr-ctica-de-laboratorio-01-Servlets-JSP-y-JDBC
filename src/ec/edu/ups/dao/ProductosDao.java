package ec.edu.ups.dao;

import java.util.List;

import ec.edu.ups.modelo.Producto;

public interface ProductosDao extends GenericcDAO<Producto, Integer> {
	public abstract List<Producto> findC(Integer id);
	public abstract List<Producto> findE(Integer id);
	public abstract Integer findID(String nombre);
}
