package co.edu.uniquindio.marketplace.persistencia;

import java.beans.XMLEncoder;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

import co.edu.uniquindio.marketplace.model.Administrador;
import co.edu.uniquindio.marketplace.model.Marketplace;
import co.edu.uniquindio.marketplace.model.Producto;
import co.edu.uniquindio.marketplace.model.Publicacion;
import co.edu.uniquindio.marketplace.model.Usuario;
import co.edu.uniquindio.marketplace.model.Vendedor;

public class Persistencia {

	public static final String RUTA_ARCHIVO_VENDEDORES = "C://td//persistencia//archivos//archivoVendedores.txt";
	public static final String RUTA_ARCHIVO_ADMINISTRADOR = "C://td//persistencia//archivos//archivoAdministrador.txt";
	public static final String RUTA_ARCHIVO_USUARIOS = "C://td//persistencia//archivos//archivoUsuarios.txt";
	public static final String RUTA_ARCHIVO_PRODUCTOS = "C://td//persistencia//archivos//archivoProductos.txt";
	public static final String RUTA_ARCHIVO_PUBLICACIONES = "C://td//persistencia//archivos//archivoPublicaciones.txt";
	public static final String RUTA_ARCHIVO_CONTACTOS = "C://td//persistencia//archivos//archivoContactos.txt";
	public static final String RUTA_ARCHIVO_LOG = "C://td//persistencia//log//marketplaceLog.txt";
	public static final String RUTA_ARCHIVO_MODELO_MARKETPLACE_BINARIO = "C://td//persistencia//model.dat";
	public static final String RUTA_ARCHIVO_MODELO_BANCO_XML = "C://td//persistencia//model.xml";
	
	
	public static void cargarDatosArchivos(Marketplace marketplace) throws FileNotFoundException, IOException {
		
		
		//cargar archivo de vendedores
		ArrayList<Vendedor> vendedoresCargados = cargarVendedores();
		
		if(vendedoresCargados.size() > 0)
			marketplace.getListaVendedores().addAll(vendedoresCargados);

		
		//cargar archivo de administrador
		Administrador administradorCargado = cargarAdministrador();
		
		if(administradorCargado != null)
			marketplace.setAdministrador(administradorCargado);
		
		
		//cargar archivo de usuarios
		ArrayList<Usuario> usuariosCargados = cargarUsuarios();
		
		if(usuariosCargados.size() > 0)
			marketplace.getListaUsuarios().addAll(usuariosCargados);
		
		//cargar archivo de productos
		
		//cargar archivo empleados
		
		//cargar archivo prestamo
		
	}
	
	//<---------------------------------------------------------------SAVES------------------------------------------------------------------->
	
	/**
	 * Guarda en un archivo de texto todos la información de las personas almacenadas en el ArrayList
	 * @param objetos
	 * @param ruta
	 * @throws IOException
	 */
	public static void guardarVendedores(ArrayList<Vendedor> listaVendedor) throws IOException {
		// TODO Auto-generated method stub
		String contenido = "";
		
		for(Vendedor vendedor:listaVendedor) 
		{
			contenido+= vendedor.getNombre()+"@@"+vendedor.getApellido()+"@@"+vendedor.getCedula()+"@@"+vendedor.getDireccion()
		     +"@@"+vendedor.getContraseña()+"@@"+"\n";
		}
		ArchivoUtil.guardarArchivo(RUTA_ARCHIVO_VENDEDORES, contenido, false);
		
	}
	
	/**
	 * Guarda en un archivo de texto toda la información del administrador
	 * @param objetos
	 * @param ruta
	 * @throws IOException
	 */
	public static void guardarAdministrador(Administrador administrador) throws IOException {
		// TODO Auto-generated method stub
		String contenido = "";
		contenido+= administrador.getNombre()+"@@"+administrador.getApellido()+"@@"+administrador.getCedula()+"@@"+administrador.getDireccion()
		+"@@"+administrador.getContraseña()+"@@"+"\n";

		ArchivoUtil.guardarArchivo(RUTA_ARCHIVO_ADMINISTRADOR, contenido, false);
		
	}
	
	/**
	 * Guarda en un archivo de texto toda la información de los usurios
	 * @param listaUsuarios
	 * @throws IOException 
	 */
	public static void guardarUsuarios(ArrayList<Usuario> listaUsuarios) throws IOException {
		String contenido = "";
		
		for(Usuario usuario:listaUsuarios) {
			contenido+= usuario.getNombreUsuario()+"@@"+usuario.getContraseña()+"\n";
		}
		ArchivoUtil.guardarArchivo(RUTA_ARCHIVO_USUARIOS, contenido, false);
		
	}
	
	/**
	 * Guarda en un archivo de texto toda la info de los productos de cada vendedor
	 * @param listaVendedores
	 * @throws IOException
	 */
	public static void guardarProductos(ArrayList<Vendedor> listaVendedores) throws IOException {
		String contenido = "";

		for (Vendedor vendedor : listaVendedores) {
			if(vendedor != null){
				ArrayList<Producto> listaProductosVendedor = vendedor.getListaProductos();

				for (Producto producto : listaProductosVendedor) {
					contenido+= vendedor.getCedula()+"@@"+producto.getCodigo()+"@@"+producto.getNombre()+"@@"+producto.getPrecio()+"@@"+producto.getEstado()+"@@"+producto.getCategoria()+"@@"+producto.getFecha()+"\n";
				}
			}
		}
		ArchivoUtil.guardarArchivo(RUTA_ARCHIVO_PRODUCTOS, contenido, false);
	}
	
	/**
	 * Guarda en un archivo de texto toda la info de las publicaciones de cada vendedor
	 * @param listaVendedores
	 * @throws IOException
	 */
	public static void guardarPublicaciones(ArrayList<Vendedor> listaVendedores) throws IOException {
		String contenido = "";
		String codigos   = "";

		for (Vendedor vendedor : listaVendedores) {
			if(vendedor != null){
				ArrayList<Publicacion> listaPublicacionesVendedor = vendedor.getListaPublicaciones();

				for (Publicacion publicacion : listaPublicacionesVendedor) {
					
					//Un for para obtener los codigos de las personas que le han dado un like a la publicacion
					for (String codigoUsuarioDioLike : publicacion.getListaLikesUsuarios()) {
						codigos += codigoUsuarioDioLike;
					}
					contenido += vendedor.getCedula()+"@@"+publicacion.getCodigo()+"@@"+publicacion.getProducto().getCodigo()+"@@"+publicacion.getFechaPublicacion()+"@@"+publicacion.getLike()+"@@"+publicacion.getComentario()+codigos+"\n";
				}
			}
		}
		ArchivoUtil.guardarArchivo(RUTA_ARCHIVO_PUBLICACIONES, contenido, false);
	}
	
	/**
	 * Guarda en un archivo de texto toda la info de los contactos de cada vendedor
	 * @param listaVendedores
	 * @throws IOException
	 */
	public static void guardarContactos(ArrayList<Vendedor> listaVendedores) throws IOException {
		String contenido = "";

		for (Vendedor vendedor : listaVendedores) {
			if(vendedor != null){
				ArrayList<Vendedor> listaContactosVendedor = vendedor.getListaContactos();
				contenido += vendedor.getCedula()+"@@";
				for (Vendedor contacto : listaContactosVendedor) {
					contenido += contacto.getCedula()+"@@";
				}
				contenido += "\n";
			}
		}
		ArchivoUtil.guardarArchivo(RUTA_ARCHIVO_CONTACTOS, contenido, false);
	}
	
	//<-----------------------------------------------------------COPY-------------------------------------------------------------------------->
	
	/**
	 * Metodo el cual crea una copia de respaldo del archivo de la ruta de archivoVendedores
	 * @param listaVendedores 
	 * @throws IOException
	 */
	public static void crearCopiaArchivoVendedores(ArrayList<Vendedor> listaVendedores) throws IOException {
		String contenido = "";
		
		for(Vendedor vendedor:listaVendedores) 
		{
			contenido+= vendedor.getNombre()+"@@"+vendedor.getApellido()+"@@"+vendedor.getCedula()+"@@"+vendedor.getDireccion()
		     +"@@"+vendedor.getContraseña()+"@@"+"\n";
		}
		
		ArchivoUtil.cargarFechaSistema();
		ArchivoUtil.crearCopiaRespaldo("C://td//persistencia//respaldo//archivoVendedoresRespaldo_"+ArchivoUtil.getFechaSistema()+".txt", contenido, false);
		
	}
	
	/**
	 * Metodo el cual crea una copia de respaldo del archivo de la ruta de archivoAdministrador
	 * @param administrador 
	 * @throws IOException
	 */
	public static void crearCopiaArchivoAdministrador(Administrador administrador) throws IOException {
		String contenido = "";
		
		contenido+= administrador.getNombre()+"@@"+administrador.getApellido()+"@@"+administrador.getCedula()+"@@"+administrador.getDireccion()
		+"@@"+administrador.getContraseña()+"@@"+"\n";
		
		ArchivoUtil.cargarFechaSistema();
		ArchivoUtil.crearCopiaRespaldo("C://td//persistencia//respaldo//archivoAdministradorRespaldo_"+ArchivoUtil.getFechaSistema()+".txt", contenido, false);
		
	}
	
	/**
	 * Metodo el cual crea una copia de respaldo del archivo de la ruta de archivoUsuarios
	 * @param listaUsuarios 
	 * @throws IOException
	 */
	public static void crearCopiaArchivoUsuarios(ArrayList<Usuario> listaUsuarios) throws IOException {
		String contenido = "";
		
		for(Usuario usuario:listaUsuarios) 
		{
			contenido+= usuario.getNombreUsuario()+"@@"+usuario.getContraseña()+"\n";
		}
		
		ArchivoUtil.cargarFechaSistema();
		ArchivoUtil.crearCopiaRespaldo("C://td//persistencia//respaldo//archivoUsuariosRespaldo_"+ArchivoUtil.getFechaSistema()+".txt", contenido, false);
		
	}
	
	/**
	 * Metodo el cual crea una copia de respaldo del archivo de la ruta de archivoProductos
	 * @param listaVendedores
	 * @throws IOException
	 */
	public static void crearCopiaArchivoProductos(ArrayList<Vendedor> listaVendedores) throws IOException {
		String contenido = "";
		
		for (Vendedor vendedor : listaVendedores) {
			if(vendedor != null){
				ArrayList<Producto> listaProductosvendedor = vendedor.getListaProductos();
				
				for (Producto producto : listaProductosvendedor) {
					contenido+= vendedor.getCedula()+"@@"+producto.getCodigo()+"@@"+producto.getNombre()+"@@"+producto.getPrecio()+"@@"+producto.getEstado()+"@@"+producto.getCategoria()+"@@"+producto.getFecha()+"\n";
				}
			}
		}
		
		ArchivoUtil.cargarFechaSistema();
		ArchivoUtil.crearCopiaRespaldo("C://td//persistencia//respaldo//archivoProductosRespaldo_"+ArchivoUtil.getFechaSistema()+".txt", contenido, false);
		
	}
	
	/**
	 * Metodo el cual crea una copia de respaldo del archivo de la ruta de archivoPublicaciones
	 * @param listaVendedores
	 * @throws IOException
	 */
	public static void crearCopiaArchivoPublicaciones(ArrayList<Vendedor> listaVendedores) throws IOException {
		String contenido = "";
		String codigos   = "";

		for (Vendedor vendedor : listaVendedores) {
			if(vendedor != null){
				ArrayList<Publicacion> listaPublicacionesVendedor = vendedor.getListaPublicaciones();

				for (Publicacion publicacion : listaPublicacionesVendedor) {
					
					//Un for para obtener los codigos de las personas que le han dado un like a la publicacion
					for (String codigoUsuarioDioLike : publicacion.getListaLikesUsuarios()) {
						codigos += codigoUsuarioDioLike;
					}
					contenido += vendedor.getCedula()+"@@"+publicacion.getCodigo()+"@@"+publicacion.getProducto().getCodigo()+"@@"+publicacion.getFechaPublicacion()+"@@"+publicacion.getLike()+"@@"+publicacion.getComentario()+codigos+"\n";
				}
			}
		}
		ArchivoUtil.cargarFechaSistema();
		ArchivoUtil.crearCopiaRespaldo("C://td//persistencia//respaldo//archivoPublicacionesRespaldo_"+ArchivoUtil.getFechaSistema()+".txt", contenido, false);
	}
	
	/**
	 * Metodo el cual crea una copia de respaldo del archivo de la ruta de archivoContactos
	 * @param listaVendedores
	 * @throws IOException
	 */
	public static void crearCopiaArchivoContactos(ArrayList<Vendedor> listaVendedores) throws IOException {
		String contenido = "";

		for (Vendedor vendedor : listaVendedores) {
			if(vendedor != null){
				ArrayList<Vendedor> listaContactosVendedor = vendedor.getListaContactos();
				contenido += vendedor.getCedula()+"@@";
				for (Vendedor contacto : listaContactosVendedor) {
					contenido += contacto.getCedula()+"@@";
				}
				contenido += "\n";
			}
		}
		ArchivoUtil.cargarFechaSistema();
		ArchivoUtil.crearCopiaRespaldo("C://td//persistencia//respaldo//archivoContactosRespaldo_"+ArchivoUtil.getFechaSistema()+".txt", contenido, false);
	}
	
	
//	----------------------LOADS------------------------
	
	/**
	 * 
	 * @param tipoPersona
	 * @param ruta
	 * @return un Arraylist de personas con los datos obtenidos del archivo de texto indicado
	 * @throws FileNotFoundException
	 * @throws IOException
	 */
	public static ArrayList<Vendedor> cargarVendedores() throws FileNotFoundException, IOException 
	{
		ArrayList<Vendedor> vendedores = new ArrayList<Vendedor>();
		
		ArrayList<String> contenido = ArchivoUtil.leerArchivo(RUTA_ARCHIVO_VENDEDORES);
		String linea="";
		
		for (int i = 0; i < contenido.size(); i++)
		{
			linea = contenido.get(i);//juan,arias,125454,Armenia,uni1@,12454,125444
			Vendedor vendedor = new Vendedor(linea.split("@@")[0], linea.split("@@")[1], linea.split("@@")[2], linea.split("@@")[3], linea.split("@@")[4]);
			
			vendedores.add(vendedor);
		}
		return vendedores;
	}
	
	public static Administrador cargarAdministrador() throws IOException {
		Administrador administrador = null;
		
		ArrayList<String> contenido = ArchivoUtil.leerArchivo(RUTA_ARCHIVO_ADMINISTRADOR);
		String linea="";
		
		for (int i = 0; i < contenido.size(); i++) {
			linea = contenido.get(i);
			administrador = new Administrador(linea.split("@@")[0], linea.split("@@")[1], linea.split("@@")[2], linea.split("@@")[3], linea.split("@@")[4]);
		}
		return administrador;
	}
	
	public static ArrayList<Usuario> cargarUsuarios() throws FileNotFoundException, IOException 
	{
		ArrayList<Usuario> usuarios = new ArrayList<Usuario>();
		
		ArrayList<String> contenido = ArchivoUtil.leerArchivo(RUTA_ARCHIVO_USUARIOS);
		String linea="";
		
		for (int i = 0; i < contenido.size(); i++)
		{
			linea = contenido.get(i);
			Usuario usuario = new Usuario(linea.split("@@")[0], linea.split("@@")[1]);
			
			usuarios.add(usuario);
		}
		return usuarios;
	}
	

	//------------------------------------Guardar Archivo Log
	
	public static void guardaRegistroLog(String mensajeLog, int nivel, String accion)
	{
		
		ArchivoUtil.guardarRegistroLog(mensajeLog, nivel, accion, RUTA_ARCHIVO_LOG);
	}


	//<----------------------------------------Verificaciones login------------------------------------------------>
	
	/**
	 * Metodo el cual verifica si el usuario ingresado pertenece a la cedula y contraseña de un usuario especifico en el archivo
	 * @param cedula
	 * @param contraseñaUsuario
	 * @return true si el usuario y contraseña pertenece a la cedula y contraseña de un usuario registrado, false si no
	 * @throws IOException
	 */
	public static boolean verificarUsuarioLogin(String cedula, String contraseñaUsuario) throws IOException {
		ArrayList<String> contenidoVendedores = ArchivoUtil.leerArchivo(RUTA_ARCHIVO_VENDEDORES);
		ArrayList<String> contenidoAdministrador = ArchivoUtil.leerArchivo(RUTA_ARCHIVO_ADMINISTRADOR);
		ArrayList<String> contenidoUsuarios = ArchivoUtil.leerArchivo(RUTA_ARCHIVO_USUARIOS);
		String linea="";

		for (int i = 0; i < contenidoVendedores.size(); i++) {
			linea = contenidoVendedores.get(i);
			String cedulaContenido = linea.split("@@")[2];
			String contraseñaContenido = linea.split("@@")[4];
			
			if(cedulaContenido.equals(cedula) && contraseñaContenido.equals(contraseñaUsuario)){
				return true;
			}
		}
		
		for (int i = 0; i < contenidoAdministrador.size(); i++) {
			linea = contenidoAdministrador.get(i);
			String cedulaContenido = linea.split("@@")[2];
			String contraseñaContenido = linea.split("@@")[4];
			
			if(cedulaContenido.equals(cedula) && contraseñaContenido.equals(contraseñaUsuario)){
				return true;
			}
		}
		
		for (int i = 0; i < contenidoUsuarios.size(); i++) {
			linea = contenidoUsuarios.get(i);
			String nombreUsuarioContenido = linea.split("@@")[0];
			String contraseñaContenido = linea.split("@@")[1];
			
			if(nombreUsuarioContenido.equals(cedula) && contraseñaContenido.equals(contraseñaUsuario)){
				return true;
			}
		}
		return false;
	}
	
	
	//------------------------------------SERIALIZACIÓN  y XML
	
	
	public static Marketplace cargarRecursoMarketplaceBinario() {
		
		Marketplace marketplace = null;
		
		try {
			marketplace = (Marketplace)ArchivoUtil.cargarRecursoSerializado(RUTA_ARCHIVO_MODELO_MARKETPLACE_BINARIO);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return marketplace;
	}
	
	public static void guardarRecursoMarketplaceBinario(Marketplace marketplace) {
		
		try {
			ArchivoUtil.salvarRecursoSerializado(RUTA_ARCHIVO_MODELO_MARKETPLACE_BINARIO, marketplace);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	public static Marketplace cargarRecursoMarketplaceXML() {
		
		Marketplace marketplace = null;
		
		try {
			marketplace = (Marketplace)ArchivoUtil.cargarRecursoSerializadoXML(RUTA_ARCHIVO_MODELO_BANCO_XML);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return marketplace;

	}

	
	
	public static void guardarRecursoMarketplaceXML(Marketplace marketplace) {
		
		try {
			ArchivoUtil.salvarRecursoSerializadoXML(RUTA_ARCHIVO_MODELO_BANCO_XML, marketplace);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


	public static void crearCopiaRecursoXML(Marketplace marketplace) {
		ArchivoUtil.cargarFechaSistema();
		try {
			ArchivoUtil.salvarRecursoSerializadoXML("C://td//persistencia//respaldo//modelRespaldo_"+ArchivoUtil.getFechaSistema()+".xml", marketplace);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}


}
