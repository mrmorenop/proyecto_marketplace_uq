package co.edu.uniquindio.marketplace.model;

import java.io.Serializable;

public class Administrador extends Empleado implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * 
	 */
	
	/**
	 * Constructor con parametros de la clase Administrador
	 * @param nombre
	 * @param apellido
	 * @param cedula
	 * @param direccion
	 * @param contraseņa
	 */
	public Administrador(String nombre, String apellido, String cedula, String direccion, String contraseņa) {
		super(nombre, apellido, cedula, direccion, contraseņa);
	}

	/**
	 * Constructor vacio de la clase Administrador
	 */
	public Administrador() {
	}

	//<------------------------------------------Metodos modificadores getters y setters----------------------------------------------------------------------->

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "Administrador []";
	}

	
	
	

}
