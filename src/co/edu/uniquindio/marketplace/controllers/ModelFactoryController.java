package co.edu.uniquindio.marketplace.controllers;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import co.edu.uniquindio.marketplace.exceptions.AdministradorAccionesException;
import co.edu.uniquindio.marketplace.exceptions.ContactoExistenteException;
import co.edu.uniquindio.marketplace.exceptions.LikePublicacionException;
import co.edu.uniquindio.marketplace.exceptions.LimiteVendedoresException;
import co.edu.uniquindio.marketplace.exceptions.VendedorExisteException;
import co.edu.uniquindio.marketplace.exceptions.VendedorNoExisteException;
import co.edu.uniquindio.marketplace.model.Administrador;
import co.edu.uniquindio.marketplace.model.Categoria;
import co.edu.uniquindio.marketplace.model.Estado;
import co.edu.uniquindio.marketplace.model.Marketplace;
import co.edu.uniquindio.marketplace.model.Producto;
import co.edu.uniquindio.marketplace.model.Publicacion;
import co.edu.uniquindio.marketplace.model.Usuario;
import co.edu.uniquindio.marketplace.model.Vendedor;
import co.edu.uniquindio.marketplace.persistencia.ArchivoUtil;
import co.edu.uniquindio.marketplace.persistencia.Persistencia;
import co.edu.uniquindio.marketplace.services.IModelFactoryService;

public class ModelFactoryController implements IModelFactoryService, Runnable{

	Marketplace marketplace;
	Thread hiloGuardarSourceXML;
	Thread hiloGuardarArchivoLog;
	Thread hiloGuardarArchivos;
	
	String mensaje;
	int nivel;
	String accion;

	//------------------------------  Singleton ------------------------------------------------
	// Clase estatica oculta. Tan solo se instanciara el singleton una vez
	private static class SingletonHolder {
		// El constructor de Singleton puede ser llamado desde aquí al ser protected
		private final static ModelFactoryController eINSTANCE = new ModelFactoryController();
	}

	// Método para obtener la instancia de nuestra clase
	public static ModelFactoryController getInstance() {
		return SingletonHolder.eINSTANCE;
	}

	public ModelFactoryController() {
		System.out.println("Invocación clase singleton");
		
		//1. Inicializar datos y luego guardarlos en archivos
//		iniciarSalvarDatosPrueba();
		
		//2. Cargar los datos de los archivos
//		cargarDatosArchivos();
		
		//3. Guardar y cargar el recurso serializable binario
//		guardarResourceBinario();
//		cargarResourceBinario();
		
		//4. Guardar y cargar el recurso serializable XML
//		guardarResourceXML();
		cargarResourceXML();
		
		//5. Crear respaldo de los datos de los archivos
//		crearRespaldos();
		
		//6. Crear respaldo del recurso serializable XML
//		crearRespaldoXML();
		
		if(marketplace == null){
			System.out.println("Es null el Marketplace");
			inicializarDatos();
			
		}
		
	}
	

	/**
	 * Inicializa datos de prueba y los guarda en un archivo de texto plano
	 */
	public void iniciarSalvarDatosPrueba() {
		inicializarDatos();
		guardarAdministrador();
		guardarVendedores();
		guardarUsuarios();
		guardarProductos();
		guardarPublicaciones();
		guardarContactos();
	}
	
	public void registrarAccionesSistema(String mensaje, int nivel, String accion){
		this.mensaje = mensaje;
		this.nivel   = nivel;
		this.accion  = accion;
		
		hiloGuardarArchivoLog = new Thread(this);
		hiloGuardarArchivoLog.start();
		
	}
	
	//-------------------------------------------------------Metodo run de implementacion de hilos------------------------------------------------
	
	@Override
	public void run() {
		Thread hiloActual = Thread.currentThread();
		
		if(hiloActual == hiloGuardarSourceXML){
			Persistencia.guardarRecursoMarketplaceXML(marketplace);
		}
		
		if(hiloActual == hiloGuardarArchivoLog){
			Persistencia.guardaRegistroLog(mensaje, nivel, accion);
		}
		
		if(hiloActual == hiloGuardarArchivos){
			guardarAdministrador();
			guardarVendedores();
			guardarUsuarios();
			guardarProductos();
			guardarPublicaciones();
			guardarContactos();
		}
	}
	
	//<---------------------------------------------------------------SAVES---------------------------------------------------------------------->

	/**
	 * Metodo para guardar todo en archivo de texto plano
	 */
	public void guardarArchivos() {
		hiloGuardarArchivos = new Thread(this);
		hiloGuardarArchivos.start();
	}
	
	
	/**
	 * Metodo para guardar Vendedores en archivo de texto plano
	 */
	public void guardarVendedores() {
		try {
			Persistencia.guardarVendedores(obtenerListaVendedores());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
	}
	
	/**
	 * Metodo para guardar el objeto Administrador en archivo de texto plano
	 */
	public void guardarAdministrador() {
		try {
			Persistencia.guardarAdministrador(marketplace.getAdministrador());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	/**
	 * Metodo para guardar usuarios en archivo de texto plano
	 */
	public void guardarUsuarios() {
		try {
			Persistencia.guardarUsuarios(marketplace.getListaUsuarios());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	/**
	 * Metodo para guardar los productos de cada vendedor
	 */
	private void guardarProductos() {
		ArrayList<Vendedor> listaVendedores = marketplace.getListaVendedores();
		
		try {
			Persistencia.guardarProductos(listaVendedores);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	/**
	 * Metodo para guardar las publicaciones de cada vendedor
	 */
	private void guardarPublicaciones() {
		ArrayList<Vendedor> listaVendedores = marketplace.getListaVendedores();
		
		try {
			Persistencia.guardarPublicaciones(listaVendedores);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * Metodo para guardar los contactos de cada vendedor
	 */
	private void guardarContactos() {
		ArrayList<Vendedor> listaVendedores = marketplace.getListaVendedores();
		
		try {
			Persistencia.guardarContactos(listaVendedores);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * Metodo el cual guarda el objeto de la clase principal Marketplace serializando en binario
	 */
	public void guardarResourceBinario(){
		Persistencia.guardarRecursoMarketplaceBinario(marketplace);
	}
	
	/**
	 * Metodo el cual guarda el objeto de la clase principal Marketplace serializando en XML
	 */
	public void guardarResourceXML() {
		hiloGuardarSourceXML = new Thread(this);
		hiloGuardarSourceXML.start();
	}
	
	//<-------------------------------------------------------------LOADS------------------------------------------------------------------------->

	/**
	 * Metodo el cual carga datos de objetos desde un archivo de texto plano
	 */
	public void cargarDatosArchivos() {
		try {
			marketplace = new Marketplace();
			
			Persistencia.cargarDatosArchivos(marketplace);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
	}
	
	/**
	 * Metodo el cual carga el objeto de la clase principal Marketplace serializando en binario
	 */
	public void cargarResourceBinario(){
		marketplace = Persistencia.cargarRecursoMarketplaceBinario();
	}
	
	/**
	 * Metodo el cual carga el objeto de la clase principal Marketplace serializando en XML
	 */
	public void cargarResourceXML() {
		marketplace = Persistencia.cargarRecursoMarketplaceXML();
		
	}
	
	//<-------------------------------------------------------Creacion de Respaldos--------------------------------------------------------->
	
	private void crearRespaldos() {
		crearRespaldoVendedores();
		crearRespaldoAdministrador();
		crearRespaldoUsuarios();
		crearRespaldoProductos();
		crearRespaldoPublicaciones();
		crearRespaldoContactos();
	}

	
	public void crearRespaldoVendedores() {
		try {
			Persistencia.crearCopiaArchivoVendedores(marketplace.getListaVendedores());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public void crearRespaldoAdministrador() {
		try {
			Persistencia.crearCopiaArchivoAdministrador(marketplace.getAdministrador());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public void crearRespaldoUsuarios() {
		try {
			Persistencia.crearCopiaArchivoUsuarios(marketplace.getListaUsuarios());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	private void crearRespaldoProductos() {
		try {
			Persistencia.crearCopiaArchivoProductos(marketplace.getListaVendedores());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private void crearRespaldoPublicaciones() {
		try {
			Persistencia.crearCopiaArchivoPublicaciones(marketplace.getListaVendedores());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private void crearRespaldoContactos() {
		try {
			Persistencia.crearCopiaArchivoContactos(marketplace.getListaVendedores());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void crearRespaldoXML() {
		Persistencia.crearCopiaRecursoXML(marketplace);
		
	}
	
	
	//-----------------------------------------------------------------------------------------------------------------------------------S

	public Marketplace getMarketplace() {
		return marketplace;
	}

	public void setMarketplace(Marketplace marketplace) {
		this.marketplace = marketplace;
	}

	/**
	 * Metodo el cual inicializa datos de prueba para la aplicacion del Marketplace
	 */
	private void inicializarDatos() {

		//Inicializacion Marketplace y su admin
		marketplace = new Marketplace("Marketplace UQ");
		Administrador administrador = new Administrador("admin", " ", "admin", " ", "admin");
		marketplace.setAdministrador(administrador);
		
		Vendedor contacto;
		
		//Creamos datos del vendedor 1
		
		Producto producto = new Producto();
		producto.setCodigo("2030");
		producto.setNombre("Pala");
		producto.setPrecio(1000);
		producto.setEstado(Estado.VENDIDO);
		producto.setCategoria(Categoria.CONSTRUCCION);
		producto.setFecha(Date.valueOf(LocalDate.now()));
		
		Publicacion publicacion = new Publicacion("5000", producto, producto.getNombre(), producto.getPrecio(), Date.valueOf(LocalDate.now()), 0, "Jaime: Buenarda");

		Vendedor vendedor = new Vendedor("Jaime", "Velez", "01", "Armenia", "1234");
		vendedor.getListaProductos().add(producto);
		vendedor.getListaPublicaciones().add(publicacion);
		vendedor.setMensajes("Manolo: Hola");
		marketplace.getListaVendedores().add(vendedor);
		
		contacto = vendedor;
		
		//Creamos datos del vendedor 2
		
		producto = new Producto();
		producto.setCodigo("1300");
		producto.setNombre("Motosierra");
		producto.setPrecio(10100);
		producto.setEstado(Estado.CANCELADO);
		producto.setCategoria(Categoria.CONSTRUCCION);
		producto.setFecha(Date.valueOf(LocalDate.now()));

		vendedor = new Vendedor("Manolo", "Martinez", "02", "Circasia", "1234");
		vendedor.getListaProductos().add(producto);
		vendedor.getListaContactos().add(contacto);
		marketplace.getListaVendedores().add(vendedor);

		contacto = vendedor;
		marketplace.getListaVendedores().get(0).getListaContactos().add(contacto);
		
		//Creamos datos del vendedor 3

		producto = new Producto();
		producto.setCodigo("1300");
		producto.setNombre("Silla");
		producto.setPrecio(10100);
		producto.setEstado(Estado.VENDIDO);
		producto.setCategoria(Categoria.MUEBLE);
		producto.setFecha(Date.valueOf(LocalDate.now()));

		vendedor = new Vendedor("Andres", "Florez", "03", "Tebaida", "1234");
		vendedor.getListaProductos().add(producto);
		marketplace.getListaVendedores().add(vendedor);
		
		marketplace.getListaVendedores().get(1).getListaContactos().add(vendedor);

		//Creamos usuarios
		
		Usuario usuario = new Usuario("Pepe", "0000");
		marketplace.getListaUsuarios().add(usuario);

		
		System.out.println("Marketplace inicializado");

	}
	
	//-------------------------------------------------------CRUD Vendedor----------------------------------------------------------

	@Override
	public boolean crearVendedor(String nombre, String apellido, String cedula, String direccion, String contraseña) {
		boolean centinela = false;
		try {
			centinela = marketplace.crearVendedor(nombre, apellido, cedula, direccion, contraseña);
		} catch (VendedorExisteException | LimiteVendedoresException e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
		}
		
		return centinela;
	}

	

	@Override
	public boolean actualizarVendedor(String nombre, String apellido, String cedula, String cedulaActual, String direccion, String contraseña) {
		boolean centinela = false;
		try{
			centinela = marketplace.actualizarVendedor(nombre, apellido, cedula, cedulaActual, direccion, contraseña);
		}
		catch (VendedorNoExisteException e){
			JOptionPane.showMessageDialog(null, e.getMessage());
		}
		
		return centinela;
		
	}

	@Override
	public boolean eliminarVendedor(String cedula) {
		boolean centinela = false;
		
		centinela = marketplace.eliminarVendedor(cedula);
		
		return centinela;
	}

	//----------------------------------------------------------Utilidades------------------------------------------------------------
	
	@Override
	public Vendedor obtenerVendedor(String cedula) {
		return marketplace.obtenerVendedor(cedula);
	}

	@Override
	public ArrayList<Vendedor> obtenerListaVendedores() {
		return marketplace.obtenerListaVendedores();
	}

	@Override
	public boolean verificarExistenciaVendedor(String cedula) {
		return marketplace.verificarExistenciaVendedor(cedula);
	}

	public String getNombreVendedor(int i) {
		return marketplace.getNombreVendedor(i);
	}

	public String getCedulaVendedor(int i) {
		return marketplace.getCedulaVendedor(i);
	}
	
	public String obtenerTextoCategoriaProducto(Categoria categoria) {
		return marketplace.obtenerTextoCategoriaProducto(categoria);
	}
	
	public String obtenerTipoUsuario(String codigoUsuario) {
		return marketplace.obtenerTipoUsuario(codigoUsuario);
	}
	
	public String obtenerTextoEstadoProducto(Estado estado) {
		return marketplace.obtenerTextoEstadoProducto(estado);
	}
	
	public boolean verificarEsContacto(Publicacion publicacionSeleccionada, String codigoUsuario) {
		return marketplace.verificarEsContacto(publicacionSeleccionada, codigoUsuario);
	}
	
	public String obtenerNombreUsuario(String codigoUsuario) {
		return marketplace.obtenerNombreUsuario(codigoUsuario);
	}
	
	public boolean verificarPosesionPublicacion(Publicacion publicacionSeleccionada, String codigoUsuario) {
		return marketplace.verificarPosesionPublicacion(publicacionSeleccionada, codigoUsuario);
	}

	//---------------------------------------------------Obtencion de listas para los tables de la GUI----------------------------------------------------------
	
	public ArrayList<Producto> getListaProductosVendedor(int i) {
		return marketplace.getListaProductosVendedor(i);
	}
	
	public ArrayList<Publicacion> getListaPublicacionesVendedor(int i) {
		return marketplace.getListaPublicacionesVendedor(i);
	}
	
	public ArrayList<Vendedor> getListaContactosVendedor(int i) {
		return marketplace.getListaContactosVendedor(i);
	}
	
	public ArrayList<Vendedor> getListaContactosSugeridosVendedor(int i){
		return marketplace.getListaContactosSugeridosVendedor(i);
	}
	
	public ArrayList<Vendedor> obtenerVendedoresEncontrados(String nombreVendedor){
		return marketplace.obtenerVendedoresEncontrados(nombreVendedor);
	}
	
	public String getNotificacionesLikesVendedor(int i) {
		return marketplace.getNotificacionesLikesVendedor(i);
	}
	
	public String getMensajesVendedor(int i) {
		return marketplace.getMensajesVendedor(i);
	}

	//----------------------------------------------------CRUD producto y publicacion---------------------------------------------------------------------------
	
	public boolean agregarProducto(String codigoUsuario, String nombre, String categoria, String precio, String estado, Date fecha) {
		boolean centinela = false;
		try {
			centinela = marketplace.agregarProducto(codigoUsuario, nombre, categoria, precio, estado, fecha);
		} catch (AdministradorAccionesException e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
		}

		return centinela;
	}

	public boolean agregarPublicacion(String codigoUsuario, Producto productoSeleccionado, Date fechaPublicacion, int likes, String comentario) {
		boolean centinela = false;
		
		try {
			centinela = marketplace.agregarPublicacion(codigoUsuario,productoSeleccionado, fechaPublicacion, likes, comentario);
		} catch (AdministradorAccionesException e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
		}
		return centinela;
	}
	
	public boolean actualizarProducto(Producto productoSeleccionado, String codigoUsuario, String nombre, String categoria, String precio, String estado, Date fecha) {
		return marketplace.actualizarProducto(productoSeleccionado, codigoUsuario, nombre, categoria, precio, estado, fecha);
	}

	public boolean actualizarPublicacion(String codigoUsuario, Publicacion publicacionSeleccionada, String nombre, String categoria, String precio, String estado, Date fecha) {
		return marketplace.actualizarPublicacion(codigoUsuario, publicacionSeleccionada, nombre, categoria, precio, estado, fecha);
	}

	public boolean eliminarProducto(String codigoUsuario, Producto productoSeleccionado) {
		return marketplace.eliminarProducto(codigoUsuario, productoSeleccionado);
	}

	public boolean eliminarPublicacion(String codigoUsuario, Publicacion publicacionSeleccionada) {
		return marketplace.eliminarPublicacion(codigoUsuario, publicacionSeleccionada);
	}

	public boolean darLikePublicacion(String codigoUsuario, Publicacion publicacionSeleccionada) {
		boolean centinela = false;
		try {
			centinela = marketplace.darLikePublicacion(codigoUsuario, publicacionSeleccionada);
		} catch (LikePublicacionException e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
		}
		return centinela;
	}

	public void agregarComentarioPublicacion(Publicacion publicacionSeleccionada, String comentario, String codigoUsuario) {
		marketplace.agregarComentarioPublicacion(publicacionSeleccionada, comentario, codigoUsuario);
	}
	
	public void enviarMensajeVendedor(String mensaje, String codigoUsuario, String cedulaReceptor) {
		marketplace.enviarMensajeVendedor(mensaje, codigoUsuario, cedulaReceptor);
	}

	//----------------------------------------------------------CRUD contactos------------------------------------------------------------------------
	
	public boolean eliminarContactoVendedor(Vendedor contactoSeleccionado, String codigoUsuario) {
		return marketplace.eliminarContactoVendedor(contactoSeleccionado, codigoUsuario);
	}

	public boolean agregarContacto(Vendedor contactoSeleccionado, String codigoUsuario) {
		boolean centinela = false;
		try {
			centinela = marketplace.agregarContacto(contactoSeleccionado, codigoUsuario);
		} catch (ContactoExistenteException e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
		}
		return centinela;
	}
	
	//-----------------------------------------------------------Busqueda de vendedores-----------------------------------------------------------------

	public ArrayList<Vendedor> buscarVendedores(String nombre, String codigoUsuario, ArrayList<Vendedor> listaVendedoresEncontrados) {
		return marketplace.buscarVendedores(nombre, codigoUsuario, listaVendedoresEncontrados);
	}

	//-----------------------------------------------------------Guardado de reportes-------------------------------------------------------------------
	
	public void guardarReportes(String ruta, String contenido, boolean flagGuardado) {
		try {
			ArchivoUtil.guardarArchivo(ruta, contenido, flagGuardado);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	public String establecerPlantillaReporte(String tema) {
		String contenido = "";

		contenido = "                                                       Reporte de: "+tema+" \n \n";
		ArchivoUtil.cargarFechaSistema();
		contenido = contenido+"                                                                 Fecha: "+ArchivoUtil.getFechaSistema()+"\n \n";
		contenido = contenido+"                                                             Reporte realizado por: Administrador \n \n";
		contenido = contenido+"Informacion reporte: \n \n";

		return contenido;
	}

	public String obtenerCantidadProductosPublicadosVendedores() {
		return marketplace.obtenerCantidadProductosPublicadosVendedores();
	}

	public String obtenerCantidadContactosVendedores() {
		return marketplace.obtenerCantidadContactosVendedor();
	}
	
	public String obtenerTopProductosMasLikeados() {
		return marketplace.obtenerTopProductosMasLikeados();
	}

}
