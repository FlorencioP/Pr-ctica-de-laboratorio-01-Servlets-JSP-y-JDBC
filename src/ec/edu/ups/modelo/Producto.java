package ec.edu.ups.modelo;
//qweqwe
public class Producto {
	private static final long serialVersionUID = 1L;
	private int id;
	private String nombre;
	private float precio;
	private String descripcion;
	private String dirImagen;
	private int FKEmpID;
	private int FKCatID;
	
	public Producto(int id, String nombre, float precio, String descripcion, String dirImagen, int FkEmp,int FKCatID) {
		this.setId(id);
		this.setNombre(nombre);
		this.setPrecio(precio);
		this.setDescripcion(descripcion);
		this.setDirImagen(dirImagen);
		this.setFKEmpID(FKEmpID);
		this.setFKCatID(FKCatID);
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
	
	
}
