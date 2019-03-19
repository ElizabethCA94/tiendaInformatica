package tiendaInformatica;

public class TelefonosMoviles extends Producto{
	private String operador;
	public TelefonosMoviles(String codigo, String nombre, float precio, int cantidad, String operador) {
		super(codigo,nombre,precio,cantidad);
		this.operador = operador;
	}
	public TelefonosMoviles() {};
	public String getoperador() {
		return this.operador;
	}
	public void setOperador(String operador) {
		this.operador = operador;
	}
	
	public String toString() {
		return "Nombre: " + this.getNombre() + "Precio: " + this.getPrecio() + "Cantidad: " + this.getCantidad() + "Operador: " + this.operador;
	}
}
