package co.edu.uniquindio.marketplace.model;

import java.io.Serializable;

public class Empleado implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String nombre;
	private String apellido;
	private String cedula;
	private String direccion;
	private String contraseña;
	
	/**
	 * Constructor con parametros de la clase Empleado
	 * @param nombre
	 * @param apellido
	 * @param cedula
	 * @param direccion
	 * @param contraseña
	 */
	public Empleado(String nombre, String apellido, String cedula, String direccion, String contraseña) {
		this.nombre = nombre;
		this.apellido = apellido;
		this.cedula = cedula;
		this.direccion = direccion;
		this.contraseña = contraseña;
	}

	/**
	 * Constructor vacio de la clase Empleado
	 */
	public Empleado() {
	}


	//<------------------------------------------Metodos modificadores getters y setters----------------------------------------------------------------------->
	
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

	public String getCedula() {
		return cedula;
	}

	public void setCedula(String cedula) {
		this.cedula = cedula;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getContraseña() {
		return contraseña;
	}

	public void setContraseña(String contraseña) {
		this.contraseña = contraseña;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "Empleado [nombre=" + nombre + ", apellido=" + apellido + ", cedula=" + cedula + ", direccion="
				+ direccion + ", contraseña=" + contraseña + "]";
	}
	
	
	
	
}
