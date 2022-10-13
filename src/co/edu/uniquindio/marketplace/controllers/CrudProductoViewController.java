package co.edu.uniquindio.marketplace.controllers;

import java.sql.Date;

import co.edu.uniquindio.marketplace.model.Marketplace;
import co.edu.uniquindio.marketplace.model.Producto;

public class CrudProductoViewController {
	
	ModelFactoryController modelFactoryController;
	Marketplace marketplace;
	
	public CrudProductoViewController(ModelFactoryController modelFactoryController) {
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

	public boolean agregarProducto(String codigoUsuario, String nombre, String categoria, String precio, String estado, Date fecha) {
		return modelFactoryController.agregarProducto(codigoUsuario, nombre, categoria, precio, estado, fecha);
	}

	public boolean actualizarProductoVendedor(Producto productoSeleccionado, String codigoUsuario, String nombre, String categoria, String precio, String estado, Date fecha) {
		return modelFactoryController.actualizarProducto(productoSeleccionado, codigoUsuario, nombre, categoria, precio, estado, fecha);
	}

	public boolean eliminarProducto(String codigoUsuario, Producto productoSeleccionado) {
		return modelFactoryController.eliminarProducto(codigoUsuario, productoSeleccionado);
	}

}
