package co.edu.uniquindio.marketplace.model;

import java.io.Serializable;
import java.util.ArrayList;

public class Vendedor extends Empleado implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	ArrayList<Publicacion> listaPublicaciones = new ArrayList<Publicacion>();
	ArrayList<Vendedor> listaContactos = new ArrayList<Vendedor>();
	ArrayList<Producto> listaProductos = new ArrayList<Producto>();
	private String notificacionesLikes = "";
	private String mensajes = "";
	
	
	/**
	 * Constructor con parametros de la clase Vendedor
	 * @param nombre
	 * @param apellido
	 * @param cedula
	 * @param direccion
	 * @param contraseña
	 */
	public Vendedor(String nombre, String apellido, String cedula, String direccion, String contraseña) {
		super(nombre, apellido, cedula, direccion, contraseña);
	}

	/**
	 * Constructor vacio de la clase Vendedor
	 */
	public Vendedor() {
	}

	//<------------------------------------------Metodos modificadores getters y setters----------------------------------------------------------------------->

	public ArrayList<Publicacion> getListaPublicaciones() {
		return listaPublicaciones;
	}

	public void setListaPublicaciones(ArrayList<Publicacion> listaPublicaciones) {
		this.listaPublicaciones = listaPublicaciones;
	}

	public ArrayList<Vendedor> getListaContactos() {
		return listaContactos;
	}

	public void setListaContactos(ArrayList<Vendedor> listaContactos) {
		this.listaContactos = listaContactos;
	}

	public ArrayList<Producto> getListaProductos() {
		return listaProductos;
	}

	public void setListaProductos(ArrayList<Producto> listaProductos) {
		this.listaProductos = listaProductos;
	}

	public String getNotificacionesLikes() {
		return notificacionesLikes;
	}

	public void setNotificacionesLikes(String notificacionesLikes) {
		this.notificacionesLikes = notificacionesLikes;
	}

	public String getMensajes() {
		return mensajes;
	}

	public void setMensajes(String mensajes) {
		this.mensajes = mensajes;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "Vendedor [listaPublicaciones=" + listaPublicaciones + ", listaContactos=" + listaContactos
				+ ", listaProductos=" + listaProductos + ", notificacionesLikes=" + notificacionesLikes + ", mensajes="
				+ mensajes + "]";
	}
	
	
	

	public boolean compararPublicacion(Publicacion publicacionSeleccionada){
		for (Publicacion publicacion : listaPublicaciones) {
			if(publicacion.getCodigo().equals(publicacionSeleccionada.getCodigo())){
				return true;
			}
		}
		return false;
	}

	public Producto obtenerProducto(String codigoProducto) {
		for (Producto producto : listaProductos) {
			if(producto != null){
				if(producto.getCodigo().equals(codigoProducto)){
					return producto;
				}
			}
		}
		return null;
	}
	
	public Publicacion obtenerPublicacion(String codigoPublicacion) {
		for (Publicacion publicacion : listaPublicaciones) {
			if(publicacion != null){
				if(publicacion.getCodigo().equals(codigoPublicacion)){
					return publicacion;
				}
			}
		}
		return null;
	}

	public void eliminarProducto(String codigoProducto) {
		Producto producto;
		for (int i = 0; i < listaProductos.size(); i++) {
			producto = listaProductos.get(i);
			if(producto.getCodigo().equals(codigoProducto)){
				listaProductos.remove(i);
			}
		}
		
	}

	public void eliminarPublicacion(String codigoPublicacion) {
		Publicacion publicacion;
		for (int i = 0; i < listaPublicaciones.size(); i++) {
			publicacion = listaPublicaciones.get(i);
			if(publicacion.getCodigo().equals(codigoPublicacion)){
				listaPublicaciones.remove(i);
			}
		}
	}

	public boolean verificarLike(String codigoPublicacion, String codigoUsuario) {
		for (Publicacion publicacion : listaPublicaciones) {
			if(publicacion != null){
				if(codigoPublicacion.equals(publicacion.getCodigo())){
					if(publicacion.verificarLike(codigoUsuario)){
						return true;
					}
				}
			}
		}
		return false;
	}

	/**
	 * Metodo para agregar un like a una publicacion del vendedor
	 * @param codigoPublicacion
	 * @param codigoUsuario
	 */
	public void agregarLike(String codigoPublicacion, String codigoUsuario) {
		for (Publicacion publicacion : listaPublicaciones) {
			if(publicacion != null){
				if(codigoPublicacion.equals(publicacion.getCodigo())){
					publicacion.getListaLikesUsuarios().add(codigoUsuario);
				}
			}
		}
	}

	/**
	 * Metodo para obtener la lista de contactos del vendedor sin contar con
	 * el vendedor con cedula que llega como parametro
	 * @param cedulaVendedor
	 * @return listaContactos (Sin contar con el vendedor con cedula de parametro)
	 */
	public ArrayList<Vendedor> obtenerListaContactos(String cedulaVendedor) {
		ArrayList<Vendedor> listaContactos = new ArrayList<Vendedor>();
		Vendedor contacto;
		
		for (int i = 0; i < getListaContactos().size(); i++) {
			contacto = getListaContactos().get(i);
			
			if(contacto != null){
				if(contacto.getCedula().equals(cedulaVendedor) == false){
					listaContactos.add(contacto);
				}
			}
		}
		return listaContactos;
	}

	public boolean verificarContacto(String codigoUsuario) {
		for (Vendedor vendedor : listaContactos) {
			if(vendedor != null){
				if(vendedor.getCedula().equals(codigoUsuario)){
					return true;
				}
			}
		}
		return false;
	}

	public boolean eliminarContacto(String cedula) {
		for (int i = 0; i < listaContactos.size(); i++) {
			Vendedor contacto = listaContactos.get(i);
			
			if(contacto != null){
				if(contacto.getCedula().equals(cedula)){
					listaContactos.remove(i);
					return true;
				}
			}
		}
		return false;
	}
	
	//-----------------------------------------------------------Reportes-----------------------------------------------------------------

	/**
	 * Metodo para obtener el numero de productos publicados en 
	 * la lista de publicaciones del vendedor
	 * @return int cantidad
	 */
	public int obtenerNumeroProductosPublicados() {
		int numeroProductos = 0;
		
		for (Publicacion publicacion : listaPublicaciones) {
			if(publicacion != null){
				if(publicacion.getProducto() != null){
					numeroProductos++;
				}
			}
		}
		return numeroProductos;
	}

	/**
	 * Metodo para obtener el numero de contactos del vendedor
	 * @return int cantidad de contactos
	 */
	public int obtenerNumeroContactos(){
		int numeroContactos=0;
		for (int i = 0; i < listaContactos.size(); i++) {
			if(listaContactos.get(i) != null){
				numeroContactos++;
			}
		}
		return numeroContactos;
	}

	/**
	 * Metodo para obtener la publicacion mas likeada 
	 * de entre lalista de publicaciones que posee 
	 * el vendedor
	 * @return Publicacion publicacionMasLikeada
	 */
	public Publicacion getPublicacionMasLikes() {
		Publicacion publicacionMasLikes = null;
		int contador                    = 0;
		
		for (Publicacion publicacion : listaPublicaciones) {
			if(publicacion != null){
				if(publicacion.getLike() >= contador){
					publicacionMasLikes = publicacion;
					contador            = publicacion.getLike();
				}
			}
		}
		return publicacionMasLikes;
	}
	
}
