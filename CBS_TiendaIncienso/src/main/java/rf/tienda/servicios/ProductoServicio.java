package rf.tienda.servicios;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import rf.tienda.dominio.Producto;
import rf.tienda.repository.ProductoRepository;

@Service
public class ProductoServicio implements IProductoServicio {

	@Autowired
	ProductoRepository productoRepo;
	@Override
	public List<Producto> leertodo() {
		return productoRepo.findAll();
	}

	@Override
	public Producto crearProducto(Producto producto) {
		return productoRepo.save(producto);
	}

	@Override
	public Producto actualizarProducto(Producto producto, String id_producto) {
		//hacer
		return null;
	}

	@Override
	public void borrarProducto(Producto producto, String id_producto) {
		Producto aux = productoRepo.findById(id_producto).get();
		productoRepo.delete(aux);
	}

		
}
