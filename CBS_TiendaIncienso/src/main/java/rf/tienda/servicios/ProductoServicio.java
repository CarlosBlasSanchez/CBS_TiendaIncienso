package rf.tienda.servicios;

import java.util.List;
import java.util.Objects;

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
		Producto aux = productoRepo.findById(id_producto).get();
		if (Objects.nonNull(producto.getDescripcion_corta()) && !"".equalsIgnoreCase(producto.getDescripcion_corta())) {
			aux.setDescripcion_corta(producto.getDescripcion_corta());
		}
		if (Objects.nonNull(producto.getExplicacion()) && !"".equalsIgnoreCase(producto.getDescripcion_corta())) {
			aux.setExplicacion(producto.getExplicacion());
		}
		if (Objects.nonNull(producto.getPrecio())) {
			aux.setPrecio(producto.getPrecio());
		}
		if (Objects.nonNull(producto.getStock())) {
			aux.setStock(producto.getStock());
		}
		if (Objects.nonNull(producto.getFecha_prevista_reposición())) {
			aux.setFecha_prevista_reposición(producto.getFecha_prevista_reposición());
		}
		if (Objects.nonNull(producto.getFecha_activacion())) {
			aux.setFecha_activacion(producto.getFecha_activacion());
		}
		if (Objects.nonNull(producto.getFecha_desactivación())) {
			aux.setFecha_desactivación(producto.getFecha_desactivación());
		}
		if (Objects.nonNull(producto.getUnidad_venta()) && !"".equalsIgnoreCase(producto.getUnidad_venta())) {
			aux.setUnidad_venta(producto.getUnidad_venta());
		}
		if (Objects.nonNull(producto.getCantidad_unidades_ultimas())) {
			aux.setCantidad_unidades_ultimas(producto.getCantidad_unidades_ultimas());
		}
		if (Objects.nonNull(producto.getUnidad_ultima()) && !"".equalsIgnoreCase(producto.getUnidad_ultima())) {
			aux.setUnidad_ultima(producto.getUnidad_ultima());
		}
		if (Objects.nonNull(producto.getPais_origen())) {
			aux.setPais_origen(producto.getPais_origen());
		}
		if (Objects.nonNull(producto.getUso_recomendado()) && !"".equalsIgnoreCase(producto.getUso_recomendado())) {
			aux.setUso_recomendado(producto.getUso_recomendado());
		}
		if (Objects.nonNull(producto.getCategoria())) {
			aux.setCategoria(producto.getCategoria());
		}
		if (Objects.nonNull(producto.getStock_reservado())) {
			aux.setStock_reservado(producto.getStock_reservado());
		}
		if (Objects.nonNull(producto.getStock_nivel_alto())) {
			aux.setStock_nivel_alto(producto.getStock_nivel_alto());
		}
		if (Objects.nonNull(producto.getStock_nivel_bajo())) {
			aux.setStock_nivel_bajo(producto.getStock_nivel_bajo());
		}
		if (Objects.nonNull(producto.getEstado())) {
			aux.setEstado(producto.getEstado());
		}
		return productoRepo.save(aux);
	}

	@Override
	public void borrarProducto(Producto producto, String id_producto) {
		Producto aux = productoRepo.findById(id_producto).get();
		productoRepo.delete(aux);
	}

		
}
