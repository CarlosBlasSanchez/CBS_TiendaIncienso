package rf.tienda.servicios;

import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import rf.tienda.dominio.Categoria;
import rf.tienda.dominio.PedidoCarrito;
import rf.tienda.exception.DomainException;
import rf.tienda.repository.PedidoCarritoRepository;
import rf.tienda.servicios.IPedidoCarritoServicio;
@Service
public class PedidoCarritoServicio implements IPedidoCarritoServicio {

	@Autowired
	PedidoCarritoRepository pedidoCarritoRepo;
	@Override
	public List<PedidoCarrito> leertodo() {
		return pedidoCarritoRepo.findAll();
	}

	@Override
	public PedidoCarrito crearPedidoCarrito(PedidoCarrito pedidoCarrito) {
		return pedidoCarritoRepo.save(pedidoCarrito);
	}

	@Override
	public PedidoCarrito actualizarPedidoCarrito(PedidoCarrito pedidoCarrito,
			int id_pedidoCarrito) throws DomainException {
		PedidoCarrito aux = pedidoCarritoRepo.findById(id_pedidoCarrito).get();
		if (Objects.nonNull(pedidoCarrito.getCodigo_producto_cliente()) && !"".equalsIgnoreCase(pedidoCarrito.getCodigo_producto_cliente())) {
			aux.setCodigo_producto_cliente(pedidoCarrito.getCodigo_producto_cliente());
		}
		if (Objects.nonNull(pedidoCarrito.getCantidad_producto())) {
			aux.setCantidad_producto(pedidoCarrito.getCantidad_producto());
		}
		if (Objects.nonNull(pedidoCarrito.getPrecio_linea_de_pedido())) {
			aux.setPrecio_linea_de_pedido(pedidoCarrito.getPrecio_linea_de_pedido());
		}
		try {
			if (Objects.nonNull(pedidoCarrito.getNumero_tarjeta_credito()) && !"".equalsIgnoreCase(pedidoCarrito.getNumero_tarjeta_credito())) {
				aux.setNumero_tarjeta_credito(pedidoCarrito.getNumero_tarjeta_credito());
			}
		} catch (DomainException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (Objects.nonNull(pedidoCarrito.getFecha_caducidad_tarjeta())) {
			aux.setFecha_caducidad_tarjeta(pedidoCarrito.getFecha_caducidad_tarjeta());
		}
		if (Objects.nonNull(pedidoCarrito.getCcv_tarjeta_credito())) {
			aux.setCcv_tarjeta_credito(pedidoCarrito.getCcv_tarjeta_credito());
		}
		if (Objects.nonNull(pedidoCarrito.getNombre_titular_tarjeta()) && !"".equalsIgnoreCase(pedidoCarrito.getNombre_titular_tarjeta())) {
			aux.setNombre_titular_tarjeta(pedidoCarrito.getNombre_titular_tarjeta());
		}
		if (Objects.nonNull(pedidoCarrito.getEstado_carrito())) {
			aux.setEstado_carrito(pedidoCarrito.getEstado_carrito());
		}
		if (Objects.nonNull(pedidoCarrito.getFechas_cambio())) {
			aux.setFechas_cambio(pedidoCarrito.getFechas_cambio());
		}
		return pedidoCarritoRepo.save(aux);
	}

	@Override
	public void borrarPedidoCarrito(PedidoCarrito pedidoCarrito, int id_pedidoCarrito) {
		PedidoCarrito aux = pedidoCarritoRepo.findById(id_pedidoCarrito).get();
		pedidoCarritoRepo.delete(aux);
	}

	
}
