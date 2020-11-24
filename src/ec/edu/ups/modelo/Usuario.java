package ec.edu.ups.modelo;

public class Usuario {
	private static final long serialVersionUID = 1L;
	private int id;
	private String nombre;
	private String apellido;
	private String correo;
	private String password;
	private char rol;
	private int FKEmpID;
	
	
	
	public Usuario(int id, String nombre, String apellido, String correo, String password, char rol, int fKEmpID) {
		super();
		this.setId(id);
		this.setNombre(nombre);
		this.setApellido(apellido);
		this.setCorreo(correo);
		this.setPassword(password);
		this.setRol(rol);
		this.setFKEmpID(fKEmpID);
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
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	public String getCorreo() {
		return correo;
	}
	public void setCorreo(String correo) {
		this.correo = correo;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public char getRol() {
		return rol;
	}
	public void setRol(char rol) {
		this.rol = rol;
	}
	public int getFKEmpID() {
		return FKEmpID;
	}
	public void setFKEmpID(int fKEmpID) {
		FKEmpID = fKEmpID;
	}
	
}
