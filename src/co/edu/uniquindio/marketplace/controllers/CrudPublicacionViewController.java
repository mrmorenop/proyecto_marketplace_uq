package co.edu.uniquindio.marketplace.controllers;

import java.sql.Date;

import co.edu.uniquindio.marketplace.model.Marketplace;
import co.edu.uniquindio.marketplace.model.Producto;
import co.edu.uniquindio.marketplace.model.Publicacion;

public class CrudPublicacionViewController {
	
	ModelFactoryController modelFactoryController;
	Marketplace marketplace;
	
	public CrudPublicacionViewController(ModelFactoryController modelFactoryController) {
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

	public boolean agregarPublicacion(String codigoUsuario, Producto productoSeleccionado, Date fechaPublicacion, int like, String comentario) {
		return modelFactoryController.agregarPublicacion(codigoUsuario, productoSeleccionado, fechaPublicacion, like, comentario);
	}

	public boolean actualizarPublicacion(String codigoUsuario, Publicacion publicacionSeleccionada, String nombre, String categoria, String precio, String estado, Date fecha) {
		return modelFactoryController.actualizarPublicacion(codigoUsuario, publicacionSeleccionada, nombre, categoria, precio, estado, fecha);
	}

	public boolean eliminarPublicacion(String codigoUsuario, Publicacion publicacionSeleccionada) {
		return modelFactoryController.eliminarPublicacion(codigoUsuario, publicacionSeleccionada);
	}

	public boolean darLikePublicacion(String codigoUsuario, Publicacion publicacionSeleccionada) {
		return modelFactoryController.darLikePublicacion(codigoUsuario, publicacionSeleccionada);
	}

	public void agregarComentarioPublicacion(Publicacion publicacionSeleccionada, String comentario, String codigoUsuario) {
		modelFactoryController.agregarComentarioPublicacion(publicacionSeleccionada, comentario, codigoUsuario);
	}

}
