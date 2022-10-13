package co.edu.uniquindio.marketplace.controllers;

import java.util.ArrayList;

import co.edu.uniquindio.marketplace.model.Marketplace;
import co.edu.uniquindio.marketplace.model.Vendedor;

public class CrudContactosViewController {
	
	ModelFactoryController modelFactoryController;
	Marketplace marketplace;
	
	public CrudContactosViewController(ModelFactoryController modelFactoryController) {
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

	public boolean eliminarContactoVendedor(Vendedor contactoSeleccionado, String codigoUsuario) {
		return modelFactoryController.eliminarContactoVendedor(contactoSeleccionado, codigoUsuario);
	}

	public boolean agregarContacto(Vendedor contactoSeleccionado, String codigoUsuario) {
		return modelFactoryController.agregarContacto(contactoSeleccionado, codigoUsuario);
	}

	public ArrayList<Vendedor> buscarVendedores(String nombre, String codigoUsuario, ArrayList<Vendedor> listaVendedoresEncontrados) {
		return modelFactoryController.buscarVendedores(nombre, codigoUsuario, listaVendedoresEncontrados);
	}

}
