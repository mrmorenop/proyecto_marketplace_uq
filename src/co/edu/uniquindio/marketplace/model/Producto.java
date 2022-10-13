package co.edu.uniquindio.marketplace.model;

import java.io.Serializable;
import java.util.Date;

import javax.swing.Icon;

public class Producto implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String codigo;
	private String nombre;
	private Icon imagen;
	private double precio;
	private Estado estado;
	private Categoria categoria;
	private Date fecha;
	
	/**
	 * Constructor con parametros de la clase Producto
	 * @param codigo
	 * @param nombre
	 * @param imagen
	 * @param precio
	 * @param estado
	 * @param categoria
	 * @param fecha
	 */
	public Producto(String codigo, String nombre, Icon imagen, double precio, Estado estado, Categoria categoria, Date fecha) {
		this.codigo = codigo;
		this.nombre = nombre;
		this.imagen = imagen;
		this.precio = precio;
		this.estado = estado;
		this.categoria = categoria;
		this.fecha = fecha;
	}

	/**
	 * Constructor vacio de la clase Producto
	 */
	public Producto() {
	}
	
	//<------------------------------------------Metodos modificadores getters y setters----------------------------------------------------------------------->

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Icon getImagen() {
		return imagen;
	}

	public void setImagen(Icon imagen) {
		this.imagen = imagen;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	public Estado getEstado() {
		return estado;
	}

	public void setEstado(Estado estado) {
		this.estado = estado;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "Producto [codigo=" + codigo + ", nombre=" + nombre + ", imagen=" + imagen + ", precio=" + precio
				+ ", estado=" + estado + ", categoria=" + categoria + ", fecha=" + fecha + "]";
	}


}
