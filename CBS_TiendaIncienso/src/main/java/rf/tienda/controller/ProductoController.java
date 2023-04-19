package rf.tienda.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import rf.tienda.dominio.Producto;
import rf.tienda.servicios.IProductoServicio;

@RestController
@RequestMapping("/productos")
public class ProductoController {
	@Autowired
	private IProductoServicio productoServicio;

	@GetMapping
	public List<Producto> listProducto() {
		return productoServicio.leertodo();
	}

	@PostMapping
	public Producto crearProducto(@RequestBody Producto producto) {
		producto.setId_producto("");
		return productoServicio.crearProducto(producto);
	}
	
	@PutMapping
	public Producto actualizarProducto(@RequestBody Producto producto) {
		return productoServicio.actualizarProducto(producto, producto.getId_producto());
	}
	
	@DeleteMapping
	public void borrarProducto(@RequestBody Producto producto) {
		productoServicio.borrarProducto(producto, producto.getId_producto());
	}
}
