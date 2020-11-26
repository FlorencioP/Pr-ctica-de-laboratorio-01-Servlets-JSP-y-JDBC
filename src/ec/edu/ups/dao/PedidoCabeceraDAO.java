package ec.edu.ups.dao;

import ec.edu.ups.modelo.PedidoCabecera;

public interface PedidoCabeceraDAO extends GenericcDAO<PedidoCabecera, Integer> {
	public abstract void modEst(char est, int id);
}
