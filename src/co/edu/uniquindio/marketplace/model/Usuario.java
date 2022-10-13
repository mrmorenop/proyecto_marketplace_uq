package co.edu.uniquindio.marketplace.model;

import java.io.Serializable;

public class Usuario implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String nombreUsuario;
	private String contrase�a;
	
	
	/**
	 * Metodo con parametros de la clase Usuario
	 * @param nombreUsuario
	 * @param contrase�a
	 * @param dioLike
	 */
	public Usuario(String nombreUsuario, String contrase�a) {
		this.nombreUsuario = nombreUsuario;
		this.contrase�a = contrase�a;
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

	public String getContrase�a() {
		return contrase�a;
	}

	public void setContrase�a(String contrase�a) {
		this.contrase�a = contrase�a;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "Usuario [nombreUsuario=" + nombreUsuario + ", contrase�a=" + contrase�a + "]";
	}

	
	
	
}
