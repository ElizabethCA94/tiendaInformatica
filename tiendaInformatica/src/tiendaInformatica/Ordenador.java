package tiendaInformatica;

public class Ordenador extends Producto{
	private String caracteristicas;
	public Ordenador(String codigo, String nombre, float precio, int cantidad, String caracteristicas) {
		super(codigo,nombre,precio,cantidad);
		this.caracteristicas = caracteristicas;
	}
	public Ordenador() {};
	public String getCaracteristicas(){
		return this.caracteristicas;
	}
	
	public void setCaracteristicas(String caracteristicas) {
		this.caracteristicas = caracteristicas;
	}
}
