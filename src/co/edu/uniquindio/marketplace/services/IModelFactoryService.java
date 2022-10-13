package co.edu.uniquindio.marketplace.services;

import java.util.ArrayList;

import co.edu.uniquindio.marketplace.exceptions.VendedorExisteException;
import co.edu.uniquindio.marketplace.model.Vendedor;

/**
 * Clase interface IModelFactoryService para los servicios (metodos) a ofrecer a la clase ModelFactoryController
 */
public interface IModelFactoryService {

	public boolean crearVendedor(String nombre, String apellido, String cedula, String direccion, String contraseña) throws VendedorExisteException;
	public boolean actualizarVendedor(String nombre, String apellido, String cedula, String cedulaActual, String direccion, String contraseña);
	public boolean eliminarVendedor(String cedula);
	public Vendedor obtenerVendedor(String cedula);
	public boolean verificarExistenciaVendedor(String cedula);
	public ArrayList<Vendedor> obtenerListaVendedores();

}
