package co.edu.uniquindio.marketplace.controllers;

import co.edu.uniquindio.marketplace.model.Marketplace;

public class CrudVendedorViewController {

	ModelFactoryController modelFactoryController;
	Marketplace marketplace;

	public CrudVendedorViewController(ModelFactoryController modelFactoryController) {
		this.modelFactoryController = modelFactoryController;
		marketplace = modelFactoryController.getMarketplace();
	}

	//Metodos modificadores get y set -------------------------->
	public Marketplace getMarketplace() {
		return marketplace;
	}

	public void setMarketplace(Marketplace marketplace) {
		this.marketplace = marketplace;
	}

	/**
	 * Metodo para crear un vendedor
	 * @param nombre
	 * @param apellido
	 * @param cedula
	 * @param direccion
	 * @param contraseña
	 * @return boolean true si se pudo crear, de lo contrario false
	 */
	public boolean crearVendedor(String nombre, String apellido, String cedula, String direccion, String contraseña){
		return modelFactoryController.crearVendedor(nombre, apellido, cedula, direccion, contraseña);
	}
	
	
	/**
	 * Metodo que actualiza el vendedor
	 * @param nombre
	 * @param apellido
	 * @param cedula
	 * @param direccion
	 * @param cedulaActual
	 * @param contraseña
	 * @return boolean true si se pudo actualizar,de lo contrario false
	 */
	public boolean actualizarVendedor(String nombre, String apellido, String cedula, String cedulaActual, String direccion, String contraseña){
		return modelFactoryController.actualizarVendedor(nombre, apellido, cedula, cedulaActual, direccion, contraseña);
	}

	/**
	 * Metodo el cual elimina un vendedor
	 * @param cedula
	 * @return true si se elimino con exito, false si no
	 */
	public boolean eliminarVendedor(String cedula) {
		return modelFactoryController.eliminarVendedor(cedula);
	}

	public void guardarVendedores() {
		modelFactoryController.guardarVendedores();
		
	}
	
	public void cargarVendedores() {
		modelFactoryController.cargarDatosArchivos();
		
	}

	public void enviarMensajeVendedor(String mensaje, String codigoUsuario, String cedulaReceptor) {
		modelFactoryController.enviarMensajeVendedor(mensaje, codigoUsuario, cedulaReceptor);
	}


}
