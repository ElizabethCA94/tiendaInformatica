package tiendaInformatica;

import java.io.ObjectInputStream.GetField;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Scanner;

import javax.swing.JOptionPane;

import org.omg.IOP.Codec;


public class tiendaInformatica {
		
	public static void main(String[] args) {
		HashMap<String, Producto> listaProductos = new HashMap<String, Producto>();	
		int opcionElegida = 0, opcionProducto=0, cantidad=0;
		String codigo = null;
		Producto producto;
			while(opcionElegida != 6) {
				opcionElegida = Integer.parseInt(JOptionPane.showInputDialog("Introduce la entrada que quieras: \n 1.Introducir productos \n 2.Eliminar productos \n 3.Consulta de productos \n 4.Venta de productos \n 5.Modificar productos \n 6.Salir"));
				switch(opcionElegida) {
					case 1:
						while(opcionProducto>3||opcionProducto==0) {
						opcionProducto = Integer.parseInt(JOptionPane.showInputDialog("Selecciona el tipo de producto: \n 1.Ordenador \n 2.Telefonos Moviles \n 3.Salir"));
						}
						if(opcionProducto == 1) {
							codigo = JOptionPane.showInputDialog("Ingrese el codigo del producto");
							producto = new Ordenador(codigo, JOptionPane.showInputDialog("Ingrese el nombre del producto"), Float.parseFloat(JOptionPane.showInputDialog("Ingrese el precio del producto")),Integer.parseInt(JOptionPane.showInputDialog("Ingrese la cantidad del producto")), JOptionPane.showInputDialog("Ingrese las caracteristicas del producto"));
							opcionProducto = 0;
						}
						else if(opcionProducto ==2) {
							codigo = JOptionPane.showInputDialog("Ingrese el codigo del producto");
							producto = new TelefonosMoviles(codigo, JOptionPane.showInputDialog("Ingrese el nombre del producto"), Float.parseFloat(JOptionPane.showInputDialog("Ingrese el precio del producto")), Integer.parseInt(JOptionPane.showInputDialog("Ingrese la cantidad del producto")), JOptionPane.showInputDialog("Ingrese el proveedor del producto"));
							opcionProducto = 0;
						}
						else {
							return;
						}
						guardarProducto(codigo, producto, listaProductos);
						break;
					case 2:
						codigo = JOptionPane.showInputDialog("Ingrese el código del producto a eliminar");
						eliminarProducto(codigo, listaProductos);
						break;
					case 3:
						codigo = JOptionPane.showInputDialog("Ingrese el código del producto a buscar");
						buscarProducto(listaProductos, codigo);
						break;
					case 4:
						codigo = JOptionPane.showInputDialog("Ingrese el código del producto a vender");
						venderProducto(listaProductos, codigo, cantidad);
						break;
					case 5:
						codigo = JOptionPane.showInputDialog("Ingrese el código del producto a modificar");
						modificarProducto(listaProductos, codigo, cantidad);	
					}	
				}
		}
			
	//Alta de nuevos productos: Se pedirán los datos del producto y se dará de alta en la tienda.
	public static void guardarProducto(String codigo, Producto producto, HashMap<String,Producto> listaProductos) {
		if(listaProductos.containsKey(codigo)) {
			JOptionPane.showMessageDialog(null, "No se puede introducir el producto, el código está repetido");
		}
		else {
			listaProductos.put(codigo,producto);
			JOptionPane.showMessageDialog(null, "Guardado exitosamente");
		}
	};
	//Baja de productos:Se pedirá el código del producto y se dará de baja de la tienda.
	public static void eliminarProducto(String codigo, HashMap<String,Producto> listaProductos) {
		if(listaProductos.containsKey(codigo)) {
			listaProductos.remove(codigo);
			JOptionPane.showMessageDialog(null, "Eliminado exitosamente");
		}
		else {
			JOptionPane.showMessageDialog(null, "No hay ningún producto con ese código");
		}
	}
	//Consulta de productos:Se pedirá el código del producto y se mostrará su información.
	public static void buscarProducto(HashMap<String,Producto> listaProductos, String codProducto) {
		String codigo;
		Iterator<String> productos = listaProductos.keySet().iterator();
		while(productos.hasNext()) {
				codigo = productos.next();
				if(codProducto.equals(codigo)) {
					JOptionPane.showMessageDialog(null, "Codigo: " + codigo + listaProductos.get(codigo).toString());
					return;
			}			
		} 	
		JOptionPane.showMessageDialog(null, "No hay ningún producto con ese código");
	}
	//Venta de productos: Se pedirá el código del producto y la cantidad y se restará esa cantidad de la actual.
	public static void venderProducto(HashMap<String,Producto> listaProductos, String codProducto, int cantidad) {
		String codigo;
		Iterator<String> productos = listaProductos.keySet().iterator();
		while(productos.hasNext()) {
			codigo = productos.next();
			if(codProducto.equals(codigo)) {
				cantidad = Integer.parseInt(JOptionPane.showInputDialog("Ingrese la cantidad de venta del producto"));
				if(cantidad <= listaProductos.get(codigo).getCantidad() ) {
					listaProductos.get(codigo).setCantidad(listaProductos.get(codigo).getCantidad() - cantidad);
					JOptionPane.showMessageDialog(null, codigo + listaProductos.get(codigo));
				}
				else {
					JOptionPane.showMessageDialog(null, "No se puede vender la cantidad de productos ");
				}
				return;
			}
		}
		JOptionPane.showMessageDialog(null, "No hay ningún producto con ese código");
	}
	//Reponer producto: Se pedirá el código del producto a reponer y se incrementará el valor de su cantidad.De forma voluntaria se puede realizar la operación de modificación de los datos de algún producto.
	public static void modificarProducto(HashMap<String,Producto> listaProductos, String codProducto, int cantidad) {
		String codigo;
		Iterator<String> productos = listaProductos.keySet().iterator();
		while(productos.hasNext()) {
			codigo = productos.next();
			if(codProducto.equals(codigo)) {
				cantidad = Integer.parseInt(JOptionPane.showInputDialog("Ingrese la cantidad a reponer: "));
				listaProductos.get(codigo).setCantidad(listaProductos.get(codigo).getCantidad() + cantidad);
				JOptionPane.showMessageDialog(null, codigo + listaProductos.get(codigo));	
			}
			else {
				JOptionPane.showMessageDialog(null, "No hay ningún producto con ese código");
			}
			return;
		}
		JOptionPane.showMessageDialog(null, "No hay ningún producto con ese código");
	}
	
}

