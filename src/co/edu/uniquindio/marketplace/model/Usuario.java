package co.edu.uniquindio.marketplace.model;

import java.io.Serializable;

public class Usuario implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String nombreUsuario;
	private String contraseña;
	
	
	/**
	 * Metodo con parametros de la clase Usuario
	 * @param nombreUsuario
	 * @param contraseña
	 * @param dioLike
	 */
	public Usuario(String nombreUsuario, String contraseña) {
		this.nombreUsuario = nombreUsuario;
		this.contraseña = contraseña;
	}

	/**
	 * Constructor vacio de la clase Usuario
	 */
	public Usuario() {
	}


	//<------------------------------------------Metodos modificadores getters y setters----------------------------------------------------------------------->
	
	public String getNombreUsuario() {
		return nombreUsuario;
	}

	public void setNombreUsuario(String nombreUsuario) {
		this.nombreUsuario = nombreUsuario;
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
		return "Usuario [nombreUsuario=" + nombreUsuario + ", contraseña=" + contraseña + "]";
	}

	
	
	
}
