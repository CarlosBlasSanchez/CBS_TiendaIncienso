package rf.tienda.servicios;

import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import rf.tienda.dominio.Categoria;
import rf.tienda.dominio.PedidoCarrito;
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
			int id_pedidoCarrito) {
		PedidoCarrito aux = pedidoCarritoRepo.findById(id_pedidoCarrito).get();
		if (Objects.nonNull(pedidoCarrito.getCodigo_producto_cliente()) && !"".equalsIgnoreCase(pedidoCarrito.getCodigo_producto_cliente())) {
			aux.setCodigo_producto_cliente(aux.getCodigo_producto_cliente());
		}
		if (Objects.nonNull(pedidoCarrito.getCantidad_producto())) {
			aux.setCantidad_producto(aux.getCantidad_producto());
		}
		if (Objects.nonNull(pedidoCarrito.getPrecio_linea_de_pedido())) {
			aux.setPrecio_linea_de_pedido(aux.getPrecio_linea_de_pedido());
		}
		if (Objects.nonNull(pedidoCarrito.getNumero_tarjeta_credito()) && !"".equalsIgnoreCase(pedidoCarrito.getNumero_tarjeta_credito())) {
			aux.setNumero_tarjeta_credito(aux.getNumero_tarjeta_credito());
		}
		if (Objects.nonNull(pedidoCarrito.getFecha_caducidad_tarjeta())) {
			aux.setFecha_caducidad_tarjeta(aux.getFecha_caducidad_tarjeta());
		}
		
		return pedidoCarritoRepo.save(aux);
	}

	@Override
	public void borrarPedidoCarrito(PedidoCarrito pedidoCarrito, int id_pedidoCarrito) {
		PedidoCarrito aux = pedidoCarritoRepo.findById(id_pedidoCarrito).get();
		pedidoCarritoRepo.delete(aux);
	}

	
}
