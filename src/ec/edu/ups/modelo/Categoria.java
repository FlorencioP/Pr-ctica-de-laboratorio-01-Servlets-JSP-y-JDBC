package ec.edu.ups.modelo;

public class Categoria {
	private static final long serialVersionUID = 1L;
	private int id;
	private String nombre;
	
	public Categoria(int id, String nombre) {
		this.setId(id);
		this.setNombre(nombre);
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	
}
