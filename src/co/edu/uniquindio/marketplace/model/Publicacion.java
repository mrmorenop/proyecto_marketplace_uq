package co.edu.uniquindio.marketplace.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;

public class Publicacion implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String codigo;
	private Producto producto;
	private String nombreProducto;
	private double precioProducto;
	private Date fechaPublicacion;
	private int like;
	private String comentario;
	ArrayList<String> listaLikesUsuarios = new ArrayList<String>();
	
	/**
	 * Constructor con parametros de la clase Publicacion
	 * @param codigo
	 * @param producto
	 * @param nombreProducto
	 * @param precioProducto
	 * @param fechaPublicacion
	 * @param like
	 * @param comentario
	 */
	public Publicacion(String codigo, Producto producto, String nombreProducto, double precioProducto, Date fechaPublicacion, int like, String comentario) {
		this.codigo = codigo;
		this.producto = producto;
		this.nombreProducto = nombreProducto;
		this.precioProducto = precioProducto;
		this.fechaPublicacion = fechaPublicacion;
		this.like = like;
		this.comentario = comentario;
	}

	/**
	 * Constructor vacio de la clase Publicacion
	 */
	public Publicacion() {
	}

	//<------------------------------------------Metodos modificadores getters y setters----------------------------------------------------------------------->
	
	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public Producto getProducto() {
		return producto;
	}

	public void setProducto(Producto producto) {
		this.producto = producto;
	}

	public String getNombreProducto() {
		return nombreProducto;
	}

	public void setNombreProducto(String nombreProducto) {
		this.nombreProducto = nombreProducto;
	}

	public double getPrecioProducto() {
		return precioProducto;
	}

	public void setPrecioProducto(double precioProducto) {
		this.precioProducto = precioProducto;
	}

	public Date getFechaPublicacion() {
		return fechaPublicacion;
	}

	public void setFechaPublicacion(Date fechaPublicacion) {
		this.fechaPublicacion = fechaPublicacion;
	}

	public int getLike() {
		return like;
	}

	public void setLike(int like) {
		this.like = like;
	}

	public String getComentario() {
		return comentario;
	}

	public void setComentario(String comentario) {
		this.comentario = comentario;
	}

	public ArrayList<String> getListaLikesUsuarios() {
		return listaLikesUsuarios;
	}

	public void setListaLikesUsuarios(ArrayList<String> listaLikesUsuarios) {
		this.listaLikesUsuarios = listaLikesUsuarios;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	

	@Override
	public String toString() {
		return "Publicacion [codigo=" + codigo + ", producto=" + producto + ", nombreProducto=" + nombreProducto
				+ ", precioProducto=" + precioProducto + ", fechaPublicacion=" + fechaPublicacion + ", like=" + like
				+ ", comentario=" + comentario + "]";
	}

	public boolean verificarLike(String codigoUsuario) {
		for (String codigo : listaLikesUsuarios) {
			if(codigo.equals(codigoUsuario)){
				return true;
			}
		}
		return false;
	}
	
	

	
	
}
