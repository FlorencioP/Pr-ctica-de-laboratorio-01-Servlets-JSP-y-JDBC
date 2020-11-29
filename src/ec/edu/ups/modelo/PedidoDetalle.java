package ec.edu.ups.modelo;

public class PedidoDetalle {
	private static final long serialVersionUID = 1L;
	private int id;
	private int cantidad;
	private int FKPedCabID;
	private int FKProdID;
	private String nombre;
	private double d;
	
<<<<<<< HEAD
	public PedidoDetalle(int id, int cantidad, int FKPedCabId, int FKProdID, String string, double d) {
=======
	public PedidoDetalle(int id, int cantidad, int FKPedCabID, int FKProdID) {
>>>>>>> branch 'master' of https://github.com/FlorencioP/Pr-ctica-de-laboratorio-01-Servlets-JSP-y-JDBC.git
		this.setId(id);
		this.setCantidad(cantidad);
		this.setFKPedCabID(FKPedCabId);
		this.setFKProdID(FKProdID);
		this.setNombre(string);
		this.setD(d);
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

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public double getD() {
		return d;
	}

	public void setD(double d) {
		this.d = d;
	}
	
}
