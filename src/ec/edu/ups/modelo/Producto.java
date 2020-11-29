package ec.edu.ups.modelo;
//qweqwe
public class Producto {
	@Override
	public String toString() {
		return "Producto [id=" + id + ", nombre=" + nombre + ", precio=" + precio + ", descripcion=" + descripcion
				+ ", dirImagen=" + dirImagen + ", FKEmpID=" + FKEmpID + ", FKCatID=" + FKCatID + "]";
	}

	private static final long serialVersionUID = 1L;
	private int id;
	private String nombre;
	private float precio;
	private String descripcion;
	private String dirImagen;
	private int FKEmpID;
	private int FKCatID;
	private char estado;
	
	public Producto(int id, String nombre, float precio, String descripcion, String dirImagen,int FkEmpID,int FKCatID,char estado) {
		this.setId(id);
		this.setNombre(nombre);
		this.setPrecio(precio);
		this.setDescripcion(descripcion);
		this.setDirImagen(dirImagen);
		this.setFKEmpID(FkEmpID);
		this.setFKCatID(FKCatID);
		this.setEstado(estado);
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
	public float getPrecio() {
		return precio;
	}
	public void setPrecio(float precio) {
		this.precio = precio;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public String getDirImagen() {
		return dirImagen;
	}
	public void setDirImagen(String dirImagen) {
		this.dirImagen = dirImagen;
	}
	public int getFKCatID() {
		return FKCatID;
	}
	public void setFKCatID(int fKCatID) {
		FKCatID = fKCatID;
	}

	public int getFKEmpID() {
		return FKEmpID;
	}

	public void setFKEmpID(int fKEmpID) {
		FKEmpID = fKEmpID;
	}

	public char getEstado() {
		return estado;
	}

	public void setEstado(char estado) {
		this.estado = estado;
	}
	
	
}
