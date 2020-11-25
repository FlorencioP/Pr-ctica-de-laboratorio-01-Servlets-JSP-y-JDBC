package ec.edu.ups.modelo;

public class PedidoDetalle {
	private static final long serialVersionUID = 1L;
	private int id;
	private int cantidad;
	private int FKPedCabID;
	private int FKProdID;
	
	public PedidoDetalle(int id, int cantidad, int FKPedCabId, int FKProdID) {
		this.setId(id);
		this.setCantidad(cantidad);
		this.setFKPedCabID(FKPedCabID);
		this.setFKProdID(FKProdID);
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getCantidad() {
		return cantidad;
	}
	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}
	public int getFKPedCabID() {
		return FKPedCabID;
	}
	public void setFKPedCabID(int fKPedCabID) {
		FKPedCabID = fKPedCabID;
	}
	public int getFKProdID() {
		return FKProdID;
	}
	public void setFKProdID(int fKProdID) {
		FKProdID = fKProdID;
	}
	
}
