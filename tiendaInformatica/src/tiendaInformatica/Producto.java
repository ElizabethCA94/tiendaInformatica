package tiendaInformatica;

public class Producto {
	private String codigo, nombre;
	private float precio;
	private int cantidad;
	
	public Producto() {};
	
	public Producto(String codigo, String nombre, float precio, int cantidad) {
		this.codigo = codigo;
		this.nombre = nombre;
		this.precio = precio;
		this.cantidad = cantidad;
	}
	
	public Producto(String nombre, float precio, int cantidad) {
		this.nombre = nombre;
		this.precio = precio;
		this.cantidad = cantidad;
	}
	
	public String getCodigo() {
		return this.codigo;
	}
	
	public String getNombre() {
		return this.nombre;
	}
	
	public float getPrecio() {
		return this.precio;
	}
	
	public int getCantidad() {
		return this.cantidad;
	}
	
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public void setPrecio(float precio) {
		this.precio = precio;
	}
	
	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}
	
	public String toString() {
		return "Nombre " + this.nombre + "Precio " + this.precio + "Cantidad " + this.cantidad;
	}
}
