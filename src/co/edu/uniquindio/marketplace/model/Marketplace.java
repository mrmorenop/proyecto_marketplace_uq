package co.edu.uniquindio.marketplace.model;

import java.io.Serializable;
import java.sql.Date;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import co.edu.uniquindio.marketplace.exceptions.AdministradorAccionesException;
import co.edu.uniquindio.marketplace.exceptions.ContactoExistenteException;
import co.edu.uniquindio.marketplace.exceptions.LikePublicacionException;
import co.edu.uniquindio.marketplace.exceptions.LimiteVendedoresException;
import co.edu.uniquindio.marketplace.exceptions.VendedorExisteException;
import co.edu.uniquindio.marketplace.exceptions.VendedorNoExisteException;
import co.edu.uniquindio.marketplace.services.IMarketplaceService;

public class Marketplace implements IMarketplaceService, Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String nombre;
	Administrador administrador;
	ArrayList<Usuario> listaUsuarios = new ArrayList<>();
	ArrayList<Vendedor> listaVendedores = new ArrayList<>();

	/**
	 * Constructo con parametros de la clase principal Marketplace
	 * @param nombre
	 */
	public Marketplace (String nombre) {
		this.nombre = nombre;
	}
	
	/**
	 * Constructor vacio de la clase principal Marketplace
	 */
	public Marketplace() {
	}

	//<------------------------------------------Metodos modificadores getters y setters----------------------------------------------------------------------->
	
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Administrador getAdministrador() {
		return administrador;
	}

	public void setAdministrador(Administrador administrador) {
		this.administrador = administrador;
	}

	public ArrayList<Usuario> getListaUsuarios() {
		return listaUsuarios;
	}

	public void setListaUsuarios(ArrayList<Usuario> listaUsuarios) {
		this.listaUsuarios = listaUsuarios;
	}

	public ArrayList<Vendedor> getListaVendedores() {
		return listaVendedores;
	}

	public void setListaVendedores(ArrayList<Vendedor> listaVendedores) {
		this.listaVendedores = listaVendedores;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	

	@Override
	public String toString() {
		return "Marketplace [nombre=" + nombre + ", administrador=" + administrador + ", listaUsuarios=" + listaUsuarios
				+ ", listaVendedores=" + listaVendedores + "]";
	}
	
	//------------------------------------------------------------UTILIDADES---------------------------------------------------------------
	
	/**
	 * Metodo el cual genera un codigo aleatorio entre un rango determinado
	 * @param valorMinimo
	 * @param valorMaximo
	 * @return String valorAleatorio
	 */
	public static String generarCodigo(int valorMinimo, int valorMaximo) {
		return String.valueOf((int)(Math.random()*(valorMaximo + 1 - valorMinimo)) + valorMinimo);
	}
	

	@Override
	public boolean verificarExistenciaVendedor(String cedula){

		for (Vendedor vendedor : listaVendedores) {
			if(vendedor.getCedula().equalsIgnoreCase(cedula)){
				return true;
			}
		}
		return false;
	}
	
	/**
	 * Metodo para obtener un estado con parametro de string, debe llegar con valores de 0 hasta 2
	 * @param estado
	 * @return Estado estado
	 */
	public Estado obtenerEstado(String estado) {
		int estadoValor = Integer.valueOf(estado);
		
		switch (estadoValor) {
		case 0:
			return Estado.VENDIDO;
			
		case 1:
			return Estado.PUBLICADO;
			
		case 2:
			return Estado.CANCELADO;
			
		default:
			return null;
		}
	}

	/**
	 * Metodo para obtener una categoria con parametro de string, debe llegar con valores de 0 hasta 2
	 * @param categoria
	 * @return Categoria categoria
	 */
	public Categoria obtenerCategoria(String categoria) {
		
		int categoriaValor = Integer.valueOf(categoria);

		switch (categoriaValor) {
		case 0:
			return Categoria.MUEBLE;

		case 1:
			return Categoria.ELECTRODOMESTICO;

		case 2:
			return Categoria.CONSTRUCCION;

		default:
			return null;
		}
		
	}


	@Override
	public Vendedor obtenerVendedor(String cedula) {
		for (Vendedor vendedor : listaVendedores) {
			if(vendedor != null){
				if(vendedor.getCedula().equals(cedula)){
					return vendedor;
				}
			}
		}
		return null;
	}
	
	/**
	 * Metodo para verificar si el codigo del vendedor como parametro
	 * coinicide con la publicacion seleccionada por el usuario
	 * @param publicacionSeleccionada
	 * @param codigoUsuario
	 * @return true si coincide, false si no
	 */
	public boolean verificarPosesionPublicacion(Publicacion publicacionSeleccionada, String codigoUsuario){
		Vendedor vendedor = obtenerVendedor(codigoUsuario);
		
		if(vendedor != null){
			for (Publicacion publicacion : vendedor.getListaPublicaciones()) {
				if(publicacion != null){
					if(publicacion.getCodigo().equals(publicacionSeleccionada.getCodigo())){
						return true;
					}
				}
			}
		}
		return false;
	}
	
	/**
	 * Metodo para obtener un usuario a partir de su codigo
	 * @param codigoUsuario
	 * @return usuario
	 */
	private Usuario obtenerUsuario(String codigoUsuario) {
		for (Usuario usuario : listaUsuarios) {
			if(usuario != null){
				if(usuario.getNombreUsuario().equals(codigoUsuario)){
					return usuario;
				}
			}
		}
		return null;
	}
	
	/**
	 * Metodo para obtener la posicion de un vendedor en la lista de vendedores del marketplace
	 * @param cedula
	 * @return int posicion, valor positivo si encontro el vendedor, valor -1 si no encontró la posicion
	 */
	public int obtenerPosicionVendedor(String cedula) {
		for (int i = 0; i < listaVendedores.size(); i++) {
			if(listaVendedores.get(i).getCedula().equals(cedula)){
				return i;
			}
		}
		return -1;
	}

	@Override
	public ArrayList<Vendedor> obtenerListaVendedores() {
		return listaVendedores;
	}


	/**
	 * Obtiene el nombre de un vendedor en una posicion especifica de la lista de vendedores
	 * @param i
	 * @return STring nombreVendedor
	 */
	public String getNombreVendedor(int i) {
		return getListaVendedores().get(i).getNombre();
	}


	/**
	 * Obtiene el codigo de un vendedor en una posicion especifica de la lista de vendedores
	 * @param i
	 * @return String cedulaVendedor
	 */
	public String getCedulaVendedor(int i) {
		return getListaVendedores().get(i).getCedula();
	}

	/**
	 * Metodo el cual retorna en forma de string un texto que dice si el codigo por parametro pertenece al administrador, usuario o vendedor
	 * @param codigoUsuario
	 * @return String, "administrador" si el codigo pertenece a un administrador, "usuario" si el codigo pertenece a un usuario o "vendedor" si
	 * el codigo pertenece a un vendedor
	 */
	public String obtenerTipoUsuario(String codigoUsuario) {
		boolean centinela = administrador.getCedula().equals(codigoUsuario);
		
		if(centinela == true){
			return "administrador";
		}
		else{
			centinela = esUsuario(codigoUsuario);
			
			if(centinela == true){
				return "usuario";
			}
			else{
				return "vendedor";
			}
		}
		
	}

	/**
	 * Verifica si el codigo de parametro es de un usuario
	 * @param codigoUsuario
	 * @return true, si pertenece a un usuario, false si no
	 */
	public boolean esUsuario(String codigoUsuario) {
		for (Usuario usuario : listaUsuarios) {
			if(usuario != null){
				if(usuario.getNombreUsuario().equals(codigoUsuario)){
					return true;
				}
			}
		}
		return false;
	}
	
	/**
	 * Metodo para obtener de manera textual la categoria de un producto
	 * @param categoria
	 * @return String categoria
	 */
	public String obtenerTextoCategoriaProducto(Categoria categoria) {
		if(categoria == Categoria.MUEBLE){
			return "Mueble";
		}
		else{
			if(categoria  == Categoria.ELECTRODOMESTICO){
				return "Electrodomesticos";
			}
			else{
				return "Construccion";
			}
		}
	}

	/**
	 * Metodo para obtener de manera textual el estado de un producto
	 * @param estado
	 * @return String estado
	 */
	public String obtenerTextoEstadoProducto(Estado estado) {
		if(estado == Estado.VENDIDO){
			return "Vendido";
		}
		else{
			if(estado  == Estado.PUBLICADO){
				return "Publicado";
			}
			else{
				return "Cancelado";
			}
		}
	}
	
	/**
	 * Metodo para obtener un producto a partir de un vendedor dado
	 * @param vendedor
	 * @param codigoProducto
	 * @return Producto productoEncontrado, o null si no lo encuentra
	 */
	public Producto obtenerProducto(Vendedor vendedor, String codigoProducto) {
		Producto producto = vendedor.obtenerProducto(codigoProducto);
		
		if(producto != null){
			return producto;
		}
		else{
			return null;
		}
	}
	
	/**
	 * Metodo para obtener una publicacion a partir de un vendedor
	 * @param vendedor
	 * @param codigoPublicacion
	 * @return publicacion
	 */
	private Publicacion obtenerPublicacion(Vendedor vendedor, String codigoPublicacion) {
		Publicacion publicacion = vendedor.obtenerPublicacion(codigoPublicacion);
		
		if(publicacion != null){
			return publicacion;
		}
		else{
			return null;
		}
	}
	
	/**
	 * Metodo para obtener un codigo no repetido para un producto
	 * @param vendedor
	 * @return String codigoNoUsado
	 */
	public String generarCodigoProducto(Vendedor vendedor) {
		Producto producto = null;
		String codigo = "";
		boolean centinela = true;
		
		while (centinela) {
			codigo = generarCodigo(1000, 3000);
			producto = obtenerProducto(vendedor, codigo);
			
			if(producto == null){
				centinela = false;
			}
		}
		return codigo;
	}
	
	/**
	 * Metodo para obtener un codigo no repetido para una publicacion
	 * @param vendedor
	 * @return String codigoNoUsado
	 */
	public String generarCodigoPublicacion(Vendedor vendedor) {
		Publicacion publicacion = null;
		String codigo = "";
		boolean centinela = true;
		
		while (centinela) {
			codigo = generarCodigo(4000, 7000);
			publicacion = obtenerPublicacion(vendedor, codigo);
			
			if(publicacion == null){
				centinela = false;
			}
		}
		return codigo;
	}
	
	/**
	 * Metodo usado para realizar una busqueda de vendedores dado un nombre
	 * @param nombreVendedor
	 * @return ArrayList listaVendedoresEncontrados
	 */
	public ArrayList<Vendedor> obtenerVendedoresEncontrados(String nombreVendedor){
		ArrayList<Vendedor> listaVendedoresEncontrados = new ArrayList<Vendedor>();
		
		for (Vendedor vendedor : listaVendedores) {
			if(vendedor != null){
				if(vendedor.getNombre().equalsIgnoreCase(nombreVendedor)){
					listaVendedoresEncontrados.add(vendedor);
				}
			}
		}
		return listaVendedoresEncontrados;
	}
	
	/**
	 * Metodo para verificar si la persona de la sesion actual
	 * es contacto de la persona dueña de la publicacion
	 * @param publicacionSeleccionada
	 * @param codigoUsuario
	 * @return true si es un contacto, la misma persona o el administrador. false de otra manera
	 */
	public boolean verificarEsContacto(Publicacion publicacionSeleccionada, String codigoUsuario) {
		for (Vendedor vendedor : listaVendedores) {
			if(vendedor != null){
				if(vendedor.getCedula().equals(codigoUsuario) == false){
					boolean centinela = vendedor.compararPublicacion(publicacionSeleccionada);

					if(centinela == true){
						centinela = vendedor.verificarContacto(codigoUsuario);

						if(centinela == true){
							return true;
						}
					}
				}
			}
		}
		
		return false;
		
	}
	
	/**
	 * Metodo para obtener el nombre de usuario del codigo del usuario que
	 * viene como parametro
	 * @param codigoUsuario
	 * @return
	 */
	public String obtenerNombreUsuario(String codigoUsuario) {
		String nombreUsuario = "";
		String tipoUsuario   = obtenerTipoUsuario(codigoUsuario);
		
		if(tipoUsuario.equalsIgnoreCase("administrador")){
			nombreUsuario = administrador.getNombre();
		}
		else{
			if(tipoUsuario.equalsIgnoreCase("vendedor")){
				nombreUsuario = obtenerVendedor(codigoUsuario).getNombre();
			}
			else{
				if(tipoUsuario.equalsIgnoreCase("usuario")){
					nombreUsuario = obtenerUsuario(codigoUsuario).getNombreUsuario();
				}
			}
		}
		return nombreUsuario;
	}
	
	
	//-----------------------------------------------------Obtencion de listas para las tables de la GUI-------------------------------------------------------

	/**
	 * Metodo el cual obtiene la lista de publicaciones de un vendedor en especifico, con la posicion i de parametro. 
	 * Nota: captura una excepcion de desbordamiento por las tablas de publicaciones de la interfaz
	 * @param i
	 * @return ArrayList listaPublicaciones de un vendedor en especifico
	 */
	public ArrayList<Publicacion> getListaPublicacionesVendedor(int i) {
		ArrayList<Publicacion> listaPublicaciones;
		try{
			listaPublicaciones = getListaVendedores().get(i).getListaPublicaciones();
		}catch(Exception e){
			System.out.println("Tabla "+(i+1)+" de publicaciones vacia, nueva lista vacia");
			listaPublicaciones = new ArrayList<Publicacion>();
		}
		return listaPublicaciones;
	}
	
	/**
	 * Metodo para obtener la lista de productos de un vendedor en una posicion especifica.
	 * Nota: captura una excepcion de desbordamiento por las tablas de productos de la interfaz, 
	 * al saltar la excepcion, creamos una nueva lista vacia
	 * @param i
	 * @return Arraylist listaProductos de un vendedor en especifico
	 */
	public ArrayList<Producto> getListaProductosVendedor(int i) {
		ArrayList<Producto> listaProductos;
		try{
			listaProductos = getListaVendedores().get(i).getListaProductos();
		}catch(Exception e){
			System.out.println("Tabla "+(i+1)+" de productos vacia, nueva lista vacia");
			listaProductos = new ArrayList<Producto>();
		}
		return listaProductos;
	}
	
	/**
	 * Metodo para obtener la lista de contactos de un vendedor en una posicion especifica.
	 * Nota: captura una excepcion de desbordamiento por las tablas de contactos de la interfaz, 
	 * al saltar la excepcion, creamos una nueva lista vacia
	 * @param i
	 * @return Arraylist listaContactos de un vendedor en especifico
	 */
	public ArrayList<Vendedor> getListaContactosVendedor(int i) {
		ArrayList<Vendedor> listaContactos;
		try{
			listaContactos = getListaVendedores().get(i).getListaContactos();
		}catch(Exception e){
			System.out.println("Tabla "+(i+1)+" de contactos vacia, nueva lista vacia");
			listaContactos = new ArrayList<Vendedor>();
		}
		return listaContactos;
	}
	
	/**
	 * Metodo para obtener la lista de contactos sugeridos de un vendedor en una posicion especifica.
	 * Nota: captura una excepcion de desbordamiento por las tablas de contactos sugeridos de la interfaz, 
	 * al saltar la excepcion, creamos una nueva lista vacia
	 * @param i
	 * @return Arraylist listaContactosSugeridos de un vendedor en especifico
	 */
	public ArrayList<Vendedor> getListaContactosSugeridosVendedor(int i){
		ArrayList<Vendedor> listaContactosSugeridos;
		try {
			Vendedor vendedor       = getListaVendedores().get(i);
			listaContactosSugeridos = obtenerListaContactosSugeridos(vendedor.getCedula());
		} catch (Exception e) {
			System.out.println("Tabla "+(i+1)+" de sugerencia de contactos vacia, nueva lista vacia");
			listaContactosSugeridos = new ArrayList<Vendedor>();
		}
		
		return listaContactosSugeridos;
	}
	
	/**
	 * Metodo para obtener la lista de contactos sugeridos de un vendedor sin contar con
	 * el vendedor con la cedula que llega como parametro
	 * @param cedulaVendedor
	 * @return
	 */
	private ArrayList<Vendedor> obtenerListaContactosSugeridos(String cedulaVendedor) {
		ArrayList<Vendedor> listaContactosSugeridos = new ArrayList<Vendedor>();
		
		for (int i = 0; i < getListaVendedores().size(); i++) {
			Vendedor vendedorAux = getListaVendedores().get(i);
			
			if(vendedorAux != null){
				if(vendedorAux.getCedula().equals(cedulaVendedor) == false){
					ArrayList<Vendedor> listaContactos = vendedorAux.obtenerListaContactos(cedulaVendedor);
					listaContactosSugeridos.addAll(listaContactos);
				}
			}
			
		}
		return listaContactosSugeridos;
	}
	
	public String getNotificacionesLikesVendedor(int i) {
		String notificacionesLikes = "";
		try {
			Vendedor vendedor   = getListaVendedores().get(i);
			notificacionesLikes = vendedor.getNotificacionesLikes();
		} catch (Exception e) {
			System.out.println("Barra notificaciones "+(i+1)+" vacia, nuevo texto vacio");
		}
		
		return notificacionesLikes;
	}
	
	public String getMensajesVendedor(int i) {
		String mensajes = "";
		try {
			Vendedor vendedor = getListaVendedores().get(i);
			mensajes          = vendedor.getMensajes();
		} catch (Exception e) {
			System.out.println("Mensajes del vendedor "+(i+1)+" vacia, nuevo texto vacio");
		}
		
		return mensajes;
	}
	
	//---------------------------------------------------------------CRUD Vendedor-----------------------------------------------------------------------------

	@Override
	public boolean crearVendedor(String nombre, String apellido, String cedula, String direccion, String contraseña) throws VendedorExisteException, LimiteVendedoresException{
		boolean centinela = verificarExistenciaVendedor(cedula);
		
		if(centinela == false){
			if(listaVendedores.size() <= 10){
				Vendedor vendedor = new Vendedor(nombre, apellido, cedula, direccion, contraseña);
				getListaVendedores().add(vendedor);
				return true;
			}
			else{
				throw new LimiteVendedoresException("El limite de vendedores a crear ha sido sobrepasado, no se puede crear mas vendedores");
			}
		}
		else{
			throw new VendedorExisteException("Vendedor no creado. El vendedor con cedula "+cedula+" ya existe");
		}
	}
	
	@Override
	public boolean actualizarVendedor(String nombre, String apellido, String cedula, String cedulaActual, String direccion, String contraseña) throws VendedorNoExisteException{
		boolean centinela = verificarExistenciaVendedor(cedulaActual);
		Vendedor vendedor = obtenerVendedor(cedulaActual);
		
		if(centinela == true){
			vendedor.setNombre(nombre);
			vendedor.setApellido(apellido);
			vendedor.setCedula(cedula);
			vendedor.setDireccion(direccion);
			vendedor.setContraseña(contraseña);
			return true;
		}
		else{
			throw new VendedorNoExisteException("Vendedor no actualizado. El vendedor con cedula "+cedula+" no existe");
		}

	}
	
	@Override
	public boolean eliminarVendedor(String cedula) {
		for (int i = 0; i < listaVendedores.size(); i++) {
			if(listaVendedores.get(i).getCedula().equalsIgnoreCase(cedula)){
				listaVendedores.remove(i);
				return true;
			}
		}
		return false;
	}
	
	//--------------------------------------------------------------CRUD Producto---------------------------------------------------------------------------
	
	/**
	 * Metodo para agregar un producto a la lista de producto de un vendedor especifico por su codigo
	 * @param codigoUsuario
	 * @param nombre
	 * @param categoria
	 * @param precio
	 * @param estado
	 * @param fecha
	 * @return true, si se creo con exito
	 * @throws AdministradorAccionesException
	 */
	public boolean agregarProducto(String codigoUsuario, String nombre, String categoria, String precio, String estado, Date fecha) throws AdministradorAccionesException {
		Vendedor vendedor        = obtenerVendedor(codigoUsuario);
		Categoria categoriaValor = obtenerCategoria(categoria);
		Estado estadoValor       = obtenerEstado(estado);
		double precioValor       = Double.valueOf(precio);
		
		if(vendedor != null){
			
			String codigo = generarCodigoProducto(vendedor);
			Producto producto = new Producto();

			producto.setCodigo(codigo);
			producto.setNombre(nombre);
			producto.setPrecio(precioValor);
			producto.setEstado(estadoValor);
			producto.setCategoria(categoriaValor);
			producto.setFecha(fecha);
			vendedor.getListaProductos().add(producto);

			return true;
			
		}
		else{
			throw new AdministradorAccionesException("Producto no creado. El administrador no puede crear productos");
		}
	}

	/**
	 * Metodo el cual actualiza un producto para un vendedor
	 * @param productoSeleccionado
	 * @param codigoUsuario
	 * @param nombre
	 * @param categoria
	 * @param precio
	 * @param estado
	 * @param fecha
	 * @return
	 */
	public boolean actualizarProducto(Producto productoSeleccionado, String codigoUsuario, String nombre, String categoria, String precio, String estado, Date fecha) {
		Vendedor vendedor        = obtenerVendedor(codigoUsuario);
		Categoria categoriaValor = obtenerCategoria(categoria);
		Estado estadoValor       = obtenerEstado(estado);
		double precioValor       = Double.valueOf(precio);
		
		//Verificamos si el vendedor existe
		if(vendedor != null){
			Producto producto = obtenerProducto(vendedor, productoSeleccionado.getCodigo());

			//Verificamos si el producto del vendedor existe
			if(producto != null){
				producto.setNombre(nombre);
				producto.setPrecio(precioValor);
				producto.setEstado(estadoValor);
				producto.setCategoria(categoriaValor);
				producto.setFecha(fecha);

				return true;
			}
			else{
				return false;
			}
		}
		else{
			return false;
		}
	}
	
	/**
	 * Metodo el cual elimina un producto de la lista de productos de un vendedor
	 * @param codigoUsuario
	 * @param productoSeleccionado
	 * @return boolean true si se elimino, false si no
	 */
	public boolean eliminarProducto(String codigoUsuario, Producto productoSeleccionado) {
		Vendedor vendedor = obtenerVendedor(codigoUsuario);
		
		if(vendedor != null){
			Producto producto = obtenerProducto(vendedor, productoSeleccionado.getCodigo());
			
			if(producto != null){
				vendedor.eliminarProducto(producto.getCodigo());
				
				return true;
			}
			else{
				return false;
			}
		}
		else{
			return false;
		}
		
	}
	
	
	//---------------------------------------------------------------CRUD Publicacion---------------------------------------------------------------------

	/**
	 * Metodo para agregar una publicacion en la lista de publicaciones del vendedor con codigo como parametro
	 * @param codigoUsuario
	 * @param productoSeleccionado
	 * @param fechaPublicacion
	 * @param likes
	 * @param comentario
	 * @return true si se registro la publicacion con exito
	 * @throws AdministradorAccionesException
	 */
	public boolean agregarPublicacion(String codigoUsuario, Producto productoSeleccionado, Date fechaPublicacion, int likes, String comentario) throws AdministradorAccionesException {
		Vendedor vendedor = obtenerVendedor(codigoUsuario);
		
		if(vendedor != null){
			String codigo = generarCodigoPublicacion(vendedor);
			Publicacion publicacion = new Publicacion();
			Producto producto = new Producto();
			
			producto.setCodigo(productoSeleccionado.getCodigo());
			producto.setNombre(productoSeleccionado.getNombre());
			producto.setPrecio(productoSeleccionado.getPrecio());
			
			productoSeleccionado.setEstado(Estado.PUBLICADO);
			
			producto.setEstado(productoSeleccionado.getEstado());
			producto.setCategoria(productoSeleccionado.getCategoria());
			producto.setFecha(productoSeleccionado.getFecha());
			
			
			publicacion.setCodigo(codigo);
			publicacion.setProducto(producto);
			publicacion.setNombreProducto(producto.getNombre());
			publicacion.setPrecioProducto(producto.getPrecio());
			publicacion.setFechaPublicacion(fechaPublicacion);
			publicacion.setLike(likes);
			publicacion.setComentario(comentario);

			vendedor.getListaPublicaciones().add(publicacion);
			return true;
		}
		else{
			throw new AdministradorAccionesException("Publicacion no realizada. El administrador no puede realizar publicaciones");
		}
		
	}

	/**
	 * Metodo para actualizar una publicacion
	 * @param codigoUsuario 
	 * @param publicacionSeleccionada
	 * @param nombre
	 * @param categoria
	 * @param precio
	 * @param estado
	 * @param fecha
	 * @return true
	 */
	public boolean actualizarPublicacion(String codigoUsuario, Publicacion publicacionSeleccionada, String nombre, String categoria, String precio, String estado, Date fecha) {
		Vendedor vendedor        = obtenerVendedor(codigoUsuario);
		Categoria categoriaValor = obtenerCategoria(categoria);
		Estado estadoValor       = obtenerEstado(estado);
		double precioValor       = Double.valueOf(precio);
		
		if(vendedor != null){
			Publicacion publicacion = obtenerPublicacion(vendedor, publicacionSeleccionada.getCodigo());
			
			if(publicacion != null){
				publicacion.getProducto().setNombre(nombre);
				publicacion.getProducto().setPrecio(precioValor);
				publicacion.getProducto().setEstado(estadoValor);
				publicacion.getProducto().setCategoria(categoriaValor);
				publicacion.getProducto().setFecha(fecha);
				
				Producto producto = publicacion.getProducto();
				publicacion.setNombreProducto(producto.getNombre());
				publicacion.setPrecioProducto(producto.getPrecio());
				
				return true;
			}
			else{
				return false;
			}
		}
		else{
			return false;
		}
		
		
	}


	/**
	 *  Metodo el cual elimina una publicacion de la lista de publicaciones de un vendedor
	 * @param codigoUsuario
	 * @param publicacionSeleccionada
	 * @return true si se elimino la ublicacion, false si no
	 */
	public boolean eliminarPublicacion(String codigoUsuario, Publicacion publicacionSeleccionada) {
		Vendedor vendedor = obtenerVendedor(codigoUsuario);
		
		if(vendedor != null){
			Publicacion publicacion = obtenerPublicacion(vendedor, publicacionSeleccionada.getCodigo());
			
			if(publicacion != null){
				vendedor.eliminarPublicacion(publicacion.getCodigo());
				
				return true;
			}
			else{
				return false;
			}
		}
		else{
			return false;
		}
		
		
	}
	
	/**
	 * Metodo para agregar un comentario a una publicacion
	 * @param publicacionSeleccionada
	 * @param comentario
	 * @param codigoUsuario
	 */
	public void agregarComentarioPublicacion(Publicacion publicacionSeleccionada, String comentario, String codigoUsuario) {
		String nombreUsuario = obtenerNombreUsuario(codigoUsuario);
		publicacionSeleccionada.setComentario(publicacionSeleccionada.getComentario()+"\n"+nombreUsuario+": "+comentario);
	}
	
	//--------------------------------------------------------Administracion de likes--------------------------------------------------------------------

	/**
	 * Metodo el cual agrega likes a las publicaciones de un vendedor
	 * @param codigoUsuario 
	 * @param publicacionSeleccionada
	 * @return 
	 * @throws LikePublicacionException 
	 */
	public boolean darLikePublicacion(String codigoUsuario, Publicacion publicacionSeleccionada) throws LikePublicacionException {
		return darLikePublicacion(publicacionSeleccionada, codigoUsuario);
	}

	/**
	 * Metodo para agregar un like a una publicacion y si es un usuario
	 * @param publicacionSeleccionada
	 * @throws LikePublicacionException
	 */
//	private void darLikePublicacionUsuario(Publicacion publicacionSeleccionada) throws LikePublicacionException {
//		for (Usuario usuario : listaUsuarios) {
//			if(usuario != null){
//				if(usuario.isDioLike() == false){
//					publicacionSeleccionada.setLike(publicacionSeleccionada.getLike()+1);
//					usuario.setDioLike(true);
//				}
//				else{
//					throw new LikePublicacionException("Ya le diste un like a esta publicacion");
//				}
//			}
//		}
//		
//	}

	/**
	 * Metodo para agregar un like a una publicacion y si es un administrador
	 * @param publicacionSeleccionada
	 * @param codigoUsuario 
	 * @throws LikePublicacionException
	 */
//	private void darLikePublicacionAdministrador(Publicacion publicacionSeleccionada, String codigoUsuario) throws LikePublicacionException {
//		if(administrador != null){
//			if(administrador.isDioLike() == false){
//				publicacionSeleccionada.setLike(publicacionSeleccionada.getLike()+1);
//			}
//			else{
//				throw new LikePublicacionException("Ya le diste un like a esta publicacion");
//			}
//		}
//		
//	}

	/**
	 * Metodo para agregar un like a una publicacion y si es un vendedor
	 * @param publicacionSeleccionada
	 * @param codigoUsuario 
	 * @return 
	 * @throws LikePublicacionException
	 */
	private boolean darLikePublicacion(Publicacion publicacionSeleccionada, String codigoUsuario) throws LikePublicacionException {
		for (Vendedor vendedor : listaVendedores) {
			//Verificamos si el vendedor existe
			if(vendedor != null){ 
				
				//Verificamos si el vendedor ya le dio un like a la publicacion
				if(vendedor.verificarLike(publicacionSeleccionada.getCodigo(), codigoUsuario) == false){
					
					//Verificamos en cual publicacion hizo el like
					if(vendedor.compararPublicacion(publicacionSeleccionada)){
						//Agregamos el like
						publicacionSeleccionada.setLike(publicacionSeleccionada.getLike()+1);
						vendedor.agregarLike(publicacionSeleccionada.getCodigo(), codigoUsuario);
						vendedor.setNotificacionesLikes(vendedor.getNotificacionesLikes()+"A "+obtenerNombreUsuario(codigoUsuario)+" le gusta la publicacion de "+vendedor.getNombre()+"\n");
						
						return true;
					}
				}
				else{
					throw new LikePublicacionException("Ya le diste un like a esta publicacion");
				}
			}
		}
		return false;
		
	}
	
	public void enviarMensajeVendedor(String mensaje, String codigoUsuario, String cedulaReceptor) {
		
		Vendedor vendedor = obtenerVendedor(cedulaReceptor);
		String tipoUsuario = obtenerTipoUsuario(codigoUsuario);
		
		if(tipoUsuario.equalsIgnoreCase("Administrador")){
			if(vendedor != null){
				vendedor.setMensajes(vendedor.getMensajes()+"\n Administrador: "+mensaje);
			}
		}
		
		if(tipoUsuario.equalsIgnoreCase("Vendedor")){
			if(vendedor != null){
				Vendedor vendedorAux = obtenerVendedor(codigoUsuario);
				
				if(vendedorAux != null){
					vendedor.setMensajes(vendedor.getMensajes()+"\n "+vendedorAux.getNombre()+": "+mensaje);
				}
			}
		}
		
		if(tipoUsuario.equalsIgnoreCase("Usuario")){
			if(vendedor != null){
				Usuario usuario = obtenerUsuario(codigoUsuario);
				
				if(usuario != null){
					vendedor.setMensajes(vendedor.getMensajes()+"\n "+usuario.getNombreUsuario()+": "+mensaje);
				}
			}
		}
		
	}
	
	//--------------------------------------------------------------CRUD Contactos----------------------------------------------------------------

	/**
	 * Metodo para eliminar un contacto de un vendedor
	 * @param contactoSeleccionado
	 * @param codigoUsuario
	 * @return true = eliminado, false de otra manera
	 */
	public boolean eliminarContactoVendedor(Vendedor contactoSeleccionado, String codigoUsuario) {
		Vendedor vendedor = obtenerVendedor(codigoUsuario);
		
		if(vendedor != null){
			return vendedor.eliminarContacto(contactoSeleccionado.getCedula());
		}
		else{
			return false;
		}
	}

	/**
	 * Metodo para agregar un contacto dado el contacto seleccionado y el codigo del usuario actual
	 * @param contactoSeleccionado
	 * @param codigoUsuario
	 * @return
	 * @throws ContactoExistenteException
	 */
	public boolean agregarContacto(Vendedor contactoSeleccionado, String codigoUsuario) throws ContactoExistenteException {
		Vendedor vendedor = obtenerVendedor(codigoUsuario);
		
		if(vendedor != null){
			boolean centinela = vendedor.verificarContacto(contactoSeleccionado.getCedula());
			
			if(centinela == false){
				vendedor.getListaContactos().add(contactoSeleccionado);
				return true;
			}
			else{
				throw new ContactoExistenteException("El contacto que va a agregar ya existe en su lista de contactos");
			}
		}
		return false;
	}

	//------------------------------------------------------------Busqueda de vendedores--------------------------------------------------------------
	
	/**
	 * Metodo para realizar la busqueda de vendedores dado su nombre
	 * @param nombre
	 * @param codigoUsuario
	 * @param listaVendedoresEncontrados
	 * @return una lista de vendedores que coinciden con el nombre
	 */
	public ArrayList<Vendedor> buscarVendedores(String nombre, String codigoUsuario, ArrayList<Vendedor> listaVendedoresEncontrados) {
		
		for (Vendedor vendedor : listaVendedores) {
			if(vendedor != null){
				if(vendedor.getCedula().equals(codigoUsuario) == false){
					if(vendedor.getNombre().equalsIgnoreCase(nombre)){
						listaVendedoresEncontrados.add(vendedor);
					}
				}
			}
		}
		
		return listaVendedoresEncontrados;
	}
	
	//------------------------------------------------------------Info para reportes--------------------------------------------------------------------

	/**
	 * Metodo para obtener la cantidad de productos publicados por cada vendedor
	 * @return String con el nombre del vendedor y la cantidad de productos publicados
	 */
	public String obtenerCantidadProductosPublicadosVendedores() {
		String contenido = "";
		
		for (Vendedor vendedor : listaVendedores) {
			if(vendedor != null){
				contenido = contenido + vendedor.getNombre()+": "+vendedor.obtenerNumeroProductosPublicados()+" Producto/s\n";
			}
		}
		
		return contenido;
	}
	
	/**
	 * Metodo para obtener la cantidad de contactos de cada vendedor
	 * @return String con el nombre del vendedor y la cantidad de
	 * contactos que posee
	 */
	public String obtenerCantidadContactosVendedor(){
		String contenido="";

		for (Vendedor vendedor : listaVendedores) {
			if(vendedor != null){
				contenido= contenido + vendedor.getNombre()+ ": "+ vendedor.obtenerNumeroContactos() + " contacto(s) \n";
			}
		}
		return contenido;
	}
	
	/**
	 * Metodo para obtener el top de los productos de las publicaciones mas likeados de cada vendedor
	 * @return contenido, el cual tendra el top
	 */
	public String obtenerTopProductosMasLikeados() {
		ArrayList<Publicacion> listaPublicacionesMasLikeadas = obtenerListaPublicacionesMasLikeadosVendedores();
		String contenido                                     = "";
		int top                                              = 10;
		
		for (int i = 0; i < top; i++) {
			contenido = contenido+(i+1)+". "+determinarNumeroMayor(listaPublicacionesMasLikeadas)+"\n";
		}
		
		return contenido;
	}

	/**
	 * Metodo para determinar cual es el numero mayor de likes que tiene la lista de publicaciones 
	 * con mas likes y removiendo el elemento de la lista con la publicacion mas likeada
	 * @param listaPublicacionesMasLikeadas
	 * @return String del producto y el numero de likes mayor de la lista
	 */
	private String determinarNumeroMayor(ArrayList<Publicacion> listaPublicacionesMasLikeadas) {
		int mayor = 0;
		int posicionMayor = 0;
		String producto = "";
		
		if(listaPublicacionesMasLikeadas.size() > 0){
			for (int i = 0; i < listaPublicacionesMasLikeadas.size(); i++) {
				if(listaPublicacionesMasLikeadas.get(i) != null){
					if(listaPublicacionesMasLikeadas.get(i).getLike() > mayor){
						mayor         = listaPublicacionesMasLikeadas.get(i).getLike();
						producto      = listaPublicacionesMasLikeadas.get(i).getProducto().getNombre()+": "+listaPublicacionesMasLikeadas.get(i).getLike()+" like/s";
						posicionMayor = i;
					}
				}
			}
			listaPublicacionesMasLikeadas.remove(posicionMayor);
		}
		
		return producto;
	}

	/**
	 * Metodo para obtener la lista de publicaciones mas likeadas de cada vendedor
	 * @return listaPublicacionesMasLikeadasVendedores
	 */
	public ArrayList<Publicacion> obtenerListaPublicacionesMasLikeadosVendedores() {
		ArrayList<Publicacion> listaPublicacionesMasLikeadas = new ArrayList<Publicacion>();
		
		for (Vendedor vendedor : listaVendedores) {
			if(vendedor != null){
				listaPublicacionesMasLikeadas.add(vendedor.getPublicacionMasLikes());
			}
		}
		
		return listaPublicacionesMasLikeadas;
	}

}
