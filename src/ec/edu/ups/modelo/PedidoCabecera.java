package ec.edu.ups.modelo;

public class PedidoCabecera {

	private static final long serialVersionUID = 1L;
	
	private int id;
	private int fk_usu_id;
	private int fk_emp_id;
	private char estado;
	
	public PedidoCabecera(int id, int fk_usu_id, int fk_emp_id, char estado ) {
		this.setId(id);
		this.setFk_usu_id(fk_usu_id);
		this.setFk_emp_id(fk_emp_id);
		this.setEstado(estado);
	}
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getFk_usu_id() {
		return fk_usu_id;
	}
	public void setFk_usu_id(int fk_usu_id) {
		this.fk_usu_id = fk_usu_id;
	}
	public int getFk_emp_id() {
		return fk_emp_id;
	}
	public void setFk_emp_id(int fk_emp_id) {
		this.fk_emp_id = fk_emp_id;
	}
	public char getEstado() {
		return estado;
	}
	public void setEstado(char estado) {
		this.estado = estado;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	
	
	
}
