package co.edu.uniquindio.marketplace.services;

import java.util.ArrayList;

import co.edu.uniquindio.marketplace.exceptions.LimiteVendedoresException;
import co.edu.uniquindio.marketplace.exceptions.VendedorExisteException;
import co.edu.uniquindio.marketplace.exceptions.VendedorNoExisteException;
import co.edu.uniquindio.marketplace.model.Vendedor;

/**
 * Clase interface IMarketplaceService para los servicios a ofrecer a la clase Marketplace
 */
public interface IMarketplaceService {

	public boolean crearVendedor(String nombre, String apellido, String cedula, String direccion, String contraseña) throws VendedorExisteException, LimiteVendedoresException;
	public boolean actualizarVendedor(String nombre, String apellido, String cedula, String cedulaActual, String direccion, String contraseña) throws VendedorNoExisteException;
	public boolean eliminarVendedor(String cedula);
	public Vendedor obtenerVendedor(String cedula);
	public boolean verificarExistenciaVendedor(String cedula);
	public ArrayList<Vendedor> obtenerListaVendedores();


}
